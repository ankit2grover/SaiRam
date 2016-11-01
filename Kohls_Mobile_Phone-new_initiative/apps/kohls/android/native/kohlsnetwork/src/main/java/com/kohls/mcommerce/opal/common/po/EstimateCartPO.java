
package com.kohls.mcommerce.opal.common.po;

import java.io.Serializable;
import java.util.List;

public class EstimateCartPO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8L;

    private Params params;

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    private String platform;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

            private Cart cart;

            public Cart getCart() {
                return cart;
            }

            public void setCart(Cart cart) {
                this.cart = cart;
            }

            public static class Cart {

                private List<CartItem> cartItems;

                public List<CartItem> getCartItems() {
                    return cartItems;
                }

                public void setCartItems(List<CartItem> cartItems) {
                    this.cartItems = cartItems;
                }

                public static class CartItem {

                    private String skuCode;

                    private String qty;

                    public String getSkuCode() {
                        return skuCode;
                    }

                    public void setSkuCode(String skuCode) {
                        this.skuCode = skuCode;
                    }

                    public String getQty() {
                        return qty;
                    }

                    public void setQty(String qty) {
                        this.qty = qty;
                    }

                }

            }

        }
    }
}
