
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class RegistryResponseVO implements IValueObject {

    private String expiryTime;

    private Payload payload;

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
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

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public static class Payload {
        private Integer responseCode;

        private String responseMessage;

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

        private List<Entries> entries;

        public List<Entries> getEntries() {
            return entries;
        }

        public void setEntries(List<Entries> entries) {
            this.entries = entries;
        }

        public static class Entries {
            private int id;

            private Integer campaignId;

            private Integer status;

            private Integer userId;

            private Integer createdTime;

            private Integer mediaType;

            private String feedItemId;

            private String mediacontenttype;

            private Integer mediasize;

            private String fileUrl;

            private String itemUrl;

            private String title;

            private String comment;

            private Integer endTime;

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

            private Properties properties;

            public Properties getProperties() {
                return properties;
            }

            public void setProperties(Properties properties) {
                this.properties = properties;
            }

            public static class Properties {

                private String Target_Loyalty_SignedIn_2;

                private String Target_Loyalty_SignedIn_1;

                private String Image_Loyalty_SignedIn_2;

                private String Image_Loyalty_SignedIn_1;

                private String Target_Recommendation_Signed;

                private String Image_Recommendation_Signed;

                private String ModuleName;

                public String getModuleName() {
                    return ModuleName;
                }

                public void setModuleName(String moduleName) {
                    ModuleName = moduleName;
                }

                public String getTarget_Loyalty_SignedIn_2() {
                    return Target_Loyalty_SignedIn_2;
                }

                public void setTarget_Loyalty_SignedIn_2(String target_Loyalty_SignedIn_2) {
                    Target_Loyalty_SignedIn_2 = target_Loyalty_SignedIn_2;
                }

                public String getTarget_Loyalty_SignedIn_1() {
                    return Target_Loyalty_SignedIn_1;
                }

                public void setTarget_Loyalty_SignedIn_1(String target_Loyalty_SignedIn_1) {
                    Target_Loyalty_SignedIn_1 = target_Loyalty_SignedIn_1;
                }

                public String getImage_Loyalty_SignedIn_2() {
                    return Image_Loyalty_SignedIn_2;
                }

                public void setImage_Loyalty_SignedIn_2(String image_Loyalty_SignedIn_2) {
                    Image_Loyalty_SignedIn_2 = image_Loyalty_SignedIn_2;
                }

                public String getImage_Loyalty_SignedIn_1() {
                    return Image_Loyalty_SignedIn_1;
                }

                public void setImage_Loyalty_SignedIn_1(String image_Loyalty_SignedIn_1) {
                    Image_Loyalty_SignedIn_1 = image_Loyalty_SignedIn_1;
                }

                public String getTarget_Recommendation_Signed() {
                    return Target_Recommendation_Signed;
                }

                public void setTarget_Recommendation_Signed(String target_Recommendation_Signed) {
                    Target_Recommendation_Signed = target_Recommendation_Signed;
                }

                public String getImage_Recommendation_Signed() {
                    return Image_Recommendation_Signed;
                }

                public void setImage_Recommendation_Signed(String image_Recommendation_Signed) {
                    Image_Recommendation_Signed = image_Recommendation_Signed;
                }

            }

            private boolean ugc;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getCampaignId() {
                return campaignId;
            }

            public void setCampaignId(int campaignId) {
                this.campaignId = campaignId;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getCreatedTime() {
                return createdTime;
            }

            public void setCreatedTime(int createdTime) {
                this.createdTime = createdTime;
            }

            public int getMediaType() {
                return mediaType;
            }

            public void setMediaType(int mediaType) {
                this.mediaType = mediaType;
            }

            public String getFeedItemId() {
                return feedItemId;
            }

            public void setFeedItemId(String feedItemId) {
                this.feedItemId = feedItemId;
            }

            public String getMediacontenttype() {
                return mediacontenttype;
            }

            public void setMediacontenttype(String mediacontenttype) {
                this.mediacontenttype = mediacontenttype;
            }

            public int getMediasize() {
                return mediasize;
            }

            public void setMediasize(int mediasize) {
                this.mediasize = mediasize;
            }

            public String getFileUrl() {
                return fileUrl;
            }

            public void setFileUrl(String fileUrl) {
                this.fileUrl = fileUrl;
            }

            public String getItemUrl() {
                return itemUrl;
            }

            public void setItemUrl(String itemUrl) {
                this.itemUrl = itemUrl;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getComment() {
                return comment;
            }

            public void setComment(String comment) {
                this.comment = comment;
            }

            public int getEndTime() {
                return endTime;
            }

            public void setEndTime(int endTime) {
                this.endTime = endTime;
            }

            public boolean isUgc() {
                return ugc;
            }

            public void setUgc(boolean ugc) {
                this.ugc = ugc;
            }

        }

        public Integer getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(Integer responseCode) {
            this.responseCode = responseCode;
        }

        public String getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
        }
    }

}
