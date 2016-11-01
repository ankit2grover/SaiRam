
package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;
import com.kohls.mcommerce.opal.modules.lnr.framework.vo.MyRegistryVO.WishList;

import java.io.Serializable;
import java.util.List;

public class ManageRegistryVO implements Serializable, IValueObject {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Expose
    private int responseCode;

    @Expose
    private String responseMessage;

    private List<WishList> lists;

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

    public List<WishList> getLists() {
        return lists;
    }

    public void setLists(List<WishList> lists) {
        this.lists = lists;
    }

}
