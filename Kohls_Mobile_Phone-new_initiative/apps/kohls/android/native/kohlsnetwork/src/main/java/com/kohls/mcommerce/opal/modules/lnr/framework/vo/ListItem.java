
package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.google.gson.annotations.Expose;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;

import java.io.Serializable;

public class ListItem implements IValueObject, Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Expose
    private Integer listId;
    @Expose
    private String itemType;
    @Expose
    private String itemId;
    @Expose
    private String itemProductId;
    @Expose
    private String itemColor;
    @Expose
    private String itemSize;
    @Expose
    private Integer wantedQty;
    @Expose
    private Integer priority;
    @Expose
    private float priceWhenCreated;
    @Expose
    private String titleIfUnavailable;
    @Expose
    private String sellingLocationCode;
    @Expose
    private Object upcCode;
    @Expose
    private String productCode;
    @Expose
    private Object collectionsProdId;
    @Expose
    private Object collectionsProdCode;
    @Expose
    private String imageUrlIfUnavailable;
    @Expose
    private String categoryIfUnavailable;
    @Expose
    private Object notes;
    @Expose
    private long listViewedTime;
    @Expose
    private long lastUpdatedTime;
    @Expose
    private long createdTime;
    @Expose
    private Properties properties;
    @Expose
    private Boolean purchased;
    @Expose
    private Object fulfillments;
    @Expose
    private Integer totalPurchaseQty;

    private float sortingPrice;

    /**
     *
     * @return
     *     The listId
     */
    public Integer getListId() {
        return listId;
    }

    /**
     *
     * @param listId
     *     The listId
     */
    public void setListId(Integer listId) {
        this.listId = listId;
    }

    /**
     *
     * @return
     *     The itemType
     */
    public String getItemType() {
        return itemType;
    }

    /**
     *
     * @param itemType
     *     The itemType
     */
    public void setItemType(String itemType) {
        this.itemType = itemType;
    }

    /**
     *
     * @return
     *     The itemId
     */
    public String getItemId() {
        return itemId;
    }

    /**
     *
     * @param itemId
     *     The itemId
     */
    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    /**
     *
     * @return
     *     The itemProductId
     */
    public String getItemProductId() {
        return itemProductId;
    }

    /**
     *
     * @param itemProductId
     *     The itemProductId
     */
    public void setItemProductId(String itemProductId) {
        this.itemProductId = itemProductId;
    }

    /**
     *
     * @return
     *     The itemColor
     */
    public String getItemColor() {
        return itemColor;
    }

    /**
     *
     * @param itemColor
     *     The itemColor
     */
    public void setItemColor(String itemColor) {
        this.itemColor = itemColor;
    }

    /**
     *
     * @return
     *     The itemSize
     */
    public String getItemSize() {
        return itemSize;
    }

    /**
     *
     * @param itemSize
     *     The itemSize
     */
    public void setItemSize(String itemSize) {
        this.itemSize = itemSize;
    }

    /**
     *
     * @return
     *     The wantedQty
     */
    public Integer getWantedQty() {
        return wantedQty;
    }

    /**
     *
     * @param wantedQty
     *     The wantedQty
     */
    public void setWantedQty(Integer wantedQty) {
        this.wantedQty = wantedQty;
    }

    /**
     *
     * @return
     *     The priority
     */
    public Integer getPriority() {
        return priority;
    }

    /**
     *
     * @param priority
     *     The priority
     */
    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    /**
     *
     * @return
     *     The priceWhenCreated
     */
    public float getPriceWhenCreated() {
        return priceWhenCreated;
    }

    /**
     *
     * @param priceWhenCreated
     *     The priceWhenCreated
     */
    public void setPriceWhenCreated(float priceWhenCreated) {
        this.priceWhenCreated = priceWhenCreated;
    }

    /**
     *
     * @return
     *     The titleIfUnavailable
     */
    public String getTitleIfUnavailable() {
        return titleIfUnavailable;
    }

    /**
     *
     * @param titleIfUnavailable
     *     The titleIfUnavailable
     */
    public void setTitleIfUnavailable(String titleIfUnavailable) {
        this.titleIfUnavailable = titleIfUnavailable;
    }

    /**
     *
     * @return
     *     The sellingLocationCode
     */
    public String getSellingLocationCode() {
        return sellingLocationCode;
    }

    /**
     *
     * @param sellingLocationCode
     *     The sellingLocationCode
     */
    public void setSellingLocationCode(String sellingLocationCode) {
        this.sellingLocationCode = sellingLocationCode;
    }

    /**
     *
     * @return
     *     The upcCode
     */
    public Object getUpcCode() {
        return upcCode;
    }

    /**
     *
     * @param upcCode
     *     The upcCode
     */
    public void setUpcCode(Object upcCode) {
        this.upcCode = upcCode;
    }

    /**
     *
     * @return
     *     The productCode
     */
    public String getProductCode() {
        return productCode;
    }

    /**
     *
     * @param productCode
     *     The productCode
     */
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    /**
     *
     * @return
     *     The collectionsProdId
     */
    public Object getCollectionsProdId() {
        return collectionsProdId;
    }

    /**
     *
     * @param collectionsProdId
     *     The collectionsProdId
     */
    public void setCollectionsProdId(Object collectionsProdId) {
        this.collectionsProdId = collectionsProdId;
    }

    /**
     *
     * @return
     *     The collectionsProdCode
     */
    public Object getCollectionsProdCode() {
        return collectionsProdCode;
    }

    /**
     *
     * @param collectionsProdCode
     *     The collectionsProdCode
     */
    public void setCollectionsProdCode(Object collectionsProdCode) {
        this.collectionsProdCode = collectionsProdCode;
    }

    /**
     *
     * @return
     *     The imageUrlIfUnavailable
     */
    public String getImageUrlIfUnavailable() {
        return imageUrlIfUnavailable;
    }

    /**
     *
     * @param imageUrlIfUnavailable
     *     The imageUrlIfUnavailable
     */
    public void setImageUrlIfUnavailable(String imageUrlIfUnavailable) {
        this.imageUrlIfUnavailable = imageUrlIfUnavailable;
    }

    /**
     *
     * @return
     *     The categoryIfUnavailable
     */
    public String getCategoryIfUnavailable() {
        return categoryIfUnavailable;
    }

    /**
     *
     * @param categoryIfUnavailable
     *     The categoryIfUnavailable
     */
    public void setCategoryIfUnavailable(String categoryIfUnavailable) {
        this.categoryIfUnavailable = categoryIfUnavailable;
    }

    /**
     *
     * @return
     *     The notes
     */
    public Object getNotes() {
        return notes;
    }

    /**
     *
     * @param notes
     *     The notes
     */
    public void setNotes(Object notes) {
        this.notes = notes;
    }

    /**
     *
     * @return
     *     The listViewedTime
     */
    public Object getListViewedTime() {
        return listViewedTime;
    }

    /**
     *
     * @param listViewedTime
     *     The listViewedTime
     */
    public void setListViewedTime(long listViewedTime) {
        this.listViewedTime = listViewedTime;
    }

    /**
     *
     * @return
     *     The lastUpdatedTime
     */
    public long getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    /**
     *
     * @param lastUpdatedTime
     *     The lastUpdatedTime
     */
    public void setLastUpdatedTime(long lastUpdatedTime) {
        this.lastUpdatedTime = lastUpdatedTime;
    }

    /**
     *
     * @return
     *     The createdTime
     */
    public long getCreatedTime() {
        return createdTime;
    }

    /**
     *
     * @param createdTime
     *     The createdTime
     */
    public void setCreatedTime(Integer createdTime) {
        this.createdTime = createdTime;
    }

    /**
     *
     * @return
     *     The properties
     */
    public Properties getProperties() {
        return properties;
    }

    /**
     *
     * @param properties
     *     The properties
     */
    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    /**
     *
     * @return
     *     The purchased
     */
    public Boolean getPurchased() {
        return purchased;
    }

    /**
     *
     * @param purchased
     *     The purchased
     */
    public void setPurchased(Boolean purchased) {
        this.purchased = purchased;
    }

    /**
     *
     * @return
     *     The fulfillments
     */
    public Object getFulfillments() {
        return fulfillments;
    }

    /**
     *
     * @param fulfillments
     *     The fulfillments
     */
    public void setFulfillments(Object fulfillments) {
        this.fulfillments = fulfillments;
    }

    /**
     *
     * @return
     *     The totalPurchaseQty
     */
    public Integer getTotalPurchaseQty() {
        return totalPurchaseQty;
    }

    /**
     *
     * @param totalPurchaseQty
     *     The totalPurchaseQty
     */
    public void setTotalPurchaseQty(Integer totalPurchaseQty) {
        this.totalPurchaseQty = totalPurchaseQty;
    }

    public float getSortingPrice() {
        return sortingPrice;
    }

    public void setSortingPrice(float sortingPrice) {
        this.sortingPrice = sortingPrice;
    }

}
