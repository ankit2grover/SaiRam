package com.kohls.mcommerce.opal.helper.adapter.rest;

import android.content.Context;

import com.worklight.wlclient.api.WLClient;

/**
 * Created by tkmaea9 on 7/21/15.
 */
public class NetworkManager {

    private static NetworkManager mInstance;

    private Context mApplicationContext;

    private WLClient mClient;

    private NetworkManager(Context applicationContext) {
        mApplicationContext = applicationContext;
    }


    public static NetworkManager getInstance(Context applicationContext) {
        if (mInstance == null) {
            mInstance = new NetworkManager(applicationContext);
        }
        return mInstance;
    }


    private boolean mIsClientConnect;

    public boolean isClientConnect() {
        return mIsClientConnect;
    }

    public void setClientConnect(boolean isClientConnect) {
        this.mIsClientConnect = isClientConnect;
    }


    public WLClient getWLClient() {
        if (mClient == null) {
            mClient = WLClient.createInstance(mApplicationContext);
        }
        return mClient;
    }
    }
