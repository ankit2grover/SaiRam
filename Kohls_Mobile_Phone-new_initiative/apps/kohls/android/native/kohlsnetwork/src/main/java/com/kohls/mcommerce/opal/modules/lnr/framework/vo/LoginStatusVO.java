package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.kohls.mcommerce.opal.framework.vo.IValueObject;

public class LoginStatusVO implements IValueObject {
	
	private int responseCode;
	private String responseMessage;
	private String jsessionId;
	private RetailerUserInfo retailerUserInfo;
	
	public static class RetailerUserInfo {
		private String retailerUserId;
		private String userFirstName;
		private String userLastname;
		private String retailerEmail;
		private String role;
		private String adminUserId;
		public String getRetailerUserId() {
			return retailerUserId;
		}
		public void setRetailerUserId(String retailerUserId) {
			this.retailerUserId = retailerUserId;
		}
		public String getUserFirstName() {
			return userFirstName;
		}
		public void setUserFirstName(String userFirstName) {
			this.userFirstName = userFirstName;
		}
		public String getUserLastname() {
			return userLastname;
		}
		public void setUserLastname(String userLastname) {
			this.userLastname = userLastname;
		}
		public String getRetailerEmail() {
			return retailerEmail;
		}
		public void setRetailerEmail(String retailerEmail) {
			this.retailerEmail = retailerEmail;
		}
		public String getRole() {
			return role;
		}
		public void setRole(String role) {
			this.role = role;
		}
		public String getAdminUserId() {
			return adminUserId;
		}
		public void setAdminUserId(String adminUserId) {
			this.adminUserId = adminUserId;
		}
		
		
	}

	public int getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(int responseCode) {
		this.responseCode = responseCode;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

	public String getJsessionId() {
		return jsessionId;
	}

	public void setJsessionId(String jsessionId) {
		this.jsessionId = jsessionId;
	}

	public RetailerUserInfo getRetailerUserInfo() {
		return retailerUserInfo;
	}

	public void setRetailerUserInfo(RetailerUserInfo retailerUserInfo) {
		this.retailerUserInfo = retailerUserInfo;
	}
	
	

}
