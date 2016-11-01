package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import java.io.Serializable;
import java.util.ArrayList;


public class DashboardCategoryVO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int totalItems = 0;

    private int purchasedItems = 0;

    private ArrayList<ListItem> listItems = new ArrayList<ListItem>();

    public ArrayList<ListItem> getListItems() {
        return listItems;
    }

    public void setListItems(ArrayList<ListItem> listItems) {
        this.listItems = listItems;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public int getPurchasedItems() {
        return purchasedItems;
    }

    public void setPurchasedItems(int purchasedItems) {
        this.purchasedItems = purchasedItems;
    }

}
