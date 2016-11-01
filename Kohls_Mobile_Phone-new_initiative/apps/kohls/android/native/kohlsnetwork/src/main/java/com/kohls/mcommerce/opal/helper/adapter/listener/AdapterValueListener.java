
package com.kohls.mcommerce.opal.helper.adapter.listener;


public interface AdapterValueListener extends IAdapterListener {

    /**
     * Called when performed network task is successful.
     */
    public void onSuccess(String valueObject);

}
