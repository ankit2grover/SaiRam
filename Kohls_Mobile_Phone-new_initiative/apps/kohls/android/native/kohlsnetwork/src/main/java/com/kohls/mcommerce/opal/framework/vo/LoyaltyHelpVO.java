
package com.kohls.mcommerce.opal.framework.vo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoyaltyHelpVO implements IValueObject {

    private String expiryTime;

    private Payload payload;

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

    public class Entry {

        private Integer campaignId;

        private Boolean ugc;

        private Integer status;

        private Integer createdTime;

        private Properties properties;

        private Integer endTime;

        private Integer mediaType;

        private Object feedItemId;

        private String fileUrl;

        private Integer id;

        private String title;

        private Object mediacontenttype;

        private Integer userId;

        private Integer mediasize;

        private Object comment;

        private Object itemUrl;

        public Integer getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(Integer campaignId) {
            this.campaignId = campaignId;
        }

        public Boolean getUgc() {
            return ugc;
        }

        public void setUgc(Boolean ugc) {
            this.ugc = ugc;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Integer getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(Integer createdTime) {
            this.createdTime = createdTime;
        }

        public Properties getProperties() {
            return properties;
        }

        public void setProperties(Properties properties) {
            this.properties = properties;
        }

        public Integer getEndTime() {
            return endTime;
        }

        public void setEndTime(Integer endTime) {
            this.endTime = endTime;
        }

        public Integer getMediaType() {
            return mediaType;
        }

        public void setMediaType(Integer mediaType) {
            this.mediaType = mediaType;
        }

        public Object getFeedItemId() {
            return feedItemId;
        }

        public void setFeedItemId(Object feedItemId) {
            this.feedItemId = feedItemId;
        }

        public String getFileUrl() {
            return fileUrl;
        }

        public void setFileUrl(String fileUrl) {
            this.fileUrl = fileUrl;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Object getMediacontenttype() {
            return mediacontenttype;
        }

        public void setMediacontenttype(Object mediacontenttype) {
            this.mediacontenttype = mediacontenttype;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

        public Integer getMediasize() {
            return mediasize;
        }

        public void setMediasize(Integer mediasize) {
            this.mediasize = mediasize;
        }

        public Object getComment() {
            return comment;
        }

        public void setComment(Object comment) {
            this.comment = comment;
        }

        public Object getItemUrl() {
            return itemUrl;
        }

        public void setItemUrl(Object itemUrl) {
            this.itemUrl = itemUrl;
        }

    }

    public static class EntryResponse {

        private Object responseMessage;

        private Integer responseCode;

        private String poolName;

        private Object campaignProperties;

        private List<Entry> entries = new ArrayList<Entry>();

        private List<Integer> totalEntries = new ArrayList<Integer>();

        private Object formattedEntryProps;

        private Map<String, Object> additionalProperties = new HashMap<String, Object>();

        public Object getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(Object responseMessage) {
            this.responseMessage = responseMessage;
        }

        public Integer getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(Integer responseCode) {
            this.responseCode = responseCode;
        }

        public String getPoolName() {
            return poolName;
        }

        public void setPoolName(String poolName) {
            this.poolName = poolName;
        }

        public Object getCampaignProperties() {
            return campaignProperties;
        }

        public void setCampaignProperties(Object campaignProperties) {
            this.campaignProperties = campaignProperties;
        }

        public List<Entry> getEntries() {
            return entries;
        }

        public void setEntries(List<Entry> entries) {
            this.entries = entries;
        }

        public List<Integer> getTotalEntries() {
            return totalEntries;
        }

        public void setTotalEntries(List<Integer> totalEntries) {
            this.totalEntries = totalEntries;
        }

        public Object getFormattedEntryProps() {
            return formattedEntryProps;
        }

        public void setFormattedEntryProps(Object formattedEntryProps) {
            this.formattedEntryProps = formattedEntryProps;
        }

        public Map<String, Object> getAdditionalProperties() {
            return this.additionalProperties;
        }

        public void setAdditionalProperty(String name,
                Object value) {
            this.additionalProperties.put(name, value);
        }

    }

    public static class Payload {

        private String expiryTime;

        private String responseMessage;

        private Integer responseCode;

        private ResponseHeaders responseHeaders;

        private List<EntryResponse> entryResponse = new ArrayList<EntryResponse>();

        public String getExpiryTime() {
            return expiryTime;
        }

        public void setExpiryTime(String expiryTime) {
            this.expiryTime = expiryTime;
        }

        public String getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
        }

        public Integer getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(Integer responseCode) {
            this.responseCode = responseCode;
        }

        public ResponseHeaders getResponseHeaders() {
            return responseHeaders;
        }

        public void setResponseHeaders(ResponseHeaders responseHeaders) {
            this.responseHeaders = responseHeaders;
        }

        public List<EntryResponse> getEntryResponse() {
            return entryResponse;
        }

        public void setEntryResponse(List<EntryResponse> entryResponse) {
            this.entryResponse = entryResponse;
        }

    }

    public static class Properties {

        // private String program_details;
        private String program_details_image;

        private String program_details_content;

        private String terms_and_conditions;

        private String faq;

        public String getProgramDetails() {
            return program_details_content;
        }

        public String getTerms_and_conditions() {
            return terms_and_conditions;
        }

        public void setTerms_and_conditions(String termsAndConditions) {
            this.terms_and_conditions = termsAndConditions;
        }

        public String getFaq() {
            return faq;
        }

        public void setFaq(String faq) {
            this.faq = faq;
        }

        public String getProgram_details_image() {
            return program_details_image;
        }

        public void setProgram_details_image(String program_details_image) {
            this.program_details_image = program_details_image;
        }

        public String getProgram_details_content() {
            return program_details_content;
        }

        public void setProgram_details_content(String program_details_content) {
            this.program_details_content = program_details_content;
        }

    }

    public static class ResponseHeaders {

        private String date;

        private String contentLength;

        private String expires;

        private String contentType;

        private String xPoweredBy;

        private String cacheControl;

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getContentLength() {
            return contentLength;
        }

        public void setContentLength(String contentLength) {
            this.contentLength = contentLength;
        }

        public String getExpires() {
            return expires;
        }

        public void setExpires(String expires) {
            this.expires = expires;
        }

        public String getContentType() {
            return contentType;
        }

        public void setContentType(String contentType) {
            this.contentType = contentType;
        }

        public String getXPoweredBy() {
            return xPoweredBy;
        }

        public void setXPoweredBy(String xPoweredBy) {
            this.xPoweredBy = xPoweredBy;
        }

        public String getCacheControl() {
            return cacheControl;
        }

        public void setCacheControl(String cacheControl) {
            this.cacheControl = cacheControl;
        }

    }

}
