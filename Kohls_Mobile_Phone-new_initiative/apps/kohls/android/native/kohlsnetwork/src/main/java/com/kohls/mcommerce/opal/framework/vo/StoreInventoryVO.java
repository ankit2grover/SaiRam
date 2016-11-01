
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class StoreInventoryVO implements IValueObject {

    private static final long serialVersionUID = 1L;

    @Expose
    private List<ErrorVO> errors;

    public List<ErrorVO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVO> errors) {
        this.errors = errors;
    }

    @Expose
    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload implements Serializable {

        private static final long serialVersionUID = 9L;

        @Expose
        private List<SKU> skus;

        public SKU getSkuCode() {
            if (skus != null && skus.size() > 0)
                return skus.get(0);
            else
                return null;
        }

        public class SKU implements Serializable {
            private static final long serialVersionUID = 19L;

            @Expose
            private List<StoreInventoryInfo> stores;

            public List<StoreInventoryInfo> getStores() {
                return stores;
            }

            public void setStores(List<StoreInventoryInfo> stores) {
                this.stores = stores;
            }

            public class StoreInventoryInfo implements Serializable {
                private static final long serialVersionUID = 20L;

                @Expose
                private String storeNum;

                @Expose
                private String channel;

                @Expose
                private String availability;

                @Expose
                private String availableStock;

                @Expose
                private String allocatedStock;

                @Expose
                private boolean isBopusEligibleStore;

                @Expose
                private boolean isBopusEligible;

                @Expose
                private boolean isClearance;

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

                public boolean getIsBopusEligibleStore() {
                    return isBopusEligibleStore;
                }

                public void setIsBopusEligibleStore(boolean isBopusEligibleStore) {
                    this.isBopusEligibleStore = isBopusEligibleStore;
                }

                public boolean getIsBopusEligible() {
                    return isBopusEligible;
                }

                public void setIsBopusEligible(boolean isBopusEligible) {
                    this.isBopusEligible = isBopusEligible;
                }

                public boolean getIsClearance() {
                    return isClearance;
                }

                public void setIsClearance(boolean isClearance) {
                    this.isClearance = isClearance;
                }
            }
        }

    }
}
