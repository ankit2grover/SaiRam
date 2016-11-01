package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.util.List;


public class SignMeUpVO {

	private String uniqueResponseId;

	public String getUniqueResponseId() {
		return uniqueResponseId;
	}

	public void setUniqueResponseId(String uniqueResponseId) {
		this.uniqueResponseId = uniqueResponseId;
	}

	private List<Error> errors;

	public List<Error> getErrors() {
		return errors;
	}

	public void setErrors(List<Error> errors) {
		this.errors = errors;
	}

	public static class Error {

		@Expose
		private String errorCode;

		@Expose
		private String message;

		@Expose
		private String id;

		public String getErrorCode() {
			return errorCode;
		}

		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}

		public String getMessage() {
			return message;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

	}

	private boolean success;

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	private Profile profile;

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public static class Profile {
		private String loyaltyId;

		public String getLoyaltyId() {
			return loyaltyId;
		}

		public void setLoyaltyId(String loyaltyId) {
			this.loyaltyId = loyaltyId;
		}

		private CustomerName customerName;

		public CustomerName getCustomerName() {
			return customerName;
		}

		public void setCustomerName(CustomerName customerName) {
			this.customerName = customerName;
		}

		public static class CustomerName {

			@Expose
			private String firstName;
			@Expose
			private String lastName;

			public String getFirstName() {
				return firstName;
			}

			public void setFirstName(String firstName) {
				this.firstName = firstName;
			}

			public String getLastName() {
				return lastName;
			}

			public void setLastName(String lastName) {
				this.lastName = lastName;
			}

		}

		@Expose
		private String email;
		@Expose
		private String birthday;
		@Expose
		private String postalCode;
		@Expose
		private String phoneNumber;

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getBirthday() {
			return birthday;
		}

		public void setBirthday(String birthday) {
			this.birthday = birthday;
		}

		public String getPostalCode() {
			return postalCode;
		}

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		private Address address;

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public static class Address {

			@Expose
			private String addr1;
			@Expose
			private String addr2;
			@Expose
			private String city;
			@Expose
			private String state;

			public String getAddr1() {
				return addr1;
			}

			public void setAddr1(String addr1) {
				this.addr1 = addr1;
			}

			public String getAddr2() {
				return addr2;
			}

			public void setAddr2(String addr2) {
				this.addr2 = addr2;
			}

			public String getCity() {
				return city;
			}

			public void setCity(String city) {
				this.city = city;
			}

			public String getState() {
				return state;
			}

			public void setState(String state) {
				this.state = state;
			}

		}

		@Expose
		private Integer pointBalance;
		@Expose
		private String status;
		@Expose
		private String memberSince;
		@Expose
		private Integer lifeTimePoints;
		@Expose
		private Integer pointThreshold;
		@Expose
		private String earningPeriod;
		@Expose
		private Object kohlsCashCoupons;
		@Expose
		private Object transactions;
		@Expose
		private Object rewards;

		public Integer getPointBalance() {
			return pointBalance;
		}

		public void setPointBalance(Integer pointBalance) {
			this.pointBalance = pointBalance;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getMemberSince() {
			return memberSince;
		}

		public void setMemberSince(String memberSince) {
			this.memberSince = memberSince;
		}

		public Integer getLifeTimePoints() {
			return lifeTimePoints;
		}

		public void setLifeTimePoints(Integer lifeTimePoints) {
			this.lifeTimePoints = lifeTimePoints;
		}

		public Integer getPointThreshold() {
			return pointThreshold;
		}

		public void setPointThreshold(Integer pointThreshold) {
			this.pointThreshold = pointThreshold;
		}

		public String getEarningPeriod() {
			return earningPeriod;
		}

		public void setEarningPeriod(String earningPeriod) {
			this.earningPeriod = earningPeriod;
		}

		public Object getKohlsCashCoupons() {
			return kohlsCashCoupons;
		}

		public void setKohlsCashCoupons(Object kohlsCashCoupons) {
			this.kohlsCashCoupons = kohlsCashCoupons;
		}

		public Object getTransactions() {
			return transactions;
		}

		public void setTransactions(Object transactions) {
			this.transactions = transactions;
		}

		public Object getRewards() {
			return rewards;
		}

		public void setRewards(Object rewards) {
			this.rewards = rewards;
		}

	}

}
