
package com.kohls.mcommerce.opal.common.po;


public class PersistantGetCartPO {

    // User is signed In - then pass the access token to get cart
    private String access_token;

    public String getaccess_token() {
        return access_token;
    }

    public void setaccess_token(String access_token) {
        this.access_token = access_token;
    }

}
