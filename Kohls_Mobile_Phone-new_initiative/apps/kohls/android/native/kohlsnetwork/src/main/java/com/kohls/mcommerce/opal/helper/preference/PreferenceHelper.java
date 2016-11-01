
package com.kohls.mcommerce.opal.helper.preference;

import com.apptentive.android.sdk.prefence.KohlsApptentivePreference;
import com.google.gson.Gson;
import com.kohls.mcommerce.opal.common.app.KohlsPhoneApplication;
import com.kohls.mcommerce.opal.common.value.ConstantValues;
import com.kohls.mcommerce.opal.framework.vo.StoreLocatorVO.Payload.Store;
import com.kohls.mcommerce.opal.helper.db.DBOperationsHelper;
import com.kohls.mcommerce.opal.helper.db.DBTablesDef;
import com.kohls.mcommerce.opal.modules.lnr.common.value.LnRConstantValues;
import com.kohls.mcommerce.opal.wallet.util.Appconfig;
import com.kohls.mcommerce.opal.wallet.util.Constants;
import com.kohls.mcommerce.opal.wallet.util.RewardCache;
import com.kohls.mcommerce.opal.wallet.util.WalletCache;

import org.json.JSONArray;
import org.json.JSONException;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.location.Location;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * This class will manage all interactions with Shared Preferences.
 */
public class PreferenceHelper {
    private final Context appContext;

    private Gson gson;

    private boolean acceptLic;

    public PreferenceHelper(Context context) {
        this.appContext = context;
    }

    private SharedPreferences getDefaultSharePreference() {
        return appContext.getSharedPreferences(ConstantValues.APP_PREFERENCE, Context.MODE_PRIVATE);
    }

    private Gson getGson() {
        if (gson == null) {
            gson = new Gson();
        }
        return gson;
    }

    /**
     * This location is being saved in order to direct user to the last know
     * location in case Location settings is disabled
     *
     * @param mLastLocation
     */
    public void saveLastUserLocation(Location mLastLocation) {
        Editor editor = getDefaultSharePreference().edit();
        String json = getGson().toJson(mLastLocation);
        editor.putString(ConstantValues.USER_LAST_LOCATION, json);
        editor.apply();
    }

    public Location getLastUserLocation() {
        String json = getDefaultSharePreference().getString(ConstantValues.USER_LAST_LOCATION, "");
        if (json != null && json.length() > 0) {
            Location mLastLocation = getGson().fromJson(json, Location.class);
            return mLastLocation;
        }
        return null;
    }

    /**
     * Save user credentials & user info in the preferences.
     *
     * @param accessToken Access token of user.
     */
    public void saveAppCofiguration(String configString) {
        if (!TextUtils.isEmpty(configString)) {
            Editor editor = getDefaultSharePreference().edit();
            editor.putString(ConstantValues.APP_CONFIG, configString);
            editor.apply();
        }
    }

    public String getAppConfiguration() {
        return getDefaultSharePreference().getString(ConstantValues.APP_CONFIG, null);
    }

    public void saveUserStore(Store userStore) {
        Editor editor = getDefaultSharePreference().edit();
        String json = getGson().toJson(userStore);
        editor.putString(ConstantValues.USER_STORE_INFO, json);
        editor.apply();
    }

    public void removeUserStore() {
        Editor editor = getDefaultSharePreference().edit();
        editor.remove(ConstantValues.USER_STORE_INFO);
        editor.apply();
    }

    public Store getUserStore() {
        String json = getDefaultSharePreference().getString(ConstantValues.USER_STORE_INFO, "");
        Store userStore = getGson().fromJson(json, Store.class);
        return userStore;
    }

    public void saveShoppingBagSubTotalAndCount(String subTotal) {
        saveShoppingBagSubTotalAndCount(null, subTotal);
    }

    public void saveShoppingBagSubTotalAndCount(final String totalBagCount,
    final String subTotal) {
        DBOperationsHelper helper = new DBOperationsHelper();
        String bagCount = null;
        if (totalBagCount != null) {
            bagCount = totalBagCount;
        } else {
            bagCount = String.valueOf(helper.count(DBTablesDef.T_SHOPPING_BAG));
        }

        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.SHOPPING_BAG_SUBTOTAL, subTotal);
        editor.putString(ConstantValues.SHOPPING_BAG_COUNT, bagCount);
        editor.apply();
    }

    public String getShoppingBagSubTotal() {
        return getDefaultSharePreference().getString(ConstantValues.SHOPPING_BAG_SUBTOTAL, "0");
    }

    public String getShoppingBagCount() {
        return getDefaultSharePreference().getString(ConstantValues.SHOPPING_BAG_COUNT, "0");
    }

    // Twiiter Preferences

    public boolean getTwitterAuthorizationStatus() {
        return getDefaultSharePreference().getBoolean(ConstantValues.TWITTER_IS_USER_AUTHORIZED,
                false);
    }

    public void setTwitterAutorizationStatus(boolean isAuthorized) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.TWITTER_IS_USER_AUTHORIZED, isAuthorized);
        editor.apply();
    }

    public void saveTwitterOauth(String tokenKey, String tokenSecret) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.TWITTER_OAUTH_KEY_TOKEN, tokenKey);
        editor.putString(ConstantValues.TWITTER_OAUTH_KEY_SECRET, tokenSecret);
        editor.apply();
    }

    public String getTwitterOauthTokenSecret() {
        return getDefaultSharePreference().getString(ConstantValues.TWITTER_OAUTH_KEY_SECRET, null);
    }

    public String getTwitterOauthTokenKey() {
        return getDefaultSharePreference().getString(ConstantValues.TWITTER_OAUTH_KEY_TOKEN, null);
    }

    /**
     * Save user credentials & user info in the preferences.
     *
     * @param accessToken Access token of user.
     * @param refreshToken Refresh token after signing in.
     * @param firstName Users name.
     * @param expireTime Expire time of token in seconds.
     * @param emailAddress Email address of user.
     * @param lastName TODO
     * @param loyaltyID TODO
     */
    public void saveUserCredentialsAndInfo(String accessToken,
            String refreshToken,
            String firstName,
            long expireTime,
            String emailAddress,
            String userID,
            String digestedMessage,
            String expiryStringTime,
            String lastName,
            String loyaltyID,
            String wallethash,
            String wallettimestamp) {
        long timeInSeconds = (System.currentTimeMillis() / 1000);
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_ACCESS_TOKEN_KEY, accessToken);
        editor.putString(ConstantValues.PREF_REFRESH_TOKEN_KEY, refreshToken);
        editor.putString(ConstantValues.PREF_USERNAME_KEY, firstName);
        editor.putString(ConstantValues.PREF_USERLASTNAME_KEY, lastName);
        editor.putString(ConstantValues.PREF_EMAIL_KEY, emailAddress);
        editor.putLong(ConstantValues.PREF_SIGN_IN_TIME_KEY, timeInSeconds);
        editor.putLong(ConstantValues.PREF_EXPIRE_TIME_KEY, expireTime);
        editor.putString(ConstantValues.PREF_DIGESTED_MSG, digestedMessage);
        editor.putString(ConstantValues.PREF_STRING_MSG, expiryStringTime);
        editor.putLong(ConstantValues.PREF_SECURE_TIME_KEY, timeInSeconds);
        editor.putString(ConstantValues.PREF_USERNAME_ID, userID);
        editor.putString(ConstantValues.PREF_LOYALTY_ID, loyaltyID);
        editor.putString(ConstantValues.PREF_WALLET_HASH, wallethash);
        editor.putString(ConstantValues.PREF_WALLET_EXPIRYTIME, wallettimestamp);

        editor.commit();

    }

    public void saveCustomerName(String firstName, String lastName) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_USERNAME_KEY, firstName);
        editor.putString(ConstantValues.PREF_USERLASTNAME_KEY, lastName);
        editor.commit();
    }

    public String getWalletTimestamp() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_WALLET_EXPIRYTIME, null);
    }

    public String getWalletHash() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_WALLET_HASH, null);
    }

    /**
     * Update user credentials tokens like refresh & accessTokens
     *
     * @param accessToken Access token of the user.
     * @param refreshToken Refresh token for refreshing access token.
     * @param walletHash TODO
     * @param walletTimestamp TODO
     */
    public void updateUserCredentialsTokens(String accessToken,
            String refreshToken,
            String walletHash,
            String walletTimestamp) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_ACCESS_TOKEN_KEY, accessToken);
        editor.putString(ConstantValues.PREF_REFRESH_TOKEN_KEY, refreshToken);
        editor.putString(ConstantValues.PREF_WALLET_HASH, walletHash);
        editor.putString(ConstantValues.PREF_WALLET_EXPIRYTIME, walletTimestamp);
        long timeInSeconds = (System.currentTimeMillis() / 1000);
        editor.putLong(ConstantValues.PREF_SIGN_IN_TIME_KEY, timeInSeconds);
        editor.commit();
    }

    /**
     * Update user's secure time with current time of the device.
     */
    public void updateAppSecureTime() {
        Editor editor = getDefaultSharePreference().edit();
        long timeInSeconds = (System.currentTimeMillis() / 1000);
        editor.putLong(ConstantValues.PREF_SECURE_TIME_KEY, timeInSeconds);
        editor.apply();
    }

    /**
     * Returns access token expire time if available else returns 0.
     */
    public long getAccessTokenExpireTime() {
        return getDefaultSharePreference().getLong(ConstantValues.PREF_EXPIRE_TIME_KEY, 0);
    }

    /**
     * Returns sign in time if available else returns 0.
     */
    public long getSignInTime() {
        return getDefaultSharePreference().getLong(ConstantValues.PREF_SIGN_IN_TIME_KEY, 0);
    }

    /**
     * Returns secure time of the user's session.
     */
    public long getSecureTime() {
        return getDefaultSharePreference().getLong(ConstantValues.PREF_SECURE_TIME_KEY, 0);
    }

    public long getIdleTimeStart() {
        return getDefaultSharePreference().getLong(ConstantValues.PREF_IDLE_TIME_KEY, 0);
    }

    /**
     * Returns sign in username.
     */
    public String getSignedInUserName() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_USERNAME_KEY, null);
    }

    public String getSignedinUserLastName() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_USERLASTNAME_KEY, null);
    }

    /**
     * Returns sign in username.
     */
    public String getSignedInUserId() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_USERNAME_ID, null);
    }

    public void setLoyaltyID(String loyaltyID) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_LOYALTY_ID, loyaltyID);
        editor.apply();
    }

    /**
     * If false means user is currently not signed in else if true means user
     * sigend in
     */
    public void setUserSignInStatus(boolean userSignedInStatus) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.PREF_USER_SIGNED_IN_STATUS, userSignedInStatus);
        editor.apply();
    }

    /**
     * If false means user is currently not signed in else if true means user
     * sigend in
     */
    public boolean getUserSignInStatus() {
        boolean signedInStatus = false;
        signedInStatus = getDefaultSharePreference().getBoolean(ConstantValues.PREF_USER_SIGNED_IN_STATUS,
                false);
        return signedInStatus;
    }

    /**
     * Returns Access token.
     */
    public String getAccessToken() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_ACCESS_TOKEN_KEY, null);
    }

    /**
     * Returns User Mail ID.
     */
    public void setUserMailId(String mailId) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_EMAIL_KEY, mailId);
        editor.apply();
    }

    /**
     * Clear user credentials & information from shared preferences.
     */
    public void clearUserCredentialAndInfo(boolean clearAll) {
        Editor editor = getDefaultSharePreference().edit();
        editor.remove(ConstantValues.PREF_ACCESS_TOKEN_KEY);
        editor.remove(ConstantValues.PREF_REFRESH_TOKEN_KEY);
        if (clearAll) {
            editor.remove(ConstantValues.PREF_USERNAME_KEY);
        }
        editor.remove(ConstantValues.PREF_SIGN_IN_TIME_KEY);
        editor.remove(ConstantValues.PREF_EXPIRE_TIME_KEY);
        editor.remove(ConstantValues.PREF_SECURE_TIME_KEY);
        editor.remove(ConstantValues.PREF_USER_LOYALTY_ID);

        editor.remove(Appconfig.WALLET_ID);
        editor.remove(Constants.ERROR_UPDATE_TIMESTAMP);
        editor.remove(Appconfig.PREFERENCE_ID);
        editor.remove(ConstantValues.PREF_WALLET_HASH);
        editor.remove(ConstantValues.PREF_WALLET_EXPIRYTIME);
        editor.remove(ConstantValues.PREF_USERLASTNAME_KEY);

        editor.apply();

        WalletCache.clear(appContext, Appconfig.WALLET_KOHLS_CASH_CACHE);
        WalletCache.clear(appContext, Appconfig.WALLET_OFFERS_CACHE);
        WalletCache.clear(appContext, Appconfig.WALLET_CACHE);
        RewardCache.clear(appContext);

        // Clear LnR
        clearSessionAndUserProfileFromListOrRegistry(LnRConstantValues.JSESSION_KEY_PREF_KEY,
                LnRConstantValues.CREATE_OR_GET_USER_PREF_KEY);

    }

    public void saveEulaPrefernces(boolean acceptLice) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.LIC_ACCEPTANCE, acceptLice);
        acceptLic = acceptLice;
        editor.apply();
    }

    public boolean isEulaAccepted() {
        return getDefaultSharePreference().getBoolean(ConstantValues.LIC_ACCEPTANCE, acceptLic);
    }

    /**
     * Returns boolean whether the application has Forsee debug enabled. - true
     * for Forsee debug enabled - false for Forsee debug disabled
     */
    public boolean getIsForseeDebug() {
        return getDefaultSharePreference().getBoolean(ConstantValues.APP_FORSEE_CONFIG, false);
    }

    public String getDigestedMessage() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_DIGESTED_MSG, null);
    }

    public String getExpiryStringTime() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_STRING_MSG, null);

    }

    /**
     * Sets data into Forsee Enabling
     */
    public void setIsForseeDebug(boolean mForseeEnabled) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.APP_FORSEE_CONFIG, mForseeEnabled);
        editor.apply();
    }

    public boolean isFirstScan() {
        return getDefaultSharePreference().getBoolean(ConstantValues.PREF_FIRST_SCAN, true);
    }

    public void setIsFirstScan(boolean mIsFirstScan) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.PREF_FIRST_SCAN, mIsFirstScan);
        editor.apply();
    }

    public void setIdleTime() {
        long timeInSeconds = (System.currentTimeMillis() / 1000);
        Editor editor = getDefaultSharePreference().edit();
        editor.putLong(ConstantValues.PREF_IDLE_TIME_KEY, timeInSeconds);
        editor.apply();

    }

    /**
     * Returns Loyalty ID.
     */
    public String getLoyaltyID() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_LOYALTY_ID, null);
    }

    /**
     * Returns Refresh token.
     */
    public String getRefreshToken() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_REFRESH_TOKEN_KEY, "");
    }

    /**
     * Returns User Mail ID.
     */
    public String getUserMailId() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_EMAIL_KEY, "");
    }

    /**
     * Returns Refresh token.
     */
    public String getFirstName() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_FIRST_NAME, "");
    }

    /**
     * Returns User Mail ID.
     */
    public String getLastName() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_LAST_NAME, "");
    }

    public void setFaqUrl(String url) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(Constants.FAQ_URL, url);
        editor.commit();
    }

    public String getFaqUrl() {
        return getDefaultSharePreference().getString(Constants.FAQ_URL, "");
    }

    public void setTermsandConditionUrl(String url) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(Constants.TERMS_CONDITIONS_URL, url);
        editor.commit();
    }

    public String getTermsandConditionUrl() {
        return getDefaultSharePreference().getString(Constants.TERMS_CONDITIONS_URL, "");
    }

    public void setProgramDetailsHeader(String header) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(Constants.PROGRAM_DETAIL_HEADER, header);
        editor.commit();
    }

    public String getProgramDetailsHeader() {
        return getDefaultSharePreference().getString(Constants.PROGRAM_DETAIL_HEADER, "");
    }

    public void setProgramDetailsContent(String header) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(Constants.PROGRAM_DETAIL_CONTENT, header);
        editor.commit();
    }

    public String getProgramDetailsContent() {
        return getDefaultSharePreference().getString(Constants.PROGRAM_DETAIL_CONTENT, "");
    }

    public void setSigninStatus(String status) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(Constants.SIGNIN_DISPLAYED, status);
        editor.commit();
    }

    public String getSigninStatus() {
        return getDefaultSharePreference().getString(Constants.SIGNIN_DISPLAYED, "");
    }

    public void setWalletId(String walletId) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(Appconfig.WALLET_ID, walletId);
        editor.commit();
    }

    public void setDigbyNotification(boolean geoFence, Location mGeoFenceLocation) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.CONSTANT_FROM_DIGBY, geoFence);
        String json = getGson().toJson(mGeoFenceLocation);
        editor.putString(ConstantValues.LOCATION_FROM_DIGBY, json);
        editor.commit();
    }

    public void setHasUserDiscardedUpgrade(boolean hasUpgradeDiscard) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.CONSTANT_FROM_UPGRADE, hasUpgradeDiscard);
        editor.commit();
    }

    public boolean getHasUserDiscardedUpgrade() {
        return getDefaultSharePreference().getBoolean(ConstantValues.CONSTANT_FROM_UPGRADE, false);
    }

    public boolean isGeoFenceBroken() {
        return getDefaultSharePreference().getBoolean(ConstantValues.CONSTANT_FROM_DIGBY, false);
    }

    public Location getLocationFromGeofence() {
        String json = getDefaultSharePreference().getString(ConstantValues.LOCATION_FROM_DIGBY, "");
        if (json != null && json.length() > 0) {
            Location mLocationFromGeoFence = getGson().fromJson(json, Location.class);
            return mLocationFromGeoFence;
        }
        return null;
    }

    public String getServerError(String code) {
        return getDefaultSharePreference().getString(code, "");
    }

    public void setServerError(String code, String msg) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(code, msg);
        editor.commit();
    }

    public String getSearchedFileName(String code) {
        return getDefaultSharePreference().getString(code, "");
    }

    public void setSearchedFileName(String code, String filename) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(code, filename);
        editor.commit();
    }

    public String getLoyaltyMode() {
        return getDefaultSharePreference().getString(Constants.LOYALTY_MODE, "");
    }

    public void setLoyaltyMode(String loyaltyMode) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(Constants.LOYALTY_MODE, loyaltyMode);
        editor.commit();
    }

    public String getErrorTimestamp() {
        return getDefaultSharePreference().getString(Constants.ERROR_UPDATE_TIMESTAMP, "");
    }

    public String getFirstInstallValue() {
        return getDefaultSharePreference().getString(Constants.FIRST_INSTALL_VALUE, "");
    }

    public void setFirstInstallValue(String fistInstallValue) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(Constants.FIRST_INSTALL_VALUE, Constants.NO);
        editor.commit();
    }

    public void setErrorTimestamp(String timestamp) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(Constants.ERROR_UPDATE_TIMESTAMP, timestamp);
        editor.commit();
    }

    public String getWalletId() {
        return getDefaultSharePreference().getString(Appconfig.WALLET_ID, "");
    }

    public void setPreferenceId(ArrayList<String> values) {
        SharedPreferences prefs = getDefaultSharePreference();
        SharedPreferences.Editor editor = prefs.edit();
        JSONArray a = new JSONArray();
        if (values == null) {
            editor.remove(Appconfig.PREFERENCE_ID);
            editor.commit();
            return;
        }
        for (int i = 0; i < values.size(); i++) {
            a.put(values.get(i));
        }
        if (!values.isEmpty()) {
            editor.putString(Appconfig.PREFERENCE_ID, a.toString());
        }
        editor.commit();
    }

    public ArrayList<String> getPreferenceId() {
        SharedPreferences prefs = getDefaultSharePreference();
        String json = prefs.getString(Appconfig.PREFERENCE_ID, null);
        ArrayList<String> urls = new ArrayList<String>();
        if (json != null) {
            try {
                JSONArray a = new JSONArray(json);
                for (int i = 0; i < a.length(); i++) {
                    String url = a.optString(i);
                    urls.add(url);
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return urls;
    }

    public void setCacheTimeCMS(long cmsCacheTime) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putLong(ConstantValues.PREF_CMS_CACHE, cmsCacheTime);
        editor.apply();
    }

    public long getCmsCacheTime() {
        return getDefaultSharePreference().getLong(ConstantValues.PREF_CMS_CACHE, 0);
    }

    public void setCacheTimeRegistry(long registryCacheTime) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putLong(ConstantValues.PREF_CMS_CACHE, registryCacheTime);
        editor.apply();
    }

    public long getRegistryCacheTime() {
        return getDefaultSharePreference().getLong(ConstantValues.PREF_CMS_CACHE, 0);
    }

    public void setCacheTimeCategory(long categoryCacheTime) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putLong(ConstantValues.PREF_CATEGORY_CACHE, categoryCacheTime);
        editor.apply();
    }

    public long getCategoryCacheTime() {
        return getDefaultSharePreference().getLong(ConstantValues.PREF_CATEGORY_CACHE, 0);
    }

    public boolean wantOmnichannelFlagOverride() {
        return getDefaultSharePreference().getBoolean(ConstantValues.PREF_OMNICHANNEL_OVERRIDE,
                false);
    }

    public void setOmnichannelFlagOverride(boolean omnichannelEnabled) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.PREF_OMNICHANNEL_OVERRIDE, omnichannelEnabled);
        editor.apply();
    }

    public boolean isOmniChannelEnabledinPref() {
        return getDefaultSharePreference().getBoolean(ConstantValues.PREF_OMNICHANNEL_ENABLED,
                false);
    }

    public void setOmnichannelEnabled(boolean isOmnichannelEnabled) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.PREF_OMNICHANNEL_ENABLED, isOmnichannelEnabled);
        editor.apply();
    }

    public void setCacheTimeCatalog(long catalogCacheTime) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putLong(ConstantValues.PREF_CATALOG_CACHE, catalogCacheTime);
        editor.apply();
    }

    public long getCatalogCacheTime() {
        return getDefaultSharePreference().getLong(ConstantValues.PREF_CATALOG_CACHE, 0);
    }

    public void setCMSPageName(String cmsPageName) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_CMS_HOME_NAME, cmsPageName);
        editor.apply();
    }

    public String getCMSPageName() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_CMS_HOME_NAME,
                ConstantValues.CMS_FOR_HOME);

    }

    public void setRegLandingPageName(String cmsPageName) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_CMS_HOME_NAME, cmsPageName);
        editor.apply();
    }

    public void saveUserName(String userName) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_USERNAME_KEY, userName);
        editor.apply();
    }

    public void saveCartID(String cartID) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_CART_ID, cartID);
        editor.apply();
    }

    public String getCartID() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_CART_ID, null);
    }

    /**
     * @param secureURL
     */
    public void setOmnitureSecureServer(String secureURL) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_OMNITURE_SECURE_SERVER, secureURL);
        editor.commit();
    }

    /**
     * @return
     */
    public String getOmnitureSecureServer() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_OMNITURE_SECURE_SERVER,
                ConstantValues.OMNITURE_CONFIGURATION_TRACKING_SERVER_SECURE);
    }

    /**
     * TODO Remove setOmnitureServer, getOmnitureServer, isFirstTimeLaunch &
     * setIsFirstTimeLaunch when app goes on production.
     *
     * @param URL
     */
    public void setOmnitureServer(String URL) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(ConstantValues.PREF_OMNITURE_SERVER, URL);
        editor.commit();
    }

    public String getOmnitureServer() {
        return getDefaultSharePreference().getString(ConstantValues.PREF_OMNITURE_SERVER,
                ConstantValues.OMNITURE_CONFIGURATION_TRACKING_SERVER);
    }

    public void saveString(String key, String value) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String getString(String key, String defaultValue) {
        return getDefaultSharePreference().getString(key, defaultValue);
    }

    public void deletePref(String key) {
        Editor editor = getDefaultSharePreference().edit();
        editor.remove(key);
        editor.commit();
    }

    public boolean isPresentInSharedPref(String key) {
        return getDefaultSharePreference().contains(key);
    }

    public void setCurrentTimeForUpgradeAlertInterval(long timeSeconds) {
        if (timeSeconds > 0) {
            Editor editor = getDefaultSharePreference().edit();
            editor.putLong(ConstantValues.CURRENT_TIME_ALERT_UPGRADE_INTERVAL, timeSeconds);
            editor.commit();
        }
    }

    public long getCurrentTimeForUpgradeAlertInterval() {
        return getDefaultSharePreference().getLong(ConstantValues.CURRENT_TIME_ALERT_UPGRADE_INTERVAL,
                -1);
    }

    public void setForseeSurveyFlag() {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.FORSEE_SURVEY_FLAG, true);
        editor.commit();
    }

    public boolean isForseeSurveyShown() {
        return getDefaultSharePreference().getBoolean(ConstantValues.FORSEE_SURVEY_FLAG, false);
    }

    public boolean isFirstVisualSearch() {
        return getDefaultSharePreference().getBoolean(ConstantValues.PREF_FIRST_VISUAL_SEARCH, true);
    }

    /* LnR Session and CreateOrGet User call */

    public void saveListOrRegistrySessionPref(String key,
            String value) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void saveCreaeOrGetUserForListOrRegistry(String key,
            String value) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putString(key, value);
        editor.commit();
    }

    public void clearSessionAndUserProfileFromListOrRegistry(String sessionKey,
            String userProfileKey) {
        Editor editor = getDefaultSharePreference().edit();
        if (sessionKey != null) {
            editor.remove(sessionKey);
        }
        if (userProfileKey != null) {
            editor.remove(userProfileKey);
        }
        editor.commit();

    }

    public String getListJsessionId() {
        return getDefaultSharePreference().getString(LnRConstantValues.JSESSION_KEY_PREF_KEY, null);

    }

    public String getCreateorGetUserForList() {
        return getDefaultSharePreference().getString(LnRConstantValues.CREATE_OR_GET_USER_PREF_KEY,
                null);

    }

    public String getRegistryJsessionId() {
        return getDefaultSharePreference().getString(LnRConstantValues.JSESSION_PREF_KEY_REGISTRY,
                null);
    }

    public String getCreateorGetUserForRegistry() {
        return getDefaultSharePreference().getString(LnRConstantValues.REGISTRY_CREATE_OR_GET_USER_PREF_KEY,
                null);

    }

    /* LnR Session and CreateOrGet User call End */

    public void setIsFirstVisualSearch(boolean isFirstVisualSearch) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.PREF_FIRST_VISUAL_SEARCH, isFirstVisualSearch);
        editor.apply();
    }

    public void setAppVersionFlag(Context context) {

        PackageInfo pInfo;
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            String version = pInfo.versionName;
            int versioncode = pInfo.versionCode;
            Editor editor = getDefaultSharePreference().edit();
            editor.putString(ConstantValues.APP_VERSION, version + "" + versioncode);
            editor.commit();

        } catch (NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String isAppVersionChanged() {
        return getDefaultSharePreference().getString(ConstantValues.APP_VERSION, "");
    }

    public void clearApptentiveAndForsee() {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.FORSEE_SURVEY_FLAG, false);
        editor.commit();

        KohlsApptentivePreference prefernce = new KohlsApptentivePreference(KohlsPhoneApplication.getContext());
        prefernce.setApptentivePreference(false);

    }

    public void setFlagForOmnitureListLanding(boolean isOmnitureCalled) {
        Editor editor = getDefaultSharePreference().edit();
        editor.putBoolean(ConstantValues.FLAG_OMNITURE_CALLED_FOR_LIST_LANDING, isOmnitureCalled);
        editor.commit();
    }

    public boolean getFlagForOmnitureListLanding(){
        return getDefaultSharePreference().getBoolean(ConstantValues.FLAG_OMNITURE_CALLED_FOR_LIST_LANDING, false);
    }

}
