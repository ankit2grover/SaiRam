
package com.kohls.mcommerce.opal.helper.error;

/**
 * Application Exception class
 */
public class AppException extends Exception {
    private static final long serialVersionUID = 7296322336299920931L;

    private static final String PREFIX = "KOHLS_PHONE_EXCEPTION: ";

    public AppException(String message) {
        super(PREFIX + message);
    }
}
