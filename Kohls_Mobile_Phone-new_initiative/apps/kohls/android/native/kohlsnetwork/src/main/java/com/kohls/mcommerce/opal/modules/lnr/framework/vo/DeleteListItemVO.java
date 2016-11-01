package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.util.List;

public class DeleteListItemVO implements IValueObject {

    @Expose
    private int responseCode;

    @Expose
    private String responseMessage;

    @Expose
    private List<Object> listItems;

    public List<Object> getListItems() {
        return listItems;
    }

    public void setListItems(List<Object> listItems) {
        this.listItems = listItems;
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

}
