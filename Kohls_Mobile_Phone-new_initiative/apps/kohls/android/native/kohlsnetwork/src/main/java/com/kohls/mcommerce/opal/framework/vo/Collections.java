
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.util.List;

public class Collections {

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

    public static class ValueAddedIcon {

        @Expose
        private String valueAddedIcon;

        public String getValueAddedIcon() {
            return valueAddedIcon;
        }

        public void setValueAddedIcon(String valueAddedIcon) {
            this.valueAddedIcon = valueAddedIcon;
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

}
