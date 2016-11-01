package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.util.ArrayList;

public class ListDetailVO implements IValueObject{

    @Expose
    private Integer responseCode;
    @Expose
    private String responseMessage;
    @Expose
    private ArrayList<ListItem> listItems = new ArrayList<ListItem>();

    /**
     *
     * @return
     *     The responseCode
     */
    public Integer getResponseCode() {
        return responseCode;
    }

    /**
     *
     * @param responseCode
     *     The responseCode
     */
    public void setResponseCode(Integer responseCode) {
        this.responseCode = responseCode;
    }

    /**
     *
     * @return
     *     The responseMessage
     */
    public String getResponseMessage() {
        return responseMessage;
    }

    /**
     *
     * @param responseMessage
     *     The responseMessage
     */
    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    /**
     *
     * @return
     *     The listItems
     */
    public ArrayList<ListItem> getListItems() {
        return listItems;
    }

    /**
     *
     * @param listItems
     *     The listItems
     */
    public void setListItems(ArrayList<ListItem> listItems) {
        this.listItems = listItems;
    }

}
