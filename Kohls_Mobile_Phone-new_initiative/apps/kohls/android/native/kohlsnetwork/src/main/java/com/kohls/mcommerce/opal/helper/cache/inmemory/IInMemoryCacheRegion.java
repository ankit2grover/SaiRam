
package com.kohls.mcommerce.opal.helper.cache.inmemory;

import java.util.LinkedHashMap;

/**
 * Interface for all cache regions in the application. Performs 4 tasks -
 * getting values from hashmap,putting value into Hashmap, deleting values from
 * hashmap,Flushing/clearing the whole region
 * 
 * @author sarnab.poddar
 */
public abstract class IInMemoryCacheRegion {

    private CacheListener mCacheReaderListener;

    public IInMemoryCacheRegion(CacheListener listener) {
        mCacheReaderListener = listener;
    }

    public abstract void save(LinkedHashMap<String, InMemoryCacheVO> savedHashmap);

    public abstract void get(String key);

    public abstract boolean put(String key,
            InMemoryCacheVO data);

    public abstract boolean delete(String key,
            LinkedHashMap<String, InMemoryCacheVO> savedHashmap);

    public abstract boolean flush();

    protected void finishCacheFetching(LinkedHashMap<String, InMemoryCacheVO> savedHashMap) {
        if (mCacheReaderListener != null) {
            mCacheReaderListener.onCompleted(savedHashMap);
        }

    }
}
