
package com.kohls.mcommerce.opal.common.po;

import com.google.gson.annotations.SerializedName;

public class WriteReviewPO {

    private String action;

    private Payload payload;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload {

        @SerializedName("ProductId")
        private String proDuctId;

        @SerializedName("User")
        private String user;

        @SerializedName("UserNickname")
        private String userNickname;

        @SerializedName("Rating")
        private String rating;

        @SerializedName("Rating_Quality")
        private String ratingQuality;

        @SerializedName("Rating_Value")
        private String ratingValue;

        @SerializedName("Rating_Style")
        private String ratingStyle;

        private String score;

        @SerializedName("Title")
        private String title;

        @SerializedName("ReviewText")
        private String reviewText;

        @SerializedName("IsRecommended")
        private String isRecommended;

        @SerializedName("tag_Pro_1")
        private String tagPro1;

        @SerializedName("tag_Con_1")
        private String tagCon1;

        @SerializedName("UserLocation")
        private String userLocation;

        @SerializedName("SendEmailAlertWhenPublished")
        private String sendEmailAlertWhenPubliShed;

        @SerializedName("SendEmailAlertWhenCommented")
        private String sendEmailAlertWhenCommented;

        @SerializedName("ContextDataValue_Age")
        private String contextDataValueAge;

        private String contextdatavaLueOnlineVisits;

        @SerializedName("Contextdatavalue_StoreVisits")
        private String contextdatavalueStoreVisits;

        @SerializedName("contextdatavalue_stateOfResidence")
        private String contextdatAvalueStateOfResidence;

        private String city;

        @SerializedName("UserEmail")
        private String userEmail;

        private String authorId;

        @SerializedName("CampaignId")
        private String campaignId;

        public String getProDuctId() {
            return proDuctId;
        }

        public void setProDuctId(String proDuctId) {
            this.proDuctId = proDuctId;
        }

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public String getUserNickname() {
            return userNickname;
        }

        public void setUserNickname(String userNickname) {
            this.userNickname = userNickname;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getRatingQuality() {
            return ratingQuality;
        }

        public void setRatingQuality(String ratingQuality) {
            this.ratingQuality = ratingQuality;
        }

        public String getRatingValue() {
            return ratingValue;
        }

        public void setRatingValue(String ratingValue) {
            this.ratingValue = ratingValue;
        }

        public String getRatingStyle() {
            return ratingStyle;
        }

        public void setRatingStyle(String ratingStyle) {
            this.ratingStyle = ratingStyle;
        }

        public String getScore() {
            return score;
        }

        public void setScore(String score) {
            this.score = score;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getReviewText() {
            return reviewText;
        }

        public void setReviewText(String reviewText) {
            this.reviewText = reviewText;
        }

        public String getIsRecommended() {
            return isRecommended;
        }

        public void setIsRecommended(String isRecommended) {
            this.isRecommended = isRecommended;
        }

        public String getTagPro1() {
            return tagPro1;
        }

        public void setTagPro1(String tagPro1) {
            this.tagPro1 = tagPro1;
        }

        public String getTagCon1() {
            return tagCon1;
        }

        public void setTagCon1(String tagCon1) {
            this.tagCon1 = tagCon1;
        }

        public String getUserLocation() {
            return userLocation;
        }

        public void setUserLocation(String userLocation) {
            this.userLocation = userLocation;
        }

        public String getSendEmailAlertWhenPubliShed() {
            return sendEmailAlertWhenPubliShed;
        }

        public void setSendEmailAlertWhenPubliShed(String sendEmailAlertWhenPubliShed) {
            this.sendEmailAlertWhenPubliShed = sendEmailAlertWhenPubliShed;
        }

        public String getSendEmailAlertWhenCommented() {
            return sendEmailAlertWhenCommented;
        }

        public void setSendEmailAlertWhenCommented(String sendEmailAlertWhenCommented) {
            this.sendEmailAlertWhenCommented = sendEmailAlertWhenCommented;
        }

        public String getContextDataValueAge() {
            return contextDataValueAge;
        }

        public void setContextDataValueAge(String contextDataValueAge) {
            this.contextDataValueAge = contextDataValueAge;
        }

        public String getContextdatavaLueOnlineVisits() {
            return contextdatavaLueOnlineVisits;
        }

        public void setContextdatavaLueOnlineVisits(String contextdatavaLueOnlineVisits) {
            this.contextdatavaLueOnlineVisits = contextdatavaLueOnlineVisits;
        }

        public String getContextdatavalueStoreVisits() {
            return contextdatavalueStoreVisits;
        }

        public void setContextdatavalueStoreVisits(String contextdatavalueStoreVisits) {
            this.contextdatavalueStoreVisits = contextdatavalueStoreVisits;
        }

        public String getContextdatAvalueStateOfResidence() {
            return contextdatAvalueStateOfResidence;
        }

        public void setContextdatAvalueStateOfResidence(String contextdatAvalueStateOfResidence) {
            this.contextdatAvalueStateOfResidence = contextdatAvalueStateOfResidence;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
        }

        public String getAuthorId() {
            return authorId;
        }

        public void setAuthorId(String authorId) {
            this.authorId = authorId;
        }

        public String getCampaignId() {
            return campaignId;
        }

        public void setCampaignId(String campaignId) {
            this.campaignId = campaignId;
        }

    }
}
