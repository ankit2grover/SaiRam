
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class EstimateCartVO implements IValueObject, Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8L;

    // Error
    @Expose
    private List<Error> errors;

    public List<Error> getErrors() {
        return errors;
    }

    public void setErrors(List<Error> errors) {
        this.errors = errors;
    }

    public static class Error {

        @Expose
        private String code;

        @Expose
        private String message;

        @Expose
        private String entity;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getEntity() {
            return entity;
        }

        public void setEntity(String entity) {
            this.entity = entity;
        }

    }

    // Payload
    @Expose
    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    /**
     * Products with the EstimateCart Details
     */
    public static class Payload {
        @Expose
        private Cart cart;

        public Cart getCart() {
            return cart;
        }

        public void setCart(Cart cart) {
            this.cart = cart;
        }

        public static class Cart {
            @Expose
            private List<CartItem> cartItems;

            public List<CartItem> getCartItems() {
                return cartItems;
            }

            public void setCartItems(List<CartItem> cartItems) {
                this.cartItems = cartItems;
            }

            public static class CartItem {
                @Expose
                private String index;

                @Expose
                private String productTitle;

                @Expose
                private String size;

                @Expose
                private String skuCode;

                @Expose
                private String qty;

                @Expose
                private boolean isGiftWrappable;

                @Expose
                private String color;

                public String getIndex() {
                    return index;
                }

                public void setIndex(String index) {
                    this.index = index;
                }

                public String getProductTitle() {
                    return productTitle;
                }

                public void setProductTitle(String productTitle) {
                    this.productTitle = productTitle;
                }

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                public String getSkuCode() {
                    return skuCode;
                }

                public void setSkuCode(String skuCode) {
                    this.skuCode = skuCode;
                }

                public boolean isGiftWrappable() {
                    return isGiftWrappable;
                }

                public void setGiftWrappable(boolean isGiftWrappable) {
                    this.isGiftWrappable = isGiftWrappable;
                }

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                public String getQty() {
                    return qty;
                }

                public void setQty(String qty) {
                    this.qty = qty;
                }

                // Images
                @Expose
                private List<Image> images;

                public List<Image> getImages() {
                    return images;
                }

                public void setImages(List<Image> images) {
                    this.images = images;
                }

                public static class Image {

                    @Expose
                    private String url;

                    @Expose
                    private String height;

                    @Expose
                    private String width;

                    @Expose
                    private String altText;

                    public String getURL() {
                        return url;
                    }

                    public void setURL(String URL) {
                        this.url = URL;
                    }

                    public String getHeight() {
                        return height;
                    }

                    public void setHeight(String height) {
                        this.height = height;
                    }

                    public String getWidth() {
                        return width;
                    }

                    public void setWidth(String width) {
                        this.width = width;
                    }

                    public String getAltText() {
                        return altText;
                    }

                    public void setAltText(String altText) {
                        this.altText = altText;
                    }

                    @Override
                    public int hashCode() {
                        return url.hashCode();
                    }

                    @Override
                    public boolean equals(Object Obj) {
                        Image imgObj = (Image) Obj;
                        return url.equals(imgObj.getURL());
                    }
                }

                // Price
                @Expose
                private Price price;

                public Price getPrice() {
                    return price;
                }

                public void setPrice(Price price) {
                    this.price = price;
                }

                public static class Price {

                    @Expose
                    private String regularPrice;

                    @Expose
                    private String salePrice;

                    @Expose
                    private String clearancePrice;

                    @Expose
                    private String regularPriceType;

                    @Expose
                    private String lineCost;

                    public String getLineCost() {
                        return lineCost;
                    }

                    public void setLineCost(String lineCost) {
                        this.lineCost = lineCost;
                    }

                    public String getRegularPrice() {
                        return regularPrice;
                    }

                    public void setRegularPrice(String regularPrice) {
                        this.regularPrice = regularPrice;
                    }

                    public String getSalePrice() {
                        return salePrice;
                    }

                    public void setSalePrice(String salePrice) {
                        this.salePrice = salePrice;
                    }

                    public String getClearancePrice() {
                        return clearancePrice;
                    }

                    public void setClearancePrice(String clearancePrice) {
                        this.clearancePrice = clearancePrice;
                    }

                    public String getRegularPriceType() {
                        return regularPriceType;
                    }

                    public void setRegularPriceType(String regularPriceType) {
                        this.regularPriceType = regularPriceType;
                    }

                    @Expose
                    private OfferPrice offerPrice;

                    public OfferPrice getOfferPrice() {
                        return offerPrice;
                    }

                    public void setOfferPrice(OfferPrice offerPrice) {
                        this.offerPrice = offerPrice;
                    }

                    public static class OfferPrice {

                        @Expose
                        private double min;

                        @Expose
                        private double max;

                        public double getMin() {
                            return min;
                        }

                        public void setMin(double min) {
                            this.min = min;
                        }

                        public double getMax() {
                            return max;
                        }

                        public void setMax(double max) {
                            this.max = max;
                        }

                    }

                }

                // Surcharges
                @Expose
                private List<Surcharge> surcharges;

                public List<Surcharge> getSurcharges() {
                    return surcharges;
                }

                public void setSurcharges(List<Surcharge> surcharge) {
                    this.surcharges = surcharge;
                }

                public static class Surcharge {

                    @Expose
                    private String type;

                    @Expose
                    private String value;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }

                }

            }

            @Expose
            private Total totals;

            public Total getTotals() {
                return totals;
            }

            public void setTotals(Total totals) {
                this.totals = totals;
            }

            public static class Total {

                @Expose
                private BigDecimal discountTotal;

                @Expose
                private BigDecimal orderTotal;

                @Expose
                private BigDecimal shipTotal;

                @Expose
                private BigDecimal subTotal;

                @Expose
                private BigDecimal taxTotal;

                public BigDecimal getDiscountTotal() {
                    return discountTotal;
                }

                public void setDiscountTotal(BigDecimal discountTotal) {
                    this.discountTotal = discountTotal;
                }

                public BigDecimal getOrderTotal() {
                    return orderTotal;
                }

                public void setOrderTotal(BigDecimal orderTotal) {
                    this.orderTotal = orderTotal;
                }

                public BigDecimal getShipTotal() {
                    return shipTotal;
                }

                public void setShipTotal(BigDecimal shipTotal) {
                    this.shipTotal = shipTotal;
                }

                public BigDecimal getSubTotal() {
                    return subTotal;
                }

                public void setSubTotal(BigDecimal subTotal) {
                    this.subTotal = subTotal;
                }

                public BigDecimal getTaxTotal() {
                    return taxTotal;
                }

                public void setTaxTotal(BigDecimal taxTotal) {
                    this.taxTotal = taxTotal;
                }

                @Expose
                private List<SurchargeTotals> surchargeTotals;

                public List<SurchargeTotals> getSurchargeTotals() {
                    return surchargeTotals;
                }

                public void setSurchargeTotals(List<SurchargeTotals> surchargeTotals) {
                    this.surchargeTotals = surchargeTotals;
                }

                public static class SurchargeTotals {
                    @Expose
                    private String type;

                    @Expose
                    private String value;

                    public String getType() {
                        return type;
                    }

                    public void setType(String type) {
                        this.type = type;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }

                }

                private List<OrderDiscount> orderDiscounts;

                public List<OrderDiscount> getOrderDiscounts() {
                    return orderDiscounts;
                }

                public void setOrderDiscounts(List<OrderDiscount> orderDiscounts) {
                    this.orderDiscounts = orderDiscounts;
                }

                public static class OrderDiscount {

                    @Expose
                    private String label;

                    @Expose
                    private BigDecimal value;

                    public String getLabel() {
                        return label;
                    }

                    public void setLabel(String label) {
                        this.label = label;
                    }

                    public BigDecimal getValue() {
                        return value;
                    }

                    public void setValue(BigDecimal value) {
                        this.value = value;
                    }

                }

            }

        }

    }

}
