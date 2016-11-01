
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.util.List;

/**
 * Value model object of signinandProfile adapter .
 * 
 * @author Ankit Grover
 */
public class SignInAndProfileVO implements IValueObject {

    private String expiryTime;

    private Payload payload;

    public static class Payload {

        private Response response;

        public static class Response {

            private ProfileInfo profileInfo;

            private SignIn signIn;

            private WalletInfo wallet;

            public WalletInfo getWallet() {
                return wallet;
            }

            public void setWallet(WalletInfo wallet) {
                this.wallet = wallet;
            }

            public class WalletInfo implements IValueObject {

                @Expose
                private String timestamp;

                @Expose
                private String hash;

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }

                public String getTimestamp() {
                    return timestamp;
                }

                public void setTimestamp(String timestamp) {
                    this.timestamp = timestamp;
                }
            }

            public static class SignIn {

                private int statusCode;

                private boolean isSuccessful;

                private String statusReason;

                private String token_type;

                private String expires_in;

                private String refresh_token;

                private String access_token;

                public int getStatusCode() {
                    return statusCode;
                }

                public void setStatusCode(int statusCode) {
                    this.statusCode = statusCode;
                }

                public boolean isSuccessful() {
                    return isSuccessful;
                }

                public void setSuccessful(boolean isSuccessful) {
                    this.isSuccessful = isSuccessful;
                }

                public String getStatusReason() {
                    return statusReason;
                }

                public void setStatusReason(String statusReason) {
                    this.statusReason = statusReason;
                }

                public String getToken_type() {
                    return token_type;
                }

                public void setToken_type(String token_type) {
                    this.token_type = token_type;
                }

                public String getExpires_in() {
                    return expires_in;
                }

                public void setExpires_in(String expires_in) {
                    this.expires_in = expires_in;
                }

                public String getRefresh_token() {
                    return refresh_token;
                }

                public void setRefresh_token(String refresh_token) {
                    this.refresh_token = refresh_token;
                }

                public String getAccess_token() {
                    return access_token;
                }

                public void setAccess_token(String access_token) {
                    this.access_token = access_token;
                }
            }

            public SignIn getSignIn() {
                return signIn;
            }

            public void setSignIn(SignIn signIn) {
                this.signIn = signIn;
            }

            private int statusCode;

            public int getStatusCode() {
                return statusCode;
            }

            public void setStatusCode(int statusCode) {
                this.statusCode = statusCode;
            }

            public static class Wallet {
                private String timestamp;

                private String hash;

                public String getTimestamp() {
                    return timestamp;
                }

                public void setTimestamp(String timestamp) {
                    this.timestamp = timestamp;
                }

                public String getHash() {
                    return hash;
                }

                public void setHash(String hash) {
                    this.hash = hash;
                }

            }

            public ProfileInfo getProfileInfo() {
                return profileInfo;
            }

            public void setProfileInfo(ProfileInfo profileInfo) {
                this.profileInfo = profileInfo;
            }
        }

        public Response getResponse() {
            return response;
        }

        public void setResponse(Response response) {
            this.response = response;
        }

        private boolean isSuccess;

        public boolean isSuccess() {
            return isSuccess;
        }

        public void setSuccess(boolean isSuccess) {
            this.isSuccess = isSuccess;
        }

        private String ErrorCode;

        private String Error;

        public String getErrorCode() {
            return ErrorCode;
        }

        public void setErrorCode(String errorCode) {
            ErrorCode = errorCode;
        }

        public String getError() {
            return Error;
        }

        public void setError(String error) {
            Error = error;
        }
    }

    private List<Errors> errors;

    public static class Errors {

        private int statusCode;

        private boolean isSuccessful;

        private String statusReason;

        private String ErrorCode;

        private String Error;

        private String code;

        private String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }

        public boolean isSuccessful() {
            return isSuccessful;
        }

        public void setSuccessful(boolean isSuccessful) {
            this.isSuccessful = isSuccessful;
        }

        public String getErrorCode() {
            return ErrorCode;
        }

        public void setErrorCode(String errorCode) {
            ErrorCode = errorCode;
        }

        public String getStatusReason() {
            return statusReason;
        }

        public void setStatusReason(String statusReason) {
            this.statusReason = statusReason;
        }

        public String getError() {
            return Error;
        }

        public void setError(String error) {
            Error = error;
        }
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

}
