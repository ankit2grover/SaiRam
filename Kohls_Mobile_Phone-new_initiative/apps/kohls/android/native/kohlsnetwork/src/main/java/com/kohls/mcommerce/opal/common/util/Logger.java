
package com.kohls.mcommerce.opal.common.util;

import com.kohls.mcommerce.opal.common.value.ConstantValues;

import android.util.Log;

/**
 * Custom logger to implement debug flag
 */
public class Logger {

    public static void debug(String tag,
            String message) {
    	if (ConstantValues.APP_DEBUG) {
    		Log.d(tag, message);
    	}
    }

    public static void error(String tag,
            String message) {
    	if (ConstantValues.APP_DEBUG) {
    		Log.e(tag, message);
    	}
    }
    
    public static void error(String tag,
            String message, Throwable tr) {
    	if (ConstantValues.APP_DEBUG) {
    		Log.e(tag, message, tr);
    	}
    }
}
