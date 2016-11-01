
package com.kohls.mcommerce.opal.helper.rest;

import com.android.volley.Request.Method;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.kohls.mcommerce.opal.common.app.KohlsPhoneApplication;
import com.kohls.mcommerce.opal.common.util.Logger;
import com.kohls.mcommerce.opal.helper.error.Error;
import com.kohls.mcommerce.opal.helper.rest.listener.IRestListener;

import org.json.JSONObject;

@SuppressWarnings("rawtypes")
public class RestHelperVolley implements Response.Listener, Response.ErrorListener {
    /**
     * Rest Helper Methods
     */
    public static enum RestHelperMethod {
        GET(Method.GET), POST(Method.PUT);

        private int method;

        private RestHelperMethod(int method) {
            this.method = method;
        }

        public int getMethod() {
            return method;
        }
    }

    private static final String TAG = RestHelperVolley.class.getSimpleName();

    private String mUrl;

    private IRestListener mIRestListener;

    private RestHelperMethod method;

    private JSONObject mPostJsonObject;

    public RestHelperVolley(String url, IRestListener restListener,
            RestHelperMethod restHelperMethod) {
        mUrl = url;
        mIRestListener = restListener;
        method = restHelperMethod;
    }

    public RestHelperVolley(String url, IRestListener restListener,
            RestHelperMethod restHelperMethod, JSONObject postJsonObject) {
        mUrl = url;
        mIRestListener = restListener;
        method = restHelperMethod;
        mPostJsonObject = postJsonObject;
    }

    /**
     * This method initiate rest call
     */
    @SuppressWarnings("unchecked")
    public void performTask() {
        KohlsPhoneApplication.getInstance().getRequestQueue()
                .add(new JsonObjectRequest(method.getMethod(), mUrl, mPostJsonObject, this, this));
    }

    @Override
    public void onErrorResponse(VolleyError arg0) {
        Error error = new Error(new Exception(arg0.getMessage()));
        Logger.debug(TAG, "onErrorResponse : " + error.getMessage());
        if (mIRestListener != null) {
            mIRestListener.onFailure(error);
        }
    }

    @Override
    public void onResponse(Object response) {
        Logger.debug(TAG, "onResponse");
        if (mIRestListener != null) {
            mIRestListener.onSuccess(response);
        }
    }
}
