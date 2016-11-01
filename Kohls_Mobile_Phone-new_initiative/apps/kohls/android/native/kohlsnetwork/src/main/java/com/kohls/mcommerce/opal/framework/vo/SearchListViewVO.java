
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class SearchListViewVO implements IValueObject {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Expose
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Expose
    private String url;

    public String getURL() {
        return url;
    }

    public void setURL(String url) {
        this.url = url;
    }

    @Expose
    private String hideHeader;

    public String getHideHeader() {
        return hideHeader;
    }

    public void setHideHeader(String hideHeader) {
        this.hideHeader = hideHeader;
    }

    @Expose
    private String animated;

    public String getAnimated() {
        return animated;
    }

    public void setAnimated(String animated) {
        this.animated = animated;
    }

    @Expose
    private ScreenProperties screenProperties;

    public class ScreenProperties implements Serializable {

        /**
		 * 
		 */
        private static final long serialVersionUID = 2L;

        @Expose
        private String title;

    }

}
