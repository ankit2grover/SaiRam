
package com.kohls.mcommerce.opal.helper.cache.image;

import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.ImageLoader.ImageCache;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayOutputStream;
import java.io.File;

/**
 * Disk cache to store bitmaps in disk memory using volley disk cache
 * implementation.
 * 
 * @author Ankit Grover
 */
public class DiskBitmapCache extends DiskBasedCache implements ImageCache {
    // Root directory holding cached bitmaps.
    File mRootDirectory;

    public DiskBitmapCache(File rootDirectory,
            int maxCacheSizeInBytes) {
        super(rootDirectory, maxCacheSizeInBytes);
        mRootDirectory = rootDirectory;
    }

    /**
     * Stores bitmap in disk cache as a key-value pair.
     * 
     * @param key key of cached bitmap.
     * @param bitmap bitmap stored as a png file in cache.
     */
    @Override
    public void putBitmap(String key,
            Bitmap bitmap) {
        if (!bitmap.isRecycled()) {
            Entry entry = new Entry();
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
            entry.data = baos.toByteArray();
            put(key, entry);
        }
    }

    /**
     * Get bitmap from disk cache according to its key-value.
     * 
     * @param key key of the bitmap.
     * @return bitmap from disk cache.
     */
    @Override
    public Bitmap getBitmap(String key) {
        Entry entry = get(key);
        if (entry != null) {
            byte[] data = entry.data;
            Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length);
            return bitmap;
        }
        return null;
    }
}
