
package com.kohls.mcommerce.opal.common.po;

import java.util.ArrayList;
import java.util.List;

public class ValidateOrderPO {
    public ValidateOrderPO() {
    }

    public ValidateOrderPO(Address address) {
        List<Address> addresses = new ArrayList<ValidateOrderPO.Address>();
        addresses.add(address);
        payload pl = new payload();
        pl.setAddresses(addresses);
        params par = new params();
        par.setPayload(pl);
    }

    private params params;

    public params getParams() {
        return params;
    }

    public void setParams(params params) {
        this.params = params;
    }

    public class params {
        private payload payload;

        public payload getPayload() {
            return payload;
        }

        public void setPayload(payload payload1) {
            payload = payload1;
        }

    }

    public class payload {
        private List<Address> addresses;

        public List<Address> getAddresses() {
            return addresses;
        }

        public void setAddresses(List<Address> addresses) {
            this.addresses = addresses;
        }

    }

    public class Address {
        private String ID;

        private String addr1;

        private String city;

        private String state;

        private String pageName;

        private String postalCode;
        private String county;

        public String getCounty() {
            return county;
        }

        public void setCounty(String county) {
            this.county = county;
        }

        public String getID() {
            return ID;
        }

        public void setID(String iD) {
            ID = iD;
        }

        public String getAddr1() {
            return addr1;
        }

        public void setAddr1(String addr1) {
            this.addr1 = addr1;
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

        public String getPageName() {
            return pageName;
        }

        public void setPageName(String pageName) {
            this.pageName = pageName;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

    }

}
