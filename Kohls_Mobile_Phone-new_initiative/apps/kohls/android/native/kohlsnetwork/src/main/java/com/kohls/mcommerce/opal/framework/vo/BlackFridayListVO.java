package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;

public class BlackFridayListVO implements IValueObject, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String responseCode;
	
	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
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

	private String responseMessage;
	
	private User user;
	
	public class User implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int userId;
		
		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		private String firstName;
	}

}
