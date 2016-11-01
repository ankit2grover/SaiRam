
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * More to Consider Value Object
 */
public class RecommendationsVO implements IValueObject, Serializable {

    /**
     * For future update
     */
    private static final long serialVersionUID = 1L;

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

    @Expose
    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public static class Payload {

        private List<Recommendations> recommendations;

        public List<Recommendations> getRecommendations() {
            return recommendations;
        }

        public void setRecommendations(List<Recommendations> recommendations) {
            this.recommendations = recommendations;
        }

        public static class Recommendations {
            private String type;

            private String categoryName;

            private List<Products> products;

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getCategoryName() {
                return categoryName;
            }

            public void setCategoryName(String categoryName) {
                this.categoryName = categoryName;
            }

            public List<Products> getProducts() {
                return products;
            }

            public void setProducts(List<Products> products) {
                this.products = products;
            }

            public static class Products {
                private String id;

                private String rank;

                private List<Link> links;

                private String productTitle;

                private Image image;

                private List<Price> prices;

                public static class Image {
                    private String url;

                    private String height;

                    private String width;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
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

                }

                public static class Link {
                    private String rel;

                    private String uri;

                    public String getRel() {
                        return rel;
                    }

                    public void setRel(String rel) {
                        this.rel = rel;
                    }

                    public String getUri() {
                        return uri;
                    }

                    public void setUri(String uri) {
                        this.uri = uri;
                    }

                }

                public static class Price implements Serializable {

                    /**
                     * 
                     */
                    private static final long serialVersionUID = 50L;

                    private RegularPrice regularPrice;

                    private SalePrice salePrice;

                    private String clearancePrice;

                    private String displayBegDateTime;

                    private String displayEndDateTime;

                    private String purchaseBegDateTime;

                    private String purchaseEndDateTime;

                    private String regularPriceType;

                    private String promotion;

                    private String statusCode;

                    private String priceCode;

                    private boolean isCurrentPrice;
                    
                    private String salePriceStatus;

                    public static class RegularPrice implements Serializable {
                        /**
                         * 
                         */
                        private static final long serialVersionUID = 49L;

                        private float minPrice;

                        private float maxPrice;

                        public float getMinPrice() {
                            return minPrice;
                        }

                        public void setMinPrice(float minPrice) {
                            this.minPrice = minPrice;
                        }

                        public float getMaxPrice() {
                            return maxPrice;
                        }

                        public void setMaxPrice(float maxPrice) {
                            this.maxPrice = maxPrice;
                        }

                    }

                    public static class SalePrice implements Serializable {
                        /**
                         * 
                         */
                        private static final long serialVersionUID = 48L;

                        private float minPrice;

                        private float maxPrice;

                        public float getMinPrice() {
                            return minPrice;
                        }

                        public void setMinPrice(float minPrice) {
                            this.minPrice = minPrice;
                        }

                        public float getMaxPrice() {
                            return maxPrice;
                        }

                        public void setMaxPrice(float maxPrice) {
                            this.maxPrice = maxPrice;
                        }

                    }

                    public String getDisplayBegDateTime() {
                        return displayBegDateTime;
                    }

                    public void setDisplayBegDateTime(String displayBegDateTime) {
                        this.displayBegDateTime = displayBegDateTime;
                    }

                    public String getDisplayEndDateTime() {
                        return displayEndDateTime;
                    }

                    public void setDisplayEndDateTime(String displayEndDateTime) {
                        this.displayEndDateTime = displayEndDateTime;
                    }

                    public String getPurchaseBegDateTime() {
                        return purchaseBegDateTime;
                    }

                    public void setPurchaseBegDateTime(String purchaseBegDateTime) {
                        this.purchaseBegDateTime = purchaseBegDateTime;
                    }

                    public String getPurchaseEndDateTime() {
                        return purchaseEndDateTime;
                    }

                    public void setPurchaseEndDateTime(String purchaseEndDateTime) {
                        this.purchaseEndDateTime = purchaseEndDateTime;
                    }

                    public String getRegularPriceType() {
                        return regularPriceType;
                    }

                    public void setRegularPriceType(String regularPriceType) {
                        this.regularPriceType = regularPriceType;
                    }

                    public String getPromotion() {
                        return promotion;
                    }

                    public void setPromotion(String promotion) {
                        this.promotion = promotion;
                    }

                    public String getStatusCode() {
                        return statusCode;
                    }

                    public void setStatusCode(String statusCode) {
                        this.statusCode = statusCode;
                    }

                    public String getPriceCode() {
                        return priceCode;
                    }

                    public void setPriceCode(String priceCode) {
                        this.priceCode = priceCode;
                    }

                    public boolean isCurrentPrice() {
                        return isCurrentPrice;
                    }

                    public void setCurrentPrice(boolean isCurrentPrice) {
                        this.isCurrentPrice = isCurrentPrice;
                    }

                    public RegularPrice getRegularPrice() {
                        return regularPrice;
                    }

                    public void setRegularPrice(RegularPrice regularPrice) {
                        this.regularPrice = regularPrice;
                    }

                    public SalePrice getSalePrice() {
                        return salePrice;
                    }

                    public void setSalePrice(SalePrice salePrice) {
                        this.salePrice = salePrice;
                    }

                    public String getClearancePrice() {
                        return clearancePrice;
                    }

                    public void setClearancePrice(String clearancePrice) {
                        this.clearancePrice = clearancePrice;
                    }

					public String getSalePriceStatus() {
						return salePriceStatus;
					}

					public void setSalePriceStatus(String salePriceStatus) {
						this.salePriceStatus = salePriceStatus;
					}

                }

                private String avgRating;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getRank() {
                    return rank;
                }

                public void setRank(String rank) {
                    this.rank = rank;
                }

                public List<Link> getLinks() {
                    return links;
                }

                public void setLinks(List<Link> links) {
                    this.links = links;
                }

                public String getProductTitle() {
                    return productTitle;
                }

                public void setProductTitle(String productTitle) {
                    this.productTitle = productTitle;
                }

                public Image getImage() {
                    return image;
                }

                public void setImage(Image image) {
                    this.image = image;
                }

                public List<Price> getPrices() {
                    return prices;
                }

                public void setPrices(List<Price> prices) {
                    this.prices = prices;
                }

                public String getAvgRating() {
                    return avgRating;
                }

                public void setAvgRating(String avgRating) {
                    this.avgRating = avgRating;
                }

                public String getRatingCount() {
                    return ratingCount;
                }

                public void setRatingCount(String ratingCount) {
                    this.ratingCount = ratingCount;
                }

                private String ratingCount;

            }
        }

    }

}
