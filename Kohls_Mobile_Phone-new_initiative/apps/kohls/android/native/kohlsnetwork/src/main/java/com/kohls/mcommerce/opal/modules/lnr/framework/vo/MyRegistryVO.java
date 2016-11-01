
package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;
import com.kohls.mcommerce.opal.modules.lnr.common.po.RegistryPO.RProperties;

import java.io.Serializable;

public class MyRegistryVO implements Serializable, IValueObject {
    private static final long serialVersionUID = 1L;

    @Expose
    private int responseCode;

    @Expose
    private String responseMessage;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Expose
    private WishList wishList;

    public WishList getWishList() {
        return wishList;
    }

    public void setWishList(WishList wishList) {
        this.wishList = wishList;
    }

    public static class WishList implements Serializable {

        private static final long serialVersionUID = 3L;

        @Expose
        private long listId;

        private String listName;

        private String type;

        @Expose
        float budget;

        @Expose
        String listEventDate;

        @SerializedName("public")
        boolean isPublic;

        @Expose
        boolean emailOptIn;

        @Expose
        private Long listViewedTime;

        @Expose
        private boolean isDeleted;

        @Expose
        private int totalPurchaseQty;

        @Expose
        private long createdTime;

        @Expose
        private String firstName;

        @Expose
        private long lastUpdatedTime;

        @Expose
        private int numberOfItems;

        private String promoCode;

        private boolean hasPurchased;

        private RProperties registryProperties;

        @Expose
        private WishListUser listuser;

        public long getListId() {
            return listId;
        }

        public void setListId(long listId) {
            this.listId = listId;
        }

        public String getListName() {
            return listName;
        }

        public void setListName(String listName) {
            this.listName = listName;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public float getBudget() {
            return budget;
        }

        public void setBudget(float budget) {
            this.budget = budget;
        }

        public String getListEventDate() {
            return listEventDate;
        }

        public void setListEventDate(String listEventDate) {
            this.listEventDate = listEventDate;
        }

        public boolean isPublic() {
            return isPublic;
        }

        public void setPublic(boolean isPublic) {
            this.isPublic = isPublic;
        }

        public boolean isEmailOptIn() {
            return emailOptIn;
        }

        public void setEmailOptIn(boolean emailOptIn) {
            this.emailOptIn = emailOptIn;
        }

        public Long getListViewedTime() {
            return listViewedTime;
        }

        public void setListViewedTime(Long listViewedTime) {
            this.listViewedTime = listViewedTime;
        }

        public boolean isDeleted() {
            return isDeleted;
        }

        public void setDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        public int getTotalPurchaseQty() {
            return totalPurchaseQty;
        }

        public void setTotalPurchaseQty(int totalPurchaseQty) {
            this.totalPurchaseQty = totalPurchaseQty;
        }

        public long getCreatedTime() {
            return createdTime;
        }

        public void setCreatedTime(long createdTime) {
            this.createdTime = createdTime;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public long getLastUpdatedTime() {
            return lastUpdatedTime;
        }

        public void setLastUpdatedTime(long lastUpdatedTime) {
            this.lastUpdatedTime = lastUpdatedTime;
        }

        public int getNumberOfItems() {
            return numberOfItems;
        }

        public void setNumberOfItems(int numberOfItems) {
            this.numberOfItems = numberOfItems;
        }

        public String getPromoCode() {
            return promoCode;
        }

        public void setPromoCode(String promoCode) {
            this.promoCode = promoCode;
        }

        public boolean isHasPurchased() {
            return hasPurchased;
        }

        public void setHasPurchased(boolean hasPurchased) {
            this.hasPurchased = hasPurchased;
        }

        public RProperties getRegistryProperties() {
            return registryProperties;
        }

        public void setRegistryProperties(RProperties registryProperties) {
            this.registryProperties = registryProperties;
        }

        public WishListUser getListuser() {
            return listuser;
        }

        public void setListuser(WishListUser listuser) {
            this.listuser = listuser;
        }

    }

    public class WishListUser implements Serializable {
        private static final long serialVersionUID = 1L;

        @Expose
        private int userId;

        @Expose
        private String firstName;

        @Expose
        private String lastName;

        @Expose
        private String retailerEmail;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getRetailerEmail() {
            return retailerEmail;
        }

        public void setRetailerEmail(String retailerEmail) {
            this.retailerEmail = retailerEmail;
        }
    }

}
