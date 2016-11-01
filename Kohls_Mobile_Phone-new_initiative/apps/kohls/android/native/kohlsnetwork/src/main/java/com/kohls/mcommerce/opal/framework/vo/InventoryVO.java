
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

/**
 * Inventory PO
 */
public class InventoryVO implements IValueObject, Serializable {
    private static final long serialVersionUID = 8L;

    private List<ErrorVO> errors;

    public List<ErrorVO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVO> errors) {
        this.errors = errors;
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
        // SKUS
        @Expose
        private List<SKU> skus;

        public List<SKU> getSkus() {
            return skus;
        }

        public void setSkus(List<SKU> skus) {
            this.skus = skus;
        }

        public static class SKU {

            private String skuCode;

            public String getSkuCode() {
                return skuCode;
            }

            public void setSkuCode(String skuCode) {
                this.skuCode = skuCode;
            }

            private List<Store> stores;

            public List<Store> getStores() {
                return stores;
            }

            public void setStores(List<Store> stores) {
                this.stores = stores;
            }

            public static class Store {

                private String storeNum;

                private String channel;

                private String availability;

                private String availableStock;

                private String allocatedStock;

                public String getStoreNum() {
                    return storeNum;
                }

                public void setStoreNum(String storeNum) {
                    this.storeNum = storeNum;
                }

                public String getChannel() {
                    return channel;
                }

                public void setChannel(String channel) {
                    this.channel = channel;
                }

                public String getAvailability() {
                    return availability;
                }

                public void setAvailability(String availability) {
                    this.availability = availability;
                }

                public String getAvailableStock() {
                    return availableStock;
                }

                public void setAvailableStock(String availableStock) {
                    this.availableStock = availableStock;
                }

                public String getAllocatedStock() {
                    return allocatedStock;
                }

                public void setAllocatedStock(String allocatedStock) {
                    this.allocatedStock = allocatedStock;
                }
            }
        }
    }
}
