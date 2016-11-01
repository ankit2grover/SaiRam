package com.kohls.mcommerce.opal.framework.vo;

public class CityAndState {
	private String city;
	private String state;
	private String zip;
	public String getZip() {
        return zip;
    }
    public void setZip(String zip) {
        this.zip = zip;
    }
    public String getCity() {
		return city;
	}
	public void setCity(String mCity) {
		this.city = mCity;
	}
	public String getState() {
		return state;
	}
	public void setState(String mState) {
		this.state = mState;
	}
}
