
package com.kohls.mcommerce.opal.common.value;

public interface ConstantValues {

    // https://card.io/apps/new/
    String CARDIO_APP_TOKEN = "adb0f9f39c1e4d059ee7df30c2bbd05a";

    String REQUESTID_PREFERENCE_KEY = "requestID";

    String APP_PLATFORM = "android";

    String SCREEN_TO_LOAD_KEY = "screenToLoad";

    String SCREEN_ORDER_STATUS_ORDER_ID = "orderId";

    String SCREEN_ORDER_STATUS_POSTAL_CODE = "postalCode";

    String CHECKOUT_AS_GUEST = "CHECKOUT_AS_GUEST";

    String CANCEL = "CANCEL";

    String URL = "http://qe13-openapi.kohlsecommerce.com/v1";

    String EXTRA_KEY_REGISTRY_ID = "key_registry_id";

    // used in the loyalty point user registration to generate md5 digest
    public static final String SALT_VALUE = "MFalls";

    public static final String PROFILE_TOKEN = "sdfsd";

    public static final String PIPE = " | ";

    public static final String COLON = ":";

    public static final String SEMI_COLON = ";";

    // cms constants

    public static final String CAMPAIGN_NAME_MISC_CAMPAIGN = "miscCampaign";

    public static final String PAGE_NAME_LOYALTY_HELP = "loyaltyhelp";

    public static final String PAGE_NAME_HELP_CONTACT_US = "helpcontactus";

    public static final String KOHLS_URL = "kohls.com";

    public static final String SKU_CODE = "skuCode";

    public static final String P_CODE = "pCode";

    public static final String ID = "id";

    public static final String BACK_TITLE = "backTitle";

    public static final String JSON_TYPE_TYPE = "type";

    public static final String JSON_TYPE_SUBTYPES = "subtypes";

    public static final String JSON_TYPE_HEADER = "header";

    public static final String JSON_TYPE_TITLE = "title";

    public static final String JSON_TYPE_TITLE_INFO = "titleInfo";

    public static final String JSON_TYPE_EDIT_PAGE = "isEditPage";

    public static final String JSON_TYPE_TITLE_ENCODED = "titleEncoded";

    public static final String JSON_TYPE_DIALOG_MESSAGE = "message";

    public static final String JSON_TYPE_NEG_BUTTON_TITLE = "cancelButtonTitle";

    public static final String JSON_TYPE_POS_BUTTON_TITLE = "otherButtonTitle";

    public static final String JSON_TYPE_NEG_BUTTON_CALLBACK = "otherbuttonjscallback";

    public static final String JSON_TYPE_PARAMS = "params";

    public static final String JSON_TYPE_UI = "ui";

    public static final String JSON_TYPE_MASTER = "master";

    public static final String JSON_TYPE_VIEW = "view";

    public static final String JSON_TYPE_MODEL_VIEW = "modal view";

    public static final String JSON_TYPE_EXT_BROWSER = "external_browser";

    public static final String JSON_TYPE_FULL_SCREEN_MODEL = "fullscreenmodal";

    public static final String JSON_TYPE_SELECTOR = "selector";

    public static final String JSON_TYPE_SIGNIN = "tapSignInButton";

    public static final String JSON_TYPE_SEARCHBAR = "SearchBar";

    public static final String JSON_TYPE_ACTIONSHEET = "actionsheet";

    public static final String JSON_TYPE_TWITTER = "text share via twitter";

    public static final String JSON_TYPE_FACEBOOK = "text share via facebook";

    public static final String JSON_TYPE_MESSAGE = "text share via message";

    public static final String JSON_TYPE_EMAIL = "text share via email";

    public static final String JSON_TYPE_SAVESEARCHTEXT = "saveSearchText";

    public static final String JSON_TYPE_SEARCHTEXT = "search.html";

    public static final String JSON_TYPE_INDEX = "indexiphone.html";

    public static final String JSON_TYPE_CLEAR_RECENT = "clearRecentSearch";

    public static final String JSON_TYPE_DEVICEINFO = "getDeviceInfo";

    public static final String JSON_TYPE_BUTTONS = "buttons";

    public static final String JSON_TYPE_BUTTON_LEFT = "left";

    public static final String JSON_TYPE_BUTTON_RIGHT = "right";

    public static final String JSON_TYPE_MORE = "More";

    public static final String JS_CALLBACK = "jscallback";

    public static final String JSON_TYPE_DIALOG_PARAMS = "displayAlertWithParams";

    public static final String JSON_TYPE_ALERT_DIALOG = "Alert Dialog";

    public static final String JS_CALLBACK_ACTION_SHEET_PARAMS = "ActionSheetParams()";

    public static final String JS_CALLBACK_BACK_TO_SEARCH = "backToSearchPage()";

    public static final String JS_CALLBACK_NAV_BACK_TO_SEARCH = "navigateBackToSearch()";

    public static final String KOHLS_HELPL_LINE_NUMBER = "(855)564-5705";

    // Content type
    public static final String CONTENT_TYPE = "application/json";

    public static final String ERROR_CODE_EMAIL_ALREADY_EXIST = "PROF9163";

    public static final String ERRORCODE_401_TEMP = "access_token_expired";

    // Open api key of the application.
    String API_KEY = "CX75gy2Whe4kmsAAAzhrd7GKALDXaO5B";

    // Authentication grant type.
    String GRANT_TYPE_PASSWORD = "password";

    // Refresh token grant type
    String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";

    String ACCEPT_JSON = "application/json";

    String ACCEPT_XML = "application/xml";

    String HEADER_API_KEY = "X-APP-API_KEY";

    String HEADER_ACCEPT = "Accept";

    String URL_CATALOG = "/catalog?channel=D";

    String URL_CATEGORY = "/catalog/category?channel=D";

    String URL_CATEGORY_BY_ID = "/catalog/category/{categoryID}?channel=D";

    String URL_PMP = "/catalog/{dimid}?offset={offset}&sortID={sortid}&limit={limit}";

    String URL_PDP = "/product/{webID}?skuDetail=true";

    String URL_PRODUCT = "/product";

    String HEADER_CHANNEL = "?channel=D";

    String VALUE_MOBILE = "mobile";

    String CURRENT_LATITUDE = "latitude";

    String CURRENT_LONGITUDE = "longitude";

    // this will be picked from Configuration, and this value stands for the
    // time when access token will be refreshed before its expires
    public static int APP_ACCESS_TOKEN_EXPIRY = 1800; // 30 *60 seconds

    String URL_STORE_LOCATOR = "/stores";

    String URL_INVENTORY_SKU = "/inventory/sku";

    double DEBUG_LATITUDE = 43.120094;

    double DEBUG_LONGITUDE = -88.123104;

    boolean APP_DEBUG = true;

    String CAMPAIGN_ID = "0ece169b898b0e4a";

    Double STORE_DEFAULT_US_LATITUDE = 40.0000;

    Double STORE_DEFAULT_US_LONGITUDE = -100.0000;

    Float STORE_DEFAULT_US_ZOOM = 4.0f;

    /**
     * Product matrix page constants.
     */
    int PMP_PRODUCTS_DEFAULT_LIMIT = 12;

    int PMP_PRODUCTS_DEFAULT_OFFSET = 1;

    int PMP_PRODUCTS_DEFAULT_SORTID = 3;

    /** Image Caching constants **/
    // Msg to notify activity that image has been loaded from disk cache.
    int MSG_IMG_LOADED_FROM_DISK = 1;

    // Msg to notify activity that image is not present in disk cache.
    int MSG_IMG_NOT_PPRESENT_IN_CACHE = 2;

    // Bundle constant for notifying UI thread with image key.
    String BUNDLE_IMAGE_KEY = "image_key";

    /*
     * Dialog Constants Reserved from 4000-4099
     */
    String DIALOG_ID = "dialogId";

    String SUB_DIALOG_ID = "subDialogId";

    int SUB_DIALOG_ID_DEFAULT = 4000;

    int ALERT_DIALOG_DEFAULT = SUB_DIALOG_ID_DEFAULT + 1;

    int PROGRESS_DIALOG_DEFAULT = ALERT_DIALOG_DEFAULT + 1;

    int LOCATION_SETTINGS_SUB_DIALOG_ID = PROGRESS_DIALOG_DEFAULT + 1;

    int FETCHING_LOCATION_SUB_DIALOG_ID = LOCATION_SETTINGS_SUB_DIALOG_ID + 1;

    int FETCHING_STORES_SUB_DIALOG_ID = FETCHING_LOCATION_SUB_DIALOG_ID + 1;

    int CANCEL_CLICKED = FETCHING_STORES_SUB_DIALOG_ID + 1;

    int POSITIVE_BUTTON_CLICKED = CANCEL_CLICKED + 1;

    int NEGATIVE_BUTTON_CLICKED = POSITIVE_BUTTON_CLICKED + 1;

    int NEUTRAL_BUTTON_CLICKED = NEGATIVE_BUTTON_CLICKED + 1;

    int PRODUCT_IMAGE_DIALOG = NEUTRAL_BUTTON_CLICKED + 1;

    int PRODUCT_IMAGE_LOAD = PRODUCT_IMAGE_DIALOG + 1;

    int ADDING_ITEM_TO_LIST = PRODUCT_IMAGE_LOAD + 1;

    int ADDING_ITEM_TO_REGISTRY = ADDING_ITEM_TO_LIST + 1;

    /*
     * Preferences Constants
     */

    String APP_PREFERENCE = "KohlsPreference";

    String USER_LOC_PREF = "LastUserLoc";

    String USER_STORE_PREF = "MyStore";

    String DIALOG_TITLE = "title";

    String DIALOG_MESSAGE = "message";

    String DIALOG_POSITIVE_BUTTON_TEXT = "positiveBtnText";

    String DIALOG_NEGATIVE_BUTTON_TEXT = "negativeBtnText";

    String DIALOG_NEUTRAL_BUTTON_TEXT = "neutralBtnText";

    String DIALOG_DRAWABLE_ID = "drawableID";

    String DIALOG_EXTRA = "extra";

    String IS_CUSTOM_DIALOG_VIEW = "isCustomView";

    String IS_DIALOG_CANCELLABLE = "isCancellable";

    String IS_DIALOG_INDETERMINATE = "isIndeterminate";

    String IS_DIALOG_CANCEL_ON_OUTSIDE_TOUCH = "isOutsideCancellable";

    String RESULTANT_RECEIVER = "resultReceiver";

    String ADD_DUMMY_CATEGORIES = "AddDummyCategory";

    String CURRENT_CATEGORY_PAGE = "1";

    String USER_STORE_INFO = "userstore";

    String USER_LAST_LOCATION = "userlocation";

    String ANALYTICS_PREFERENCE_OBJECT = "analyticsPrefObject";

    /*
     * Adapter Procedures Constants
     */

    String ADAPTER_CATEGORY = "CategoryAdapter";

    String ADAPTER_STORE_LOCATOR = "StoreLocatorAdapter";

    /*
     * Layout Constants
     */

    int CATEGORY_IMAGE_HEIGHT = 240;

    int CATEGORY_IMAGE_WIDTH = 278;

    /** Fragment Constants **/

    String FRAGMENT_CATEGORY_NAME = "item_name";

    String FRAGMENT_SUBCATEGORY_NAME = "item_subcategory_name";

    String CATEGORY_ITEM_TYPE_CATEGORY = "category";

    String CATEGORY_ITEM_TYPE_CATALOG = "catalog";

    /** Toast constants **/
    String SHOW_TOAST = "show_toast";

    /** Google service error dialog constants **/
    // Unique tag for the google service error dialog fragment.
    String GOOGLE_SERVICE_DIALOG_ERROR = "dialog_error";

    // Google service connection failure resolve request error key.
    String RESOLUTION_REQUEST_ERROR_KEY = "resolution_request_error";

    /**
     * Bundle constants.
     */
    // Category id extra key.
    String EXTRA_KEY_IS_FROM_CATEGORY = "key_is_from_category";

    String EXTRA_KEY_CATEGORY = "key_category";

    String EXTRA_KEY_CATEGORY_ID = "key_category_id";

    String EXTRA_KEY_PARRENT_CATEGORY = "key_parrent_category";

    // Web id extra key.
    String EXTRA_KEY_WEB_ID = "key_category_id";

    String EXTRA_KEY_SKU_CODE = "key_sku_code";

    String EXTRA_KEY_UPC_CODE = "key_upc_code";

    String EXTRA_KEY_IS_FROM_PDP = "key_is_from_pdp";

    String EXTRA_KEY_TITLE_AND_SUBTITLE = "key_title_and_subtitle";

    String EXTRA_KEY_COLLECTIONS_PRODUCT_WEB_ID = "key_collection_product_id";

    // Product Detail Page
    String EXTRA_KEY_PAGE_TITLE = "key_page_title";

    String EXTRA_KEY_LONG_DESCRIPTION = "key_long_description";

    String EXTRA_KEY_SHORT_DESCRIPTION = "key_short_description";

    String EXTRA_KEY_OVERALL_RATING = "key_overall_rating";

    String EXTRA_KEY_RATING_COUNT = "key_rating_count";

    String EXTRA_KEY_PRODUCTS = "products";

    int PDP_PRODUCTS_RATING_DEFAULT_LIMIT = 6;

    String MORE_TO_CONSIDER_SIZE = "4";

    String MORE_TO_CONSIDER_TYPE = "similar";

    String MORE_TO_CONSIDER_TYPE_SIGNIN = "customer";

    String MORE_TO_CONSIDER_TYPE_GUEST = "toptrending";

    String EXTRA_KEY_IS_EDIT_SHOPPING_BAG = "key_is_edit_shopping_bag";

    String EXTRA_KEY_IS_EDIT_SHOPPING_BAG_IS_BOTTOM_FOCUS = "key_is_edit_shopping_bag_isbottomfocus";

    // Constant for passing Cart item id from Hybrid to Native DB for GWP
    // removal.
    String EXTRA_KEY_CART_ITEM_ID = "key_cart_item_id";

    String EXTRA_KEY_IS_FOR_PWP_SCREEN = "key_is_for_pwp_screen";

    String EXTRA_KEY_PMP_FILTER_DATA = "pmp_filter_data";

    String EXTRA_KEY_PMP_IN_LISTVIEW = "key_is_pmp_in_listview";

    String EXTRA_KEY_REGISTRY_OBJECT = "key_registry_id";

    String EXTRA_KEY_ON_WRITE_REVIEW_SUCCESS = "On_Write_review_success";

    String EXTRA_KEY_OFFER_GROUP_TYPE = "key_offer_type";

    String EXTRA_KEY_OFFER_ID = "key_offer_id";

    String PDP_OFFER_TYPE_PWP = "PWP";

    String PDP_OFFER_TYPE_GWP = "GWP";

    String PDP_OFFER_ITEM_TYPE_BUY = "BUY";

    String PDP_OFFER_ITEM_TYPE_GET = "GET";

    String PDP_OFFER_MESSAGE_OFFER_TITLE_GET = "OfferTitleGet";

    String PDP_OFFER_MESSAGE_OFFER_TITLE = "OfferTitle";

    String PDP_OFFER_MESSAGE_OFFER_MESSAGE = "OfferMessage";

    String PDP_OFFER_MESSAGE_TERMS = "Terms";

    String PDP_OFFER_MESSAGE_OFFER_CONFIGURED_FINAL = "OfferConfiguredFinal";

    String PDP_OFFER_MESSAGE_OFFER_CONFIGURED_SINGULAR = "OfferConfiguredSingular";

    String PDP_OFFER_MESSAGE_OFFER_CONFIGURED = "OfferConfigured";

    String PDP_OFFER_YOUR_PRICE = "OfferPrice";

    String EXTRA_KEY_PDP_GET_PRODUCT_PRICE = "pdp_get_product_your_price";

    String EXTRA_KEY_PDP_BUY_PRODUCT_WEBID = "pdp_buy_product_web_id";

    /**
     * Shopping bag
     */

    String EXTRA_KEY_EDIT_SOPPING_BAG_QUANTITY = "key_edit_shopping_bag_qyt";

    String EXTRA_KEY_EDIT_SOPPING_BAG_SKU = "key_edit_shopping_bag_sku";

    String EXTRA_KEY_EDIT_SOPPING_BAG_SKU_STORENUM = "key_edit_shopping_bag_sku_storenum";

    String EXTRA_KEY_EDIT_SOPPING_BAG_REGISRTY_ID = "key_edit_shopping_bag_registry_id";

    String EXTRA_KEY_EDIT_SOPPING_BAG_ITEM_INDX = "key_edit_shopping_bag_itemIndexs";

    /**
     * Shopping bag
     */
    String SHOPPING_BAG_SUBTOTAL = "shopping_bag_subtotal";

    String SHOPPING_BAG_COUNT = "shopping_bag_count";

    /**
     * Share Constants
     */
    String SHARE_DIALOG_TAG = "share_dialog";

    String SHARE_VIA = "share_via";

    int SHARE_FACEBOOK = 7001;

    int SHARE_TWITTER = 7002;

    int FOLLOW_PINTEREST = 7003;

    int FOLLOW_INSTAGRAM = 7004;

    int LIKE_FACEBOOK = 7005;

    int FOLLOW_TWITTER = 7006;

    String TWITTER_API_KEY = "v1MbjtSP51voQOAu394Cw";

    String TWITTER_API_SECRET = "ciSPNHWogW6fhhy3KY5T3S1hgGdHcQ73YnoIxJsgo8";

    String TWITTER_CALLBACK_URL = "http://www.kohls.com";

    String PRODUCT_LINK = "product_link";

    String PRODUCT_TITLE = "product_title";

    String PRODUCT_DESC = "product_desc";

    String PRODUCT_IMAGE_LINK = "product_image_link";

    String TWITTER_OAUTH_KEY_SECRET = "oauth_token_secret";

    String TWITTER_OAUTH_KEY_TOKEN = "oauth_token";

    String TWITTER_IS_USER_AUTHORIZED = "twitter_is_user_authorized";

    String EMAIL_SUBJECT = "Checkout this Product";

    String SHARE_IS_FROM_LNR = "share_is_from_lnr";

    /*
     * Configuration changes
     */

    String APP_CONFIG = "kohlsAppConfig";

    /*
     * Forsee debug changes
     */
    String APP_FORSEE_CONFIG = "kohlsForseeConfig";

    // Sign in extra keys.
    String EXTRA_KEY_USER_ID = "key_user_id";

    String EXTRA_KEY_PASSWORD = "key_password";

    String EXTRA_IS_FROM_CHECKOUT_SCREEN = "isFromCheckoutScreen";

    String EXTRA_IS_FROM_MY_INFO = "isFromMyInfo";

    String EXTRA_IS_FROM_SECURE_PAGE = "isFromSecurePage";

    /**
     * Preference keys.
     */
    String PREF_ACCESS_TOKEN_KEY = "access_token";

    String PREF_REFRESH_TOKEN_KEY = "refresh_token";

    String PREF_USERNAME_KEY = "user_name";

    String PREF_USER_LOYALTY_ID = "user_loyalty_id";

    String PREF_USERNAME_ID = "user_id";

    String PREF_EMAIL_KEY = "email_address";

    String PREF_LOYALTY_ID = "loyalty";

    String PREF_FIRST_NAME = "first_name";

    String PREF_LAST_NAME = "last_name";

    String PREF_WALLET_HASH = "hash";

    String PREF_WALLET_EXPIRYTIME = "timestamp";

    String PREF_SIGN_IN_TIME_KEY = "sign_in_time";

    String PREF_EXPIRE_TIME_KEY = "expire_time";

    String PREF_SECURE_TIME_KEY = "secure_time";

    String PREF_USERLASTNAME_KEY = "user_lastname";

    String PREF_USER_SIGNED_IN_STATUS = "user_signed_in_status";

    String PREF_IDLE_TIME_KEY = "idle_time";

    String PREF_CART_ID = "cartID";

    // TODO Remove variable PREF_OMNITURE_SERVER when app goes on production
    public static final String PREF_DIGESTED_MSG = "PREF_DIGESTED_MSG";

    public static final String PREF_STRING_MSG = "PREF_STRING_MSG";

    // TODO Remove variable PREF_OMNITURE_SERVER when app goes on production
    String PREF_OMNITURE_SERVER = "omniture_server";

    // TODO Remove variable PREF_OMNITURE_SECURE_SERVER when app goes on
    // production
    String PREF_OMNITURE_SECURE_SERVER = "omniture_secure_server";

    // TODO Remove variable PREF_OMNITURE_FIRST_LAUNCH when app goes on
    // production
    String PREF_OMNITURE_FIRST_LAUNCH = "omniture_is_first_launch";

    // Request to code when sign in activity is opened from any other activity.
    int REQUEST_CODE_SIGN_IN_ACTIVITY = 1;

    int REQUEST_CODE_SCAN_ACTIVITY = REQUEST_CODE_SIGN_IN_ACTIVITY + 1;

    int REQUEST_CODE_CREATE_ACCOUNT = 1006;

    int REQUEST_CODE_SIGN_IN_ACTIVITY_FROM_MY_INFO = 1003;

    int REQUEST_CODE_SIGN_IN_ACTIVITY_FROM_HYBRID = REQUEST_CODE_SIGN_IN_ACTIVITY_FROM_MY_INFO + 1;

    // TODO Should come from Configuration Adapter
    String OMNITURE_CONFIGURATION_RSSID = "kohlsnativeappprod";

    // TODO Should come from Configuration Adapter
    String OMNITURE_CONFIGURATION_TRACKING_SERVER = "ww9.kohls.com";

    String OMNITURE_CONFIGURATION_TRACKING_SERVER_SECURE = "ww8.kohls.com";

    // Collection
    String MIME = "text/html";

    String ENCODING_UTF8 = "utf-8";

    String HTML_END_TAG = "</font>";

    String HTML_COLOR_START_TAG = "<font color='gray'>";

    String ADD_TO_BAG = "AddToBag";

    String FIND_IN_STORES = "FindInStores";

    // Create profile extra keys.
    String EXTRA_KEY_FIRST_NAME = "key_first_name";

    String EXTRA_KEY_LAST_NAME = "key_last_name";

    String EXTRA_KEY_EMAIL = "key_email";

    String EXTRA_KEY_RETYPE_EMAIL = "key_retype_email";

    String EXTRA_KEY_RETYPE_PASSWORD = "key_retype_password";

    String EXTRA_KEY_SEARCH_KEYWORD = "key_search_keyword";

    String EXTRA_KEY_IS_FROM_SAERCH = "key_is_from_search";

    String EXTRA_KEY_IS_TYPEHEAD = "key_is_typehead";

    String EXTRA_KEY_SEARCH_TYPE = "key_search_type";

    String EXTRA_KEY_IS_FILTER_SET_MANUALLY = "key_is_filter_set_manually";

    String EXTRA_KEY_FILTER_SET_MANUALLY = "key_filter_set_manually";

    String EXTRA_KEY_IS_FOR_FEATURED_BRAND = "key_is_for_featured_brand";

    String EXTRA_KEY_SORT_ID = "key_sort_id";

    String EXTRA_KEY_SEARCH_HISTORY = "key_search_history";

    String KOHLS_STORES = "kohls_stores";

    // Value Added Icons
    String VALUE_ADDED_ICON_ONLINE = "//d16rliti0tklvn.cloudfront.net/5/1376916272203.373873069.gif";

    String VALUE_ADDED_ICON_MORE_COLORS = "//d16rliti0tklvn.cloudfront.net/5/1376916393655.1217695000.gif";

    String VALUE_ADDED_ICON_BOGO_1_1_D_100 = "//d16rliti0tklvn.cloudfront.net/5/bogo_1_1_D_100.gif";

    String VALUE_ADDED_ICON_BOGO_1_1_P_50 = "//d16rliti0tklvn.cloudfront.net/5/bogo_1_1_P_50.gif";

    String VALUE_ADDED_ICON_BOGO_1_1 = "//d16rliti0tklvn.cloudfront.net/5/bogo_1_1.gif";

    String VALUE_ADDED_ICON_BOGO_2_1 = "//d16rliti0tklvn.cloudfront.net/5/bogo_2_1.gif";

    String VALUE_ADDED_ICON_REBATE = "//d16rliti0tklvn.cloudfront.net/5/rebate.gif";

    String VALUE_ADDED_ICON_WARNING = "//d16rliti0tklvn.cloudfront.net/5/war.gif";

    String VALUE_ADDED_ICON_BUY_1_GET_0_50_PERCENTAGE = "//d16rliti0tklvn.cloudfront.net/5/1376918161165.1885808990.gif";

    int VALUE_ADDED_ICON_HEIGHT = 20;

    int VALUE_ADDED_ICON_WIDTH = 60;

    // Scan Result Constants

    public static final String PREF_FIRST_SCAN = "PREF_FIRST_SCAN";

    public static final String INTENT_FROM_SCAN = "INTENT_FROM_SCAN";

    // Visual search -> launch the regular text search -> intent will contain
    // this flag to let PMP know that this is coming from visual search.
    public static final String INTENT_FROM_VISUAL_SEARCH = "INTENT_FROM_VISUAL_SEARCH";

    public static final int SCAN_RESULT_FAILED = 2;

    public static final int REQUEST_CODE_SCAN_PRODUCTS = SCAN_RESULT_FAILED + 1;

    public static final int REQUEST_CODE_SCAN_CATALOG = REQUEST_CODE_SCAN_PRODUCTS + 1;

    public static final int REQUEST_CODE_PDP = REQUEST_CODE_SCAN_CATALOG + 1;

    public static final int RESULT_CODE_SHOPPING_BAG_START_SHOPPING = REQUEST_CODE_PDP + 1;

    public static final int RESULT_CODE_CLOSE_ACTIVITY_ONLY = 7002;

    public static final int RESULT_CODE_CLOSE_UPDATE_ACCOUNT_ACTIVITY = 7003;

    public static final int RESULT_CODE_CLOSE_MY_INFO = 7004;

    public static final int RESULT_CODE_OPEN_ACCOUNT = 7005;

    public static final int RESULT_CODE_KOHLS_CASH_ERROR_DIALOG = 7005;

    public static final int CACHE_DIR = 1001;

    public static final int EXTERNAL_CACHE_DIR = CACHE_DIR + 1;

    public static final long CATALOG_EXPIRY_TIME = 30;

    public static final long ONE_MINUTE_IN_MILLIS = 60000;// millisecs

    // Name of the file that will contain the LinkedHashMap of the data
    public static final String CATALOG_FILENAME = "catalog.tmp";

    // Name of the file that will contain the LinkedHashMap of the data
    public static final String CATEGORY_FILENAME = "category.tmp";

    // Day Constants
    public static final String CMS_FILENAME = "cms.tmp";

    public static final String REGISTRY_CACH_FILENAME = "reg_cms.tmp";

    // Day Constants
    String DAY_MONDAY = "monday";

    String DAY_TUESDAY = "tuesday";

    String DAY_WEDNESDAY = "wednesday";

    String DAY_THURSDAY = "thursday";

    String DAY_FRIDAY = "friday";

    String DAY_SATURDAY = "saturday";

    String DAY_SUNDAY = "sunday";

    // GeoCode Specific Strings.
    String GEOCODE_US_SHORT_NAME = "US";

    String GEOCODE_CITYNAME = "locality";

    String GEOCODE_STATENAME = "administrative_area_level_1";

    String GEOCODE_STATE_SHORT_NAME = "state_short_name";

    String GEOCODE_COUNTYNAME = "administrative_area_level_2";

    String GEOCODE_PINCODE = "postal_code";

    String GEOCODE_COUNTRY = "country";

    String GEOCODE_POI = "point_of_interest";

    String GEOCODE_ESTABLISHMENT = "establishment";

    String GEOCODE_ROUTE = "route";

    String GEOCODE_STREET_ADDRESS = "street_address";

    String STREET_NUMBER = "street_number";

    String GEOCODE_ADDRESS_PARAMS = "address";

    String GEOCODE_CLIENTID = "client";

    String GEOCODE_SENSOR_PARAMS = "sensor";

    String SIGNATURE_PARAMETER = "signature";

    public static final String US_CODE = "United States";

    // Request code to use when launching the resolution activity
    public static final int REQUEST_RESOLVE_ERROR = 1001;

    public static final String BUNDLE_STORE_DETAIL = "store_detail";

    public static final String BUNDLE_SEARCH_LATITUDE = "search_latitude";

    public static final String BUNDLE_SEARCH_LONGITUDE = "search_longitude";

    public static final String BUNDLE_PRODUCT_IMAGEURL = "product_imageUrl";

    public static final String BUNDLE_PRODUCT_NAME = "product_nameTitle";

    public static final String BUNDLE_PRODUCT_WEBID = "product_webID";

    public static final String BUNDLE_PRODUCT_SALE = "product_salePrice";

    public static final String BUNDLE_PRODUCT_ORIGINAL = "product_oriPrice";

    public static final String BUNDLE_PRODUCT_SKU = "product_sku";

    public static final String BUNDLE_PRODUCT_BOPUS_ELIGIBLE = "product_bopus_eligible";

    public static final String BUNDLE_SKU_BOPUS_ELIGIBLE = "sku_bopus_eligible";

    public static final String BUNDLE_PRODUCT_WEB_ID = "product_web_id";

    public static final String BUNDLE_PRODUCT_RATINGS = "product_ratings";

    public static final String BUNDLE_PRODUCT_RATINGS_COUNT = "product_ratings_count";

    public static final int START_GEOCODE_REQUEST = 1001;

    public static final int GET_STORES = START_GEOCODE_REQUEST + 1;

    public static final int GET_STORE_INVENTORY = GET_STORES + 1;

    public static final int MERGE_STORE_INVENTORY = GET_STORE_INVENTORY + 1;

    public static final int STORE_ADD_BAG = MERGE_STORE_INVENTORY + 1;

    public static final String GOOGLE_APIS_CLIENT_ID = "gme-kohlsdepartmentstores";

    String SEARCH_FRAGMENT = "search_add";

    public static final String COLLECTION_ID = "collection id";

    public static final String ONLINE_EXCLUSIVE = "OnlineExclusive";

    public static final String FROM_CHECKOUT = "FromCheckout";

    public static final String FROM_EDITBAG = "FromEditBag";

    // Request and result code for account activity
    public static final int REQUEST_CODE_MANAGE_ACCOUNT = 7001;

    public static final int RESULT_CODE_ATTACH_MANAGE_ACCOUNT_FRAGMENT = 7002;

    public static final int REQUEST_CODE_ORDER_TRACK_STATUS = 7003;

    public static final String ATTACH_MANAGE_ACCOUNT_FRAGMENT = "ATTACH_MANAGE_ACCOUNT_FRAGMENT";

    public static final String CLOSE_ACTIVITY_ONLY = "CLOSE_ACTIVITY_ONLY";

    String SEARCH_KEYWORD = "search_key";

    String SKU = "sku";

    String SUGGESTION_URL_TAIL = ".jsp";

    public static final String SCAN_DATA = "SCAN_DATA";

    public static final String SCAN_PMP_ID = "SCAN_PMP_ID";

    public static final String SCAN_PMP_BARCODE_SEARCH_ID = "SCAN_PMP_BARCODE_SEARCH_ID";

    public static final String SCAN_PMP_SORT = "SCAN_PMP_SORT";

    public static final String SCAN_PDP_QR = "SCAN_PDP_QR";

    public static final String SCAN_PDP_BARCODE = "SCAN_PDP_BARCODE";

    public static final String SCAN_LOYALTY_NUMBER = "SCAN_LOYALTY_ID";

    public static final String SCAN_PRODUCT_REVIEW = "SCAN_PRODUCT_REVIEW";

    public static final String SCAN_DISCOUNT_NUMBER = "SCAN_DISCOUNT_ID";

    // Adding For Registry

    public static final String SCAN_FIND_REGISTRY_ID = "SCAN_FIND_REGISTRY_ID";

    public static final String SCAN_PRODUCT_FOR_LIST = "product for list";

    public static final String KOHLS_COM = "kohls.com";

    public static final String WEB_COM = ".com";

    public static final String SCAN_KEYWORD = "keyword";

    public static final String SCAN_ID = "id";

    public static final String SCAN_SORT = "sort";

    public static final String SCAN_ACTION = "com.google.zxing.client.android.SCAN";

    public static final String SCAN_FORMAT_TITLE = "SCAN_FORMATS";

    public static final String SCAN_HISTORY_TITLE = "SAVE_HISTORY";

    public static final String SCAN_WIDTH_TITLE = "SCAN_WIDTH";

    public static final String SCAN_HEIGHT_TITLE = "SCAN_HEIGHT";

    /* Add Scan Variable for LnR.(For SingleProductId) */
    public static final String SCAN_REGISTRY_ID = "registryId";

    public static final String SCAN_LIST_ID = "list id";

    public static final int SCAN_REGISTRY_SUCCESSES = 121;

    public static final String LAUNCHED_FROM_TOOLS = "LAUNCHED_FROM_TOOLS";

    public static final String[] STATES_CODE = {
            "AL",
            "AK",
            "AZ",
            "AR",
            "CA",
            "CO",
            "CT",
            "DE",
            "DC",
            "FL",
            "GA",
            "HI",
            "ID",
            "IL",
            "IN",
            "IA",
            "KS",
            "KY",
            "LA",
            "ME",
            "MD",
            "MA",
            "MI",
            "MN",
            "MS",
            "MO",
            "MT",
            "NE",
            "NV",
            "NH",
            "NJ",
            "NM",
            "NY",
            "NC",
            "ND",
            "OH",
            "OK",
            "OR",
            "PA",
            "RI",
            "SC",
            "SD",
            "TN",
            "TX",
            "UT",
            "VT",
            "VA",
            "WA",
            "WV",
            "WI",
            "WY",
            "STATE"
    };

    public static final String[] STATES = {
            "Alabama",
            "Alaska",
            "Arizona",
            "Arkansas",
            "California",
            "Colorado",
            "Connecticut",
            "Delaware",
            "District Of Columbia",
            "Florida",
            "Georgia",
            "Hawaii",
            "Idaho",
            "Illinois",
            "Indiana",
            "Iowa",
            "Kansas",
            "Kentucky",
            "Louisiana",
            "Maine",
            "Maryland",
            "Massachusetts",
            "Michigan",
            "Minnesota",
            "Mississippi",
            "Missouri",
            "Montana",
            "Nebraska",
            "Nevada",
            "New Hampshire",
            "New Jersey",
            "New Mexico",
            "New York",
            "North Carolina",
            "North Dakota",
            "Ohio",
            "Oklahoma",
            "Oregon",
            "Pennsylvania",
            "Rhode Island",
            "South Carolina",
            "South Dakota",
            "Tennessee",
            "Texas",
            "Utah",
            "Vermont",
            "Virginia",
            "Washington",
            "West Virginia",
            "Wisconsin",
            "Wyoming",
            /* For showing as hint on the spinner */"Select State"
    };

    public static final String[] ARMED_FORCE_STATES_CODE = {
            "AA", "AE", "AP", "STATE"
    };

    public static final String[] ARMED_FORCE_STATES = {
            "Armed forces - America", "Armed forces - Europe", "Armed forces - Pacific", /*
                                                                                          * For
                                                                                          * showing
                                                                                          * as
                                                                                          * hint
                                                                                          * on
                                                                                          * the
                                                                                          * spinner
                                                                                          */
            "Select State"
    };

    public static final String STATE = "STATE";

    public static final String PHONE_TYPE_MOBILE = "MOBILE";

    public static final String SELECT_CATEGORY = "SELECT_CATEGORY";

    public static final String EXTRA_KEY_URL = "KEY_URL";

    public static final String EXTRA_KEY_FROM_LIST_REGISTRY = "KEY_LIST_REGISTRY";

    public static final String EXTRA_KEY_OVERRIDE_USERAGENT = "EXTRA_KEY_OVERRIDE_USERAGENT";

    public static final String EXTRA_KEY_FOR_REG_FAQ_SCREEN = "Reg Faq Screen";

    public static final String EXTRA_KEY_HTML_CONTENT = "HTML_CONTENT";

    public static final String EXTRA_KEY_WEBVIEW_FROM_URL = "EXTRA_KEY_WEBVIEW_FROM_URL";

    public static final String EXTRA_KEY_LISTS_PDP = "LIST_PDP";

    public static final String EXTRA_KEY_REGISTRY_PDP = "REGISTRY_PDP";

    public static final String EXTRA_KEY_SCREENNAME = "KEY_SCREENNAME";

    public static final String URL_TINT = "tint/tint.html";

    public static final String ASSETS_FOLDER_PATH = "file:///android_asset/";

    // Bundle Key for checking whether to show create account in Account
    // activity or not.
    public static final String SHOW_CREATE_ACCOUNT_KEY = "show_create_account";

    public static final String SHOW_UNSECURE_PAGE = "show_unsecure_page_account";

    public static final String SHOW_MANAGE_ACCOUNT_SCREEN = "show_manage_account_screen";

    public static final String MAKE_CART_API = "make_cart_call";

    public static final String SIGN_IN_ACC_ERROR = "sign_in_err_msg";

    // Bundle Key for checking whether to show guest and signin in Account
    // activity or not.
    public static final String SHOW_GUSET_SIGNIN_KEY = "show_guest_signin";

    // This constant will indicate that the create account will be active and no
    // selection tab(Sign In, Create an Account) will be there at the top of the
    // screen.
    public static final String SHOW_CREATE_ACCOUNT_WITH_NO_TAB = "show_create_account_with_no_tab";

    // Rating review screen
    public static final String EXTRA_KEY_RATING_REVIEW_DETAILS = "rating_review_details";

    public static final String EXTRA_KEY_RATING_REVIEW_PRODUCT_TITLE = "rating_review_product_title";

    public static final String EXTRA_KEY_OPEN_WRITE_REVIEW = "open_write_review";

    public static final String EXTRA_KEY_RATING_REVIEW_PRODUCT_PRICE = "rating_review_product_price";

    public static final String WRITE_REVIEW_PRODUCT_ID = "productId";

    public static final String WRITE_REVIEW_USER_ID = "UserId";

    public static final String WRITE_REVIEW_USER_NICKNAME = "UserNickname";

    public static final String WRITE_REVIEW_RATING = "Rating";

    public static final String WRITE_REVIEW_RATING_QUALITY = "Rating_Quality";

    public static final String WRITE_REVIEW_RATING_VALUE = "Rating_Value";

    public static final String WRITE_REVIEW_RATING_STYLE = "Rating_Style";

    public static final String WRITE_REVIEW_TITLE = "Title";

    public static final String WRITE_REVIEW_TEXT = "ReviewText";

    public static final String WRITE_REVIEW_IS_RECOMMENDED = "IsRecommended";

    public static final String WRITE_REVIEW_PRO = "tag_Pro_1";

    public static final String WRITE_REVIEW_CON = "tag_Con_1";

    public static final String WRITE_REVIEW_USER_LOCATION = "UserLocation";

    public static final String WRITE_REVIEW_MAIL_ON_POSTED = "SendEmailAlertWhenPublished";

    public static final String WRITE_REVIEW_MAIL_ON_COMMENT = "SendEmailAlertWhenCommented";

    public static final String WRITE_REVIEW_AGE_RANGE = "ContextDataValue_Age";

    public static final String WRITE_REVIEW_ONLINE_STORE_VISIT = "Contextdatavalue_OnlineVisits";

    public static final String WRITE_REVIEW_STORE_VISIT = "Contextdatavalue_StoreVisits";

    // Activity results constants
    public static final int ACTIVITY_RESULT_BACK_PRESS = 10;

    public static final int ACTIVITY_RESULT_FAILURE = 11;

    public static final int ACTIVITY_RESULT_OK_CHECKOUT_AS_GUEST = 12;

    public static final int ACTIVITY_RESULT_OK_MISCELLANOUS = 12;

    public static final String OPEN_SCREEN_KEY = "open_screen_key";

    public static final String OPEN_PRODUCT_MATRIX = "open_product_matrix";

    public static final String OPEN_STORE_LOCATOR = "open_store_locator";

    public static final String OPEN_My_LISTS = "open_my_lists";

    public static final String OPEN_My_REGISTRY = "open_my_registry";

    public static final String OPEN_MY_REGISTRY_LANDING_SCREEN = "open_my_registry_landing_screen";

    public static final String OPEN_ACCOUNT = "open_account";

    public static final int RESULT_CODE_SHOPPING_BAG_UPDATE_SUCCESS = 13;

    public static final int RESULT_CODE_WRITE_REVIEW_SUCCESS = 14;

    public static final String SHARED_PREF_ACCEPT_LIC = "accept-lic-pending";

    public static final String SHARED_PREF_LIC_ACCEPTANCE = "lic-acceptance";

    public static final String DIALOG_EULA_ACCEPT = "ACCEPT";

    public static final String DIALOG_EULA_CANCEL = "CANCEL";

    public static final String DIALOG_EULA_TITLE = "EULA";

    public static final String DIALOG_EULA_DESC = "Accept the licsence agreement or else the applicattion will be closed.";

    /* CMS Constants */
    String CMS_FOR_HOME = "homepage";

    String CMS_FOR_HOME_CAMPAIGN = "homeCampaign";

    String CAMPAIGN_NAME_REGISTRY = "grlandingpage";

    String PAGE_NAME_REGISTRY = "landingpage";

    String PAGE_NAME_MISC = "miscellaneous";

    String PAGE_NAME_ABT_WED_REGISTRY = "aboutwedding";

    String PAGE_NAME_ABT_BABY_REGISTRY = "aboutbaby";

    String PAGE_NAME_ABT_CELB_REGISTRY = "aboutcelebration";

    String PAGE_NAME_CELEBRATION_ABOUT = "";

    String CMS_LOYALTY = "Loyalty";

    String CMS_6UP_SPOT = "6UpSpot";

    String CMS_6UP_SPOT_1 = "6UpSpot1";

    String CMS_6UP_SPOT_2 = "6UpSpot2";

    String CMS_6UP_SPOT_3 = "6UpSpot3";

    String CMS_6UP_SPOT_4 = "6UpSpot4";

    String CMS_6UP_SPOT_5 = "6UpSpot5";

    String CMS_6UP_SPOT_6 = "6UpSpot6";

    String CMS_6UP_SPOT_HEADER = "6UpBrandHeader";

    String CMS_PROMOMODULE_1 = "PromotionModule1";

    String CMS_PROMOMODULE_2 = "PromotionModule2";

    String CMS_BRAND_FEATURE_1 = "BrandFeature1";

    String CMS_BRAND_FEATURE_2 = "BrandFeature2";

    String CMS_RECOMENDATION = "Recommendation";

    String CMS_TARGET_URL = "cmsTargetURL";

    String CMS_SEARCH_KEYWORD = "keyword=";

    String CMS_ID_KEYWORD = "id=";

    String CMS_SUBCATEGORY_HTML = "subcategory.html?id=";

    String CMS_DEPARTMENT_HTML = "department.html?id=";

    String CMS_CN = "CN=";

    String CMS_AMPERSAND = "&";

    String CMS_FEATURE_BRAND_PAGE = "featuredbrandpage";

    String CMS_FEATURE_BRAND_CAMPAIGN = "featuredbrandCampaign";

    String RECOMMENDED_TYPE_TOP_TRENDING = "toptrending";

    String PDP_OFFER_MESSAGE_CHOOSE_GIFT = "OfferChooseGift";

    String PDP_OFFER_MESSAGE_OFFER_CONFIRMATION = "OfferConfirmation";

    String USSTD = "USSTD";

    String EXTRA_KEY_IS_EDIT_SOPPING_BAG = "key_is_edit_shopping_bag";

    // From constants shows from where the user reached to PDP screen.

    public static final String FROM = "from";

    public static final String FROM_RECOMMENDATIONS = "Recommendations";

    public static final String FROM_SCAN = "ScanHelper";

    public static final String FROM_IN_STORE_TOOLS = "InStoreTools";

    public static final String FROM_SHOPPING_BAG = "ShoppingBag";

    public static final String FROM_HOME = "Home";

    public static final String FROM_COLLECTION_PRODUCTS = "CollectionProducts";

    public static final String FROM_SIX_UP_ADAPTER = "SixUpAdapter";

    public static final String FROM_BROWS_FRAGMENT = "BrowsFragment";

    public static final String FROM_RATING_REVIEW = "RatingReview";

    public static final String FROM_FEATURE_BRAND = "FeatureBrand";

    public static final String FROM_BIG_DATA = "BigData";

    String PDP_OFFER_MESSAGE_ADD_TO_BAG_SINGULAR = "AddToBagMessageSingular";

    String PDP_OFFER_MESSAGE_ADD_TO_BAG = "AddToBagMessage";

    String PDP_OFFER_MESSAGE_DISCARD = "DiscardMessage";

    String PDP_OFFER_MESSAGE_GIFT_NOT_ADDED = "OfferGiftNotAdded";

    String EXTRA_KEY_PDP_OFFER_MESSAGES = "offer_msg_hash_map";

    String EXTRA_KEY_PDP_BUY_PRODUCT_NAME = "pdp_offer_buy_product_web_id";

    public static final String ACTION_GET_PROFILE_JSON = "GET_PROFILE_JSON";

    public static final String ACTION_GET_PROFILE_ERROR = "GET_PROFILE_ERROR_JSON";

    String PDP_OFFER_MESSAGE = "offerMessage";

    String PDP_OFFER_CONFIG_MESSAGE = "configMessage";

    String PDP_OFFER_REACHED_THRESHOLD = "enableButtons";

    public static final String TAG_LIST = "tag-list";

    public static final String TAG_REGISTRY = "tag-registry";

    public static final String TAG_RESET_PASSWORD = "tag-reset-password";

    public static final String TAG_SIGIN_INFO = "tag-sign-in-info";

    public static final String TAG_SOCIAL_FEED = "tag-#KOHLS";

    public static final String TAG_CONFIRM_PASSWORD = "tag-confirm-password";

    public static final String TAG_ACCOUNT = "tag-account";

    public static final String TAG_ORDER_TRACK_STATUS = "tag-order-track-status";

    public static final String TAG_EULA = "tag-eula";

    public static final String TAG_HOME_FRAGMENT = "tag-home";

    public static final String TAG_HYBRID_MYINFO = "tag-hybrid-myinfo";

    String ORDER_CAL_ERROR_CODE = "ORDER3014";

    public static final String APP_CONFIG_FILE = "default_config";

    public static final String APP_EULA_FILE = "eula_content";

    public static final int REQUEST_CODE_EULA = 111;

    public static final int REQUEST_CODE_CLOSE_ACCOUNT = 112;

    public static final int REQUEST_CLOSE_UPDATE_ACTIVITY = 113;

    public static final int REQUEST_CLOSE_UPDATE_ACC_ACTIVITY_WITH_ERROR = 114;

    public static final int VISUAL_SEARCH_REQUEST_CODE_CAMERA = 115;

    public static final int VISUAL_SEARCH_REQUEST_CODE_GALLERY = 116;

    public static final String LIC_ACCEPTANCE = "lic-acceptance";

    public static final String PREF_CMS_CACHE = "PREF_CMS_CACHE";

    public static final String PREF_CATEGORY_CACHE = "PREF_CATEGORY_CACHE";

    public static final String PREF_CATALOG_CACHE = "PREF_CATALOG_CACHE";

    public static final String PREF_CMS_HOME_NAME = "PREF_CMS_PAGENAME";

    public static final String PREF_OMNICHANNEL_OVERRIDE = "PREF_OMNICHANNEL_OVERRIDE";

    public static final String PREF_OMNICHANNEL_ENABLED = "PREF_OMNICHANNEL_ENABLED";

    // Hamburger root level menu item
    public static final int ROOT_LEVEL_ITEM_HOME = 0;

    public static final int ROOT_LEVEL_ITEM_MENU = 1;

    public static final String EXTRA_KEY_IS_EDIT_SOPPING_BAG_FOR_PWP = "is_from_shopping_bag_for_pwp";

    public static final String CONSTANT_TINT_URL = "http://www.tintup.com/loyalty";

    public static final String CONSTANT_FROM_DIGBY = "CONSTANT_FROM_DIGBY";

    public static final String CONSTANT_FROM_UPGRADE = "CONSTANT_DISMISS_UPGRADE";

    public static final String LOCATION_FROM_DIGBY = "LOCATION_FROM_DIGBY";

    public static final String EXTRA_KEY_UPD_ACC_EMAIL_ID = "EMAIL_ID";

    public static final String EXTRA_KEY_UPD_ACC_EMAIL_ID_CHANGED = "EMAIL_ID_CHANGED";

    public static final String EXTRA_KEY_UPD_ACC_FIRST_NAME = "FIRST_NAME";

    public static final String EXTRA_KEY_UPD_ACC_LAST_NAME = "LAST_NAME";

    String GEOCODE_URL = "http://maps.googleapis.com/maps/api/geocode/json";

    public static final String FRAGMENT_TAG = "fragment_tag";

    public static final String WALLET_FRAGMENT = "wallet";

    public static final String LOYALTY_FRAGMENT = "loyalty";

    public static final String OPEN_My_WALLET = "open_my_wallet";

    public static final String OPEN_My_LOYALTY = "open_my_loyalty";

    public static final String OPEN_My_ENROLLMENT = "open_my_enrollment";

    public static final String ENROLLED_TO_LOYALTY = "enrolled";

    public static final String PAGE_TYPE = "pageType";

    public static final String PAGE_ID = "pageID";

    public static final String PAGE_CATEGORY = "category";

    public static final String PAGE_CATALOG = "catalog";

    public static final String PAGE_CMS = "cms";

    public static final String PAGE_PRODUCT = "productDetail";

    public static final String BLACK_FRIDAY_LIST_SUCCESS = "Success";

    public static int SPLASH_TIME_OUT = 2000;

    public static final String MORNING = "morning";

    public static final String NOON = "noon";

    public static final String EVENING = "evening";

    public static final String NIGHT = "night";

    public static final String MID_NIGHT = "midnight";

    public static final String KOHLS_LOGGED_IN = "kohls-logged-in|loyalty-not-logged-in";

    public static final String LOYALTY_LOGGED_IN = "kohls-logged-in|loyalty-logged-in";

    public static final String FACEBOOK = "facebook";

    public static final String FACEBOOK_SHARE_MESSAGE = "I love this item I found on Kohls.com. I just had to share it!";

    public static final String FACEBOOK_SHARE_FROM_SCREEN = "facebook-share sccreen";

    public static final String FACEBOOK_SHARE_FROM_PDP = "facebook-share-from-pdp";

    public static final String FACEBOOK_SHARE_FROM_LIST_REGISTRY = "facebook-share-from-listregistry";

    public static final String FACEBOOK_SHARE_DIALOG_DESC = "description";

    public static final String FACEBOOK_SHARE_DIALOG_NAME = "name";

    public static final String FACEBOOK_SHARE_DIALOG_PICTIRE = "picture";

    public static final String FACEBOOK_SHARE_DIALOG_LINK = "link";

    public static final String FACEBOOK_SHARE_DIALOG_CAPTION = "caption";

    public static final String FACEBOOK_SHARE_DIALOG_DISPLAY = "display";

    public static final String FOR_FINAL_PRICE_ADD_TO_BAG = "For final price, Add to Bag";

    public static final String FINAL = "final";

    public static final String FOR_PRICE_ADD_TO_BAG = "For price, Add to Bag";

    public static final String TYPECODE_KOHLSCASH = "kohlscash";

    public static final String YOUR_PRICE = "Your Price: $";

    // Error Code
    public static final String[] ERRORCODE_LOGOUT = {
            "3032", "9092", "9100", "9463"
    };

    public static final String ERRORCODE_401 = "401";

    public static final String SERVER_LOGGER_EMAIL = "email";

    public static final String SERVER_LOGGER_REFRESH_TOKEN = "refresh_token";

    public static final String SERVER_LOGGER_ACCESS_TOKEN = "access_token";

    public static final String SERVER_LOGGER_ERROR_MESSAGE = "due to error in success of ";

    public static final String SERVER_USER_TOKEN = "userToken";

    public static final String SERVER_FIRST_NAME = "firstName";

    public static final String SERVER_LAST_NAME = "lastName";

    public static final String SERVER_WALLET_HASH = "walletHash";

    public static final String SERVER_TIMESTAMP = "walletTimeStamp";

    public static final String EXTRA_KEY_SCAN_TYPE = "scanType";

    public static final String EXTRA_KEY_SCAN_CODE = "scanCode";

    public static final String EXTRA_VALUE_SCAN_TYPE_QRCODE = "QRCODE";

    public static final String EXTRA_VALUE_SCAN_TYPE_BARCODE = "BARCODE";

    public static final String EXTRA_KEY_LAST_PFM = "lastProductFindingMethod";

    public static final String SERVER_LOGGER_LOYALTY_WALLET = "wallet_loyalty";

    public static final String SERVER_LOGGER_CLIENT_TYPE = "client";

    public static final String ANDROID = "Android";

    public static final String CURRENT_TIME_ALERT_UPGRADE_INTERVAL = "Current_Time_Alert_Upgrade_Interval";

    public static final String ORIGINATED_FROM_FRAGMENT = "originated from which fragment";

    public static final String ORIGINATED_FROM_REG_LND = "origin from reg lan";

    public static final String ORIGINATED_FROM_FRAGMENT_PRODUCT_SEARCH = "originated from product search";

    /* String OPEN_LIST_SEARCH_RESULTS = "open_list_search_results"; */

    String EXTRA_KEY_WEBVIEW_BACK_HANDLING = "is webview back enabled";

    public static final String TAG_REGISTRY_LANDING_FRAGMENT = "reg landing frag";

    public static final String TAG_ADDRESS_FRAGMENT = "address frag";

    public static final String TAG_ADD_ADDRESS_FRAGMENT = "add address frag";

    public static final String TAG_REGISTRY_SEARCH_FRAGMENT = "reg search frag";

    public static final String TAG_REGISTRY_CONFIRMATION_FRAGMENT = "reg conf frag";

    public static final String FORSEE_SURVEY_FLAG = "forsee";

    public static final String APPTENTIVE_SURVEY_FLAG = "apptentive";

    public static final String LOYALTY_SURVEY_EVENT = "loyalty";

    public static final String INSTORE_SURVEY_EVENT = "instore";

    public static final String SEARCH_ITEM_SURVEY_EVENT = "searchproduct";

    public static final String CHECKOUT_SURVEY_EVENT = "checkout";

    public static final String PREF_FIRST_VISUAL_SEARCH = "PREF_FIRST_VISUAL_SEARCH";

    public static final String SALE = "sale";

    public static final String CLEARANCE = "Clearance";

    public static final String SALE_CLEARANCE = "sale+clearance";

    public static final String MIXED = "Mixed";

    public static final String CLEARANCE_STATUS_CODE = "30";

    public static final String REDIRECT = "redirect";

    public static final String REDIRECT_STORE_LOCATOR_CORPORATION = "store_locator.htm";

    public static final String REDIRECT_STORE_LOCATOR = "stores.shtml";

    public static final String REDIRECT_TODAYS_DEALS = "coupons-deals.jsp";

    public static final String REDIRECT_MY_KOHLS_CHARGE = "credit.kohls.com/eCustService";

    public static final String REDIRECT_KOHLS_REWARDS = "rewards.jsp";

    public static final int REQUEST_CODE_FROM_QRSCAN_SIGN_IN = 200;

    String QRCODE = "qrcode";

    String APP_VERSION = "appVersion";

    public static final String ABOUT_SCREENS = "about screens";

    public static final String QRCODE_LIST_SCAN = "list_scan";

    public static final String LIST_ID = "list_id";

    public static final String SUPPRESS_ADD_TO_BAG = "add to bag";

    public static final String LOCATION_OFF_TAG = "LOCATION_OFF";

    public static final String NON_US_ZIPCODE = "LOCATION_NONUSA";

    public static final String LOCATION_CODE = "code";

    public static final String LOCATION_MSG = "message";

    public static final String TEXT = "text";

    public static final String LINK = "link";

    public static final String CONTENT_TAG = "content";

    public static final String HEADER_TAG = "header";

    public static final String EXTRA_KEY_SKU_FROM_LIST_OR_REGISTRY = "key_sku_from_list_or_registry";

    public static final String EXTRA_KEY_QTY_FROM_LIST_OR_REGISTRY = "key_qty_from_list_or_registry";

    public static final String FLAG_OMNITURE_CALLED_FOR_LIST_LANDING = "flag_omniture_called_for_list_landing";

    String EXTRA_KEY_COLLECTION_ID = "Collection_id";

    public static String URL_REGEX = "^((https?|ftp)://|(www|ftp)\\.)?[a-z0-9-]+(\\.[a-z0-9-]+)+([/?].*)?$";

    public static final String USER_AGENT_TAG = "overrideUserAgent";

    public static final int ACTIVITY_RESULT_STORENUM_FIS = 110;

    public static final String GENERIC_FAILURE = "GENERIC_FAILURE";

    public static final String SELECTED_STORE = "SELECTED_STORE";

    // JIRA:KAP-12289
    public static final String TAG_FRAGMENT_LOYALTY = "tag-fragment-loyalty";

    public static final int FACEBOOK_LIKE_REQUEST_CODE = 64207;

    public static final int PINTEREST_FOLLOW_REQUEST_CODE = 64208;

    public static final int INSTAGRAM_FOLLOW_REQUEST_CODE = 64209;

    public static final int TWITTER_FOLLOW_REQUEST_CODE = 64210;

    String EXTRA_KEY_OMNITURE_S_PRODUCTS = "key_omniture_s_products";

}
