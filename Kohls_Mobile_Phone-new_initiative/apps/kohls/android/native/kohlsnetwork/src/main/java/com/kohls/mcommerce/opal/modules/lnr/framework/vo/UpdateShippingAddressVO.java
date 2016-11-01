
package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.kohls.mcommerce.opal.framework.vo.ErrorVO;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.io.Serializable;
import java.util.List;

public class UpdateShippingAddressVO implements IValueObject, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -5272920482739687565L;

    private List<ErrorVO> errors;

    private Payload payload;

    public List<ErrorVO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVO> errors) {
        this.errors = errors;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public static class Payload {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        private String message;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
