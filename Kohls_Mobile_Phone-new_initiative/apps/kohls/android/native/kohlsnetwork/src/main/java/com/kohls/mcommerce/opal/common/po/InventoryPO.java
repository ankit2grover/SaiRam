
package com.kohls.mcommerce.opal.common.po;

import java.io.Serializable;
import java.util.List;

public class InventoryPO implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 8L;

    private Params params;

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    private String platform;

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public class Params {

        private Payload payload;

        public Payload getPayload() {
            return payload;
        }

        public void setPayload(Payload payload) {
            this.payload = payload;
        }

        public class Payload {

            private List<Product> products;

            public List<Product> getProducts() {
                return products;
            }

            public void setProducts(List<Product> products) {
                this.products = products;
            }

            public class Product implements Serializable {

                private static final long serialVersionUID = 21L;

                private String ID;

                public String getID() {
                    return ID;
                }

                public void setID(String iD) {
                    ID = iD;
                }

            }
        }
    }
}
