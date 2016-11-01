
package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;
import java.util.List;

public class ProfileInfo {

    private String id;

    private CustomerName customerName;

    public static class CustomerName {

        private String middleName;

        private String lastName;

        private String firstName;

        public String getMiddleName() {
            return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

    }

    private Phone phone;

    public static class Phone {
        private String phoneNumber;

        private String phoneNumberType;

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public String getPhoneNumberType() {
            return phoneNumberType;
        }

        public void setPhoneNumberType(String phoneNumberType) {
            this.phoneNumberType = phoneNumberType;
        }
    }

    private String updateShipAddressId;

    private List<Address> shipAddresses;

    private String status;

    private String email;

    private String loyaltyId;

    private boolean isEligibleForExpeditedCheckout;

    private Address billAddress;

    private List<PaymentTypes> paymentTypes;

    private Preferences preferences;

    public static class PaymentTypes {

        private boolean preferredPaymentType;

        private String nameOnCard;

        private String ID;

        private String expDate;

        private String type;

        private String cardNum;

        private boolean isEligibleForExpeditedCheckout;

        public boolean isEligibleForExpeditedCheckout() {
            return isEligibleForExpeditedCheckout;
        }

        public void setEligibleForExpeditedCheckout(boolean isEligibleForExpeditedCheckout) {
            this.isEligibleForExpeditedCheckout = isEligibleForExpeditedCheckout;
        }

        public boolean isPreferredPaymentType() {
            return preferredPaymentType;
        }

        public void setPreferredPaymentType(boolean preferredPaymentType) {
            this.preferredPaymentType = preferredPaymentType;
        }

        public String getNameOnCard() {
            return nameOnCard;
        }

        public void setNameOnCard(String nameOnCard) {
            this.nameOnCard = nameOnCard;
        }

        public String getID() {
            return ID;
        }

        public void setID(String iD) {
            ID = iD;
        }

        public String getExpDate() {
            return expDate;
        }

        public void setExpDate(String expDate) {
            this.expDate = expDate;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getCardNum() {
            return cardNum;
        }

        public void setCardNum(String cardNum) {
            this.cardNum = cardNum;
        }
    }

    public static class Address implements Serializable{

        /**
         * 
         */
        private static final long serialVersionUID = -1342438742077602881L;


        private String lastName;

        private String postalCode;

        private String phoneNumber;

        private String addr1;

        private String county;

        private String addr2;

        private Location location;

        private boolean preferredAddr;

        private String ID;

        private String countryCode;

        private String state;

        private String firstName;

        private String city;

        public static class Location implements Serializable{

            /**
             * 
             */
            private static final long serialVersionUID = -104006372296235123L;


            private String longitude;

            private String latitude;

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
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

        public String getAddr1() {
            return addr1;
        }

        public void setAddr1(String addr1) {
            this.addr1 = addr1;
        }

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getAddr2() {
            return addr2;
        }

        public void setAddr2(String addr2) {
            this.addr2 = addr2;
        }

        public Location getLocation() {
            return location;
        }

        public void setLocation(Location location) {
            this.location = location;
        }

        public boolean getPreferredAddr() {
            return preferredAddr;
        }

        public void setPreferredAddr(boolean preferredAddr) {
            this.preferredAddr = preferredAddr;
        }

        public String getID() {
            return ID;
        }

        public void setID(String iD) {
            ID = iD;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public void setCountryCode(String countryCode) {
            this.countryCode = countryCode;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

    }

    public static class Preferences {
        private boolean emailAlerts;

        private boolean saleAlerts;

        private boolean bridalAlerts;

        public boolean isEmailAlerts() {
            return emailAlerts;
        }

        public void setEmailAlerts(boolean emailAlerts) {
            this.emailAlerts = emailAlerts;
        }

        public boolean isSaleAlerts() {
            return saleAlerts;
        }

        public void setSaleAlerts(boolean saleAlerts) {
            this.saleAlerts = saleAlerts;
        }

        public boolean isBridalAlerts() {
            return bridalAlerts;
        }

        public void setBridalAlerts(boolean bridalAlerts) {
            this.bridalAlerts = bridalAlerts;
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CustomerName getCustomerName() {
        return customerName;
    }

    public void setCustomerName(CustomerName customerName) {
        this.customerName = customerName;
    }

    public Phone getPhone() {
        return phone;
    }

    public void setPhone(Phone phone) {
        this.phone = phone;
    }

    public String getUpdateShipAddressId() {
        return updateShipAddressId;
    }

    public void setUpdateShipAddressId(String updateShipAddressId) {
        this.updateShipAddressId = updateShipAddressId;
    }

    public List<Address> getShipAddresses() {
        return shipAddresses;
    }

    public void setShipAddresses(List<Address> shipAddresses) {
        this.shipAddresses = shipAddresses;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoyaltyId() {
        return loyaltyId;
    }

    public void setLoyaltyId(String loyaltyId) {
        this.loyaltyId = loyaltyId;
    }

    public boolean isEligibleForExpeditedCheckout() {
        return isEligibleForExpeditedCheckout;
    }

    public void setEligibleForExpeditedCheckout(boolean isEligibleForExpeditedCheckout) {
        this.isEligibleForExpeditedCheckout = isEligibleForExpeditedCheckout;
    }

    public Address getBillAddress() {
        return billAddress;
    }

    public void setBillAddress(Address billAddress) {
        this.billAddress = billAddress;
    }

    public List<PaymentTypes> getPaymentTypes() {
        return paymentTypes;
    }

    public void setPaymentTypes(List<PaymentTypes> paymentTypes) {
        this.paymentTypes = paymentTypes;
    }

    public Preferences getPreferences() {
        return preferences;
    }

    public void setPreferences(Preferences preferences) {
        this.preferences = preferences;
    }
}
