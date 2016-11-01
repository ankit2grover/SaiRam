
package com.kohls.mcommerce.opal.helper.cache.inmemory;

import com.kohls.mcommerce.opal.common.value.ConstantValues;

public class InMemoryCacheHelper {

    public static final byte REGION_CATALOG = 0;

    public static final byte REGION_CATEGORY = 1;

    public static final byte REGION_PRODUCTS = 2;

    public static final byte REGION_CMS = 3;
    
    public static final byte REGION_REGISTRY = 4;

    public static IInMemoryCacheRegion getRegion(byte type,
            CacheListener cacheListener) {
        IInMemoryCacheRegion cacheRegion = null;
        switch (type) {
            case REGION_CATALOG:
                cacheRegion = new InMemoryCatalogRegion(cacheListener);
                return cacheRegion;

            case REGION_CATEGORY:
                cacheRegion = new InMemoryCategoryRegion(cacheListener);
                return cacheRegion;

            case REGION_CMS:
                cacheRegion = new InMemoryCMSRegion(cacheListener);
                return cacheRegion;

            default:
                break;
        }

        return null;
    }

    public static String getFileName(int type) {
        String fileName = null;

        switch (type) {
            case REGION_CATALOG:
                fileName = ConstantValues.CATALOG_FILENAME;
                break;
            case REGION_CATEGORY:
                fileName = ConstantValues.CATEGORY_FILENAME;
                break;
            case REGION_CMS:
                fileName = ConstantValues.CMS_FILENAME;
                break;
            default:
                break;
        }
        return fileName;
    }
}
