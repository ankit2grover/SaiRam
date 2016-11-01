
package com.kohls.mcommerce.opal.helper.adapter;

//import android.R;

import android.content.Context;
import android.os.Message;

import com.kohls.mcommerce.opal.common.util.Logger;
import com.kohls.mcommerce.opal.common.util.NetworkUtils;
import com.kohls.mcommerce.opal.framework.vo.IValueObject;
import com.kohls.mcommerce.opal.helper.adapter.listener.AdapterValueListener;
import com.kohls.mcommerce.opal.helper.adapter.listener.IAdapterListener;
import com.kohls.mcommerce.opal.helper.adapter.rest.NetworkManager;
import com.kohls.mcommerce.opal.helper.adapter.rest.RequestProcessor;
import com.kohls.mcommerce.opal.helper.cache.inmemory.CacheListener;
import com.kohls.mcommerce.opal.helper.cache.inmemory.HeaderObject;
import com.kohls.mcommerce.opal.helper.cache.inmemory.IInMemoryCacheRegion;
import com.kohls.mcommerce.opal.helper.cache.inmemory.InMemoryCMSRegion;
import com.kohls.mcommerce.opal.helper.cache.inmemory.InMemoryCacheHelper;
import com.kohls.mcommerce.opal.helper.cache.inmemory.InMemoryCacheVO;
import com.kohls.mcommerce.opal.helper.cache.inmemory.InMemoryCatalogRegion;
import com.kohls.mcommerce.opal.helper.cache.inmemory.InMemoryCategoryRegion;
import com.kohls.mcommerce.opal.helper.error.AppException;
import com.kohls.mcommerce.opal.helper.error.Error;
import com.kohls.mcommerce.opal.helper.json.JSONParsingHelper;
import com.kohls.mcommerce.opal.helper.json.JSONParsingHelper.IJSONParsingListener;
import com.worklight.wlclient.api.WLFailResponse;
import com.worklight.wlclient.api.WLResponse;
import com.worklight.wlclient.api.WLResponseListener;

import org.apache.http.Header;
import org.json.JSONObject;

import java.util.LinkedHashMap;

//import com.kohls.mcommerce.opal.framework.controller.impl.RefreshTokenControllerImpl;
//import com.kohls.mcommerce.opal.framework.controller.impl.SignInControllerImpl;
//import com.kohls.mcommerce.opal.modules.lnr.common.value.LnRConstantValues;

/**
 * This class is responsible for calling worklight adapters
 */
public class AdapterHelper implements CacheListener {

    private static final String HEADER_EXPIRES = "Expires";

    private AdapterProcedure mProcedure;

    private Object mParams;

    private IAdapterListener mAdapterListener;

    private AdapterOperation mOperation;

    private JSONParsingHelper mJsonParsingHelper;

    private HeaderObject headerObject;

    private WLResponse invocationResponse;

    private Context mContext;

    // Tag name for Logger
    private static final String TAG = AdapterHelper.class.getSimpleName();

    /**
     * Constructor
     *
     * @param procedure       Procedure to be called
     * @param po              Value object containing procedure parameter values
     * @param adapterListener Listener methods to be called
     */
    public AdapterHelper(AdapterProcedure procedure, Object po, IAdapterListener adapterListener, Context context) {
        this(procedure, po, adapterListener, null, context);
    }

    /**
     * @param procedure
     * @param po
     * @param adapterListener
     * @param headerObject
     */
    public AdapterHelper(AdapterProcedure procedure, Object po, IAdapterListener adapterListener,
                         HeaderObject headerObject, Context context) {
        mProcedure = procedure;
        mParams = po;
        mAdapterListener = adapterListener;
        mOperation = AdapterOperation.CONNECT;
        this.headerObject = headerObject;
        mContext = context;
    }

    /**
     * This method initiate adapter call
     */
    public void performTask() {
        if (!NetworkManager.getInstance(mContext).isClientConnect()) {
            mOperation = AdapterOperation.CONNECT;
            Logger.debug(TAG, "Connect request");
            NetworkManager.getInstance(mContext).getWLClient().connect(mWlResponseListener);
        } else {
            mOperation = AdapterOperation.PROCEDURE_CALL;
            callNetworkProcedure();
        }

    }

    /**
     * If the procedure call is for "productsForDimensions" then we try to get
     * data from the cache.
     *
     * @return true if data cache request is valid else returns false.
     */
    public boolean checkAndRequestDataFromCache() {
        if (mProcedure.getProcedureName().equalsIgnoreCase(
                AdapterProcedure.PRODUCT_FOR_DIMENSIONS.getProcedureName())) {
            InMemoryCatalogRegion catalogRegion = (InMemoryCatalogRegion) InMemoryCacheHelper
                    .getRegion(InMemoryCacheHelper.REGION_CATALOG, this);
            catalogRegion.get(NetworkUtils.createJsonFromModel(mParams).toString());
            Logger.error("********",
                    "************NetworkUtils.createJsonFromModel(mParams).toString()");
            return true;
        } else if (mProcedure.getProcedureName().equalsIgnoreCase(
                AdapterProcedure.PRODUCT_FOR_DEPARTMENTID.getProcedureName())) {
            InMemoryCategoryRegion categoryRegion = (InMemoryCategoryRegion) InMemoryCacheHelper
                    .getRegion(InMemoryCacheHelper.REGION_CATEGORY, this);
            categoryRegion.get(NetworkUtils.createJsonFromModel(mParams).toString());
            return true;
        } else if (mProcedure.getProcedureName().equalsIgnoreCase(
                AdapterProcedure.CMS_HOME.getProcedureName())) {
            InMemoryCMSRegion cmsRegion = (InMemoryCMSRegion) InMemoryCacheHelper.getRegion(
                    InMemoryCacheHelper.REGION_CMS, this);
            cmsRegion.get(NetworkUtils.createJsonFromModel(mParams).toString());
            return true;
        }
        return false;
    }

    /**
     * Save the response and expiry time into the cache. Expiry time is normally
     * read from the response header, but since Adapter response does not have
     * expiry time yet, we are hardcoding the expiry of Catalog data to 30
     * minutes
     *
     * @param response
     * @param mExpiryTime
     */
    public void saveDataintoCache(final WLResponse response, final long mExpiryTime) {
        IInMemoryCacheRegion mCacheRegion = null;
        if (mProcedure.getProcedureName().equalsIgnoreCase(
                AdapterProcedure.PRODUCT_FOR_DIMENSIONS.getProcedureName())) {
            mCacheRegion = InMemoryCacheHelper.getRegion(InMemoryCacheHelper.REGION_CATALOG, this);
        } else if (mProcedure.getProcedureName().equalsIgnoreCase(
                AdapterProcedure.PRODUCT_FOR_DEPARTMENTID.getProcedureName())) {
            mCacheRegion = InMemoryCacheHelper.getRegion(InMemoryCacheHelper.REGION_CATEGORY, this);
        } else if (mProcedure.getProcedureName().equalsIgnoreCase(
                AdapterProcedure.CMS_HOME.getProcedureName())) {
            mCacheRegion = InMemoryCacheHelper.getRegion(InMemoryCacheHelper.REGION_CMS, this);
        }

        if (mCacheRegion != null) {
            mCacheRegion.put(NetworkUtils.createJsonFromModel(mParams).toString(),
                    new InMemoryCacheVO(mExpiryTime, response.getResponseJSON().toString()));
        }
    }

    /**
     * Call the adapter procedure
     */
    private void callNetworkProcedure() {
        if (checkAndRequestDataFromCache()) {
            return;
        }
        requestAdapter();
        // Update user secure time
        // KohlsPhoneApplication.getInstance().getAuthenticationUtils().updateSecureTime();
    }

    /**
     * Listener for both WLClient.connect and Procedure response
     */
    private WLResponseListener mWlResponseListener = new WLResponseListener() {

        @Override
        public void onSuccess(WLResponse successResponse) {
            if (mOperation == AdapterOperation.CONNECT) {
                NetworkManager.getInstance(mContext).setClientConnect(true);
                Logger.debug(TAG, "Connect request finished.");
                callNetworkProcedure();
                mOperation = AdapterOperation.PROCEDURE_CALL;

            } else if (mOperation == AdapterOperation.PROCEDURE_CALL) {
                Logger.debug(TAG, "Connect request finished. " + mProcedure.getAdapterName()
                        + " ** " + mProcedure.getProcedureName() + " \n response" + successResponse);
                parseResponse(successResponse);

//                if (LnRConstantValues.DUMP_NETWORK_LOGS
//                        && (mAdapterListener instanceof RefreshTokenControllerImpl || mAdapterListener instanceof SignInControllerImpl)) {
//                    NetworkUtils.dumpIntoFile("successResponse= " + successResponse + "\n ",
//                            LnRConstantValues.LOG_FILE_NAME_TOKEN);
//                    NetworkUtils.dumpIntoFile(
//                            "current time in mill= " + System.currentTimeMillis() + "\n",
//                            LnRConstantValues.LOG_FILE_NAME_TOKEN);
//                }

            }
        }

        @Override
        public void onFailure(WLFailResponse failureResponse) {
            Logger.debug(TAG, " request failed." + mProcedure.getAdapterName() + " ** "
                    + mProcedure.getProcedureName());
            Error networkException = null;
            if (!checkAndRequestDataFromCache()) {
                if (mOperation == AdapterOperation.CONNECT) {
                    Logger.debug(TAG, "Connect request failed.");
                    if (!NetworkUtils.isNetworkConnected(mContext)) {
                        networkException = new Error(failureResponse, Error.ErrorType.NO_NETWORK);
                    } else {
                        networkException = new Error(failureResponse,
                                Error.ErrorType.ADAPTER_FAILURE);
                    }
                } else if (mOperation == AdapterOperation.PROCEDURE_CALL) {
                    Logger.debug(TAG, "Network request failed.");
                    if (!NetworkUtils.isNetworkConnected(mContext)) {
                        if (!NetworkUtils.isNetworkConnected(mContext)) {
                            networkException = new Error(failureResponse, Error.ErrorType.NO_NETWORK);
                        } else {
                            networkException = new Error(failureResponse, Error.ErrorType.ADAPTER_ERROR);
                        }
                    }
                    if (mAdapterListener != null) {
                        mAdapterListener.onFailure(networkException);
                    }
                }
            }
        }

    };

        /**
         * Listener for JSON Parsing and will be calling observer callback
         */
        private JSONParsingHelper.IJSONParsingListener mJsonParsingListener = new IJSONParsingListener() {

            @Override
            public void onParseSuccess(Message msg) {
                Logger.debug(TAG, "Parse request finished.");
                if (mAdapterListener != null) {
                    Error error = mAdapterListener.getPayloadError((IValueObject) msg.obj);
                    if (error == null) {

                        if (invocationResponse != null) {
                            long time = 0;
                            Header expiryTimeHeader = invocationResponse.getHeader(HEADER_EXPIRES);
                            String expiryTime;
                            if (expiryTimeHeader != null) {
                                expiryTime = expiryTimeHeader.getValue();
                                //time = NetworkUtils.getTimeinLong(expiryTime);
                            }

                            saveDataintoCache(invocationResponse, time);
                        }
                        if (mAdapterListener != null) {
                            mAdapterListener.onSuccess((IValueObject) msg.obj);
                        }
                    } else {
                        if (mAdapterListener != null) {
                            mAdapterListener.onFailure(error);
                        }
                    }
                }
            }

            @Override
            public void onParseFailure(Error ex) {
                Logger.debug(TAG, "Parse request failed.");
                if (mAdapterListener != null) {
                    mAdapterListener.onFailure(ex);
                }
            }
        };

        private void parseResponse(WLResponse response) {

            invocationResponse = response;
            JSONObject data = null;

            data = invocationResponse.getResponseJSON();
            Logger.debug(TAG, "*** ADAPTER RESPONSE: \n\t "
                    + ((data != null) ? data.toString() : "Response is null"));
            if (mProcedure.getValueObjectClass() == null) {
                ((AdapterValueListener) mAdapterListener).onSuccess(data.toString());
            } else {
                Logger.debug(TAG, "Parse request");
                mJsonParsingHelper = new JSONParsingHelper(mProcedure.getValueObjectClass(),
                        mJsonParsingListener);
                if (data != null) {
                    mJsonParsingHelper.execute(data.toString());
                } else {
                    if (mAdapterListener != null) {
                        mAdapterListener.onFailure(new com.kohls.mcommerce.opal.helper.error.Error(
                                new AppException("Exception while executing request")));
                    }
                }
            }
            data = null;
        }

        private void sendCacheResponse(InMemoryCacheVO response) {
            if (mProcedure.getValueObjectClass() == null && response.getmCacheData() != null) {
                ((AdapterValueListener) mAdapterListener).onSuccess(response.getmCacheData());
            } else {
                Logger.debug(TAG, "Parse request");
                mJsonParsingHelper = new JSONParsingHelper(mProcedure.getValueObjectClass(),
                        mJsonParsingListener);
                mJsonParsingHelper.execute(response.getmCacheData());
            }
        }

        // Cancel the adapter that is performing background operation.
        public void cancelAdapter() {
            if (mJsonParsingHelper != null && !mJsonParsingHelper.isCancelled()) {
                mJsonParsingHelper.cancel(true);
            }
            mAdapterListener = null;
            mJsonParsingListener = null;
        }

        @Override
        public void onCompleted(LinkedHashMap<String, InMemoryCacheVO> savedHashMap) {
            if (savedHashMap != null) {
                InMemoryCacheVO cacheData = savedHashMap.get(NetworkUtils
                        .createJsonFromModel(mParams).toString());
                if (cacheData != null) {
                    sendCacheResponse(cacheData);
                    return;
                }
            }
            requestAdapter();
        }

        private void requestAdapter() {

            String reqJson = NetworkUtils.createJsonFromModel(mParams);

//        if (LnRConstantValues.DUMP_NETWORK_LOGS
//                && (mAdapterListener instanceof RefreshTokenControllerImpl || mAdapterListener instanceof SignInControllerImpl)) {
//            NetworkUtils.dumpIntoFile(
//                    "mProcedure.getAdapterName()= " + mProcedure.getAdapterName() + "\n ",
//                    LnRConstantValues.LOG_FILE_NAME_TOKEN);
//            NetworkUtils.dumpIntoFile(
//                    "mProcedure.getProcedureName()= " + mProcedure.getProcedureName() + "\n ",
//                    LnRConstantValues.LOG_FILE_NAME_TOKEN);
//            NetworkUtils.dumpIntoFile("reqJson= " + reqJson + "\n",
//                    LnRConstantValues.LOG_FILE_NAME_TOKEN);
//            NetworkUtils.dumpIntoFile("current time in mill= " + System.currentTimeMillis()
//                    + "\n", LnRConstantValues.LOG_FILE_NAME_TOKEN);
//        }
//        if (LnRConstantValues.DUMP_NETWORK_LOGS) {
//            NetworkUtils.dumpIntoFile(
//                    "mProcedure.getAdapterName()= " + mProcedure.getAdapterName() + "\n ",
//                    LnRConstantValues.LOG_FILE_NAME);
//            NetworkUtils.dumpIntoFile(
//                    "mProcedure.getProcedureName()= " + mProcedure.getProcedureName() + "\n ",
//                    LnRConstantValues.LOG_FILE_NAME);
//            NetworkUtils.dumpIntoFile("reqJson= " + reqJson + "\n",
//                    LnRConstantValues.LOG_FILE_NAME);
//        }
//
            try {
                Logger.debug(TAG, "### Procedure called :" + mProcedure.getURI() + " Request params: " + reqJson);
                RequestProcessor.getInst().process(mProcedure, mParams, mWlResponseListener);
            } catch (Exception e) {
                Logger.error(TAG, "### REST Request Failed With Message : " + e.getMessage());
            }

        }
    }

