
package com.kohls.mcommerce.opal.helper.cache.inmemory;

import com.kohls.mcommerce.opal.common.util.Logger;
import com.kohls.mcommerce.opal.common.util.UtilityMethods;
import com.kohls.mcommerce.opal.common.value.ConstantValues;

import android.os.AsyncTask;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.StreamCorruptedException;
import java.util.LinkedHashMap;

/**
 * One of the 3 cache regions of the application. This region is a LinkedHashMap
 * of request parameters as key, and CacheValueObject as values. This
 * LinkedHashMap is saved in a file on the application cache folder in the SD
 * card(if available) or the application internal memory.
 */
public class InMemoryCategoryRegion extends IInMemoryCacheRegion {

    // Max size of the file data of the cache
    private static final int MAX_SIZE = 20;

    private String TAG = InMemoryCategoryRegion.class.getName();

    public InMemoryCategoryRegion(CacheListener listener) {
        super(listener);
    }

    /*
     * Get data from the LinkedHashMap in the file (if present). Check whether
     * the data is expired, if yes - then delete the data from the LinkedHashMap
     * and return null
     * @see com.kohls.cache.ICacheRegion#get(java.lang.String)
     */
    @Override
    public void get(final String key) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                LinkedHashMap<String, InMemoryCacheVO> hashMap =
                        new InMemoryCacheAsync(InMemoryCacheHelper.REGION_CATEGORY).getHashmapfromFile();
                if (hashMap != null && !hashMap.isEmpty() && hashMap.containsKey(key)) {
                    InMemoryCacheVO cacheVO = hashMap.get(key);
                    // Check if the expiry time is crossed on the data and
                    // delete the
                    // same if it has expired
                    if (UtilityMethods.checkDataExpired(cacheVO.getmExpiryTime())) {
                        delete(key, null);
                        save(hashMap);
                    } else {
                        // This is to ensure LRU, the latest used key should
                        // move to the
                        // last element in the LinkedHashmap - so that when we
                        // reach the
                        // cachecapacity - we can start deleting data from the
                        // start of
                        // the
                        // Linked hashmap as it would be Least Recently Used
                        hashMap.remove(key);
                        hashMap.put(key, cacheVO);

                        save(hashMap);
                    }
                }
                finishCacheFetching(hashMap);
            }
        }).start();
    }

    /*
     * This method will first get the LinkedHashMap out of the file data and
     * then add the key values into the LinkedHashMap and save the LinkedHashMap
     * back into the file. Check first for whether the size of the file has
     * crossed the threshold size , if it has crossed the threshold size, flush
     * the cache and restart caching
     * @see com.kohls.cache.ICacheRegion#put(java.lang.String,
     * com.kohls.cache.CacheValueObject)
     */
    @Override
    public boolean put(String key,
            InMemoryCacheVO data) {

        LinkedHashMap<String, InMemoryCacheVO> mSavedHashmap =
                new InMemoryCacheAsync(InMemoryCacheHelper.REGION_CATEGORY).getHashmapfromFile();

        if (mSavedHashmap == null) {
            mSavedHashmap = new LinkedHashMap<String, InMemoryCacheVO>();
        }

        // This is to ensure LRU, the latest used key should move to the
        // last element in the LinkedHashmap - so that when we reach the
        // cachecapacity - we can start deleting data from the start of the
        // Linked hashmap as it would be Least Recently Used
        if (mSavedHashmap.containsKey(key)) {
            mSavedHashmap.remove(key);
        }
        mSavedHashmap.put(key, data);
        // While putting data into the file, check if the size of the file
        // is greater than the max size allowed
        while (mSavedHashmap.size() >= MAX_SIZE) {
            // remove the first element in the hashmap, considering that as
            // the Least Recently Used
            for (LinkedHashMap.Entry<String, InMemoryCacheVO> entry : mSavedHashmap.entrySet()) {
                mSavedHashmap.remove(entry.getKey());
                break;
            }
        }

        // Save the hashmap
        save(mSavedHashmap);

        return true;
    }

    /*
     * Delete the key from the LinkedHashMap - if the LinkedHashMap exists
     * @see com.kohls.cache.ICacheRegion#delete(java.lang.String)
     */
    @Override
    public boolean delete(String key,
            LinkedHashMap<String, InMemoryCacheVO> mSavedHashmap) {
        if (mSavedHashmap != null) {
            mSavedHashmap.remove(key);
            return true;
        }
        return false;
    }

    /*
     * Clear the region and reset the file
     * @see com.kohls.cache.ICacheRegion#flush()
     */
    @Override
    public boolean flush() {

        save(null);
        return true;

    }

    /**
     * This is a async task to save the LinkedHashMap into the file
     */
    class CacheSaverTask extends AsyncTask<LinkedHashMap<String, InMemoryCacheVO>, Void, Void> {

        @Override
        protected Void doInBackground(LinkedHashMap<String, InMemoryCacheVO>... params) {
            LinkedHashMap<String, InMemoryCacheVO> mSavedHashmap = params[0];
            FileOutputStream mOutput = null;
            ObjectOutputStream mObj = null;

            try {
                mOutput =
                        new FileOutputStream(UtilityMethods.createFile(ConstantValues.CATEGORY_FILENAME));
            } catch (FileNotFoundException e) {
                Logger.error(TAG, e.getMessage());
                e.printStackTrace();
            }
            try {
                mObj = new ObjectOutputStream(mOutput);
            } catch (StreamCorruptedException e) {
                Logger.error(TAG, e.getMessage());
            } catch (IOException e) {
                Logger.error(TAG, e.getMessage());
            }
            try {
                mObj.writeObject(mSavedHashmap);
            } catch (IOException e) {
                Logger.error(TAG, e.getMessage());
            }
            try {
                mObj.flush();
                mObj.close();
                mOutput.close();
            } catch (IOException e) {
                Logger.error(TAG, e.getMessage());
            }

            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void save(LinkedHashMap<String, InMemoryCacheVO> savedHashmap) {
        new CacheSaverTask().execute(savedHashmap);
    }
}
