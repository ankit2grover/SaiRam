
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

public class AddRegistryVO implements IValueObject {

    @Expose
    private int responseCode;

    @Expose
    private String responseMessage;

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

}
