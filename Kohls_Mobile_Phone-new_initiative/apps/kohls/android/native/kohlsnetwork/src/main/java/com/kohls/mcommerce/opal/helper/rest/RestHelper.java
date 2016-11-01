
package com.kohls.mcommerce.opal.helper.rest;

import com.kohls.mcommerce.opal.common.app.KohlsPhoneApplication;
import com.kohls.mcommerce.opal.common.util.Logger;
import com.kohls.mcommerce.opal.common.util.UtilityMethods;
import com.kohls.mcommerce.opal.helper.error.AppException;
import com.kohls.mcommerce.opal.helper.rest.listener.IRestListener;
import com.kohls.mcommerce.opal.modules.lnr.common.value.LnRConstantValues;

import android.os.AsyncTask;
import android.util.Log;

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

/**
 * This class is responsible for executing Rest Calls
 */
public class RestHelper {
    private static final String TAG = RestHelper.class.getSimpleName();

    public static enum Method {
        GET,
        POST,
        PUT
    };

    private IRestListener listener = null;

    private Method method;

    private String urlValue;

    private String requestParameterOrBody;

    private WeakHashMap<String, String> headers;

    public RestHelper(IRestListener listener,
            Method method,
            final String urlValue,
            String requestParameterOrBody,
            WeakHashMap<String, String> headers) {
        this.listener = listener;
        this.method = method;
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
            Log.d("PRK", "response is " + result);
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

        Log.d("PRK", "request url is " + newUrlValue);

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
                DataOutputStream outputStream = new DataOutputStream(urlConnection.getOutputStream());
                if (requestParameterOrBody != null) {
                    outputStream.writeBytes(requestParameterOrBody);
                }
                outputStream.flush();
                outputStream.close();
            }
            if (LnRConstantValues.DUMP_NETWORK_LOGS) {
                UtilityMethods.dumpIntoFile("url= " + newUrlValue + "\n ",
                        LnRConstantValues.LOG_FILE_NAME);
                UtilityMethods.dumpIntoFile("body= " + requestParameterOrBody + "\n",
                        LnRConstantValues.LOG_FILE_NAME);
            }

            int responseCode = urlConnection.getResponseCode();
            if (responseCode >= HttpURLConnection.HTTP_OK && responseCode < HttpURLConnection.HTTP_BAD_REQUEST) {
                urlInputStream = urlConnection.getInputStream();
                if (urlInputStream != null) {
                    response = readStream(urlInputStream);
                } else {
                    // getErrorStream() may contains HTML TAG which is unable to
                    // parse in GSON library so add response to null so we can
                    // handle response onpostexecute() listener
                    response = null;

                }

                String headerName;
                for (int index = 1; (headerName = urlConnection.getHeaderFieldKey(index)) != null; index++) {
                    if (headerName.equalsIgnoreCase(LnRConstantValues.SERVER_COOKIES)) {
                        parseAndSaveHeader(urlConnection.getHeaderField(index));
                        break;
                    }
                }

            }
        } catch (MalformedURLException e) {
            Logger.error(TAG, "MalformedURLException: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            Logger.error(TAG, "IOException: " + e.getMessage());
            // e.printStackTrace();
            // getErrorStream() may contains HTML TAG which is unable to parse
            // in GSON library so add response to null so we can handle response
            // onpostexecute() listener
            response = null;
        } catch (Exception e) {
            Logger.error(TAG, "Exception: " + e.getMessage());
        } finally {
            if (LnRConstantValues.DUMP_NETWORK_LOGS) {
                UtilityMethods.dumpIntoFile("response= " + response + "\n ",
                        LnRConstantValues.LOG_FILE_NAME);
            }
            if (urlConnection != null) {
                urlConnection.disconnect();
                urlInputStream = null;
            }
        }

        return response;
    }

    private void parseAndSaveHeader(String headerValue) {
        if (headerValue != null) {
            String jsessionId = null;
            String[] values = headerValue.split(";");
            if (values.length > 0) {
                for (int index = 0; values.length > index; index++) {
                    if (values[index].contains(LnRConstantValues.SERVER_JSESSIONID)) {
                        jsessionId = values[index].substring(values[index].indexOf('=') + 1,
                                values[index].length());
                        break;
                    }
                }
            }

            if (jsessionId != null) {
                saveJsessionId(jsessionId);
            }

        }
    }

    private void saveJsessionId(String sessionId) {
        KohlsPhoneApplication.getInstance()
                .getKohlsPref()
                .saveListOrRegistrySessionPref(LnRConstantValues.JSESSION_KEY_PREF_KEY, sessionId);

    }
}
