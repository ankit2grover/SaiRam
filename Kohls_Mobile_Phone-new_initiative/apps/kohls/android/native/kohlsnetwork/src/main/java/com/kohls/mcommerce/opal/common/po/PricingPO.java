package com.kohls.mcommerce.opal.common.po;

import java.io.Serializable;
import java.util.List;

/**
 * Product Details Parameters for Adapter Call
 */
public class PricingPO implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 8L;

    private Parameters params;

    public void setParams(Parameters params) {
        this.params = params;
    }

    public Parameters getParams() {
		return params;
	}

	public String getType() {
		return type;
	}

	private String type;

    public void setType(String type) {
        this.type = type;
    }

    public class Parameters {
        private Payload payload;

        public void setPayload(Payload payload) {
            this.payload = payload;
        }

        public Payload getPayload() {
			return payload;
		}

		public class Payload {

            private List<Product> products;

            public List<Product> getProducts() {
				return products;
			}

			public void setProducts(List<Product> products) {
                this.products = products;
            }

            public class Product {
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