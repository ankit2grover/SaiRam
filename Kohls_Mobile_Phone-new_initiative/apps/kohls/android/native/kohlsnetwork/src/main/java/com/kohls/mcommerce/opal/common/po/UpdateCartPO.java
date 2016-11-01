
package com.kohls.mcommerce.opal.common.po;

import java.util.List;

public class UpdateCartPO {

    private ParamsPO params;

    private String access_token;

    public String getaccess_token() {
        return access_token;
    }

    public void setaccess_token(String access_token) {
        this.access_token = access_token;
    }

    public ParamsPO getparams() {
        return params;
    }

    public void setparams(ParamsPO params) {
        this.params = params;
    }

    public class ParamsPO {

        private PayloadPO payload;

        public PayloadPO getpayload() {
            return payload;
        }

        public void setpayload(PayloadPO payload) {
            this.payload = payload;
        }

        public class PayloadPO {

            private CartPO cart;

            public CartPO getcart() {
                return cart;
            }

            public void setcart(CartPO cart) {
                this.cart = cart;
            }

            public class CartPO {

                private List<CartItemPO> cartItems;

                private String cartID;

                public void setCartID(String cartID) {
                    this.cartID = cartID;
                }

                public List<CartItemPO> getCartItems() {
                    return cartItems;
                }

                public void setCartItems(List<CartItemPO> cartItems) {
                    this.cartItems = cartItems;
                }

                public class CartItemPO {

                    private String cartItemID;

                    private boolean giftItem;

                    private String skuCode;

                    private RegistryPO registry;

                    private boolean bopusItem;

                    private String storeNum;

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    private String itemType;

                    public RegistryPO getregistry() {
                        return registry;
                    }

                    public void setregistry(RegistryPO registry) {
                        this.registry = registry;
                    }

                    public String getCartItemID() {
                        return cartItemID;
                    }

                    public void setCartItemID(String cartItemID) {
                        this.cartItemID = cartItemID;
                    }

                    public String getStoreNum() {
                        return storeNum;
                    }

                    public void setStoreNum(String storeNum) {
                        this.storeNum = storeNum;
                    }

                    public boolean isGiftItem() {
                        return giftItem;
                    }

                    public void setGiftItem(boolean giftItem) {
                        this.giftItem = giftItem;
                    }

                    public class RegistryPO {

                        private String registryName;

                        private String registryType;

                        private String registryID;

                        private String shipToId;

                        private String wantedQty;

                        public String getwantedQty() {
                            return wantedQty;
                        }

                        public void setwantedQty(String wantedQty) {
                            this.wantedQty = wantedQty;
                        }

                        public String getshipToId() {
                            return shipToId;
                        }

                        public void setshipToId(String shipToId) {
                            this.shipToId = shipToId;
                        }

                        public String getRegistryType() {
                            return registryType;
                        }

                        public void setRegistryType(String registryType) {
                            this.registryType = registryType;
                        }

                        public String getRegistryId() {
                            return registryID;
                        }

                        public void setRegistryId(String registryId) {
                            this.registryID = registryId;
                        }

                        public String getRegistryName() {
                            return registryName;
                        }

                        public void setRegistryName(String registryName) {
                            this.registryName = registryName;
                        }

                    }

                    public String getSkuCode() {
                        return skuCode;
                    }

                    public void setSkuCode(String skuCode) {
                        this.skuCode = skuCode;
                    }

                    private String qty;

                    public String getQty() {
                        return qty;
                    }

                    public void setQty(String qty) {
                        this.qty = qty;
                    }

                    private String action;

                    public String getAction() {
                        return action;
                    }

                    public void setAction(String action) {
                        this.action = action;
                    }

                    public boolean isBopusItem() {
                        return bopusItem;
                    }

                    public void setBopusItem(boolean bopusItem) {
                        this.bopusItem = bopusItem;
                    }

                }
            }
        }
    }

}

