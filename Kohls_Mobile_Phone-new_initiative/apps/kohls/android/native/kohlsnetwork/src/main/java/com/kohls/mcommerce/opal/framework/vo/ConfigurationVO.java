
package com.kohls.mcommerce.opal.framework.vo;

public class ConfigurationVO implements IValueObject {

    private static ConfigurationVO sInstance;

    public static ConfigurationVO getInstance() {
        if (sInstance == null)
            sInstance = new ConfigurationVO();
        return sInstance;
    }

    public String getResponseID() {
        return responseID;
    }

    public void setResponseID(String responseID) {
        this.responseID = responseID;
    }

    public boolean isSuccessful() {
        return isSuccessful;
    }

    public void setSuccessful(boolean isSuccessful) {
        this.isSuccessful = isSuccessful;
    }

    public PayLoad getPayload() {
        return payload;
    }

    public void setPayload(PayLoad payload) {
        this.payload = payload;
    }

    private String responseID;

    private boolean isSuccessful;

    private PayLoad payload;

    public class PayLoad {

        private Config config;

        public class Config {

            public String getConfigFileVersion() {
                return configFileVersion;
            }

            public void setConfigFileVersion(String configFileVersion) {
                this.configFileVersion = configFileVersion;
            }

            public String getHeaderApikey() {
                return headerApikey;
            }

            public void setHeaderApikey(String headerApikey) {
                this.headerApikey = headerApikey;
            }

            public String getLoggingMode() {
                return loggingMode;
            }

            public void setLoggingMode(String loggingMode) {
                this.loggingMode = loggingMode;
            }

            public String getStoreRadius() {
                return storeRadius;
            }

            public void setStoreRadius(String storeRadius) {
                this.storeRadius = storeRadius;
            }

            public String getDomainName() {
                return domainName;
            }

            public String getZipCode() {
                return zipCode;
            }

            public void setZipCode(String zipCode) {
                this.zipCode = zipCode;
            }

            public String getWeeklyAdURL() {
                return weeklyAdURL;
            }

            public void setWeeklyAdURL(String weeklyAdURL) {
                this.weeklyAdURL = weeklyAdURL;
            }

            public String getClient() {
                return client;
            }

            public void setClient(String client) {
                this.client = client;
            }

            public String getSecret() {
                return secret;
            }

            public void setSecret(String secret) {
                this.secret = secret;
            }

            public String getPercentAvailableSpaceUsed() {
                return PercentAvailableSpaceUsed;
            }

            public void setPercentAvailableSpaceUsed(String percentAvailableSpaceUsed) {
                PercentAvailableSpaceUsed = percentAvailableSpaceUsed;
            }

            public String getPDPTTLOverrideTime() {
                return PDPTTLOverrideTime;
            }

            public void setPDPTTLOverrideTime(String pDPTTLOverrideTime) {
                PDPTTLOverrideTime = pDPTTLOverrideTime;
            }

            public String getTypeaheadUrl() {
                return TypeaheadUrl;
            }

            public void setTypeaheadUrl(String typeaheadUrl) {
                TypeaheadUrl = typeaheadUrl;
            }

            public String getTodaysDealsUrl() {
                return TodaysDealsUrl;
            }

            public void setTodaysDealsUrl(String todaysDealsUrl) {
                TodaysDealsUrl = todaysDealsUrl;
            }

            public String getGIftCardCNNumber() {
                return GIftCardCNNumber;
            }

            public void setGIftCardCNNumber(String gIftCardCNNumber) {
                GIftCardCNNumber = gIftCardCNNumber;
            }

            public String getCreateLoyaltyProfile() {
                return CreateLoyaltyProfile;
            }

            public void setCreateLoyaltyProfile(String createLoyaltyProfile) {
                CreateLoyaltyProfile = createLoyaltyProfile;
            }

            public String getWalletandLoyaltyBaseURL() {
                return WalletandLoyaltyBaseURL;
            }

            public void setWalletandLoyaltyBaseURL(String walletandLoyaltyBaseURL) {
                WalletandLoyaltyBaseURL = walletandLoyaltyBaseURL;
            }

            public String getWalletVideoURL() {
                return WalletVideoURL;
            }

            public void setWalletVideoURL(String walletVideoURL) {
                WalletVideoURL = walletVideoURL;
            }

            public String getLoyaltyEnrollmentScanningUrl() {
                return LoyaltyEnrollmentScanningUrl;
            }

            public void setLoyaltyEnrollmentScanningUrl(String loyaltyEnrollmentScanningUrl) {
                LoyaltyEnrollmentScanningUrl = loyaltyEnrollmentScanningUrl;
            }

            public String getLoyaltySignupPoints() {
                return loyaltySignupPoints;
            }

            public void setLoyaltySignupPoints(String loyaltySignupPoints) {
                this.loyaltySignupPoints = loyaltySignupPoints;
            }

            public String getNetworktimeout() {
                return networktimeout;
            }

            public void setNetworktimeout(String networktimeout) {
                this.networktimeout = networktimeout;
            }

            public String getIdleTimeout() {
                return idleTimeout;
            }

            public void setIdleTimeout(String idleTimeout) {
                this.idleTimeout = idleTimeout;
            }

            public String getSigninTimeout() {
                return signinTimeout;
            }

            public void setSigninTimeout(String signinTimeout) {
                this.signinTimeout = signinTimeout;
            }

            public String getWalletTimeout() {
                return walletTimeout;
            }

            public void setWalletTimeout(String walletTimeout) {
                this.walletTimeout = walletTimeout;
            }

            public String getAddToListUrl() {
                return AddToListUrl;
            }

            public void setAddToListUrl(String addToListUrl) {
                AddToListUrl = addToListUrl;
            }

            public String getShowListItemsUrl() {
                return ShowListItemsUrl;
            }

            public void setShowListItemsUrl(String showListItemsUrl) {
                ShowListItemsUrl = showListItemsUrl;
            }

            public String getAddToRegistryUrl() {
                return AddToRegistryUrl;
            }

            public void setAddToRegistryUrl(String addToRegistryUrl) {
                AddToRegistryUrl = addToRegistryUrl;
            }

            public String getShowRegistryItemsUrl() {
                return ShowRegistryItemsUrl;
            }

            public void setShowRegistryItemsUrl(String showRegistryItemsUrl) {
                ShowRegistryItemsUrl = showRegistryItemsUrl;
            }

            public String getNewPaymentPreference() {
                return NewPaymentPreference;
            }

            public void setNewPaymentPreference(String newPaymentPreference) {
                NewPaymentPreference = newPaymentPreference;
            }

            public String getKohlsChargeSignInUrl() {
                return kohlsChargeSignInUrl;
            }

            public void setKohlsChargeSignInUrl(String kohlsChargeSignInUrl) {
                this.kohlsChargeSignInUrl = kohlsChargeSignInUrl;
            }

            public String getKohlsChargeApplyNowUrl() {
                return kohlsChargeApplyNowUrl;
            }

            public void setKohlsChargeApplyNowUrl(String kohlsChargeApplyNowUrl) {
                this.kohlsChargeApplyNowUrl = kohlsChargeApplyNowUrl;
            }

            public String getDefaultShippingMethod() {
                return defaultShippingMethod;
            }

            public void setDefaultShippingMethod(String defaultShippingMethod) {
                this.defaultShippingMethod = defaultShippingMethod;
            }

            public String getForceUpgradeDisplayMessage() {
                return forceUpgradeDisplayMessage;
            }

            public void setForceUpgradeDisplayMessage(String forceUpgradeDisplayMessage) {
                this.forceUpgradeDisplayMessage = forceUpgradeDisplayMessage;
            }

            public String getForceUpgradeTitle() {
                return forceUpgradeTitle;
            }

            public void setForceUpgradeTitle(String forceUpgradeTitle) {
                this.forceUpgradeTitle = forceUpgradeTitle;
            }

            public String getBazaarVoiceApiKey() {
                return bazaarVoiceApiKey;
            }

            public void setBazaarVoiceApiKey(String bazaarVoiceApiKey) {
                this.bazaarVoiceApiKey = bazaarVoiceApiKey;
            }

            public String getBazaarVoiceApiVersion() {
                return bazaarVoiceApiVersion;
            }

            public void setBazaarVoiceApiVersion(String bazaarVoiceApiVersion) {
                this.bazaarVoiceApiVersion = bazaarVoiceApiVersion;
            }

            public String getBazaarVoiceURL() {
                return bazaarVoiceURL;
            }

            public void setBazaarVoiceURL(String bazaarVoiceURL) {
                this.bazaarVoiceURL = bazaarVoiceURL;
            }

            public String getForseeFeedbackURL() {
                return forseeFeedbackURL;
            }

            public void setForseeFeedbackURL(String forseeFeedbackURL) {
                this.forseeFeedbackURL = forseeFeedbackURL;
            }

            public String getForsee_DefaultDaysSinceFirstLaunch() {
                return forsee_DefaultDaysSinceFirstLaunch;
            }

            public void
                    setForsee_DefaultDaysSinceFirstLaunch(String forsee_DefaultDaysSinceFirstLaunch) {
                this.forsee_DefaultDaysSinceFirstLaunch = forsee_DefaultDaysSinceFirstLaunch;
            }

            public String getForsee_DefaultLaunchCount() {
                return forsee_DefaultLaunchCount;
            }

            public void setForsee_DefaultLaunchCount(String forsee_DefaultLaunchCount) {
                this.forsee_DefaultLaunchCount = forsee_DefaultLaunchCount;
            }

            public String getForsee_DefaultRepeatDaysAfterComplete() {
                return forsee_DefaultRepeatDaysAfterComplete;
            }

            public void
                    setForsee_DefaultRepeatDaysAfterComplete(String forsee_DefaultRepeatDaysAfterComplete) {
                this.forsee_DefaultRepeatDaysAfterComplete = forsee_DefaultRepeatDaysAfterComplete;
            }

            public String getForsee_DefaultRepeatDaysAfterDecline() {
                return forsee_DefaultRepeatDaysAfterDecline;
            }

            public void
                    setForsee_DefaultRepeatDaysAfterDecline(String forsee_DefaultRepeatDaysAfterDecline) {
                this.forsee_DefaultRepeatDaysAfterDecline = forsee_DefaultRepeatDaysAfterDecline;
            }

            public String isForseeEnabled() {
                return isForseeEnabled;
            }

            public void setForseeEnabled(String isForseeEnabled) {
                this.isForseeEnabled = isForseeEnabled;
            }

            public String isDigbyURL() {
                return digbyURL;
            }

            public void setDigbyURL(String digbyURL) {
                this.digbyURL = digbyURL;
            }

            public String isDigbyEnabled() {
                return isDigbyEnabled;
            }

            public String isOmnitureEnabled() {
                return isOmnitureEnabled;
            }

            public void setOmnitureEnabled(String isOmnitureEnabled) {
                this.isOmnitureEnabled = isOmnitureEnabled;
            }

            public String getOmnitureURL() {
                return omnitureURL;
            }

            public void setOmnitureURL(String omnitureURL) {
                this.omnitureURL = omnitureURL;
            }

            public String getOmnitureAPIKey() {
                return omnitureAPIKey;
            }

            public void setOmnitureAPIKey(String omnitureAPIKey) {
                this.omnitureAPIKey = omnitureAPIKey;
            }

            public String getTIntSocialFeedUrl() {
                return TIntSocialFeedUrl;
            }

            public void setTIntSocialFeedUrl(String tIntSocialFeedUrl) {
                TIntSocialFeedUrl = tIntSocialFeedUrl;
            }

            public String getRedLaserURL() {
                return redLaserURL;
            }

            public void setRedLaserURL(String redLaserURL) {
                this.redLaserURL = redLaserURL;
            }

            public String getCrashlyticsURL() {
                return crashlyticsURL;
            }

            public void setCrashlyticsURL(String crashlyticsURL) {
                this.crashlyticsURL = crashlyticsURL;
            }

            public String getAppDisplayName() {
                return appDisplayName;
            }

            public void setAppDisplayName(String appDisplayName) {
                this.appDisplayName = appDisplayName;
            }

            /**
             * @return the alertUpgradeInterval
             */
            public String getAlertUpgradeInterval() {
                return alertUpgradeInterval;
            }

            /**
             * @param alertUpgradeInterval the alertUpgradeInterval to set
             */
            public void setAlertUpgradeInterval(String alertUpgradeInterval) {
                this.alertUpgradeInterval = alertUpgradeInterval;
            }

            public String getAppMode() {
                return appMode;
            }

            public void setAppMode(String appMode) {
                this.appMode = appMode;
            }

            public String getFacebookURL() {
                return facebookURL;
            }

            public void setFacebookURL(String facebookURL) {
                this.facebookURL = facebookURL;
            }

            public String getFacebook_page() {
                return facebook_page;
            }

            public void setFacebook_page(String facebook_page) {
                this.facebook_page = facebook_page;
            }

            public String getTwitterURL() {
                return twitterURL;
            }

            public void setTwitterURL(String twitterURL) {
                this.twitterURL = twitterURL;
            }

            public String getTwitter_page() {
                return twitter_page;
            }

            public void setTwitter_page(String twitter_page) {
                this.twitter_page = twitter_page;
            }

            public String getGoogleMapsURL() {
                return googleMapsURL;
            }

            public void setGoogleMapsURL(String googleMapsURL) {
                this.googleMapsURL = googleMapsURL;
            }

            public String isRegistryEnabled() {
                return isRegistryEnabled;
            }

            public void setRegistryEnabled(String isRegistryEnabled) {
                this.isRegistryEnabled = isRegistryEnabled;
            }

            public String getIsScanningEnabled() {
                return isScanningEnabled;
            }

            public void setIsScanningEnabled(String isScanningEnabled) {
                this.isScanningEnabled = isScanningEnabled;
            }

            public String getPMPCacheSessions() {
                return PMPCacheSessions;
            }

            public void setPMPCacheSessions(String pMPCacheSessions) {
                PMPCacheSessions = pMPCacheSessions;
            }

            public String getCacheSize() {
                return cacheSize;
            }

            public void setCacheSize(String cacheSize) {
                this.cacheSize = cacheSize;
            }

            public String getSignInRefreshInterval() {
                return signInRefreshInterval;
            }

            public void setSignInRefreshInterval(String signInRefreshInterval) {
                this.signInRefreshInterval = signInRefreshInterval;
            }

            public String getCmsURL() {
                return cmsURL;
            }

            public void setCmsURL(String cmsURL) {
                this.cmsURL = cmsURL;
            }

            public String getIsBugsense() {
                return isBugsense;
            }

            public void setIsBugsense(String isBugsense) {
                this.isBugsense = isBugsense;
            }

            public String getBugsenseAPIKeyIos() {
                return BugsenseAPIKeyIos;
            }

            public void setBugsenseAPIKeyIos(String bugsenseAPIKeyIos) {
                BugsenseAPIKeyIos = bugsenseAPIKeyIos;
            }

            public String getBugsenseAPIKeyHybrid() {
                return BugsenseAPIKeyHybrid;
            }

            public void setBugsenseAPIKeyHybrid(String bugsenseAPIKeyHybrid) {
                BugsenseAPIKeyHybrid = bugsenseAPIKeyHybrid;
            }

            public String getBugsenseAPIKeyAndroid() {
                return BugsenseAPIKeyAndroid;
            }

            public void setBugsenseAPIKeyAndroid(String bugsenseAPIKeyAndroid) {
                BugsenseAPIKeyAndroid = bugsenseAPIKeyAndroid;
            }

            public String getLoyaltyReward() {
                return loyaltyReward;
            }

            public void setLoyaltyReward(String loyaltyReward) {
                this.loyaltyReward = loyaltyReward;
            }

            public String getCustomerServiceUrl() {
                return customerServiceUrl;
            }

            public void setCustomerServiceUrl(String customerServiceUrl) {
                this.customerServiceUrl = customerServiceUrl;
            }

            public String getGeoCodeUrl() {
                return geoCodeUrl;
            }

            public void setGeoCodeUrl(String geoCodeUrl) {
                this.geoCodeUrl = geoCodeUrl;
            }

            public String getNextKohlsCashEarning() {
                return nextKohlsCashEarning;
            }

            public void setNextKohlsCashEarning(String nextKohlsCashEarning) {
                this.nextKohlsCashEarning = nextKohlsCashEarning;
            }

            public String getListUrl() {
                return listAndroidUrl;
            }

            public void setListUrl(String listUrl) {
                this.listAndroidUrl = listUrl;
            }

            public String getRegistryUrl() {
                return registryUrl;
            }

            public void setRegistryUrl(String registryUrl) {
                this.registryUrl = registryUrl;
            }

            public String getRegistryTypeSearch() {
                return registryTypeSearch;
            }

            public void setRegistryTypeSearch(String registryTypeSearch) {
                this.registryTypeSearch = registryTypeSearch;
            }

            public String getLoyaltyProfileAppend() {
                return loyaltyProfileAppend;
            }

            public void setLoyaltyProfileAppend(String loyaltyProfileAppend) {
                this.loyaltyProfileAppend = loyaltyProfileAppend;
            }

            public String getIsBeaconsEnabled() {
                return isBeaconsEnabled;
            }

            public void setIsBeaconsEnabled(String isBeaconsEnabled) {
                this.isBeaconsEnabled = isBeaconsEnabled;
            }

            public String getWalletVideoVersion() {
                return walletVideoVersion;
            }

            public void setWalletVideoVersion(String walletvideoVersion) {
                this.walletVideoVersion = walletvideoVersion;
            }

            public String getSpecificOfferListOn() {
                return specificOfferListOn;
            }

            public void setSpecificOfferListOn(String specificOfferListOn) {
                this.specificOfferListOn = specificOfferListOn;
            }

            public String getSpecificOfferListName() {
                return specificOfferListName;
            }

            public void setSpecificOfferListName(String specificOfferListName) {
                this.specificOfferListName = specificOfferListName;
            }

            public String getSpecificOfferListUrl() {
                return specificOfferListUrl;
            }

            public void setSpecificOfferListUrl(String specificOfferListUrl) {
                this.specificOfferListUrl = specificOfferListUrl;
            }

            public String getSpecificOfferButtonDisplayName() {
                return specificOfferButtonDisplayName;
            }

            public String getWalletPriceURL() {
                return walletPriceURL;
            }

            public void setWalletPriceURL(String walletPriceURL) {
                this.walletPriceURL = walletPriceURL;
            }

            public void setSpecificOfferButtonDisplayName(String specificOfferButtonDisplayName) {
                this.specificOfferButtonDisplayName = specificOfferButtonDisplayName;
            }

            public String getSpecificOfferButtonColor() {
                return specificOfferButtonColor;
            }

            public void setSpecificOfferButtonColor(String specificOfferButtonColor) {
                this.specificOfferButtonColor = specificOfferButtonColor;
            }

            public String getSpecificOfferPDPUpcomingSaleColorr() {
                return specificOfferPDPUpcomingSaleColor;
            }

            public void
                    setSpecificOfferPDPUpcomingSaleColor(String specificOfferPDPUpcomingSaleColor) {
                this.specificOfferPDPUpcomingSaleColor = specificOfferPDPUpcomingSaleColor;
            }

            public String getSpecificOfferPDPUpcomingPriceColorr() {
                return specificOfferPDPUpcomingPriceColor;
            }

            public void
                    setSpecificOfferPDPUpcomingPriceeColor(String specificOfferPDPUpcomingPriceColor) {
                this.specificOfferPDPUpcomingPriceColor = specificOfferPDPUpcomingPriceColor;
            }

            public String getSpecificOfferPDPPriceDisplayName() {
                return specificOfferPDPPriceDisplayName;
            }

            public void
                    setSpecificOfferPDPPriceDisplayName(String specificOfferPDPPriceDisplayName) {
                this.specificOfferPDPPriceDisplayName = specificOfferPDPPriceDisplayName;
            }

            public String getGooglePlayLink() {
                return googlePlayLink;
            }

            public void setGooglePlayLink(String googlePlayLink) {
                this.googlePlayLink = googlePlayLink;
            }

            public String getAppAndroidVersion() {
                return appAndroidVersion;
            }

            public void setAppAndroidVersion(String appAndroidVersion) {
                this.appAndroidVersion = appAndroidVersion;
            }

            public String getAppIOSVersion() {
                return appIOSVersion;
            }

            public void setAppIOSVersion(String appIOSVersion) {
                this.appIOSVersion = appIOSVersion;
            }

            public String getForceAndroidUpgrade() {
                return forceAndroidUpgrade;
            }

            public void setForceAndroidUpgrade(String forceAndroidUpgrade) {
                this.forceAndroidUpgrade = forceAndroidUpgrade;
            }

            public String getForceAndroidUpgradeReferenceUrl() {
                return forceAndroidUpgradeReferenceUrl;
            }

            public void setForceAndroidUpgradeReferenceUrl(String forceAndroidUpgradeReferenceUrl) {
                this.forceAndroidUpgradeReferenceUrl = forceAndroidUpgradeReferenceUrl;
            }

            public String getKrj() {
                return krj;
            }

            public void setKrj(String krj) {
                this.krj = krj;
            }

            public String getSpecificOfferPDPDisplayTextColor() {
                return specificOfferPDPDisplayTextColor;
            }

            public void
                    setSpecificOfferPDPDisplayTextColor(String specificOfferPDPDisplayTextColor) {
                this.specificOfferPDPDisplayTextColor = specificOfferPDPDisplayTextColor;
            }

            public String getSpecificOfferPMPDisplayTextColor() {
                return specificOfferPMPDisplayTextColor;
            }

            public void
                    setSpecificOfferPMPDisplayTextColor(String specificOfferPMPDisplayTextColor) {
                this.specificOfferPMPDisplayTextColor = specificOfferPMPDisplayTextColor;
            }

            public String getSpecificOfferPriceCode() {
                return specificOfferPriceCode;
            }

            public void setSpecificOfferPriceCode(String specificOfferPriceCode) {
                this.specificOfferPriceCode = specificOfferPriceCode;
            }

            public String getSpecificOfferPMPBackgroundColor() {
                return specificOfferPMPBackgroundColor;
            }

            public void setSpecificOfferPMPBackgroundColor(String specificOfferPMPBackgroundColor) {
                this.specificOfferPMPBackgroundColor = specificOfferPMPBackgroundColor;
            }

            public String getSpecificOfferPMPPriceColor() {
                return specificOfferPMPPriceColor;
            }

            public void setSpecificOfferPMPPriceColor(String specificOfferPMPPriceColor) {
                this.specificOfferPMPPriceColor = specificOfferPMPPriceColor;
            }

            public String getCustomerCarePhone() {
                return CustomerCarePhone;
            }

            public void setCustomerCarePhone(String customerCarePhone) {
                CustomerCarePhone = customerCarePhone;
            }

            public String getServerLog() {
                return serverLog;
            }

            public void setServerLog(String serverLog) {
                this.serverLog = serverLog;
            }

            public String getVoiceIsActive() {
                return voiceIsActive;
            }

            public String getVisualSearchMajorPoll() {
                return visualSearchMajorPoll;
            }

            public String getOmnibagswitch() {
                return FeatureOCBEnabled;
            }

            public String getVisualSearchMinorPoll() {
                return visualSearchMinorPoll;
            }

            public String getVisualSearchIsActive() {
                return visualSearchIsActive;
            }

            public String getVisualSearchMaxTimeAllowedForSearch() {
                return VisualSearchMaxTimeAllowedForSearch;
            }

            public String getIsPartialResponseAllowed() {
                return isPartialResponseAllowed;
            }
            public String getLnrItemImageURL() {
                return lnrItemImageURL;
            }

            public void setLnrItemImageURL(String lnrItemImageURL) {
                this.lnrItemImageURL = lnrItemImageURL;
            }

            private String alertUpgradeInterval;

            private String appAndroidVersion;

            private String appIOSVersion;

            private String configFileVersion;

            private String headerApikey;

            private String loggingMode;

            private String storeRadius;

            private String zipCode;

            private String domainName;

            private String weeklyAdURL;

            private String client;

            private String secret;

            private String krj;

            private String PercentAvailableSpaceUsed;

            private String PDPTTLOverrideTime;

            private String isBugsense;

            private String TypeaheadUrl;

            private String TodaysDealsUrl;

            private String GIftCardCNNumber;

            private String CreateLoyaltyProfile;

            private String WalletandLoyaltyBaseURL;

            private String WalletVideoURL;

            private String LoyaltyEnrollmentScanningUrl;

            private String loyaltySignupPoints;

            private String networktimeout;

            private String idleTimeout;

            private String signinTimeout;

            private String walletTimeout;

            private String AddToListUrl;

            private String ShowListItemsUrl;

            private String AddToRegistryUrl;

            private String ShowRegistryItemsUrl;

            private String NewPaymentPreference;

            private String kohlsChargeSignInUrl;

            private String kohlsChargeApplyNowUrl;

            private String defaultShippingMethod;

            private String forceAndroidUpgrade;

            private String forceUpgradeDisplayMessage;

            private String forceUpgradeTitle;

            private String forceAndroidUpgradeReferenceUrl;

            private String bazaarVoiceApiKey;

            private String redirectErrorURL;

            private String bazaarVoiceApiVersion;

            private String bazaarVoiceURL;

            private String forseeFeedbackURL;

            private String forsee_DefaultDaysSinceFirstLaunch;

            private String forsee_DefaultLaunchCount;

            private String forsee_DefaultRepeatDaysAfterComplete;

            private String forsee_DefaultRepeatDaysAfterDecline;

            private String isForseeEnabled;

            private String digbyURL;

            private String isOmnitureEnabled;

            private String isDigbyEnabled;

            private String omnitureURL;

            private String omnitureAPIKey;

            private String TIntSocialFeedUrl;

            private String redLaserURL;

            private String crashlyticsURL;

            private String appDisplayName;

            private String appMode;

            private String facebookURL;

            private String facebook_page;

            private String twitterURL;

            private String twitter_page;

            private String googleMapsURL;

            private String isRegistryEnabled;

            private String isScanningEnabled;

            private String PMPCacheSessions;

            private String cacheSize;

            private String signInRefreshInterval;

            private String cmsURL;

            private String BugsenseAPIKeyIos;

            private String BugsenseAPIKeyHybrid;

            private String BugsenseAPIKeyAndroid;

            private String loyaltyReward;

            private String customerServiceUrl;

            private String geoCodeUrl;

            private String nextKohlsCashEarning;

            private String listAndroidUrl;

            private String registryUrl;

            private String registryTypeSearch;

            private String loyaltyProfileAppend;

            private String specificOfferListOn;

            private String specificOfferListName;

            private String specificOfferListUrl;

            private String specificOfferButtonDisplayName;

            private String specificOfferButtonColor;

            private String specificOfferPDPUpcomingSaleColor;

            private String specificOfferPDPUpcomingPriceColor;

            private String specificOfferPDPPriceDisplayName;

            private String specificOfferPDPDisplayTextColor;

            private String specificOfferPMPBackgroundColor;

            private String specificOfferPMPDisplayTextColor;

            private String specificOfferPMPPriceColor;

            private String specificOfferPriceCode;

            private String isBeaconsEnabled;

            private String walletVideoVersion;

            private String googlePlayLink;

            private String walletPriceURL;

            private String CustomerCarePhone;

            private String serverLog;

            private String FeatureOCBEnabled;

            private String voiceIsActive;

            private String visualSearchMajorPoll;

            private String visualSearchMinorPoll;

            private String visualSearchIsActive;

            private String VisualSearchMaxTimeAllowedForSearch;

            private String isPartialResponseAllowed;

            private String FeatureBOPUSEnabled;

            private String restrictedAPIErrors;

            public String isFeatureBOPUSEnabled() {
                return FeatureBOPUSEnabled;
            }

            public void setFeatureBOPUSEnabled(String featureBOPUSEnabled) {
                FeatureBOPUSEnabled = featureBOPUSEnabled;
            }

            public String getRestrictedAPIErrors() {
                return restrictedAPIErrors;
            }

            public void setRestrictedAPIErrors(String restrictedAPIErrors) {
                this.restrictedAPIErrors = restrictedAPIErrors;
            }

            public String getBaseUrlList() {
                return baseUrlList;
            }

            public void setBaseUrlList(String baseUrlList) {
                this.baseUrlList = baseUrlList;
            }

            public String getBaseUrlRegistry() {
                return baseUrlRegistry;
            }

            public void setBaseUrlRegistry(String baseUrlRegistry) {
                this.baseUrlRegistry = baseUrlRegistry;
            }

            public String getRegistryShareURL() {
                return RegistryShareURL;
            }

            public void setRegistryShareURL(String registryShareURL) {
                RegistryShareURL = registryShareURL;
            }

            public String getListShareURL() {
                return ListShareURL;
            }

            public void setListShareURL(String listShareURL) {
                ListShareURL = listShareURL;
            }

            private String baseUrlList;

            private String baseUrlRegistry;

            private String RegistryShareURL;

            private String ListShareURL;

            private String lnrItemImageURL;

            private String KillSwitchFlagReferFriend; // To enable/disable invite a friend feature.
            private String KillSwitchWithRewards;
            private String KillSwitchFlagSocial; // To enable/disable social follow
            private String KillSwitchFlagFacebook;
            private String KillSwitchFlagTwitter;
            private String KillSwitchFlagYouTube;
            private String KillSwitchFlagGooglePlus;
            private String KillSwitchFlagInstagram;
            private String KillSwitchFlagPinterest;

            private String LoyaltyFriendInviteRewardAmt;

            public String getLoyaltyFriendInviteRewardAmt(){
                return this.LoyaltyFriendInviteRewardAmt;
            }

            public String getKillSwitchFlagReferFriend(){
                return this.KillSwitchFlagReferFriend;
            }

            public String getKillSwitchWithRewards(){
                return this.KillSwitchWithRewards;
            }

            public String getKillSwitchFlagSocial(){
                return this.KillSwitchFlagSocial;
            }

            public String getKillSwitchFlagFacebook() {
                return KillSwitchFlagFacebook;
            }

            public String getKillSwitchFlagTwitter() {
                return KillSwitchFlagTwitter;
            }

            public String getKillSwitchFlagYouTube() {
                return KillSwitchFlagYouTube;
            }

            public String getKillSwitchFlagGooglePlus() {
                return KillSwitchFlagGooglePlus;
            }

            public String getKillSwitchFlagInstagram() {
                return KillSwitchFlagInstagram;
            }

            public String getKillSwitchFlagPinterest() {
                return KillSwitchFlagPinterest;
            }

        }

        public Config getConfig() {
            return config;
        }

        public void setConfig(Config config) {
            this.config = config;
        }
    }
}
