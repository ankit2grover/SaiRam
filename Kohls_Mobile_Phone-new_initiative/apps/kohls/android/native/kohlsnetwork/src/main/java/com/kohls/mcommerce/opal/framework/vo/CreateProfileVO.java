
package com.kohls.mcommerce.opal.framework.vo;

import java.util.List;

/**
 * Value model object of createProfile adapter .
 */
public class CreateProfileVO implements IValueObject {

    private String responseID;

    private String expiryTime;

    private List<Errors> errors;

    public static class Errors {

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
    }

    private Payload payload;

    public static class Payload {

        private int statusCode;

        private DataPayload payload;

        private boolean isSuccessful;

        private String statusReason;

        public static class DataPayload {
            private String message;

            public String getMessage() {
                return message;
            }

            public void setMessage(String message) {
                this.message = message;
            }
        }

        public DataPayload getPayload() {
            return payload;
        }

        public void setPayload(DataPayload payload) {
            this.payload = payload;
        }

        public String getStatusReason() {
            return statusReason;
        }

        public void setStatusReason(String statusReason) {
            this.statusReason = statusReason;
        }

        public boolean isSuccessful() {
            return isSuccessful;
        }

        public void setSuccessful(boolean isSuccessful) {
            this.isSuccessful = isSuccessful;
        }

        public int getStatusCode() {
            return statusCode;
        }

        public void setStatusCode(int statusCode) {
            this.statusCode = statusCode;
        }
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public String getExpiryTime() {
        return expiryTime;
    }

    public void setExpiryTime(String expiryTime) {
        this.expiryTime = expiryTime;
    }

    public String getResponseID() {
        return responseID;
    }

    public void setResponseID(String responseID) {
        this.responseID = responseID;
    }

    public List<Errors> getErrors() {
        return errors;
    }

    public void setErrors(List<Errors> errors) {
        this.errors = errors;
    }
}
