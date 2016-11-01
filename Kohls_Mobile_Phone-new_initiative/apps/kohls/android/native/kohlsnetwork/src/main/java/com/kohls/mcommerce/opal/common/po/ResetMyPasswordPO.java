
package com.kohls.mcommerce.opal.common.po;


public class ResetMyPasswordPO {

    private Params params;

    private String access_token;

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public class Params {

        private PayLoad payload;

        public PayLoad getPayload() {
            return payload;
        }

        public void setPayload(PayLoad payload) {
            this.payload = payload;
        }

        public class PayLoad {

            private Profile profile;

            public Profile getProfile() {
                return profile;
            }

            public void setProfile(Profile profile) {
                this.profile = profile;
            }

            public class Profile {

                private CustomerName customerName;

                private String password;

                private String email;

                private String loyaltyId;

                public String getLoyaltyId() {
                    return loyaltyId;
                }

                public void setLoyaltyId(String loyaltyId) {
                    this.loyaltyId = loyaltyId;
                }

                public CustomerName getCustomerName() {
                    return customerName;
                }

                public void setCustomerName(CustomerName customerName) {
                    this.customerName = customerName;
                }

                public String getPassword() {
                    return password;
                }

                public void setPassword(String password) {
                    this.password = password;
                }

                public String getEmail() {
                    return email;
                }

                public void setEmail(String email) {
                    this.email = email;
                }

                public class CustomerName {

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
            }
        }
    }
}
