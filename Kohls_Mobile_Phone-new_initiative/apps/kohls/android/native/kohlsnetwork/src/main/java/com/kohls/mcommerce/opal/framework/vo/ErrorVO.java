
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

public class ErrorVO {

    @Expose
    private String code;

    @Expose
    private String message;

    @Expose
    private String entity;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getEntity() {
        return entity;
    }

    public void setEntity(String entity) {
        this.entity = entity;
    }

}
