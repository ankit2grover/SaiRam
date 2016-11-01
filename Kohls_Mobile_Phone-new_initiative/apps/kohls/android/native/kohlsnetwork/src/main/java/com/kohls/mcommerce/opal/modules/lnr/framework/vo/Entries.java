package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.io.Serializable;

public class Entries implements IValueObject, Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Expose
    private int entryId;
    @Expose
    private int campaignId;
    @Expose
    private int userId;
    @Expose
    private Long createdTime;
    @Expose
    private int mediaType;
    @Expose
    private String feedItemId;
    @Expose
    private String fileUrl;
    @Expose
    private String itemUrl;
    @Expose
    private String title;
    @Expose
    private String comment;
    @Expose
    private Long startTime;
    @Expose
    private Long endTime;
    @Expose
    private Properties properties;
    @Expose
    private Boolean ugc;

    /**
     *
     * @return
     * The entryId
     */
    public int getEntryId() {
        return entryId;
    }

    /**
     *
     * @param entryId
     * The entryId
     */
    public void setEntryId(int entryId) {
        this.entryId = entryId;
    }

    /**
     *
     * @return
     * The campaignId
     */
    public int getCampaignId() {
        return campaignId;
    }

    /**
     *
     * @param campaignId
     * The campaignId
     */
    public void setCampaignId(int campaignId) {
        this.campaignId = campaignId;
    }

    /**
     *
     * @return
     * The userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     *
     * @param userId
     * The userId
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

    /**
     *
     * @return
     * The createdTime
     */
    public Long getCreatedTime() {
        return createdTime;
    }

    /**
     *
     * @param createdTime
     * The createdTime
     */
    public void setCreatedTime(Long createdTime) {
        this.createdTime = createdTime;
    }

    /**
     *
     * @return
     * The mediaType
     */
    public int getMediaType() {
        return mediaType;
    }

    /**
     *
     * @param mediaType
     * The mediaType
     */
    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    /**
     *
     * @return
     * The feedItemId
     */
    public String getFeedItemId() {
        return feedItemId;
    }

    /**
     *
     * @param feedItemId
     * The feedItemId
     */
    public void setFeedItemId(String feedItemId) {
        this.feedItemId = feedItemId;
    }

    /**
     *
     * @return
     * The fileUrl
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     *
     * @param fileUrl
     * The fileUrl
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     *
     * @return
     * The itemUrl
     */
    public String getItemUrl() {
        return itemUrl;
    }

    /**
     *
     * @param itemUrl
     * The itemUrl
     */
    public void setItemUrl(String itemUrl) {
        this.itemUrl = itemUrl;
    }

    /**
     *
     * @return
     * The title
     */
    public String getTitle() {
        return title;
    }

    /**
     *
     * @param title
     * The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     *
     * @return
     * The comment
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     * The comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     * The startTime
     */
    public Long getStartTime() {
        return startTime;
    }

    /**
     *
     * @param startTime
     * The startTime
     */
    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    /**
     *
     * @return
     * The endTime
     */
    public Long getEndTime() {
        return endTime;
    }

    /**
     *
     * @param endTime
     * The endTime
     */
    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    /**
     *
     * @return
     * The properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     *
     * @param properties
     * The properties
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     *
     * @return
     * The ugc
     */
    public Boolean getUgc() {
        return ugc;
    }

    /**
     *
     * @param ugc
     * The ugc
     */
    public void setUgc(Boolean ugc) {
        this.ugc = ugc;
    }

    public class Properties implements IValueObject,Serializable{

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        @SerializedName("vc.halficonurl")
        @Expose
        private String vcHalficonurl;
        @SerializedName("vc.iconurl")
        @Expose
        private String vcIconurl;
        @SerializedName("ct_prop_0")
        @Expose
        private String ctProp0;
        @SerializedName("ct_prop_1")
        @Expose
        private String ctProp1;
        @SerializedName("ct_prop_2")
        @Expose
        private String ctProp2;
        @SerializedName("ct_prop_3")
        @Expose
        private String ctProp3;
        @SerializedName("ct_prop_5")
        @Expose
        private String ctProp5;
        @SerializedName("ct_prop_6")
        @Expose
        private String ctProp6;
        @SerializedName("ct_prop_7")
        @Expose
        private String ctProp7;
        @SerializedName("ct_prop_9")
        @Expose
        private String ctProp9;
        @SerializedName("ct_prop_12")
        @Expose
        private String ctProp12;
        @SerializedName("ct_prop_11")
        @Expose
        private String ctProp11;
        @SerializedName("vc.scaledurl")
        @Expose
        private String vcScaledurl;
        @SerializedName("ct_prop_14")
        @Expose
        private String ctProp14;
        @SerializedName("ct_prop_15")
        @Expose
        private String ctProp15;
        @SerializedName("ct_prop_16")
        @Expose
        private String ctProp16;
        @SerializedName("ct_prop_17")
        @Expose
        private String ctProp17;
        @SerializedName("ct_prop_18")
        @Expose
        private String ctProp18;
        @SerializedName("ep_isxmldesc")
        @Expose
        private String epIsxmldesc;

        /**
         *
         * @return
         * The vcHalficonurl
         */
        public String getVcHalficonurl() {
            return vcHalficonurl;
        }

        /**
         *
         * @param vcHalficonurl
         * The vc.halficonurl
         */
        public void setVcHalficonurl(String vcHalficonurl) {
            this.vcHalficonurl = vcHalficonurl;
        }

        /**
         *
         * @return
         * The vcIconurl
         */
        public String getVcIconurl() {
            return vcIconurl;
        }

        /**
         *
         * @param vcIconurl
         * The vc.iconurl
         */
        public void setVcIconurl(String vcIconurl) {
            this.vcIconurl = vcIconurl;
        }

        /**
         *
         * @return
         * The ctProp0
         */
        public String getCtProp0() {
            return ctProp0;
        }

        /**
         *
         * @param ctProp0
         * The ct_prop_0
         */
        public void setCtProp0(String ctProp0) {
            this.ctProp0 = ctProp0;
        }

        /**
         *
         * @return
         * The ctProp1
         */
        public String getCtProp1() {
            return ctProp1;
        }

        /**
         *
         * @param ctProp1
         * The ct_prop_1
         */
        public void setCtProp1(String ctProp1) {
            this.ctProp1 = ctProp1;
        }

        /**
         *
         * @return
         * The ctProp2
         */
        public String getCtProp2() {
            return ctProp2;
        }

        /**
         *
         * @param ctProp2
         * The ct_prop_2
         */
        public void setCtProp2(String ctProp2) {
            this.ctProp2 = ctProp2;
        }

        /**
         *
         * @return
         * The ctProp3
         */
        public String getCtProp3() {
            return ctProp3;
        }

        /**
         *
         * @param ctProp3
         * The ct_prop_3
         */
        public void setCtProp3(String ctProp3) {
            this.ctProp3 = ctProp3;
        }

        /**
         *
         * @return
         * The ctProp5
         */
        public String getCtProp5() {
            return ctProp5;
        }

        /**
         *
         * @param ctProp5
         * The ct_prop_5
         */
        public void setCtProp5(String ctProp5) {
            this.ctProp5 = ctProp5;
        }

        /**
         *
         * @return
         * The ctProp6
         */
        public String getCtProp6() {
            return ctProp6;
        }

        /**
         *
         * @param ctProp6
         * The ct_prop_6
         */
        public void setCtProp6(String ctProp6) {
            this.ctProp6 = ctProp6;
        }

        /**
         *
         * @return
         * The ctProp7
         */
        public String getCtProp7() {
            return ctProp7;
        }

        /**
         *
         * @param ctProp7
         * The ct_prop_7
         */
        public void setCtProp7(String ctProp7) {
            this.ctProp7 = ctProp7;
        }

        /**
         *
         * @return
         * The ctProp9
         */
        public String getCtProp9() {
            return ctProp9;
        }

        /**
         *
         * @param ctProp9
         * The ct_prop_9
         */
        public void setCtProp9(String ctProp9) {
            this.ctProp9 = ctProp9;
        }

        /**
         *
         * @return
         * The ctProp12
         */
        public String getCtProp12() {
            return ctProp12;
        }

        /**
         *
         * @param ctProp12
         * The ct_prop_12
         */
        public void setCtProp12(String ctProp12) {
            this.ctProp12 = ctProp12;
        }

        /**
         *
         * @return
         * The ctProp11
         */
        public String getCtProp11() {
            return ctProp11;
        }

        /**
         *
         * @param ctProp11
         * The ct_prop_11
         */
        public void setCtProp11(String ctProp11) {
            this.ctProp11 = ctProp11;
        }

        /**
         *
         * @return
         * The vcScaledurl
         */
        public String getVcScaledurl() {
            return vcScaledurl;
        }

        /**
         *
         * @param vcScaledurl
         * The vc.scaledurl
         */
        public void setVcScaledurl(String vcScaledurl) {
            this.vcScaledurl = vcScaledurl;
        }

        /**
         *
         * @return
         * The ctProp14
         */
        public String getCtProp14() {
            return ctProp14;
        }

        /**
         *
         * @param ctProp14
         * The ct_prop_14
         */
        public void setCtProp14(String ctProp14) {
            this.ctProp14 = ctProp14;
        }

        /**
         *
         * @return
         * The ctProp15
         */
        public String getCtProp15() {
            return ctProp15;
        }

        /**
         *
         * @param ctProp15
         * The ct_prop_15
         */
        public void setCtProp15(String ctProp15) {
            this.ctProp15 = ctProp15;
        }

        /**
         *
         * @return
         * The ctProp16
         */
        public String getCtProp16() {
            return ctProp16;
        }

        /**
         *
         * @param ctProp16
         * The ct_prop_16
         */
        public void setCtProp16(String ctProp16) {
            this.ctProp16 = ctProp16;
        }

        /**
         *
         * @return
         * The ctProp17
         */
        public String getCtProp17() {
            return ctProp17;
        }

        /**
         *
         * @param ctProp17
         * The ct_prop_17
         */
        public void setCtProp17(String ctProp17) {
            this.ctProp17 = ctProp17;
        }

        /**
         *
         * @return
         * The ctProp18
         */
        public String getCtProp18() {
            return ctProp18;
        }

        /**
         *
         * @param ctProp18
         * The ct_prop_18
         */
        public void setCtProp18(String ctProp18) {
            this.ctProp18 = ctProp18;
        }

        /**
         *
         * @return
         * The epIsxmldesc
         */
        public String getEpIsxmldesc() {
            return epIsxmldesc;
        }

        /**
         *
         * @param epIsxmldesc
         * The ep_isxmldesc
         */
        public void setEpIsxmldesc(String epIsxmldesc) {
            this.epIsxmldesc = epIsxmldesc;
        }

    }

}
