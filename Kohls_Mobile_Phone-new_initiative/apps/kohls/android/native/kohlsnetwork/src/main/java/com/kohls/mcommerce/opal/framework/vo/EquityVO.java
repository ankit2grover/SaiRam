
package com.kohls.mcommerce.opal.framework.vo;

import java.util.ArrayList;

/**
 * @author sanchit.gupta
 */
public class EquityVO {
    private ArrayList<Integer> mImagesLarge = new ArrayList<Integer>();

    private ArrayList<Integer> mImagesSmall = new ArrayList<Integer>();

    private ArrayList<String> mResourcePath = new ArrayList<String>();

    public ArrayList<String> getResourcePath() {
        return mResourcePath;
    }

    public void setResourcePath(ArrayList<String> ResourcePath) {
        this.mResourcePath = ResourcePath;
    }

    private static String sEquityType = "home";

    /**
     * @return the sImagesLarge
     */
    public ArrayList<Integer> getImagesLarge() {
        return mImagesLarge;
    }

    /**
     * @param sImagesLarge the sImagesLarge to set
     */
    public void setImagesLarge(ArrayList<Integer> ImagesLarge) {
        this.mImagesLarge = ImagesLarge;
    }

    /**
     * @return the sImagesSmall
     */
    public ArrayList<Integer> getImagesSmall() {
        return mImagesSmall;
    }

    /**
     * @param sImagesSmall the sImagesSmall to set
     */
    public void setImagesSmall(ArrayList<Integer> ImagesSmall) {
        this.mImagesSmall = ImagesSmall;
    }

    /**
     * @return the sEquityType
     */
    public String getEquityType() {
        return sEquityType;
    }

    /**
     * @param sEquityType the sEquityType to set
     */
    public void setEquityType(String sEquityType) {
        this.sEquityType = sEquityType;
    }

}
