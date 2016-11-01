
package com.kohls.mcommerce.opal.framework.vo;

import java.util.List;

public class ForgotPasswordVO implements IValueObject {

    private List<ErrorVO> errors;

    public List<ErrorVO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVO> errors) {
        this.errors = errors;
    }

}
