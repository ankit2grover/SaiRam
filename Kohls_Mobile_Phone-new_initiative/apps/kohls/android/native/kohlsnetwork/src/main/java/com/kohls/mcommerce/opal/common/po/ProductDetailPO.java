
package com.kohls.mcommerce.opal.common.po;

import java.io.Serializable;

/**
 * Product Details Parameters for Adapter Call
 * 
 * @author nalin.k
 */
public class ProductDetailPO implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 8L;


    private boolean skuDetail;

    private boolean allSkus;
    
    private String skuCode;
    
    private String upc;
    
    private String webID;
    
    public boolean getSkuDetail() {
        return skuDetail;
    }

    public void setSkuDetail(boolean skuDetail) {
        this.skuDetail = skuDetail;
    }

    public boolean getallSkus() {
        return allSkus;
    }

    public void setallSkus(boolean allSkus) {
        this.allSkus = allSkus;
    }

	public String getSkuCode() {
		return skuCode;
	}

	public void setSkuCode(String skuCode) {
		this.skuCode = skuCode;
	}

	public String getUpc() {
		return upc;
	}

	public void setUpc(String upc) {
		this.upc = upc;
	}

	public String getWebID() {
		return webID;
	}

	public void setWebID(String webID) {
		this.webID = webID;
	}
}
