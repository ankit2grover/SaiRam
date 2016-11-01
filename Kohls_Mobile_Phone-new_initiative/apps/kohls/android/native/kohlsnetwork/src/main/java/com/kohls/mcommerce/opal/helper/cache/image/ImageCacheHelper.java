
package com.kohls.mcommerce.opal.helper.cache.image;

import com.kohls.mcommerce.opal.common.value.ConstantValues;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;

import java.io.File;

/**
 * Custom cache that is caching bitmap in main memory, also storing bitmaps
 * permanently in disk memory. It will sync main memory cache with disk memory.
 * It will search for bitmap in main memory first, if no bitmap is found then it
 * will fetch bitmap from disk memory.
 */
public class ImageCacheHelper {

    /**
     * Bitmap worker class download the image from disk memory & add it in main
     * memory, if no image is found in cache then message is sent to handler
     * that no image is available in cache.
     */
    class BitmapWorkerTask extends AsyncTask<Object, Void, Void> {
        // Fetch the image from disk memory in background.
        @Override
        protected Void doInBackground(Object... params) {
            final String imageKey = String.valueOf(params[0]);
            final Handler handler = (Handler) params[1];
            // Check disk cache in background thread
            Bitmap bitmap = getBitmapFromDiskCache(imageKey);
            Message msg = Message.obtain();
            Bundle bundle = new Bundle();
            bundle.putString(ConstantValues.BUNDLE_IMAGE_KEY, imageKey);
            if (bitmap == null) {
                msg.what = ConstantValues.MSG_IMG_NOT_PPRESENT_IN_CACHE;
            } else {
                // Add latest image in memory cache.
                mBitmapLruCache.putBitmap(imageKey, bitmap);
            }
            // Notify ui thread to pull the image from main memory cache.
            msg.what = ConstantValues.MSG_IMG_LOADED_FROM_DISK;
            msg.setData(bundle);
            if (handler != null) {
                handler.sendMessage(msg);
            }
            return null;
        }
    }

    /**
     * Async task to initialize disk cache in disk memory.
     */
    class InitDiskCacheTask extends AsyncTask<String, Void, Void> {
        @Override
        protected Void doInBackground(String... params) {
            synchronized (mDiskCacheLock) {
                mDiskBitmapCache =
                        new DiskBitmapCache(getDiskCacheDir(DISK_CACHE_SUBDIR),
                                DEFAULT_DISK_USAGE_BYTES);
                // Finished initialization
                mDiskCacheStarting = false;
                // Wake any waiting threads
                mDiskCacheLock.notifyAll();
            }
            return null;
        }
    }

    /**
     * Async task to update disk cache with new bitmaps.
     */
    class UpdateDiskCacheTask extends AsyncTask<Object, Void, Void> {
        // Update disk cache in background thread.
        @Override
        protected Void doInBackground(Object... params) {
            String key = (String) params[0];
            Bitmap bitmap = (Bitmap) params[1];
            synchronized (mDiskCacheLock) {
                // Check if disk cache is initializing, if it is then wait for
                // updating.
                if (mDiskCacheStarting) {
                    try {
                        mDiskCacheLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (mDiskBitmapCache != null) {
                    mDiskBitmapCache.putBitmap(key, bitmap);
                }
            }
            return null;
        }
    }

    // Application context.
    private Context mContext;

    // Holding instance of LRU cache that is implemented in main memory.
    private BitmapLruCache mBitmapLruCache;

    // Holding instance of disk bitmap cache.
    private DiskBitmapCache mDiskBitmapCache;

    // Lock of disk cache, to avoid conflicts during read & write operation.
    private final Object mDiskCacheLock = new Object();

    // Check whether disk cache is initializing or not.
    private boolean mDiskCacheStarting = true;

    // Sub-directory for storing images in disk memory.
    private static final String DISK_CACHE_SUBDIR = "thumbnails";

    // Singleton instance of cache.
    private static ImageCacheHelper mInstance;

    /** Default maximum disk usage in bytes. */
    private static final int DEFAULT_DISK_USAGE_BYTES = 5 * 1024 * 1024;

    public static synchronized ImageCacheHelper open(Context context) {
        if (mInstance == null) {
            mInstance = new ImageCacheHelper(context);
        }
        return mInstance;
    }

    private ImageCacheHelper(Context context) {
        mContext = context;
        init();
    }

    /**
     * Creates a unique sub-directory of the designated disk cache directory,
     * tries to use external but if not mounted, falls back on internal storage.
     * 
     * @param uniqueName unique name of disk cache sub-directory.
     * @return file object of disk cache.
     */
    public File getDiskCacheDir(String uniqueName) {
        // Check if media is mounted or storage is built-in, if so, try and use
        // external cache dir
        // otherwise use internal cache dir
        final String cachePath =
                Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState()) ? mContext.getExternalFilesDir(null)
                        .getPath()
                        : mContext.getFilesDir().getPath();
        // Construct directory & sub-directories of disk cache.
        File cacheDir = new File(cachePath + File.separator + uniqueName);
        cacheDir.mkdirs();
        return cacheDir;
    }

    /**
     * Initialise main memory & disk memory caches.
     */
    private void init() {
        mBitmapLruCache = BitmapLruCache.open();
        // Initialize disk cache.
        new InitDiskCacheTask().execute();
    }

    /**
     * Add bitmap to cache for the given key value.
     * 
     * @param key bitmap's key.
     * @param bitmap bitmap to be stored.
     */
    public void addBitmapToCache(String key,
            Bitmap bitmap) {
        // Add latest images in memory cache
        mBitmapLruCache.putBitmap(key, bitmap);
        new UpdateDiskCacheTask().execute(key, bitmap);
    }

    /**
     * Get bitmap from cache.
     * 
     * @param key bitmap's key
     * @param handler if bitmap is not found in main memory cache, it will be
     *            fetched from disk memory & notified to application component
     *            through handler.If handler is null then image fetching is only
     *            checked in the main memory.
     * @return bitmap from cache.
     */
    public Bitmap getImageFromCache(String key,
            Handler handler) {
        Bitmap bitmap = mBitmapLruCache.getBitmap(key);
        // If bitmap is not found in memory-cache, run async
        // task to download image from disk cache
        // .Also, download the image from disk cache only if handler is
        // non null.
        if (bitmap == null && handler != null) {
            new BitmapWorkerTask().execute(key, handler);
        }
        return bitmap;
    }

    /**
     * Get bitmap from disk cache for the given key.
     * 
     * @param key bitmap's key.
     * @return bitmap from disk cache for the given key.
     */
    private Bitmap getBitmapFromDiskCache(String key) {
        synchronized (mDiskCacheLock) {
            // Wait while disk cache is started from background thread
            while (mDiskCacheStarting) {
                try {
                    mDiskCacheLock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (mDiskBitmapCache != null) {
                return mDiskBitmapCache.getBitmap(key);
            }
        }
        return null;
    }
}
