
package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.kohls.mcommerce.opal.framework.vo.ErrorVO;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.io.Serializable;
import java.util.List;

public class DeleteShippingAddressVO implements IValueObject, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1350862187189805100L;

    // "payload": {
    // "message": "Profile Updated Successfully"
    // }

    private List<ErrorVO> errors;

    private payload payload;

    public List<ErrorVO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVO> errors) {
        this.errors = errors;
    }

    public payload getPayload() {
        return payload;
    }

    public void setPayload(payload payload) {
        this.payload = payload;
    }

    static class payload {
        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
