
package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;

public class SearchSuggestionVO implements IValueObject, Serializable {
    private static final long serialVersionUID = 1L;

    private int searchID;

    private String searchKeyword;

    private String searchDateTime;

    public int getSearchID() {
        return searchID;
    }

    public void setSearchID(int searchID) {
        this.searchID = searchID;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    public String getSearchDateTime() {
        return searchDateTime;
    }

    public void setSearchDateTime(String searchDateTime) {
        this.searchDateTime = searchDateTime;
    }

}
