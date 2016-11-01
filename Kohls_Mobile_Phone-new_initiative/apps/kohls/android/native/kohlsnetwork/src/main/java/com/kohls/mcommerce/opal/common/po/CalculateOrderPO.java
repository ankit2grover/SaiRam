package com.kohls.mcommerce.opal.common.po;

import java.io.Serializable;
import java.util.List;

public class CalculateOrderPO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private boolean trEnabled;

    private Params params;

    public boolean isTrEnabled() {
        return trEnabled;
    }

    public void setTrEnabled(boolean trEnabled) {
        this.trEnabled = trEnabled;
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public static class Params {
        private Payload payload;

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
                private String shippingMethod;

                private List<CartItems> cartItems;

                public List<CartItems> getCartItems() {
                    return cartItems;
                }

                public void setCartItems(List<CartItems> cartItems) {
                    this.cartItems = cartItems;
                }

                public String getShippingMethod() {
                    return shippingMethod;
                }

                public void setShippingMethod(String shippingMethod) {
                    this.shippingMethod = shippingMethod;
                }

                public boolean checkBopusItemInventory;

                public void setCheckBopusItemInventory(boolean isCheckBopusItemInventory) {
                    checkBopusItemInventory = isCheckBopusItemInventory;
                }

                public static class CartItems {
                    private String qty;

                    private String skuCode;

                    private boolean bopusItem;

                    private String storeNum;

                    public String getQty() {
                        return qty;
                    }

                    public void setQty(String qty) {
                        this.qty = qty;
                    }

                    public String getSkuCode() {
                        return skuCode;
                    }

                    public void setSkuCode(String skuCode) {
                        this.skuCode = skuCode;
                    }

                    public boolean isBopusItem() {
                        return bopusItem;
                    }

                    public void setBopusItem(boolean bopusItem) {
                        this.bopusItem = bopusItem;
                    }

                    public String getStoreNum() {
                        return storeNum;
                    }

                    public void setStoreNum(String storeNum) {
                        this.storeNum = storeNum;
                    }

                }

            }
        }

    }
}