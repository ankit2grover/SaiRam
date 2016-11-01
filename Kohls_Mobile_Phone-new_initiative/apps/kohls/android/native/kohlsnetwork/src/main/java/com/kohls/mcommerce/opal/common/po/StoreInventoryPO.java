
package com.kohls.mcommerce.opal.common.po;

public class StoreInventoryPO {

    private String latitude;

    private String longitude;

    private String city;

    private String radius;

    private String channel;

    private String storeNum;

    private String sku;

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getchannel() {
        return channel;
    }

    public void setchannel(String channel) {
        this.channel = channel;
    }

    public String getstoreNum() {
        return storeNum;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getRadius() {
        return radius;
    }

    public void setRadius(String radius) {
        this.radius = radius;
    }

    public String getcity() {
        return city;
    }

    public void setcity(String city) {
        this.city = city;
    }

    public void setstoreNum(String storeNum) {
        this.storeNum = storeNum;
    }

}
