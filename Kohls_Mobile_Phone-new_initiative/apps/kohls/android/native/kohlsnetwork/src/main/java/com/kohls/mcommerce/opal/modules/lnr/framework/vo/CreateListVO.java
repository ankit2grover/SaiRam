package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;
import com.kohls.mcommerce.opal.modules.lnr.common.po.ListPO;

public class CreateListVO implements IValueObject {

    @Expose
    private int responseCode;

    @Expose
    private String responseMessage;

    @Expose
    private ListPO wishList;

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

    public ListPO getWishList() {
        return wishList;
    }

    public void setWishList(ListPO wishList) {
        this.wishList = wishList;
    }

}
