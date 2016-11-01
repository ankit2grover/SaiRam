package com.kohls.mcommerce.opal.common.po;

public class BlackFridayListPO {

	public String getListUserId() {
		return listUserId;
	}

	public void setListUserId(String listUserId) {
		this.listUserId = listUserId;
	}

	public String getRetailerUserId() {
		return retailerUserId;
	}

	public void setRetailerUserId(String retailerUserId) {
		this.retailerUserId = retailerUserId;
	}

	public LoggedInUser getLoggedInUser() {
		return loggedInUser;
	}

	public void setLoggedInUser(LoggedInUser loggedInUser) {
		this.loggedInUser = loggedInUser;
	}

    private String listUserId;

    private String retailerUserId;
    
    private LoggedInUser loggedInUser;

    public LoggedInUser getloggedInUser() {
        return loggedInUser;
    }

    public void setloggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
    
    public class LoggedInUser {
    	
    	 public String getRetailerUserId() {
			return retailerUserId;
		}

		public void setRetailerUserId(String retailerUserId) {
			this.retailerUserId = retailerUserId;
		}

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

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getCheckSum() {
			return checkSum;
		}

		public void setCheckSum(String checkSum) {
			this.checkSum = checkSum;
		}

		private String retailerUserId;

         private String firstName;

         private String lastName;

         private String email;

         private String checkSum;
    }
}
