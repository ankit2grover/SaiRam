package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.util.ArrayList;

public class FulfillmentActivityVO implements IValueObject {

    @Expose
    private Long responseCode;
    @Expose
    private String responseMessage;
    @Expose
    private ArrayList<Fulfillment> fulfillments = new ArrayList<Fulfillment>();


    public Long getResponseCode() {
        return responseCode;
    }


    public void setResponseCode(Long responseCode) {
        this.responseCode = responseCode;
    }


    public String getResponseMessage() {
        return responseMessage;
    }


    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }


    public ArrayList<Fulfillment> getFulfillments() {
        return fulfillments;
    }


    public void setFulfillments(ArrayList<Fulfillment> fulfillments) {
        this.fulfillments = fulfillments;
    }


    public class Fulfillment implements IValueObject {

        @Expose
        private String itemId;
        @Expose
        private Integer quantity;

        /**
         *
         * @return
         * The itemId
         */
        public String getItemId() {
            return itemId;
        }

        /**
         *
         * @param itemId
         * The itemId
         */
        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        /**
         *
         * @return
         * The quantity
         */
        public Integer getQuantity() {
            return quantity;
        }

        /**
         *
         * @param quantity
         * The quantity
         */
        public void setQuantity(Integer quantity) {
            this.quantity = quantity;
        }

    }

}
