
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class MyRegistryVO implements IValueObject {

    /**
     * 
     */

    @Expose
    private int responseCode;

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    @Expose
    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    @Expose
    private String loggedInUser;

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    @Expose
    private WishListUser wishListUser;

    public WishListUser getWishListUser() {
        return wishListUser;
    }

    public void setWishListUser(WishListUser wishListUser) {
        this.wishListUser = wishListUser;
    }

    public class WishListUser implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 3L;

        @Expose
        private int userId;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        @Expose
        private String firstName;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }
    }

    @Expose
    private List<MyList> lists;

    public List<MyList> getLists() {
        return lists;
    }

    public void setLists(List<MyList> lists) {
        this.lists = lists;
    }

    public class MyList implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 2L;

        @Expose
        private long listId;

        public long getListId() {
            return listId;
        }

        public void setListId(long listId) {
            this.listId = listId;
        }

        @Expose
        private String listName;

        public String getListName() {
            return listName;
        }

        public void setListName(String listName) {
            this.listName = listName;
        }

        @Expose
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Expose
        private String budget;

        public String getBudget() {
            return budget;
        }

        public void setBudget(String budget) {
            this.budget = budget;
        }

        @Expose
        private boolean isDeleted;

        public boolean isDeleted() {
            return isDeleted;
        }

        public void setDeleted(boolean isDeleted) {
            this.isDeleted = isDeleted;
        }

        @Expose
        private String listEventDate;

        public String getListEventDate() {
            return listEventDate;
        }

        public void setListEventDate(String listEventDate) {
            this.listEventDate = listEventDate;
        }

        @Expose
        private String listViewedTime;

        public String getListViewedTime() {
            return listViewedTime;
        }

        public void setListViewedTime(String listViewedTime) {
            this.listViewedTime = listViewedTime;
        }

        @Expose
        private int numberOfItems;

        public int getNumberOfItems() {
            return numberOfItems;
        }

        public void setNumberOfItems(int numberOfItems) {
            this.numberOfItems = numberOfItems;
        }

        @Expose
        private boolean emailOptIn;

        public boolean isEmailOptIn() {
            return emailOptIn;
        }

        public void setEmailOptIn(boolean emailOptIn) {
            this.emailOptIn = emailOptIn;
        }
    }

}
