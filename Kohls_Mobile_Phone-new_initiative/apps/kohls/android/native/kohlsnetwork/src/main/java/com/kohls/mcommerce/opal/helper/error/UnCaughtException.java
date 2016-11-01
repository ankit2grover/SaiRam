
package com.kohls.mcommerce.opal.helper.error;

import com.crashlytics.android.Crashlytics;
import com.kohls.mcommerce.opal.BuildConfig;
import com.kohls.mcommerce.opal.common.util.Logger;
import com.kohls.mcommerce.opal.common.value.ConstantValues;
import com.kohls.mcommerce.opal.framework.view.activity.ErrorScreenActivity;

import android.app.Activity;
import android.content.Intent;

import java.lang.Thread.UncaughtExceptionHandler;

/**
 * Capture all uncaught exceptions
 */
public class UnCaughtException implements UncaughtExceptionHandler {
    private final Activity mActivity;

    public UnCaughtException(Activity activity) {
        mActivity = activity;
    }

    @Override
    public void uncaughtException(Thread thread,
            Throwable ex) {
        Logger.error("EXCEPTION", "Application Crashed");
        ex.printStackTrace();
        Crashlytics.logException(ex);
        if (BuildConfig.DEBUG) {
            ex.printStackTrace();
        }
        Intent intent = new Intent(mActivity.getBaseContext(), ErrorScreenActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        mActivity.startActivity(intent);
        mActivity.finish();

        System.exit(0);
    }
}
