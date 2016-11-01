package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.util.ArrayList;
import java.util.List;

public class UpdateListItemVO implements IValueObject{
    @Expose
    private int responseCode;

    @Expose
    private String responseMessage;
    @Expose
    private List<ListItem> listItems = new ArrayList<ListItem>();

    private int smartListTotalQuantity;

    private int listTotalQuantity;

    private int listPurchaseQuantity;

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

    public List<ListItem> getListItems() {
        return listItems;
    }

    public void setListItems(List<ListItem> listItems) {
        this.listItems = listItems;
    }

    public int getSmartListTotalQuantity() {
        return smartListTotalQuantity;
    }

    public void setSmartListTotalQuantity(int smartListTotalQuantity) {
        this.smartListTotalQuantity = smartListTotalQuantity;
    }

    public int getListTotalQuantity() {
        return listTotalQuantity;
    }

    public void setListTotalQuantity(int listTotalQuantity) {
        this.listTotalQuantity = listTotalQuantity;
    }

    public int getListPurchaseQuantity() {
        return listPurchaseQuantity;
    }

    public void setListPurchaseQuantity(int listPurchaseQuantity) {
        this.listPurchaseQuantity = listPurchaseQuantity;
    }

}
