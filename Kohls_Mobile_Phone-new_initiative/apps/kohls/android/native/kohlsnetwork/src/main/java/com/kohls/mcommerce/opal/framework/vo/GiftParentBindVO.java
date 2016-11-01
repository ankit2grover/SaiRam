package com.kohls.mcommerce.opal.framework.vo;

/**
 * Shopping Bag Model/Value Object
 * 
 * @author Perminder.Singh
 */
public class GiftParentBindVO implements IValueObject {
	private String giftSkuCode;

	private String giftWebId;

	private String parentWebId;

	public String getGiftSkuCode() {
		return giftSkuCode;
	}

	public void setGiftSkuCode(String giftSkuCode) {
		this.giftSkuCode = giftSkuCode;
	}

	public String getGiftWebId() {
		return giftWebId;
	}

	public void setGiftWebId(String giftWebId) {
		this.giftWebId = giftWebId;
	}

	public String getParentWebId() {
		return parentWebId;
	}

	public void setParentWebId(String parentWebId) {
		this.parentWebId = parentWebId;
	}

}
