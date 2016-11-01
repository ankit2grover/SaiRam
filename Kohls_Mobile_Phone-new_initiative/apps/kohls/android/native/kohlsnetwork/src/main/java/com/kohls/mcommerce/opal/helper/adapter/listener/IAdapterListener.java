
package com.kohls.mcommerce.opal.helper.adapter.listener;

import com.kohls.mcommerce.opal.framework.vo.IValueObject;
import com.kohls.mcommerce.opal.helper.error.Error;

/**
 * Network listener that will be implemented by classes to notify components
 * that performed network task is successful or not.
 */
public interface IAdapterListener {
    /**
     * Called when performed network task is successful.
     */
    public void onSuccess(IValueObject valueObject);

    /**
     * Called when performed network task is not successful.
     */
    public void onFailure(Error ex);

    /**
     * @param payload
     * @return
     */
    public Error getPayloadError(IValueObject payload);

}
