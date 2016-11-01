
package com.kohls.mcommerce.opal.helper.error;

import com.kohls.mcommerce.opal.R;
import com.kohls.mcommerce.opal.common.app.KohlsPhoneApplication;
import com.kohls.mcommerce.opal.common.util.Logger;
import com.kohls.mcommerce.opal.common.util.UtilityMethods;

import android.content.Context;
import android.widget.Toast;

/**
 * This class is used to handle application errors as a whole
 */
public class ErrorHelper {
    private static final String TAG = KohlsPhoneApplication.class.getSimpleName();

    public static boolean isApplicationManagable(Error error) {
        if (error.getErrorType() == Error.ErrorType.APPLICATION_EXCEPTION) {
            manageException(error);
        } else {
            return manageError(error);
        }
        return false;
    }

    private static void manageException(Error error) {
        Exception ex = error.getException();
        if (ex != null) {
            Logger.error(TAG, String.format("Exception is: Type: [%s], Message: [%s]",
                    error.getErrorType().getErrorDescription(),
                    ex.getMessage()));
            Logger.error(TAG, "Stack Trace ----->");
            ex.printStackTrace();
            Logger.error(TAG, "<----- Stack Trace");
        }
    }

    private static boolean manageError(Error error) {
        Context context = KohlsPhoneApplication.getContext();
        if (error.getErrorType() == Error.ErrorType.ADAPTER_FAILURE || error.getErrorType() == Error.ErrorType.ADAPTER_ERROR) {
            UtilityMethods.showToast(context,
                    context.getString(R.string.api_call_failed),
                    Toast.LENGTH_LONG);
            return true;
        } else if (error.getErrorType() == Error.ErrorType.NO_NETWORK) {
            UtilityMethods.showToast(context,
                    context.getString(R.string.no_network_connection),
                    Toast.LENGTH_LONG);

            return true;
        } else {
            return false;
        }
    }
}
