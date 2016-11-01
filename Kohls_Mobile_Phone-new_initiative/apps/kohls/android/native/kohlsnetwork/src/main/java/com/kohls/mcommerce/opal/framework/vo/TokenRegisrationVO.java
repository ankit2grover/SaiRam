
package com.kohls.mcommerce.opal.framework.vo;

import java.util.List;

/**
 * Value model object of tokenRegisration adapter .
 */
public class TokenRegisrationVO implements IValueObject {

    private List<ErrorVO> errors;

    private Payload payload;

    public static class Payload {

        private int statusCode;

        private boolean isSuccessful;

        private int expires_in;

        private String refresh_token;

        private String access_token;
        
        private Wallet wallet;

        public int getExpires_in() {
            return expires_in;
        }

        public void setExpires_in(int expires_in) {
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

		public Wallet getWallet() {
			return wallet;
		}

		public void setWallet(Wallet wallet) {
			this.wallet = wallet;
		}
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

    public List<ErrorVO> getErrors() {
        return errors;
    }

    public void setErrors(List<ErrorVO> errors) {
        this.errors = errors;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

}
