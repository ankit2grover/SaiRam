
package com.kohls.mcommerce.opal.common.po;

/**
 * Parameter class for providing parameters for createProfile adapter.
 * 
 * @author Ankit Grover
 */
public class CreateProfilePO {

    private Params params;

    public static class Params {

        private Payload payload;

        public static class Payload {

            private Profile profile;

            public static class Profile {
                private String email;

                private String password;
                
                private String loyaltyId;

                private CustomerName customerName;

                public static class CustomerName {
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

            }

            public Profile getProfile() {
                return profile;
            }

            public void setProfile(Profile profile) {
                this.profile = profile;
            }
        }

        public Payload getPayload() {
            return payload;
        }

        public void setPayload(Payload payload) {
            this.payload = payload;
        }
    }

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }
}
