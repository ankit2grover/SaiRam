
package com.kohls.mcommerce.opal.common.po;

import java.util.ArrayList;
import java.util.List;

public class DeleteAddressPO {

//    private List<ShippingAddress> shippingAddress;

//    public DeleteAddressPO(String userAccessTokenFromPref, String id) {
////        ShippingAddress shippingAdd = new ShippingAddress();
//        shippingAdd.setAccess_token(userAccessTokenFromPref);
//        shippingAdd.setShipAddressID(id);
//        this.shippingAddress = new ArrayList<ShippingAddress>();
//        this.shippingAddress.add(shippingAdd);
//    }

    public DeleteAddressPO() {
        super();
    }

//    public List<ShippingAddress> getShippingAddress() {
//        return shippingAddress;
//    }
//
//    public void setShippingAddress(List<ShippingAddress> shippingAddress) {
//        this.shippingAddress = shippingAddress;
//    }

//    public static class ShippingAddress {
        private String shipAddressID;

        private String access_token;

        public String getShipAddressID() {
            return shipAddressID;
        }

        public void setShipAddressID(String shipAddressID) {
            this.shipAddressID = shipAddressID;
        }

        public String getAccess_token() {
            return access_token;
        }

        public void setAccess_token(String access_token) {
            this.access_token = access_token;
        }

//    }
}
