
package com.kohls.mcommerce.opal.common.po;

/**
 * Sign in and get profile parameter class for providing parameters for
 * signInAndProfile adapter.
 * 
 * @author Ankit Grover
 */
public class SignInAndProfilePO {

//    private Params params;
//
//    public Params getparams() {
//        return params;
//    }
//
//    public void setparams(Params params) {
//        this.params = params;
//    }

   // public class Params {
        private String grant_type;

        private String userId;

        private String password;

        public String getGrant_type() {
            return grant_type;
        }

        public void setgrant_type(String grant_type) {
            this.grant_type = grant_type;
        }

        public String getuserId() {
            return userId;
        }

        public void setuserId(String userId) {
            this.userId = userId;
        }

        public String getPassword() {
            return password;
        }

        public void setpassword(String password) {
            this.password = password;
        }
    //}

}
