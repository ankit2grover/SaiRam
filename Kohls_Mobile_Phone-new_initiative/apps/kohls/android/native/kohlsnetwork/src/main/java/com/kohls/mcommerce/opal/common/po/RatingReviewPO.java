
package com.kohls.mcommerce.opal.common.po;

/**
 * Ratings and Reviews PO
 * 
 * @author Nalin.K
 */
public class RatingReviewPO {

    private String Filter;

    private String Sort;

    private String Offset;

    private String Limit;

    private String Stats;

    private String Include;

    public String getFilter() {
        return Filter;
    }

    public void setFilter(String filter) {
        Filter = filter;
    }

    public String getSort() {
        return Sort;
    }

    public void setSort(String sort) {
        Sort = sort;
    }

    public String getOffset() {
        return Offset;
    }

    public void setOffset(String offset) {
        Offset = offset;
    }

    public String getLimit() {
        return Limit;
    }

    public void setLimit(String limit) {
        Limit = limit;
    }

    public String getStats() {
        return Stats;
    }

    public void setStats(String stats) {
        Stats = stats;
    }

    public String getInclude() {
        return Include;
    }

    public void setInclude(String include) {
        Include = include;
    }

}
