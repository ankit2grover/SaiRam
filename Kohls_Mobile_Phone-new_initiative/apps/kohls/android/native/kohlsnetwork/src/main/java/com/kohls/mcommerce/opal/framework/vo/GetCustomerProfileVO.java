
package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

/**
 * Value model object of getCustomerProfile adapter .
 */
public class GetCustomerProfileVO implements IValueObject {

    private List<ErrorVO> errors;

    private Payload payload;

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

    public static class Payload {

        private ProfileInfo profile;
        
        private WalletInfo wallet;
        
        private SignIn signin;

        public ProfileInfo getProfile() {
            return profile;
        }

        public void setProfile(ProfileInfo profile) {
            this.profile = profile;
        }
        
        public WalletInfo getWallet() {
			return wallet;
		}

		public void setWallet(WalletInfo wallet) {
			this.wallet = wallet;
		}
		
		public SignIn getSignin() {
			return signin;
		}

		public void setSignin(SignIn signin) {
			this.signin = signin;
		}

		public class SignIn implements Serializable {
			
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@SerializedName("token_type")
			private String tokenType;
			
			@SerializedName("expires_in")
			private String expiresIn;
			
			@SerializedName("refresh_token")
			private String refreshToken;
			
			@SerializedName("access_token")
			private String accessToken;

			public String getTokenType() {
				return tokenType;
			}

			public void setTokenType(String tokenType) {
				this.tokenType = tokenType;
			}

			public String getExpiresIn() {
				return expiresIn;
			}

			public void setExpiresIn(String expiresIn) {
				this.expiresIn = expiresIn;
			}

			public String getRefreshToken() {
				return refreshToken;
			}

			public void setRefreshToken(String refreshToken) {
				this.refreshToken = refreshToken;
			}

			public String getAccessToken() {
				return accessToken;
			}

			public void setAccessToken(String accessToken) {
				this.accessToken = accessToken;
			}
		}

		public class WalletInfo {
        	
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
    }
}
