
package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;
import java.util.List;

public class CalculateOrderVO implements IValueObject, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private String expiryTime;

    private String responseID;

    private List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public static class Error {

        private String message;

        private String code;

        private String entity;

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

    }

    private Payload payload;

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getResponseID() {
        return responseID;
    }

    public void setResponseID(String responseID) {
        this.responseID = responseID;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public static class Payload {

        private Order order;

        public Order getOrder() {
            return order;
        }

        public void setOrder(Order order) {
            this.order = order;
        }

        public static class Order {

            private List<CartItem> cartItems;

            public List<CartItem> getCartItems() {
                return cartItems;
            }

            public void setCartItems(List<CartItem> cartItems) {
                this.cartItems = cartItems;
            }

            private Totals totals;

            public Totals getTotals() {
                return totals;
            }

            public void setTotals(Totals totals) {
                this.totals = totals;
            }

            private OrderItemsCount orderItemsCount;

            public OrderItemsCount getOrderItemsCount() {
                return orderItemsCount;
            }

            public void setOrderItemsCount(OrderItemsCount orderItemsCount) {
                this.orderItemsCount = orderItemsCount;
            }

            public static class OrderItemsCount {

                private Integer pickUpCount;

                private Integer shipCount;

                public Integer getPickUpCount() {
                    return pickUpCount;
                }

                public void setPickUpCount(Integer pickUpCount) {
                    this.pickUpCount = pickUpCount;
                }

                public Integer getShipCount() {
                    return shipCount;
                }

                public void setShipCount(Integer shipCount) {
                    this.shipCount = shipCount;
                }

            }

            public static class Totals {

                private ShipMeter shipMeter;

                public ShipMeter getShipMeter() {
                    return shipMeter;
                }

                public void setShipMeter(ShipMeter shipMeter) {
                    this.shipMeter = shipMeter;
                }

                public static class ShipMeter {
                    private boolean isFreeShipping;

                    public boolean isFreeShipping() {
                        return isFreeShipping;
                    }

                    public void setFreeShipping(boolean isFreeShipping) {
                        this.isFreeShipping = isFreeShipping;
                    }

                }
            }

            public static class CartItem {

                private Error error;

                public Error getError() {
                    return error;
                }

                public void setError(Error error) {
                    this.error = error;
                }

                public static class Error {

                    private String message;

                    private String code;

                    public String getMessage() {
                        return message;
                    }

                    public void setMessage(String message) {
                        this.message = message;
                    }

                    public String getCode() {
                        return code;
                    }

                    public void setCode(String code) {
                        this.code = code;
                    }

                }

            }

        }
    }

}
