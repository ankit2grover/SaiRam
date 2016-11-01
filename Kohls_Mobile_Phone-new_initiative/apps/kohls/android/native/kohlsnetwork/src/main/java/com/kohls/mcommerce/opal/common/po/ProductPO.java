
package com.kohls.mcommerce.opal.common.po;

/**
 * Product Parameter Object
 * 
 * @author nalin.k
 *
 */
public class ProductPO {

    public static final int FEATURED = 1;

    public static final int NEW_ARRIVALS = 2;

    public static final int BEST_SELLERS = 3;

    public static final int PRICE_LOW_HIGH = 4;

    public static final int PRICE_HIGH_LOW = 5;

    public static final int HIGHEST_RATED = 6;

    private String sortID;

    private String offset;

    private String limit;

    private String dimensionValueID;

    private String platform;

    public String getSortID() {
        return sortID;
    }

    public void setSortID(String sortID) {
        this.sortID = sortID;
    }

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getDimensionValueID() {
        return dimensionValueID;
    }

    public void setDimensionValueID(String dimensionValueID) {
        this.dimensionValueID = dimensionValueID;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

}
