
package com.kohls.mcommerce.opal.framework.vo;


public class AddListVO implements IValueObject {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private int responseCode;


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
