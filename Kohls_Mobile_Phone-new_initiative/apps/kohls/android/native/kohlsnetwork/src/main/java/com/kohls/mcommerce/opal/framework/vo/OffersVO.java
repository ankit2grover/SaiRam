
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * More to Consider Value Object
 */
public class OffersVO implements IValueObject, Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Expose
    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    private List<String> errors;

    @Expose
    private String expiryTime;

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public class Payload implements Serializable {

        /**
         *
         */
        private static final long serialVersionUID = 1L;

        private List<Product> products = new ArrayList<Product>();

        public List<Product> getProducts() {
            return products;
        }

        public void setProducts(List<Product> products) {
            this.products = products;
        }

        public class Product {

            @Expose
            private String id;

            @Expose
            private OfferPrice offerPrice;

            @Expose
            private List<ProductOffer> productOffers = new ArrayList<ProductOffer>();

            @Expose
            private List<Object> offerErrors = new ArrayList<Object>();

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public OfferPrice getOfferPrice() {
                return offerPrice;
            }

            public void setOfferPrice(OfferPrice offerPrice) {
                this.offerPrice = offerPrice;
            }

            public class OfferPrice {

                float min;

                public float getMin() {
                    return min;
                }

                public void setMin(float min) {
                    this.min = min;
                }

            }

            public List<ProductOffer> getProductOffers() {
                return productOffers;
            }

            public void setProductOffers(List<ProductOffer> productOffers) {
                this.productOffers = productOffers;
            }

            public List<Object> getOfferErrors() {
                return offerErrors;
            }

            public void setOfferErrors(List<Object> offerErrors) {
                this.offerErrors = offerErrors;
            }

            public class ProductOffer {

                @Expose
                private String id;

                @Expose
                private String termsConditions;

                @Expose
                private String message;

                @Expose
                private String begDateTime;

                @Expose
                private String endDateTime;

                @Expose
                private Boolean offerLimitation;

                @Expose
                private List<OfferGroup> offerGroups = new ArrayList<OfferGroup>();

                @Expose
                private Integer thresholdQty;

                @Expose
                private Float thresholdAmt;

                public Float getThresholdAmt() {
                    return thresholdAmt;
                }

                public void setThresholdAmt(Float thresholdAmt) {
                    this.thresholdAmt = thresholdAmt;
                }

                @Expose
                private List<ConditionalMessage> conditionalMessages = new ArrayList<ConditionalMessage>();

                @Expose
                private List<OfferProduct> offerProducts = new ArrayList<OfferProduct>();

                @Expose
                private Double pricePointAmount;

                @Expose
                private Integer percentOff;

                public Integer getPercentOff() {
                    return percentOff;
                }

                public void setPercentOff(Integer percentOff) {
                    this.percentOff = percentOff;
                }

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
                }

                public String getTermsConditions() {
                    return termsConditions;
                }

                public void setTermsConditions(String termsConditions) {
                    this.termsConditions = termsConditions;
                }

                public String getMessage() {
                    return message;
                }

                public void setMessage(String message) {
                    this.message = message;
                }

                public String getBegDateTime() {
                    return begDateTime;
                }

                public void setBegDateTime(String begDateTime) {
                    this.begDateTime = begDateTime;
                }

                public String getEndDateTime() {
                    return endDateTime;
                }

                public void setEndDateTime(String endDateTime) {
                    this.endDateTime = endDateTime;
                }

                public Boolean getOfferLimitation() {
                    return offerLimitation;
                }

                public void setOfferLimitation(Boolean offerLimitation) {
                    this.offerLimitation = offerLimitation;
                }

                public List<OfferGroup> getOfferGroups() {
                    return offerGroups;
                }

                public void setOfferGroups(List<OfferGroup> offerGroups) {
                    this.offerGroups = offerGroups;
                }

                public class OfferGroup {

                    @Expose
                    private Boolean validGrouping;

                    @Expose
                    private String itemType;

                    @Expose
                    private String groupType;

                    @Expose
                    private Boolean offerPriceEligible;

                    @Expose
                    private String qtyNeeded;

                    public String getGroupId() {
                        return groupId;
                    }

                    public void setGroupId(String groupId) {
                        this.groupId = groupId;
                    }

                    @Expose
                    private String groupId;

                    public Boolean getValidGrouping() {
                        return validGrouping;
                    }

                    public void setValidGrouping(Boolean validGrouping) {
                        this.validGrouping = validGrouping;
                    }

                    public String getItemType() {
                        return itemType;
                    }

                    public void setItemType(String itemType) {
                        this.itemType = itemType;
                    }

                    public String getGroupType() {
                        return groupType;
                    }

                    public void setGroupType(String groupType) {
                        this.groupType = groupType;
                    }

                    public Boolean getOfferPriceEligible() {
                        return offerPriceEligible;
                    }

                    public void setOfferPriceEligible(Boolean offerPriceEligible) {
                        this.offerPriceEligible = offerPriceEligible;
                    }

                    public String getQtyNeeded() {
                        return qtyNeeded;
                    }

                    public void setQtyNeeded(String qtyNeeded) {
                        this.qtyNeeded = qtyNeeded;
                    }

                }

                public Integer getThresholdQty() {
                    return thresholdQty;
                }

                public void setThresholdQty(Integer thresholdQty) {
                    this.thresholdQty = thresholdQty;
                }

                public List<ConditionalMessage> getConditionalMessages() {
                    return conditionalMessages;
                }

                public void setConditionalMessages(List<ConditionalMessage> conditionalMessages) {
                    this.conditionalMessages = conditionalMessages;
                }

                public class ConditionalMessage {

                    @Expose
                    private String key;

                    @Expose
                    private String value;

                    public String getKey() {
                        return key;
                    }

                    public void setKey(String key) {
                        this.key = key;
                    }

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }

                }

                public List<OfferProduct> getOfferProducts() {
                    return offerProducts;
                }

                public void setOfferProducts(List<OfferProduct> offerProducts) {
                    this.offerProducts = offerProducts;
                }

                public class OfferProduct {

                    @Expose
                    private String id;

                    @Expose
                    private String productTitle;

                    @Expose
                    private String productURL;

                    @Expose
                    private String availability;

                    @Expose
                    private List<Image> images = new ArrayList<Image>();

                    @Expose
                    private Price price;

                    @Expose
                    private List<Sku> skus = new ArrayList<Sku>();

                    @Expose
                    private List<Link> links = new ArrayList<Link>();

                    @Expose
                    private Object errors;

                    @Expose
                    private List<SwatchImage> swatchImages;

                    @Expose
                    private Description description;

                    public Description getDescription() {
                        return description;
                    }

                    public void setDescription(Description description) {
                        this.description = description;
                    }

                    public class Description {

                        @Expose
                        private String shortDescription;

                        @Expose
                        private String longDescription;

                        @Expose
                        private String avgRating;

                        public String getLongDescription() {
                            return longDescription;
                        }

                        public void setLongDescription(String longDescription) {
                            this.longDescription = longDescription;
                        }

                        public String getAvgRating() {
                            return avgRating;
                        }

                        public void setAvgRating(String avgRating) {
                            this.avgRating = avgRating;
                        }

                        public String getShortDescription() {
                            return shortDescription;
                        }

                        public void setShortDescription(String shortDescription) {
                            this.shortDescription = shortDescription;
                        }

                    }

                    public String getId() {
                        return id;
                    }

                    public void setId(String id) {
                        this.id = id;
                    }

                    public String getProductTitle() {
                        return productTitle;
                    }

                    public void setProductTitle(String productTitle) {
                        this.productTitle = productTitle;
                    }

                    public String getProductURL() {
                        return productURL;
                    }

                    public void setProductURL(String productURL) {
                        this.productURL = productURL;
                    }

                    public String getAvailability() {
                        return availability;
                    }

                    public void setAvailability(String availability) {
                        this.availability = availability;
                    }

                    public List<Image> getImages() {
                        return images;
                    }

                    public void setImages(List<Image> images) {
                        this.images = images;
                    }

                    public class Image {

                        @Expose
                        private String height;

                        @Expose
                        private String width;

                        @SerializedName("URL")
                        @Expose
                        private String uRL;

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

                        public String getURL() {
                            return uRL;
                        }

                        public void setURL(String uRL) {
                            this.uRL = uRL;
                        }

                    }

                    public Price getPrice() {
                        return price;
                    }

                    public void setPrice(Price price) {
                        this.price = price;
                    }

                    public class Price {

                        @Expose
                        private String regularPrice;

                        @Expose
                        private String salePrice;

                        @Expose
                        private String regularPriceType;

                        @Expose
                        private String clearancePrice;

                        @Expose
                        private OfferPrice_ offerPrice;

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

                        public String getRegularPriceType() {
                            return regularPriceType;
                        }

                        public void setRegularPriceType(String regularPriceType) {
                            this.regularPriceType = regularPriceType;
                        }

                        public String getClearancePrice() {
                            return clearancePrice;
                        }

                        public void setClearancePrice(String clearancePrice) {
                            this.clearancePrice = clearancePrice;
                        }

                        public OfferPrice_ getOfferPrice() {
                            return offerPrice;
                        }

                        public void setOfferPrice(OfferPrice_ offerPrice) {
                            this.offerPrice = offerPrice;
                        }

                        public class OfferPrice_ {

                            @Expose
                            private float min;

                            public float getMin() {
                                return min;
                            }

                            public void setMin(float min) {
                                this.min = min;
                            }

                        }

                    }

                    public List<Sku> getSkus() {
                        return skus;
                    }

                    public void setSkus(List<Sku> skus) {
                        this.skus = skus;
                    }

                    public class Sku {

                        @Expose
                        private List<Image> images = new ArrayList<Image>();

                        @Expose
                        private Price_ price;

                        @Expose
                        private String color;

                        @Expose
                        private String skuCode;

                        @Expose
                        private String availability;

                        @Expose
                        private String size;

                        public List<Image> getImages() {
                            return images;
                        }

                        public void setImages(List<Image> images) {
                            this.images = images;
                        }

                        public Price_ getPrice() {
                            return price;
                        }

                        public void setPrice(Price_ price) {
                            this.price = price;
                        }

                        public class Price_ {

                            @Expose
                            private String regularPriceType;

                            @Expose
                            private String salePrice;

                            @Expose
                            private String clearancePrice;

                            @Expose
                            private String regularPrice;

                            @Expose
                            private OfferPrice_ offerPrice;

                            public String getRegularPriceType() {
                                return regularPriceType;
                            }

                            public void setRegularPriceType(String regularPriceType) {
                                this.regularPriceType = regularPriceType;
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

                            public String getRegularPrice() {
                                return regularPrice;
                            }

                            public void setRegularPrice(String regularPrice) {
                                this.regularPrice = regularPrice;
                            }

                            public OfferPrice_ getOfferPrice() {
                                return offerPrice;
                            }

                            public void setOfferPrice(OfferPrice_ offerPrice) {
                                this.offerPrice = offerPrice;
                            }

                            public class OfferPrice_ {

                                @Expose
                                private String min;

                                public String getMin() {
                                    return min;
                                }

                                public void setMin(String min) {
                                    this.min = min;
                                }

                            }

                        }

                        public String getColor() {
                            return color;
                        }

                        public void setColor(String color) {
                            this.color = color;
                        }

                        public String getSkuCode() {
                            return skuCode;
                        }

                        public void setSkuCode(String skuCode) {
                            this.skuCode = skuCode;
                        }

                        public String getAvailability() {
                            return availability;
                        }

                        public void setAvailability(String availability) {
                            this.availability = availability;
                        }

                        public String getSize() {
                            return size;
                        }

                        public void setSize(String size) {
                            this.size = size;
                        }

                    }

                    public List<Link> getLinks() {
                        return links;
                    }

                    public void setLinks(List<Link> links) {
                        this.links = links;
                    }

                    public class Link {

                        @Expose
                        private String rel;

                        @Expose
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

                    public Object getErrors() {
                        return errors;
                    }

                    public void setErrors(Object errors) {
                        this.errors = errors;
                    }

                    public List<SwatchImage> getSwatchImages() {
                        return swatchImages;
                    }

                    public void setSwatchImages(List<SwatchImage> swatchImages) {
                        this.swatchImages = swatchImages;
                    }

                }

                public Double getPricePointAmount() {
                    return pricePointAmount;
                }

                public void setPricePointAmount(Double pricePointAmount) {
                    this.pricePointAmount = pricePointAmount;
                }
            }
        }
    }

}
