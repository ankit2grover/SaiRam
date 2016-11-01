package com.kohls.mcommerce.opal.common.po;

public class RoyaltyPO {

	private CustomerName customerName;
	private String email;
	private String phoneNumber;
	private String birthday;
	
	private Address address;
	private String postalCode;
	
	public CustomerName getCustomerName() {
		return customerName;
	}

	public void setCustomerName(CustomerName customerName) {
		this.customerName = customerName;
	}
	
	public static class CustomerName {

		private String firstName;
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
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public static class Address {
		private String addr1;
		private String addr2;
		private String city;
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

	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

}
