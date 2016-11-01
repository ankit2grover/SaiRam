
package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Product Detail Page VO
 */
public class PricingVO implements IValueObject, Serializable {
    private static final long serialVersionUID = 8L;

    private String responseID;

    private String expiryTime;

    private Payload payload;
    
	private ArrayList<ErrorVO> errors;
    
    public ArrayList<ErrorVO> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<ErrorVO> errors) {
		this.errors = errors;
	}

    public String getResponseID() {
        return responseID;
    }

    public void setResponseID(String responseID) {
        this.responseID = responseID;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload {

        private List<Product> products = new ArrayList<Product>();

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public class Product {

            private List<Store> stores = new ArrayList<Store>();

            private String webID;

            public List<Store> getStores() {
                return stores;
            }

            public void setStores(List<Store> stores) {
                this.stores = stores;
            }

            public String getWebID() {
                return webID;
            }

            public void setWebID(String webID) {
                this.webID = webID;
            }

            public class Store {

                private String channel;

                private List<Price> prices = new ArrayList<Price>();

                private String storeNum;

                public String getChannel() {
                    return channel;
                }

                public void setChannel(String channel) {
                    this.channel = channel;
                }

                public List<Price> getPrices() {
                    return prices;
                }

                public void setPrices(List<Price> prices) {
                    this.prices = prices;
                }

                public String getStoreNum() {
                    return storeNum;
                }

                public void setStoreNum(String storeNum) {
                    this.storeNum = storeNum;
                }

                public class Price {

                    private String statusCode;

                    private String purchaseEndDateTime;

                    private Object promotion;

                    private String regularPriceType;

                    private String purchaseBegDateTime;

                    private SalePrice salePrice;

                    private Boolean isCurrentPrice;

                    private String displayEndDateTime;

                    private String displayBegDateTime;

                    private RegularPrice regularPrice;

                    private String priceCode;

                    public String getStatusCode() {
                        return statusCode;
                    }

                    public void setStatusCode(String statusCode) {
                        this.statusCode = statusCode;
                    }

                    public String getPurchaseEndDateTime() {
                        return purchaseEndDateTime;
                    }

                    public void setPurchaseEndDateTime(String purchaseEndDateTime) {
                        this.purchaseEndDateTime = purchaseEndDateTime;
                    }

                    public Object getPromotion() {
                        return promotion;
                    }

                    public void setPromotion(Object promotion) {
                        this.promotion = promotion;
                    }

                    public String getRegularPriceType() {
                        return regularPriceType;
                    }

                    public void setRegularPriceType(String regularPriceType) {
                        this.regularPriceType = regularPriceType;
                    }

                    public String getPurchaseBegDateTime() {
                        return purchaseBegDateTime;
                    }

                    public void setPurchaseBegDateTime(String purchaseBegDateTime) {
                        this.purchaseBegDateTime = purchaseBegDateTime;
                    }

                    public SalePrice getSalePrice() {
                        return salePrice;
                    }

                    public void setSalePrice(SalePrice salePrice) {
                        this.salePrice = salePrice;
                    }

                    public Boolean getIsCurrentPrice() {
                        return isCurrentPrice;
                    }

                    public void setIsCurrentPrice(Boolean isCurrentPrice) {
                        this.isCurrentPrice = isCurrentPrice;
                    }

                    public String getDisplayEndDateTime() {
                        return displayEndDateTime;
                    }

                    public void setDisplayEndDateTime(String displayEndDateTime) {
                        this.displayEndDateTime = displayEndDateTime;
                    }

                    public String getDisplayBegDateTime() {
                        return displayBegDateTime;
                    }

                    public void setDisplayBegDateTime(String displayBegDateTime) {
                        this.displayBegDateTime = displayBegDateTime;
                    }

                    public RegularPrice getRegularPrice() {
                        return regularPrice;
                    }

                    public void setRegularPrice(RegularPrice regularPrice) {
                        this.regularPrice = regularPrice;
                    }

                    public String getPriceCode() {
                        return priceCode;
                    }

                    public void setPriceCode(String priceCode) {
                        this.priceCode = priceCode;
                    }

                    public class RegularPrice {

                        private Double minPrice;

                        public Double getMinPrice() {
                            return minPrice;
                        }

                        public void setMinPrice(Double minPrice) {
                            this.minPrice = minPrice;
                        }

                    }

                    public class SalePrice {

                        private Double minPrice;

                        public Double getMinPrice() {
                            return minPrice;
                        }

                        public void setMinPrice(Double minPrice) {
                            this.minPrice = minPrice;
                        }

                        private Double maxPrice;

                        public Double getMaxPrice() {
                            return maxPrice;
                        }

                        public void setMaxPrice(Double maxPrice) {
                            this.maxPrice = maxPrice;
                        }

                    }
                }

            }

        }

    }

}
