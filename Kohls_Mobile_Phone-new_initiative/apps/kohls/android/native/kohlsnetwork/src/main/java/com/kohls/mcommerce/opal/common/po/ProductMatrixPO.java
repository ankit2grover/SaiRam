
package com.kohls.mcommerce.opal.common.po;

/**
 * Product matrix parameter class for providing parameters for product matrix
 * adapter.
 * 
 * @author Ankit Grover
 */
public class ProductMatrixPO {

    private String[] dimensionValueID;

    private String platform;

    private String limit;

    private String offset;

    private String sortID;
    
    private String keyword;

    public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String[] getdimensionValueID() {
        return dimensionValueID;
    }

    public void setdimensionValueID(String[] dimensionValueID) {
        this.dimensionValueID = dimensionValueID;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getlimit() {
        return limit;
    }

    public void setlimit(String limit) {
        this.limit = limit;
    }

    public String getoffset() {
        return offset;
    }

    public void setoffset(String offset) {
        this.offset = offset;
    }

    public String getsortID() {
        return sortID;
    }

    public void setsortID(String sortID) {
        this.sortID = sortID;
    }
}
