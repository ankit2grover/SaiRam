package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;
import java.util.List;


public class StoreInfo {

	private String storeNum;

	private String storeName;

	public String getStoreNum() {
		return storeNum;
	}

	public void setStoreNum(String storeNum) {
		this.storeNum = storeNum;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}


	public class StoreHour implements Serializable {
		private static final long serialVersionUID = 11L;

		private List<Day> days;

		public List<Day> getDays() {
			return days;
		}

		public void setDays(List<Day> days) {
			this.days = days;
		}

		public class Day implements Serializable {

			private static final long serialVersionUID = 20L;

			private String name;

			public String getDayName() {
				return name;
			}

			public void setDayName(String name) {
				this.name = name;
			}

			
			private Hour hours;

			public Hour getHoursofOperation() {
				return hours;
			}

			public void setHoursofOperation(Hour hours) {
				this.hours = hours;
			}

			public class Hour implements Serializable {

				private static final long serialVersionUID = 5L;

				
				private String open;

				public void setOpenTimes(String open) {
					this.open = open;
				}

				public String getOpenTimes() {
					return open;
				}

				
				private String close;

				public void setCloseTimes(String close) {
					this.close = close;
				}

				public String getCloseTimes() {
					return close;
				}

			}

		}

	}

	
	private Address address;

	public class Address implements Serializable {
		private static final long serialVersionUID = 15L;

		
		private String addr1;

		public void setAddr1(String addr1) {
			this.addr1 = addr1;
		}

		public String getAddr1() {
			return addr1;
		}

		
		private String city;

		public void setCity(String city) {
			this.city = city;
		}

		public String getCity() {
			return city;
		}

		
		private String state;

		public void setState(String state) {
			this.state = state;
		}

		public String getState() {
			return state;
		}

		
		private String postalCode;

		public void setPostalCode(String postalCode) {
			this.postalCode = postalCode;
		}

		public String getPostalCode() {
			return postalCode;
		}

	}

	
	private ContactInfo[] contactInfo;

	public ContactInfo[] getContactInfo() {
		return contactInfo;
	}

	public void setContactInfo(ContactInfo[] contactInfo) {
		this.contactInfo = contactInfo;
	}

	public class ContactInfo implements Serializable {

		private static final long serialVersionUID = 12L;

		
		private String value;

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

		
		private String type;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

	}

	
	private String distanceFromOrigin;

	public void setDistanceFromOrigin(String distanceFromOrigin) {
		this.distanceFromOrigin = distanceFromOrigin;
	}

	public String getDistanceFromOrigin() {
		return distanceFromOrigin;
	}

}
