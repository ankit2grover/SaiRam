
package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;
import com.kohls.mcommerce.opal.modules.lnr.common.po.ListPO;

import java.io.Serializable;
import java.util.ArrayList;

public class MyListVO implements IValueObject, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Expose
    private int responseCode;

    @Expose
    private String responseMessage;

    @Expose
    private String loggedInUser;

    @Expose
    private int totalNumberOfLists;

    @Expose
    private WishListUser wishListUser;

    @Expose
    private ArrayList<ListPO> lists;

    public ArrayList<ListPO> getLists() {
        return lists;
    }

    public void setLists(ArrayList<ListPO> lists) {
        this.lists = lists;
    }

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

    public int getTotalNumberOfLists() {
        return totalNumberOfLists;
    }

    public void setTotalNumberOfLists(int totalNumberOfLists) {
        this.totalNumberOfLists = totalNumberOfLists;
    }

    public String getLoggedInUser() {
        return loggedInUser;
    }

    public void setLoggedInUser(String loggedInUser) {
        this.loggedInUser = loggedInUser;
    }

    public WishListUser getWishListUser() {
        return wishListUser;
    }

    public void setWishListUser(WishListUser wishListUser) {
        this.wishListUser = wishListUser;
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
