
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;

public class FlushdataVO implements IValueObject, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    @Expose
    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 2L;

        @Expose
        private long cms;

        public long getCms() {
            return cms;
        }

        public void setCms(long cms) {
            this.cms = cms;
        }

        @Expose
        private long catalogs;

        public long getCatalogs() {
            return catalogs;
        }

        public void setCatalogs(long catalogs) {
            this.catalogs = catalogs;
        }

        @Expose
        private long categories;

        public long getCategories() {
            return categories;
        }

        public void setCategories(long categories) {
            this.categories = categories;
        }
    }

}
