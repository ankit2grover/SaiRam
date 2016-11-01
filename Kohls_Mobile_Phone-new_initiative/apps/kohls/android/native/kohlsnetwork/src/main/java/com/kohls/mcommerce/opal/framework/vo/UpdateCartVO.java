
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.PersistentGetCartVO.Payload.Cart;

import java.io.Serializable;
import java.util.List;

public class UpdateCartVO implements IValueObject {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Expose
    private List<ErrorVO> errors;

    public List<ErrorVO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVO> errors) {
        this.errors = errors;
    }

    private PayloadObject payload;

    public PayloadObject getPayload() {
        return payload;
    }

    public void setPayload(PayloadObject payload) {
        this.payload = payload;
    }

    public class PayloadObject implements Serializable {

        private static final long serialVersionUID = 2L;

        @Expose
        private Cart cart;

        public Cart getCart() {
            return cart;
        }

    }
}
