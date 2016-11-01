
package com.kohls.mcommerce.opal.common.po;

import java.io.Serializable;

import com.kohls.mcommerce.opal.framework.vo.IValueObject;

public class CreateListPO implements IValueObject, Serializable {

    private int numLists;

    private int numItems;

    private LoggedInUser loggedInUser;

    public LoggedInUser getloggedInUser() {
        return loggedInUser;
    }

    public void setloggedInUser(LoggedInUser loggedInUser) {
        this.loggedInUser = loggedInUser;
    }
   // http://kohls.skavaone.com/kohls/createList?listName=test&listType=wishlist&budget=&listEventDate=&isPublic=false &emailOptIn=false&loggedInUser={“retailerUserId":"2253999806804095","firstName":"anto","lastName":"charli","email":"skavatest1@m.com","checkSum":"21187f919c0a81fd19483b543b9fb0cb"}&callback=createListCbk
    public class LoggedInUser {

        private String retailerUserId ;
        private String listName;
        private String listType;
        private String budget;
        private String listEventDate;
       // private boolean isPublic;
       // private boolean emailOptIn;

        private String firstName;

        public String getListName() {
			return listName;
		}

		public void setListName(String listName) {
			this.listName = listName;
		}

		public String getListType() {
			return listType;
		}

		public void setListType(String listType) {
			this.listType = listType;
		}

		public String getBudget() {
			return budget;
		}

		public void setBudget(String budget) {
			this.budget = budget;
		}

		public String getListEventDate() {
			return listEventDate;
		}

		public void setListEventDate(String listEventDate) {
			this.listEventDate = listEventDate;
		}

		/*public boolean isPublic() {
			return isPublic;
		}

		public void setPublic(boolean isPublic) {
			this.isPublic = isPublic;
		}

		public boolean isEmailOptIn() {
			return emailOptIn;
		}

		public void setEmailOptIn(boolean emailOptIn) {
			this.emailOptIn = emailOptIn;
		}*/

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

		private String lastName;

        private String email;

        private String checkSum;

        public String getcheckSum() {
            return checkSum;
        }

        public void setcheckSum(String checkSum) {
            this.checkSum = checkSum;
        }

        public String getemail() {
            return email;
        }

        public void setemail(String email) {
            this.email = email;
        }

        public String getlastName() {
            return lastName;
        }

        public void setlastName(String lastName) {
            this.lastName = lastName;
        }

        public String getfirstNamee() {
            return firstName;
        }

        public void setfirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getretailerUserId() {
            return retailerUserId;
        }

        public void setretailerUserId(String retailerUserId) {
            this.retailerUserId = retailerUserId;
        }
    }

    public int getnumItems() {
        return numItems;
    }

    public void setnumItems(int numItems) {
        this.numItems = numItems;
    }

    public void setnumLists(int numLists) {
        this.numLists = numLists;
    }

    public int getnumLists() {
        return this.numLists;
    }

    private ListItem listItem;

    public ListItem getListItem() {
        return listItem;
    }

    public void setListItem(ListItem listItem) {
        this.listItem = listItem;
    }

    public class ListItem {

        private String itemType;

        public String getItemType() {
            return itemType;
        }

        public void setItemType(String itemType) {
            this.itemType = itemType;
        }

        private String itemId;

        public String getItemId() {
            return itemId;
        }

        public void setItemId(String itemId) {
            this.itemId = itemId;
        }

        private String itemProductId;

        public String getItemProductId() {
            return itemProductId;
        }

        public void setItemProductId(String itemProductId) {
            this.itemProductId = itemProductId;
        }

        private String itemColor;

        public String getItemColor() {
            return itemColor;
        }

        public void setItemColor(String itemColor) {
            this.itemColor = itemColor;
        }

        private String itemSize;

        public String getItemSize() {
            return itemSize;
        }

        public void setItemSize(String itemSize) {
            this.itemSize = itemSize;
        }

        private String wantedQty;

        public String getWantedQty() {
            return wantedQty;
        }

        public void setWantedQty(String wantedQty) {
            this.wantedQty = wantedQty;
        }

        private String priceWhenCreated;

        public String getPriceWhenCreated() {
            return priceWhenCreated;
        }

        public void setPriceWhenCreated(String priceWhenCreated) {
            this.priceWhenCreated = priceWhenCreated;
        }

        private String productCode;
        
        private String upcCode;

        public String getProductCode() {
            return productCode;
        }

        public void setProductCode(String productCode) {
            this.productCode = productCode;
        }

        private String listId;

        public String getListId() {
            return listId;
        }

        public void setListId(String listId) {
            this.listId = listId;
        }

        private int priority;

        public int getPriority() {
            return priority;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        private String titleIfUnavailable;

        public String getTitleIfUnavailable() {
            return titleIfUnavailable;
        }

        public void setTitleIfUnavailable(String titleIfUnavailable) {
            this.titleIfUnavailable = titleIfUnavailable;
        }

        private String imageUrlIfUnavailable;

        public String getImageUrlIfUnavailable() {
            return imageUrlIfUnavailable;
        }

        public void setImageUrlIfUnavailable(String imageUrlIfUnavailable) {
            this.imageUrlIfUnavailable = imageUrlIfUnavailable;
        }

        private String categoryIfUnavailable;

        public String getCategoryIfUnavailable() {
            return categoryIfUnavailable;
        }

        public void setCategoryIfUnavailable(String categoryIfUnavailable) {
            this.categoryIfUnavailable = categoryIfUnavailable;
        }

		public String getUpcCode() {
			return upcCode;
		}

		public void setUpcCode(String upcCode) {
			this.upcCode = upcCode;
		}

    }

}
