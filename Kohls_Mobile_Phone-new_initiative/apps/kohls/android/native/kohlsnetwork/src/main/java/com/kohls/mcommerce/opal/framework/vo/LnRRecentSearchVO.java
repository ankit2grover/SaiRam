package com.kohls.mcommerce.opal.framework.vo;

public class LnRRecentSearchVO implements IValueObject {
	
	private int searchID;

    private String lnrSearchKeyword;
    
    private int lnrSearchKeywordFor;

    private String lnrSearchDateTime;

	public int getSearchID() {
		return searchID;
	}

	public void setSearchID(int searchID) {
		this.searchID = searchID;
	}

	public String getLnrSearchKeyword() {
		return lnrSearchKeyword;
	}

	public void setLnrSearchKeyword(String lnrSearchKeyword) {
		this.lnrSearchKeyword = lnrSearchKeyword;
	}

	public int getLnrSearchKeywordFor() {
		return lnrSearchKeywordFor;
	}

	public void setLnrSearchKeywordFor(int lnrSearchKeywordFor) {
		this.lnrSearchKeywordFor = lnrSearchKeywordFor;
	}

	public String getLnrSearchDateTime() {
		return lnrSearchDateTime;
	}

	public void setLnrSearchDateTime(String lnrSearchDateTime) {
		this.lnrSearchDateTime = lnrSearchDateTime;
	}  
    

}
