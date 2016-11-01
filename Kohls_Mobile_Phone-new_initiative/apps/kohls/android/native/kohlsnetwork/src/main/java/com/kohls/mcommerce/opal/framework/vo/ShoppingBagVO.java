
package com.kohls.mcommerce.opal.framework.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * Shopping Bag Model/Value Object
 *
 * @author Perminder.Singh
 */
public class ShoppingBagVO implements IValueObject {
    private String skuCode;

    private int quantity;

    private String webID;

    private int bagItemId;

    private String registryID;

    private String registryQty;

    private boolean isGift;

    private String registryName;

    private String registryType;

    private String registryShipID;

    private String registryWantedQty;

    private String storeNum;

    private String isSynced;

    private List<OffersVO.Payload.Product.ProductOffer> itemOffers =
            new ArrayList<OffersVO.Payload.Product.ProductOffer>();

    public String isSynced() {
        return isSynced;
    }

    public void setSynced(String isSynced) {
        this.isSynced = isSynced;
    }

    public int getbagItemId() {
        return bagItemId;
    }

    public void setbagItemId(int itemIndex) {
        this.bagItemId = itemIndex;
    }

    public String getRegistryWantedQty() {
        return registryWantedQty;
    }

    public void setRegistryWantedQty(String registryWantedQty) {
        this.registryWantedQty = registryWantedQty;
    }

    public String getRegistryShipID() {
        return registryShipID;
    }

    public void setRegistryShipID(String registryShipID) {
        this.registryShipID = registryShipID;
    }

    public String getRegistryType() {
        return registryType;
    }

    public void setRegistryType(String registryType) {
        this.registryType = registryType;
    }

    public String getRegistryName() {
        return registryName;
    }

    public void setRegistryName(String registryName) {
        this.registryName = registryName;
    }

    /**
     * @return the skuCode
     */
    public String getSkuCode() {
        return skuCode;
    }

    /**
     * @param skuCode the skuCode to set
     */
    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    /**
     * @return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the webId
     */
    public String getWebId() {
        return webID;
    }

    /**
     * @param webId the webId to set
     */
    public void setWebId(String webId) {
        this.webID = webId;
    }

    /**
     * @return the ID of the registry if the skuCode has been added as registry
     */
    public String getRegistryID() {
        return registryID;
    }

    /**
     * @param registryID this will be set if Sku code has been added from a
     *            registry item
     */
    public void setRegistryID(String registryID) {
        this.registryID = registryID;
    }

    /**
     * @return the Qty of the Sku code which has been added from the registry.
     *         So, if getQuantity returns 3 , and getRegistryQty returns 1, then
     *         there are 2 skus which as are normal items
     */
    public String getRegistryQty() {
        return registryQty;
    }

    /**
     * @param registryQty this is the Qty of the sku that has been specifically
     *            added from registry
     */
    public void setRegistryQty(String registryQty) {
        this.registryQty = registryQty;
    }

    /**
     * @return in case of BOPUS items, it will return the Store id for that
     *         particular SKU.
     */
    public String getStoreNum() {
        return storeNum;
    }

    /**
     * @param storeId the ship to store id for BOPUS item.
     */
    public void setStoreNum(String storeId) {
        this.storeNum = storeId;
    }

    public boolean getIsGift() {
        return isGift;
    }

    public void setIsGift(boolean isGift) {
        this.isGift = isGift;
    }

    public List<OffersVO.Payload.Product.ProductOffer> getItemOffers() {
        return itemOffers;
    }

    public void setItemOffers(List<OffersVO.Payload.Product.ProductOffer> itemOffers) {
        this.itemOffers = itemOffers;
    }

}
