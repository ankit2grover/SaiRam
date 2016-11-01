
package com.kohls.mcommerce.opal.common.po;

public class OffersPO {

    private String productId;

    private String cart;

    public String getOfferProducts() {
        return offerProducts;
    }

    public void setOfferProducts(String offerProducts) {
        this.offerProducts = offerProducts;
    }

    private String offerProducts;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getCart() {
        return cart;
    }

    public void setCart(String cart) {
        this.cart = cart;
    }
}
