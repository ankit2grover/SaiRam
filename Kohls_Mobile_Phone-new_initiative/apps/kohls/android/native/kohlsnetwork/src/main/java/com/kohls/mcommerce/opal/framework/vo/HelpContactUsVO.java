
package com.kohls.mcommerce.opal.framework.vo;

import java.util.ArrayList;
import java.util.List;

public class HelpContactUsVO implements IValueObject {

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

    public static class Payload {

        private String responseMessage;

        private List<EntryResponse> entryResponse = new ArrayList<EntryResponse>();

        private Integer responseCode;

        public String getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
        }

        public List<EntryResponse> getEntryResponse() {
            return entryResponse;
        }

        public void setEntryResponse(List<EntryResponse> entryResponse) {
            this.entryResponse = entryResponse;
        }

        public Integer getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(Integer responseCode) {
            this.responseCode = responseCode;
        }

    }

    public static class Properties {

        private String HOURS_WEDNESDAY;

        private String CALIFORNIA_PRIVACY_POLICY;

        private String HOURS_MONDAY;

        private String LEGAL_NOTICES;

        private String PRIVACY_POLICY;

        private String HOURS_FRIDAY;

        private String HOURS_TUESDAY;

        private String HOURS_SUNDAY;

        private String EMAIL_CUSTOMER_SERVICE;

        private String CALL_TOLL_FREE;

        private String HOURS_SATURDAY;

        private String HOURS_THURSDAY;

        public String getHOURS_WEDNESDAY() {
            return HOURS_WEDNESDAY;
        }

        public void setHOURS_WEDNESDAY(String HOURS_WEDNESDAY) {
            this.HOURS_WEDNESDAY = HOURS_WEDNESDAY;
        }

        public String getCALIFORNIA_PRIVACY_POLICY() {
            return CALIFORNIA_PRIVACY_POLICY;
        }

        public void setCALIFORNIA_PRIVACY_POLICY(String CALIFORNIA_PRIVACY_POLICY) {
            this.CALIFORNIA_PRIVACY_POLICY = CALIFORNIA_PRIVACY_POLICY;
        }

        public String getHOURS_MONDAY() {
            return HOURS_MONDAY;
        }

        public void setHOURS_MONDAY(String HOURS_MONDAY) {
            this.HOURS_MONDAY = HOURS_MONDAY;
        }

        public String getLEGAL_NOTICES() {
            return LEGAL_NOTICES;
        }

        public void setLEGAL_NOTICES(String LEGAL_NOTICES) {
            this.LEGAL_NOTICES = LEGAL_NOTICES;
        }

        public String getPRIVACY_POLICY() {
            return PRIVACY_POLICY;
        }

        public void setPRIVACY_POLICY(String PRIVACY_POLICY) {
            this.PRIVACY_POLICY = PRIVACY_POLICY;
        }

        public String getHOURS_FRIDAY() {
            return HOURS_FRIDAY;
        }

        public void setHOURS_FRIDAY(String HOURS_FRIDAY) {
            this.HOURS_FRIDAY = HOURS_FRIDAY;
        }

        public String getHOURS_TUESDAY() {
            return HOURS_TUESDAY;
        }

        public void setHOURS_TUESDAY(String HOURS_TUESDAY) {
            this.HOURS_TUESDAY = HOURS_TUESDAY;
        }

        public String getHOURS_SUNDAY() {
            return HOURS_SUNDAY;
        }

        public void setHOURS_SUNDAY(String HOURS_SUNDAY) {
            this.HOURS_SUNDAY = HOURS_SUNDAY;
        }

        public String getEMAIL_CUSTOMER_SERVICE() {
            return EMAIL_CUSTOMER_SERVICE;
        }

        public void setEMAIL_CUSTOMER_SERVICE(String EMAIL_CUSTOMER_SERVICE) {
            this.EMAIL_CUSTOMER_SERVICE = EMAIL_CUSTOMER_SERVICE;
        }

        public String getCALL_TOLL_FREE() {
            return CALL_TOLL_FREE;
        }

        public void setCALL_TOLL_FREE(String CALL_TOLL_FREE) {
            this.CALL_TOLL_FREE = CALL_TOLL_FREE;
        }

        public String getHOURS_SATURDAY() {
            return HOURS_SATURDAY;
        }

        public void setHOURS_SATURDAY(String HOURS_SATURDAY) {
            this.HOURS_SATURDAY = HOURS_SATURDAY;
        }

        public String getHOURS_THURSDAY() {
            return HOURS_THURSDAY;
        }

        public void setHOURS_THURSDAY(String HOURS_THURSDAY) {
            this.HOURS_THURSDAY = HOURS_THURSDAY;
        }

    }

    public static class EntryResponse {

        private Object responseMessage;

        private List<Entry> entries = new ArrayList<Entry>();

        private Integer responseCode;

        private List<Integer> totalEntries = new ArrayList<Integer>();

        private Object campaignProperties;

        private String poolName;

        private Object formattedEntryProps;

        public Object getResponseMessage() {
            return responseMessage;
        }

        public void setResponseMessage(Object responseMessage) {
            this.responseMessage = responseMessage;
        }

        public List<Entry> getEntries() {
            return entries;
        }

        public void setEntries(List<Entry> entries) {
            this.entries = entries;
        }

        public Integer getResponseCode() {
            return responseCode;
        }

        public void setResponseCode(Integer responseCode) {
            this.responseCode = responseCode;
        }

        public List<Integer> getTotalEntries() {
            return totalEntries;
        }

        public void setTotalEntries(List<Integer> totalEntries) {
            this.totalEntries = totalEntries;
        }

        public Object getCampaignProperties() {
            return campaignProperties;
        }

        public void setCampaignProperties(Object campaignProperties) {
            this.campaignProperties = campaignProperties;
        }

        public String getPoolName() {
            return poolName;
        }

        public void setPoolName(String poolName) {
            this.poolName = poolName;
        }

        public Object getFormattedEntryProps() {
            return formattedEntryProps;
        }

        public void setFormattedEntryProps(Object formattedEntryProps) {
            this.formattedEntryProps = formattedEntryProps;
        }

    }

    public class Entry {

        private Integer campaignId;

        private Integer createdTime;

        private Integer status;

        private Boolean ugc;

        private Properties properties;

        private Integer endTime;

        private Object feedItemId;

        private Integer mediaType;

        private String fileUrl;

        private Integer id;

        private String title;

        private Object mediacontenttype;

        private Integer mediasize;

        private Integer userId;

        private Object comment;

        private Object itemUrl;

        public Integer getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(Integer campaignId) {
            this.campaignId = campaignId;
        }

        public Integer getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(Integer createdTime) {
            this.createdTime = createdTime;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
        }

        public Boolean getUgc() {
            return ugc;
        }

        public void setUgc(Boolean ugc) {
            this.ugc = ugc;
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

        public Object getFeedItemId() {
            return feedItemId;
        }

        public void setFeedItemId(Object feedItemId) {
            this.feedItemId = feedItemId;
        }

        public Integer getMediaType() {
            return mediaType;
        }

        public void setMediaType(Integer mediaType) {
            this.mediaType = mediaType;
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

        public Integer getMediasize() {
            return mediasize;
        }

        public void setMediasize(Integer mediasize) {
            this.mediasize = mediasize;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
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

}
