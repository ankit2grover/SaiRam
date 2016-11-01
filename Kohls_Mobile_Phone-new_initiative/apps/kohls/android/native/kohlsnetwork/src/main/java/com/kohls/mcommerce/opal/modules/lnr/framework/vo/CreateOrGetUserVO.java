package com.kohls.mcommerce.opal.modules.lnr.framework.vo;

import com.kohls.mcommerce.opal.framework.vo.IValueObject;

public class CreateOrGetUserVO implements IValueObject {
	
	private int responseCode;
	private String responseMessage;
	private User user;
	
	public static class User {
		private long userId;
		private String firstName;
		
		public long getUserId() {
			return userId;
		}
		public void setUserId(long userId) {
			this.userId = userId;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	

}
