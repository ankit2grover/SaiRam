
package com.kohls.mcommerce.opal.helper.rest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.WeakHashMap;

import android.os.AsyncTask;
import android.util.Log;

import com.kohls.mcommerce.opal.common.util.Logger;
import com.kohls.mcommerce.opal.helper.error.AppException;
import com.kohls.mcommerce.opal.helper.rest.listener.BeautyOperationListener;
import com.kohls.mcommerce.opal.wallet.util.Constants;

/**
 * This class is responsible for executing Rest Calls
 */
public class BeautyRestHelper {
    private static final String TAG = BeautyRestHelper.class.getSimpleName();

    public static enum Method {
        GET,
        POST,
        PUT
    };

    private BeautyOperationListener listener = null;

    private Method method;

    private String urlValue;

    private String requestParameterOrBody;
    
    public String listExists;

    public String getListExists() {
		return listExists;
	}

	public void setListExists(String listExists) {
		this.listExists = listExists;
	}

	private WeakHashMap<String, String> headers;

    public BeautyRestHelper(BeautyOperationListener listener,
            Method get,
            final String urlValue,
            String requestParameterOrBody,
            WeakHashMap<String, String> headers) {
        this.listener = listener;
        this.method = get;
        this.urlValue = urlValue;
        this.requestParameterOrBody = requestParameterOrBody;
        this.headers = headers;
    }

    public void performTask() {
        task.execute();
    }

    private AsyncTask<Void, Void, String> task = new AsyncTask<Void, Void, String>() {

        @Override
        protected void onPostExecute(String result) {

            if (result != null) {
                listener.onSuccess(result);
            } else {
                listener.onFailure(new com.kohls.mcommerce.opal.helper.error.Error(new AppException("Exception while executing request")));
            }
            super.onPostExecute(result);
        }

        @Override
        protected String doInBackground(Void... params) {
            String result = performRequestOperation();
            return result;
        }

    };

    private static String readStream(InputStream in) {
        BufferedReader reader = null;
        StringBuilder builder = new StringBuilder();
        try {
            reader = new BufferedReader(new InputStreamReader(in));
            String line = "";
            while (reader != null && (line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            Logger.error(TAG, "Error while processing input stream: " + e.getMessage());
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return builder.toString();
    }

    private String performRequestOperation() {
        String response = null;
        String newUrlValue = null;

        if (Method.GET == method && requestParameterOrBody != null) {
            newUrlValue = urlValue + "?" + requestParameterOrBody;
        } else {
            newUrlValue = urlValue;
        }

        URL url = null;
        InputStream urlInputStream = null;
        HttpURLConnection urlConnection = null;
        try {
            url = new URL(newUrlValue);

            urlConnection = (HttpURLConnection) url.openConnection();

            // Setting Method
            urlConnection.setRequestMethod(method.name());
            if (headers != null) {
                Iterator<String> itHeaders = headers.keySet().iterator();
                String headerName = null;
                String headerValue = null;

                // Setting Headers
                while (itHeaders.hasNext()) {
                    headerName = itHeaders.next();
                    headerValue = headers.get(headerName);
                    urlConnection.setRequestProperty(headerName, headerValue);
                }
            }
            // Adding object in Post Body
            if (Method.POST == method || Method.PUT == method) {
                DataOutputStream outputStream =
                        new DataOutputStream(urlConnection.getOutputStream());
                if (requestParameterOrBody != null) {
                    outputStream.writeBytes(requestParameterOrBody);
                }
                outputStream.flush();
                outputStream.close();
            }

            urlInputStream = urlConnection.getInputStream();
            if (urlInputStream != null) {
                response = readStream(urlInputStream);
            }
        } catch (MalformedURLException e) {
            Logger.error(TAG, "MalformedURLException: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            Logger.error(TAG, "IOException: " + e.getMessage());
            // e.printStackTrace();
            urlInputStream = urlConnection.getErrorStream();
            if (urlInputStream != null) {
                response = readStream(urlInputStream);
            }
        } catch (Exception e) {
            Logger.error(TAG, "Exception: " + e.getMessage());
        } finally {

            if (urlConnection != null) {
                urlConnection.disconnect();
                urlInputStream = null;
            }
        }
Log.i("INFO::::", "*****RESPONSE TO READ****"+response);
Constants.GET_USERS_LISTS=response;
setListExists(response);
        return response;
    }
}
