
package com.kohls.mcommerce.opal.helper.cache.inmemory;

import java.util.LinkedHashMap;

public interface CacheListener {
    public void onCompleted(LinkedHashMap<String, InMemoryCacheVO> savedHashMap);
}
