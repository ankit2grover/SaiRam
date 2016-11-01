package com.kohls.mcommerce.opal.common.po;

/**
 * @author chitransh.srivastava
 *
 */
public class ProductSearchPO {

	private String keyword;
	
	private String limit;
	
	private String offset;
	
	private String sortID;
	
	private String[] dimensionValueID;

	public String[] getDimensionValueID() {
		return dimensionValueID;
	}

	public void setDimensionValueID(String[] dimensionValueID) {
		this.dimensionValueID = dimensionValueID;
	}

	public String getSortID() {
		return sortID;
	}

	public void setSortID(String sortID) {
		this.sortID = sortID;
	}

	public String getLimit() {
		return limit;
	}

	public void setLimit(String limit) {
		this.limit = limit;
	}

	public String getOffset() {
		return offset;
	}

	public void setOffset(String offset) {
		this.offset = offset;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

}
