package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;
import java.util.ArrayList;

public class UpdateAccountVO implements IValueObject{

	private String expiryTime;

	private PayLoad payload;
	
	private ArrayList<ErrorVO> errors;

	public class PayLoad implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private String message;

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}
	}

	public String getExpiryTime() {
		return expiryTime;
	}

	public void setExpiryTime(String expiryTime) {
		this.expiryTime = expiryTime;
	}

	public ArrayList<ErrorVO> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<ErrorVO> errors) {
		this.errors = errors;
	}

	public PayLoad getPayload() {
		return payload;
	}

	public void setPayload(PayLoad payload) {
		this.payload = payload;
	}
}
