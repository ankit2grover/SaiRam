
package com.kohls.mcommerce.opal.common.value;

import com.kohls.mcommerce.opal.common.util.Logger;

/**
 * Provides and contains application wide modifiable common values
 */
public class CommonValues {
    private static CommonValues instance;

    private boolean mEnableBugSense;

    private boolean mEnableAnalytics;

    private boolean mEnableDigby;

    private boolean mEnableForseeFeedback;

    private String mKohlsPasscode;

    private int mIdleTimeout;

    private int mSigninTimeout;

    private int mAccessTokenExpiryTimeout;

    private CommonValues() {

        try {
            mAccessTokenExpiryTimeout = ConstantValues.APP_ACCESS_TOKEN_EXPIRY;
        } catch (NumberFormatException numberFormatException) {
            Logger.debug(numberFormatException.getMessage(), numberFormatException.getMessage());
        }

    }

    public static CommonValues getInstance() {
        if (instance == null) {
            instance = new CommonValues();
        }
        return instance;
    }

  /*  public boolean isEnableBugSense() {
        if (Boolean.valueOf(KohlsPhoneApplication.getInstance()
                .getConfigurationUtils()
                .getConfig()
                .getIsBugsense())) {
            return true;
        }
        return mEnableBugSense;
    }*/

    public void setEnableBugSense(boolean mEnableBugSense) {
        this.mEnableBugSense = mEnableBugSense;
    }

    public boolean isEnableDigby() {
        return mEnableDigby;
    }

    public void setEnableDigby(boolean mEnableDigby) {
        this.mEnableDigby = mEnableDigby;
    }

    public boolean isEnableAnalytics() {
        return mEnableAnalytics;
    }

    public void setEnableAnalytics(boolean mEnableAnalytics) {
        this.mEnableAnalytics = mEnableAnalytics;
    }

    public boolean isEnableForseeFeedback() {
        return mEnableForseeFeedback;
    }

    public void setEnableForseeFeedback(boolean mEnableForseeFeedback) {
        this.mEnableForseeFeedback = mEnableForseeFeedback;
    }

    public String getKohlsPasscode() {
        return mKohlsPasscode;
    }

    public void setKohlsPasscode(String mKohlsPasscode) {
        this.mKohlsPasscode = mKohlsPasscode;
    }

    public void setIdleTimeOut(int idleTimeout) {
        mIdleTimeout = idleTimeout;
    }

    public int getIdleTimeOut() {
        return mIdleTimeout;
    }

    public void setSignInTimeOut(int mSigninTimeout) {
        this.mSigninTimeout = mSigninTimeout;
    }

    public int getSignInTimeOut() {
        return mSigninTimeout;
    }

    public void setAccesstokenExpiry(int mAccessTokenExpiryTimeout) {
        this.mAccessTokenExpiryTimeout = mAccessTokenExpiryTimeout;
    }

    public int getAccesstokenExpiry() {
        return mAccessTokenExpiryTimeout;
    }

}
