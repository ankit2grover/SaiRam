
package com.kohls.mcommerce.opal.helper.cache.inmemory;

import java.io.Serializable;

public class InMemoryCacheVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long mExpiryTime;

    private String mCacheData;

    public InMemoryCacheVO(long expiryTime,
            String mCacheData) {
        this.mExpiryTime = expiryTime;
        this.mCacheData = mCacheData;
    }

    public long getmExpiryTime() {
        return mExpiryTime;
    }

    public String getmCacheData() {
        return mCacheData;
    }

}
