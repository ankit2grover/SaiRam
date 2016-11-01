
package com.kohls.mcommerce.opal.helper.adapter;

/**
 * Enum to represent different network operations of APIs & also parsing
 * operation.
 */
public enum AdapterOperation {
    CONNECT("Connect to adapter"),
    PROCEDURE_CALL("Adapter Procedure"),
    PARSING("JSON Parsing");

    private AdapterOperation(String operationType) {
        this.mOperationType = operationType;
    }

    // Name of the operation type..
    private String mOperationType;

    // Get name of the operation type.
    public String getOperationType() {
        return mOperationType;
    }
}
