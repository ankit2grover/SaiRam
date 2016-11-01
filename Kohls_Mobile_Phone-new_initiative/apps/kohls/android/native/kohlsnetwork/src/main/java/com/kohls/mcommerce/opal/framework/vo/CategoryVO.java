
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CategoryVO implements IValueObject, Serializable {
    private static final long serialVersionUID = 8L;

    @Expose
    private Payload payload;

    @Expose
    private String expiryTime;

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    @Expose
    private ResponseHeader responseHeaders;

    public ResponseHeader getResponseHeaders() {
        return responseHeaders;
    }

    public void setResponseHeaders(ResponseHeader responseHeaders) {
        this.responseHeaders = responseHeaders;
    }

    public class ResponseHeader implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 2L;

        @Expose
        private String Expires;

        public String getExpires() {
            return this.Expires;
        }

        public void setExpires(String expires) {
            this.Expires = expires;
        }

    }

    public static class Payload implements Serializable {
        private static final long serialVersionUID = 9L;

        @Expose
        private ResponseHeader responseHeaders;

        public ResponseHeader getResponseHeaders() {
            return responseHeaders;
        }

        public void setResponseHeaders(ResponseHeader responseHeaders) {
            this.responseHeaders = responseHeaders;
        }

        public class ResponseHeader implements Serializable {

            /**
             * 
             */
            private static final long serialVersionUID = 2L;

            @Expose
            private String Expires;

            public String getExpires() {
                return this.Expires;
            }

            public void setExpires(String expires) {
                this.Expires = expires;
            }

        }

        @Expose
        private List<Category> categories;

        public List<Category> getCategories() {
            return categories;
        }

        public void setCategories(List<Category> categories) {
            this.categories = categories;
        }

        public static class Category implements Serializable {
            private static final long serialVersionUID = 81L;

            @Expose
            private String name;

            @Expose
            private String type;

            @Expose
            private String resourcePath;

            @Expose
            private Integer index;

            @Expose
            private List<Category> categories = new ArrayList<Category>();

            @Expose
            private String ID;

            @Expose
            private String expiryTime;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getResourcePath() {
                return resourcePath;
            }

            public void setResourcePath(String resourcePath) {
                this.resourcePath = resourcePath;
            }

            public Integer getIndex() {
                return index;
            }

            public void setIndex(Integer index) {
                this.index = index;
            }

            public List<Category> getCategories() {
                return categories;
            }

            public void setCategories(List<Category> categories) {
                this.categories = categories;
            }

            public String getID() {
                return ID;
            }

            public void setID(String ID) {
                this.ID = ID;
            }

            public String getExpiryTime() {
                return expiryTime;
            }

            public void setExpiryTime(String expiryTime) {
                this.expiryTime = expiryTime;
            }

        }
    }

}
