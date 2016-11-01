
package com.kohls.mcommerce.opal.common.po;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This is a VO for all the Categories seen in the Menu
 */
public class MenuCategory implements Serializable {
    private static final long serialVersionUID = 831682390492138365L;

    /**
     * Resource Path for the Root Level Category Data.This data is in sync with
     * "Category.json" , SO If this is changed, please change the corresponding
     * data in category.json in assets
     */

    public static final String CATEGORY_ROOT_LEVEL = "CATEGORY_ROOT";

    public static final String CATEGORY_CATALOG_LEVEL = "/category/";

    public static final String CATEGORY_WALLET_LEVEL = "CATEGORY_WALLET";

    public static final String CATEGORY_YES2REWARDS_LEVEL = "CATEGORY_LOYALTY";

    public static final String CATEGORY_ACCOUNT_LEVEL = "CATEGORY_ACCOUNT";

    public static final String CATEGORY_LIST_LEVEL = "CATEGORY_LISTS";

    public static final String CATEGORY_REGISTRY_LEVEL = "CATEGORY_REGISTRY";

    public static final String CATEGORY_DEALS_LEVEL = "CATEGORY_DEALS";

    public static final String CATEGORY_STORE_LEVEL = "CATEGORY_STORE";

    public static final String CATEGORY_ORDERSTATUS_LEVEL = "CATEGORY_ORDERSTATUS";

    public static final String CATEGORY_KOHLS_CHARGE = "CATEGORY_KOHLSCHARGE";

    public static final String CATEGORY_INSTORE_LEVEL = "CATEGORY_INSTORE";

    public static final String CATEGORY_HELP_LEVEL = "CATEGORY_HELP_CONTACT";

    public static final String CATEGORY_FEATUREBRAND_LEVEL = "CATEGORY_FEATURE_BRAND";

    public static final String CATEGORY_DEBUGSETTINGS_LEVEL = "CATEGORY_DEBUG_SETTINGS";

    // Dummy value for bopus switch should be removed before making code live
    public static final String CATEGORY_BOPUS_LEVEL = "CATEGORY_BOPUS";

    public static final String CATEGORY_OMNICHANNEL_FLAG_LEVEL = "CATEGORY_OMNICHANNEL_SETTINGS";

    /****
     * Code for the Categories.This data is in sync with "Category.json" , SO If
     * this is changed, please change the corresponding data in category.json in
     * assets
     */

    // all Subcategories will be assigned the same Catcode.
    public static final int CODE_SUBCATEGORY_LEVEL = 999;

    public static final int CODE_ROOT_LEVEL = 1000;

    public static final int CODE_CATEGORY_LEVEL = CODE_ROOT_LEVEL + 1;

    public static final int CODE_WALLET_LEVEL = CODE_CATEGORY_LEVEL + 1;

    public static final int CODE_YES2REWARDS_LEVEL = CODE_WALLET_LEVEL + 1;

    public static final int CODE_ACCOUNT_LEVEL = CODE_YES2REWARDS_LEVEL + 1;

    public static final int CODE_LIST_LEVEL = CODE_ACCOUNT_LEVEL + 1;

    public static final int CODE_REGISTRY_LEVEL = CODE_LIST_LEVEL + 1;

    public static final int CODE_DEALS_LEVEL = CODE_REGISTRY_LEVEL + 1;

    public static final int CODE_STORE_LEVEL = CODE_DEALS_LEVEL + 1;

    public static final int CODE_ORDERSTATUS_LEVEL = CODE_STORE_LEVEL + 1;

    public static final int CODE_KOHLS_CHARGE = CODE_ORDERSTATUS_LEVEL + 1;

    public static final int CODE_INSTORE_LEVEL = CODE_KOHLS_CHARGE + 1;

    public static final int CODE_HELP_LEVEL = CODE_INSTORE_LEVEL + 1;

    public static final int CODE_FEATUREBRAND_LEVEL = CODE_HELP_LEVEL + 1;

    public static final int CODE_FEATUREBRAND_CHILD_LEVEL = CODE_FEATUREBRAND_LEVEL + 1;

    public static final int CODE_DEBUGSETINGS_LEVEL = CODE_FEATUREBRAND_CHILD_LEVEL + 1;

    // Dummy value for bopus switch should be removed before making code live
    public static final int CODE_BOPUS_LEVEL = CODE_DEBUGSETINGS_LEVEL + 1;

    public static final int CODE_OMNICHANNEL_LEVEL = CODE_BOPUS_LEVEL + 1;

    /************
     * Type of Display of the Category , whether the list needs to show them as
     * Bold/Highligted
     */

    public static final int TYPE_BOLD = 2001;

    public static final int TYPE_HIGHLIGHT = TYPE_BOLD + 1;

    public static final int TYPE_GRAY_BACKGROUND = TYPE_HIGHLIGHT + 1;

    public static final int TYPE_NORMAL = TYPE_GRAY_BACKGROUND + 1;

    // This is the list of categories which are read from the "category.json"
    @Expose
    ArrayList<MenuCategory> categories;

    // Category name String to be displayed in the menu option - To be set
    // through Constructor
    private String name;

    // Does the category has a child? In case of root category , it will always
    // set this to true, in cases where data is received from server - this will
    // be determined based on resourcePath , if resourcePath has /category - it
    // will be set to true
    private boolean hasChild;

    // Does the category has a parent? All Categories will have this set to true
    // except for ROOT Category
    private boolean hasParent;

    // Resource Path of all the Categories, the Categories hardcoded in the
    // category.json will have the Resource Path hardcoded to the values set
    // above in the class, otherwise if the data is downloaded from server then
    // the resourcePath is taken directly from there.
    private String resourcePath;

    // If the hasParent is true, this is the category which on Clicked takes us
    // to the child.
    private MenuCategory parentCat;

    // Catcode is an Integer code for all the categories to help in switch
    // statements on itemClick. All Categories will have code from the above set
    // of integers
    private int catCode;

    // View type - whether the textview that hold this data needs to be Bold or
    // Highlighted
    private int type;

    // If the category display in the menu is an image
    private String image;

    /**
     * @param name - String of the name to be displayed in the menu
     * @param hasChild - boolean whether the category is expected to have any
     *            sub categories
     * @param hasParent - boolean whether the category has any parent category
     * @param resourcePath - Identifier as to where the category data will lead
     *            to.
     * @param parentCat - If hasParent then what is the parent Category.
     * @param catCode TODO
     */
    public MenuCategory(String name,
            boolean hasChild,
            boolean hasParent,
            String resourcePath,
            MenuCategory parentCat,
            int catCode) {
        this.name = name;
        this.hasChild = hasChild;
        this.hasParent = hasParent;
        this.resourcePath = resourcePath;
        this.parentCat = parentCat;
        this.catCode = catCode;
    }

    public String getName() {
        return name;
    }

    public boolean isHasChild() {
        return hasChild;
    }

    public boolean isHasParent() {
        return hasParent;
    }

    public String getResourcePath() {
        return resourcePath;
    }

    public MenuCategory getParentCat() {
        return parentCat;
    }

    public int getCatCode() {
        return catCode;
    }

    public ArrayList<MenuCategory> getCategories() {
        return categories;
    }

    public void setParentCat(MenuCategory parentCat) {
        this.parentCat = parentCat;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getImage() {
        return image;
    }

}
