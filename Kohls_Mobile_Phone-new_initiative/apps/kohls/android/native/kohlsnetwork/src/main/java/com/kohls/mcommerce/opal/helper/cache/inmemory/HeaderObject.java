
package com.kohls.mcommerce.opal.helper.cache.inmemory;

public class HeaderObject {

    public HeaderObject(String pageType,
            String pageID) {
        this.pageType = pageType;
        this.pageID = pageID;
    }

    private String pageType;

    private String pageID;

    public String getPageID() {
        return pageID;
    }

    public String getPageType() {
        return pageType;
    }

}
