
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.view.fragment.productdetails.iface.QuantityViewState;
import com.kohls.mcommerce.opal.framework.vo.OffersVO.Payload.Product.ProductOffer.OfferProduct;
import com.kohls.mcommerce.opal.framework.vo.OffersVO.Payload.Product.ProductOffer.OfferProduct.Sku;
import com.kohls.mcommerce.opal.framework.vo.OffersVO.Payload.Product.ProductOffer.OfferProduct.Sku.Price_;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Product Detail Page Value objects
 */
public class ProductDetailVO implements IValueObject, Serializable {
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

    @Expose
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Expose
    private int limit;

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    @Expose
    private int offset;

    public int getOffset() {
        return offset;
    }

    public void setOffset(int offset) {
        this.offset = offset;
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
     * Products Class with the Product Description
     */
    public static class Payload {

        // Products
        @Expose
        private List<Product> products;

        public List<Product> getproducts() {
            return products;
        }

        public void setproducts(List<Product> products) {
            this.products = products;
        }

        /**
         * Class handling complete product details
         */
        public static class Product implements QuantityViewState {

            @Expose
            private boolean isBopusEligible;

            private int mSelectedQty;

            /**
             * @return The isBopusEligible
             */
            public boolean getIsBopusEligible() {
                return isBopusEligible;
            }

            /**
             * @param isBopusEligible The isBopusEligible
             */
            public void setIsBopusEligible(boolean isBopusEligible) {
                this.isBopusEligible = isBopusEligible;
            }

            public void init(OfferProduct op) {

                if (op.getId() != null)
                    setWebID(op.getId());

                if (op.getProductTitle() != null)
                    setProductTitle(op.getProductTitle());

                // op.getAvailability();
                if (op.getDescription() != null)
                    setProductDescription(op.getDescription());
                // setAvgRating();

                if (op.getErrors() != null)
                    op.getErrors();

                if (op.getImages() != null)
                    setProductImages(op.getImages());

                if (op.getLinks() != null)
                    op.getLinks();

                if (op.getPrice() != null)
                    setProductPrice(op.getPrice());

                if (op.getProductURL() != null)
                    setProductURL(op.getProductURL());

                if (op.getSwatchImages() != null)
                    setSwatchImages(op.getSwatchImages());

                if (op.getSkus() != null)
                    setOfferSKUS(op.getSkus());

            };

            private void
            setProductPrice(com.kohls.mcommerce.opal.framework.vo.OffersVO.Payload.Product.ProductOffer.OfferProduct.Price price2) {
                Price price = new Price();

                price.setClearancePrice(price2.getClearancePrice());
                price.setRegularPrice(price2.getRegularPrice());
                price.setRegularPriceType(price2.getRegularPriceType());
                price.setSalePrice(price2.getSalePrice());

                setPrice(price);
            }

            private void
            setProductImages(List<com.kohls.mcommerce.opal.framework.vo.OffersVO.Payload.Product.ProductOffer.OfferProduct.Image> images2) {
                for (int j = 0; j < images2.size(); j++) {
                    List<Image> imageList = new ArrayList<Image>();
                    Image img = new Image();

                    if (images2.get(j).getHeight() != null)
                        img.setHeight(images2.get(j).getHeight());

                    if (images2.get(j).getWidth() != null)
                        img.setWidth(images2.get(j).getWidth());

                    if (images2.get(j).getURL() != null)
                        img.setURL(images2.get(j).getURL());

                    imageList.add(img);
                    setImages(imageList);
                }
            }

            private void
            setProductDescription(com.kohls.mcommerce.opal.framework.vo.OffersVO.Payload.Product.ProductOffer.OfferProduct.Description description2) {
                Description description = new Description();
                if (description2.getAvgRating() != null)
                    description.setAvgRating(description2.getAvgRating());

                if (description2.getLongDescription() != null)
                    description.setLongDescription(description2.getLongDescription());

                if (description2.getShortDescription() != null)
                    description.setShortDescription(description2.getShortDescription());

                setDescription(description);

            }

            private void setOfferSKUS(List<Sku> skus2) {
                List<SKU> skulist = new ArrayList<SKU>();
                for (int i = 0; i < skus2.size(); i++) {
                    setProductSkus(skulist, skus2, i);
                }
                setSKUS(skulist);

            }

            private void setProductSkus(List<SKU> skulist, List<Sku> skus2, int i) {
                SKU sku = new SKU();

                if (skus2.get(i).getAvailability() != null)
                    sku.setAvailability(skus2.get(i).getAvailability());

                if (skus2.get(i).getColor() != null)
                    sku.setColor(skus2.get(i).getColor());

                if (skus2.get(i).getImages() != null)
                    setOfferSkuImage(sku, skus2.get(i).getImages());

                if (skus2.get(i).getPrice() != null)
                    setOfferSkuPrice(sku, skus2.get(i).getPrice());

                if (skus2.get(i).getSize() != null)
                    sku.setSize(skus2.get(i).getSize());
                if (skus2.get(i).getSkuCode() != null)
                    sku.setSkuCode(skus2.get(i).getSkuCode());

                skulist.add(sku);
            }

            private void setOfferSkuPrice(SKU sku, Price_ price2) {
                com.kohls.mcommerce.opal.framework.vo.ProductDetailVO.Payload.Product.SKU.Price price =
                        new com.kohls.mcommerce.opal.framework.vo.ProductDetailVO.Payload.Product.SKU.Price();

                if (price2.getClearancePrice() != null)
                    price.setClearancePrice(price2.getClearancePrice());
                if (price2.getRegularPrice() != null)
                    price.setRegularPrice(price2.getRegularPrice());
                if (price2.getRegularPriceType() != null)
                    price.setRegularPriceType(price2.getRegularPriceType());
                if (price2.getSalePrice() != null)
                    price.setSalePrice(price2.getSalePrice());

                sku.setPrice(price);
            }

            private void
            setOfferSkuImage(SKU sku,
                    List<com.kohls.mcommerce.opal.framework.vo.OffersVO.Payload.Product.ProductOffer.OfferProduct.Image> images2) {
                for (int j = 0; j < images2.size(); j++) {
                    List<Image> imageList = new ArrayList<Image>();
                    Image img = new Image();
                    img.setHeight(images2.get(j).getHeight());
                    img.setWidth(images2.get(j).getWidth());
                    img.setURL(images2.get(j).getURL());
                    imageList.add(img);
                    sku.setImage(imageList);
                }

            }

            @Expose
            private Error error;

            public Error getError() {
                return error;
            }

            public void setError(Error error) {
                this.error = error;
            }

            @Expose
            private StyleGuide styleGuide;

            public StyleGuide getStyleGuide() {
                return styleGuide;
            }

            public void setError(StyleGuide styleGuide) {
                this.styleGuide = styleGuide;
            }

            public class StyleGuide {

                private String sizeChartText;

                private String sizeChartURL;

                public String getSizeChartText() {
                    return sizeChartText;
                }

                public void setSizeChartText(String sizeChartText) {
                    this.sizeChartText = sizeChartText;
                }

                public String getSizeChartURL() {
                    return sizeChartURL;
                }

                public void setSizeChartURL(String sizeChartURL) {
                    this.sizeChartURL = sizeChartURL;
                }

            }

            // Description
            @Expose
            private Description description;

            public Description getDescription() {
                return description;
            }

            public void setDescription(Description description) {
                this.description = description;
            }

            public static class Description {

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
                private String salePriceStatus;

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

                public String getSalePriceStatus() {
                    return salePriceStatus;
                }

                public void setSalePriceStatus(String salePriceStatus) {
                    this.salePriceStatus = salePriceStatus;
                }

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

            // Brand
            @Expose
            private String brand;

            public String getBrand() {
                return brand;
            }

            public void setBrand(String brand) {
                this.brand = brand;
            }

            // Collections
            private List<Product> collection;

            public List<Product> getCollection() {
                return collection;
            }

            public void setCollection(List<Product> collection) {
                this.collection = collection;
            }

            // SwatchImages
            @Expose
            private List<SwatchImage> swatchImages;

            public List<SwatchImage> getSwatchImages() {
                return swatchImages;
            }

            public void setSwatchImages(List<SwatchImage> swatchImages) {
                this.swatchImages = swatchImages;
            }

            // RatingCount
            @Expose
            private int ratingCount;

            public int getRatingCount() {
                return ratingCount;
            }

            public void setRatingCount(int ratingCount) {
                this.ratingCount = ratingCount;
            }

            // Videos
            @Expose
            private List<Video> videos;

            public List<Video> getVideos() {
                return videos;
            }

            public void setVideos(List<Video> videos) {
                this.videos = videos;
            }

            public static class Video {

                @Expose
                private String name;

                @Expose
                private String desc;

                @Expose
                private String url;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String desc) {
                    this.desc = desc;
                }

                public String getUrl() {
                    return url;
                }

                public void setUrl(String url) {
                    this.url = url;
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

            // ValueAddedIcons
            @Expose
            private List<String> valueAddedIcons;

            public List<String> getValueAddedIcons() {
                return valueAddedIcons;
            }

            public void setValueAddedIcons(List<String> valueAddedIcons) {
                this.valueAddedIcons = valueAddedIcons;
            }

            // Documents
            @Expose
            private Documents documents;

            public Documents getDocuments() {
                return documents;
            }

            public void setDocuments(Documents documents) {
                this.documents = documents;
            }

            public static class Documents {

                @Expose
                private List<Document> document;

                public List<Document> getDocument() {
                    return document;
                }

                public void setDocument(List<Document> document) {
                    this.document = document;
                }

                public static class Document {

                    @Expose
                    private String name;

                    @Expose
                    private String desc;

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String desc) {
                        this.desc = desc;
                    }

                    @Expose
                    private String url;

                    public String getUrl() {
                        return url;
                    }

                    public void setUrl(String url) {
                        this.url = url;
                    }

                    public String getName() {
                        return name;
                    }

                    public void setName(String name) {
                        this.name = name;
                    }

                }

            }

            // Rebate
            @Expose
            private Rebate rebate;

            public Rebate getRebate() {
                return rebate;
            }

            public void setRebate(Rebate rebate) {
                this.rebate = rebate;
            }

            public static class Rebate {
                @Expose
                private String URL;

                public String getURL() {
                    return URL;
                }

                public void setURL(String uRL) {
                    URL = uRL;
                }
            }

            private Exclusions exclusions;

            public Exclusions getExclusions() {
                return exclusions;
            }

            public void setExclusions(Exclusions exclusions) {
                this.exclusions = exclusions;
            }

            public static class Exclusions {

                @Expose
                private String longDescription;

                @Expose
                private String shortDescription;

                public String getLongDescription() {
                    return longDescription;
                }

                public void setLongDescription(String longDescription) {
                    this.longDescription = longDescription;
                }

                public String getShortDescription() {
                    return shortDescription;
                }

                public void setShortDescription(String shortDescription) {
                    this.shortDescription = shortDescription;
                }


            }
            // SKU IDs
            @Expose
            private List<SKU> SKUS;

            public List<SKU> getSKUS() {
                return SKUS;
            }

            public void setSKUS(List<SKU> SKUS) {
                this.SKUS = SKUS;
            }

            public static class SKU {

                @Expose
                private String skuCode;

                public String getSkuCode() {
                    return skuCode;
                }

                public void setSkuCode(String skuCode) {
                    this.skuCode = skuCode;
                }

                // Images
                @Expose
                private List<Image> images;

                public List<Image> getImage() {
                    return images;
                }

                public void setImage(List<Image> images) {
                    this.images = images;
                }

                // Color
                @Expose
                private String color;

                public String getColor() {
                    return color;
                }

                public void setColor(String color) {
                    this.color = color;
                }

                // Size
                private String size;

                public String getSize() {
                    return size;
                }

                public void setSize(String size) {
                    this.size = size;
                }

                // Bopus Eligible
                @Expose
                private boolean isBopusEligible;

                /**
                 * @return The isBopusEligible
                 */
                public boolean getIsBopusEligible() {
                    return isBopusEligible;
                }

                /**
                 * @param isBopusEligible The isBopusEligible
                 */
                public void setIsBopusEligible(boolean isBopusEligible) {
                    this.isBopusEligible = isBopusEligible;
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
                    private String salePriceStatus;

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

                    public String getSalePriceStatus() {
                        return salePriceStatus;
                    }

                    public void setSalePriceStatus(String salePriceStatus) {
                        this.salePriceStatus = salePriceStatus;
                    }

                }

                @Expose
                private String availability;

                public String getAvailability() {
                    return availability;
                }

                public void setAvailability(String availability) {
                    this.availability = availability;
                }

                @Expose
                private boolean giftWrappable;

                public boolean isGiftWrappable() {
                    return giftWrappable;
                }

                public void setGiftWrappable(boolean giftWrappable) {
                    this.giftWrappable = giftWrappable;
                }

                // Universal Product Code
                private UPC UPC;

                public UPC getUPC() {
                    return UPC;
                }

                public void setUPC(UPC uPC) {
                    UPC = uPC;
                }

                public static class UPC {

                    private String image;

                    private String ID;

                    public String getImage() {
                        return image;
                    }

                    public void setImage(String image) {
                        this.image = image;
                    }

                    public String getID() {
                        return ID;
                    }

                    public void setID(String iD) {
                        ID = iD;
                    }

                }

            }

            // ProductStatus
            @Expose
            private String productStatus;

            public String getProductStatus() {
                return productStatus;
            }

            public void setProductStatus(String productStatus) {
                this.productStatus = productStatus;
            }

            // ProductTitle
            @Expose
            private String productTitle;

            public String getProductTitle() {
                return productTitle;
            }

            public void setProductTitle(String productTitle) {
                this.productTitle = productTitle;
            }

            // ProductURL
            @Expose
            private String productURL;

            public String getProductURL() {
                return productURL;
            }

            public void setProductURL(String productURL) {
                this.productURL = productURL;
            }

            // Average Rating
            @Expose
            private String avgRating;

            public String getAvgRating() {
                return avgRating;
            }

            public void setAvgRating(String avgRating) {
                this.avgRating = avgRating;
            }

            // WebID
            @Expose
            private String webID;

            public String getWebID() {
                return webID;
            }

            public void setWebID(String webID) {
                this.webID = webID;
            }

            // ProductOffers
            private List<ProductOffer> productOffers;

            public List<ProductOffer> getProductOffers() {
                return productOffers;
            }

            public void setProductOffers(List<ProductOffer> productOffers) {
                this.productOffers = productOffers;
            }

            public static class ProductOffer {

                private String id;

                private String itemType;

                private String groupType;

                public String getId() {
                    return id;
                }

                public void setId(String id) {
                    this.id = id;
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

            }

            @Expose
            private List<Image> altImages = new ArrayList<Image>();

            /**
             * @return The altImages
             */
            public List<Image> getAltImages() {
                return altImages;
            }

            /**
             * @param altImages The altImages
             */
            public void setAltImages(List<Image> altImages) {
                this.altImages = altImages;
            }

            @Override
            public void setProductQty(int qty) {
                if (qty < 1) {
                    mSelectedQty = 1;
                } else {
                    mSelectedQty = qty;
                }
            }

            @Override
            public int getProductQty() {
                if (mSelectedQty < 1) {
                    mSelectedQty = 1;
                }
                return mSelectedQty;
            }

        }
    }

}

