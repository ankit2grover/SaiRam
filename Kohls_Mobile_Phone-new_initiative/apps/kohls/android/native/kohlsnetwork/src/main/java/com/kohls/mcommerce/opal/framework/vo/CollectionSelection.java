
package com.kohls.mcommerce.opal.framework.vo;

import java.util.List;

public class CollectionSelection {

    private boolean isSizeSelected;

    private boolean isColorSelected;

    private boolean isColorRequired;

    private boolean isSizeRequired;

    private String selectedColor;

    private String selectedSize;

    private String selectedSKU;

    private boolean isFromShoppingBag;

    private int selColorPosition;

    private int selSizePosition;

    private String colorShoppingBag;

    private String sizeShoppingBag;

    private List<SwatchImage> listSwatchImages;

    private List<SkuColorSize> listSize;

    public boolean isSizeSelected() {
        return isSizeSelected;
    }

    public void setSizeSelected(boolean isSizeSelected) {
        this.isSizeSelected = isSizeSelected;
    }

    public boolean isColorSelected() {
        return isColorSelected;
    }

    public void setColorSelected(boolean isColorSelected) {
        this.isColorSelected = isColorSelected;
    }

    public boolean isSizeRequired() {
        return isSizeRequired;
    }

    public void setSizeRequired(boolean isSizeRequired) {
        this.isSizeRequired = isSizeRequired;
    }

    public boolean isColorRequired() {
        return isColorRequired;
    }

    public void setColorRequired(boolean isColorRequired) {
        this.isColorRequired = isColorRequired;
    }

    public String getSelectedColor() {
        return selectedColor;
    }

    public void setSelectedColor(String selectedColor) {
        this.selectedColor = selectedColor;
    }

    public String getSelectedSize() {
        return selectedSize;
    }

    public void setSelectedSize(String selectedSize) {
        this.selectedSize = selectedSize;
    }

    public String getSelectedSKU() {
        return selectedSKU;
    }

    public void setSelectedSKU(String selectedSKU) {
        this.selectedSKU = selectedSKU;
    }

    public List<SwatchImage> getListSwatchImages() {
        return listSwatchImages;
    }

    public void setListSwatchImages(List<SwatchImage> listSwatchImages) {
        this.listSwatchImages = listSwatchImages;
    }

    public List<SkuColorSize> getListSize() {
        return listSize;
    }

    public void setListSize(List<SkuColorSize> listSize) {
        this.listSize = listSize;
    }

    public int getSelColorPosition() {
        return selColorPosition;
    }

    public void setSelColorPosition(int selColorPosition) {
        this.selColorPosition = selColorPosition;
    }

    public int getSelSizePosition() {
        return selSizePosition;
    }

    public void setSelSizePosition(int selSizePosition) {
        this.selSizePosition = selSizePosition;
    }

    public String getColorShoppingBag() {
        return colorShoppingBag;
    }

    public void setColorShoppingBag(String colorShoppingBag) {
        this.colorShoppingBag = colorShoppingBag;
    }

    public String getSizeShoppingBag() {
        return sizeShoppingBag;
    }

    public void setSizeShoppingBag(String sizeShoppingBag) {
        this.sizeShoppingBag = sizeShoppingBag;
    }

    /**
     * @return the isFromShoppingBag
     */
    public boolean isFromShoppingBag() {
        return isFromShoppingBag;
    }

    /**
     * @param isFromShoppingBag the isFromShoppingBag to set
     */
    public void setFromShoppingBag(boolean isFromShoppingBag) {
        this.isFromShoppingBag = isFromShoppingBag;
    }

}
