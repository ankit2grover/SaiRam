
package com.kohls.mcommerce.opal.helper.cache.inmemory;

import com.kohls.mcommerce.opal.common.app.KohlsPhoneApplication;
import com.kohls.mcommerce.opal.common.po.FlushCachePO;
import com.kohls.mcommerce.opal.common.po.FlushCachePO.Params;
import com.kohls.mcommerce.opal.framework.vo.FlushdataVO;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;
import com.kohls.mcommerce.opal.helper.adapter.AdapterHelper;
import com.kohls.mcommerce.opal.helper.adapter.AdapterProcedure;
import com.kohls.mcommerce.opal.helper.adapter.listener.IAdapterListener;
import com.kohls.mcommerce.opal.helper.error.Error;

public class CacheFlushHelper implements IAdapterListener {

    public void startFlushCalls() {

        FlushCachePO flushCachePO = new FlushCachePO();
        Params params = flushCachePO.new Params();
        flushCachePO.setparams(params);
        AdapterHelper mAdapterHelper =
                new AdapterHelper(AdapterProcedure.CACHE_FLUSH_API, flushCachePO, this);
        mAdapterHelper.performTask();

    }

    @Override
    public void onSuccess(IValueObject valueObject) {
        if (valueObject instanceof FlushdataVO) {
            FlushdataVO flushData = (FlushdataVO) valueObject;
            if (KohlsPhoneApplication.getInstance().getKohlsPref().getCmsCacheTime() == 0) {
                KohlsPhoneApplication.getInstance()
                        .getKohlsPref()
                        .setCacheTimeCMS(flushData.getPayload().getCms());
            } else if (KohlsPhoneApplication.getInstance().getKohlsPref().getCmsCacheTime() > 0 && KohlsPhoneApplication.getInstance()
                    .getKohlsPref()
                    .getCmsCacheTime() != flushData.getPayload().getCms()) {
                ((InMemoryCMSRegion) InMemoryCacheHelper.getRegion(InMemoryCacheHelper.REGION_CMS,
                        null)).flush();
            }

            if (KohlsPhoneApplication.getInstance().getKohlsPref().getCategoryCacheTime() == 0) {
                KohlsPhoneApplication.getInstance()
                        .getKohlsPref()
                        .setCacheTimeCategory(flushData.getPayload().getCategories());
            } else if (KohlsPhoneApplication.getInstance().getKohlsPref().getCategoryCacheTime() > 0 && KohlsPhoneApplication.getInstance()
                    .getKohlsPref()
                    .getCategoryCacheTime() != flushData.getPayload().getCategories()) {
                ((InMemoryCategoryRegion) InMemoryCacheHelper.getRegion(InMemoryCacheHelper.REGION_CATEGORY,
                        null)).flush();
            }

            if (KohlsPhoneApplication.getInstance().getKohlsPref().getCatalogCacheTime() == 0) {
                KohlsPhoneApplication.getInstance()
                        .getKohlsPref()
                        .setCacheTimeCatalog(flushData.getPayload().getCatalogs());
            } else if (KohlsPhoneApplication.getInstance().getKohlsPref().getCmsCacheTime() > 0 && KohlsPhoneApplication.getInstance()
                    .getKohlsPref()
                    .getCatalogCacheTime() != flushData.getPayload().getCatalogs()) {
                ((InMemoryCatalogRegion) InMemoryCacheHelper.getRegion(InMemoryCacheHelper.REGION_CATALOG,
                        null)).flush();
            }

        }
    }

    @Override
    public void onFailure(Error ex) {
        // TODO Auto-generated method stub

    }

    @Override
    public Error getPayloadError(IValueObject payload) {
        // TODO Auto-generated method stub
        return null;
    }

}
