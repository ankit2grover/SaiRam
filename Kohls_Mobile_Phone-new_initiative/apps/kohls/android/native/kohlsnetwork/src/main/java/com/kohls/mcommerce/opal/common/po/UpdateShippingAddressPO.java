
package com.kohls.mcommerce.opal.common.po;

public class UpdateShippingAddressPO {
    private params params;

    private String access_token;

    public params getParams() {
        return params;
    }

    public void setParams(params params) {
        this.params = params;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public class params {
        private payload payload;

        public payload getpLoad() {
            return payload;
        }

        public void setpLoad(payload payload) {
            this.payload = payload;
        }

    }

    public class payload {
        private profile profile;

        public profile getProfile() {
            return profile;
        }

        public void setProfile(profile profile) {
            this.profile = profile;
        }
        
    }

    public class profile {
        private shipAddress shipAddress;

        public shipAddress getshipAddress() {
            return shipAddress;
        }

        public void setsAddress(shipAddress shipAddress) {
            this.shipAddress = shipAddress;
        }

    }

    public class shipAddress {
        private String firstName;

        private String lastName;

        private String addr1;

        private String addr2;

        private String city;

        private String state;

        private String postalCode;

        private String phoneNumber;

        private String action;
        private String county;

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        private boolean preferredAddr;

        private String ID;

        // "firstName": "dfgdfgsdfsdf",
        // "lastName": "dfgdfg",
        // "addr1": "Sdsu Campus Parking",
        // "addr2": "",
        // "city": "San Diego",
        // "state": "CA",
        // "postalCode": "92115",
        // "phoneNumber": "5345345345",
        // "action": "update",
        // "preferredAddr": false,
        // "ID": "600000000014823275"
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

        public String getAction() {
            return action;
        }

        public void setAction(String action) {
            this.action = action;
        }

        public boolean isPreferredAddr() {
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
    }
}
