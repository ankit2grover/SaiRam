
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class PersistentGetCartVO implements IValueObject {

    @Expose
    private List<ErrorVO> errors;

    public List<ErrorVO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVO> errors) {
        this.errors = errors;
    }

    @Expose
    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload implements IValueObject {

        @Expose
        private Cart cart;

        public Cart getCart() {
            return cart;
        }

        public class Cart implements IValueObject {

            @Expose
            private List<CartItem> cartItems;

            @Expose
            private String cartID;

            @Expose
            private ErrorCart error;

            public ErrorCart getError() {
                return error;
            }

            public class ErrorCart implements Serializable {

                @Expose
                private String message;

                public String getMessage() {
                    return message;
                }

                @Expose
                private String code;

                public String getCode() {
                    return code;
                }

            }

            public List<CartItem> getCartItems() {
                return cartItems;
            }

            public String getCartID() {
                return cartID;
            }

            public class CartItem implements IValueObject {

                @Expose
                private ErrorCartItem error;

                @Expose
                private String cartItemID;

                @Expose
                private boolean isSuccessful;

                @Expose
                private String skuCode;

                @Expose
                private String qty;

                @Expose
                private String webID;

                @Expose
                private String isGiftWrappable;

                @Expose
                private RegistryVO registry;

                @Expose
                private String itemType;

                @Expose
                private StoreAddress storeAddress;

                private List<OffersVO.Payload.Product.ProductOffer> cartItemOffers = new ArrayList<OffersVO.Payload.Product.ProductOffer>();

                public class StoreAddress implements IValueObject {

                    @Expose
                    private String storeNum;

                    public String getStoreNum() {
                        return storeNum;
                    }
                }

                public class RegistryVO implements IValueObject {

                    @Expose
                    private String registryName;

                    @Expose
                    private String registryID;

                    @Expose
                    private String registryType;

                    @Expose
                    private String shipToId;

                    @Expose
                    private String wantedQty;

                    public String getWantedQty() {
                        return wantedQty;
                    }

                    public String getShipToId() {
                        return shipToId;
                    }

                    public String getRegistryType() {
                        return registryType;
                    }

                    public String getregistryID() {
                        return registryID;
                    }

                    public String getRegistryName() {
                        return registryName;
                    }

                }

                public String isGiftWrappable() {
                    return isGiftWrappable;
                }

                public String getItemType() {
                    return itemType;
                }

                public RegistryVO getRegistry() {
                    return registry;
                }

                public String getCartItemID() {
                    return cartItemID;
                }

                public String getQty() {
                    return qty;
                }

                public String getWebId() {
                    return webID;
                }

                public String getSkuCode() {
                    return skuCode;
                }

                public StoreAddress getStoreAddress() {
                    return storeAddress;
                }

                public ErrorCartItem getError() {
                    return error;
                }

                public class ErrorCartItem implements IValueObject {

                    @Expose
                    private String code;

                    public String getCode() {
                        return code;
                    }

                    @Expose
                    private String message;

                    public String getMessage() {
                        return message;
                    }

                }

                public List<OffersVO.Payload.Product.ProductOffer> getCartItemOffers() {
                    return cartItemOffers;
                }

                public void setCartItemOffers(List<OffersVO.Payload.Product.ProductOffer> itemOffers) {
                    this.cartItemOffers = itemOffers;
                }


            }}
    }

}
