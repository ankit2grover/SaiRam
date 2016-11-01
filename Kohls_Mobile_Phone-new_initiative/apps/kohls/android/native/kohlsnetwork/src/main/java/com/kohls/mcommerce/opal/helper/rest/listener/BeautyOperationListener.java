
package com.kohls.mcommerce.opal.helper.rest.listener;



/**
 * Network listener that will be implemented by classes to notify components
 * that performed network task is successful or not.
 */
public interface BeautyOperationListener {
    /**
     * Called when performed network task is successful.
     */
    public void onSuccess(Object valueObject);

    /**
     * Called when performed network task is not successful.
     */
    public void onFailure(com.kohls.mcommerce.opal.helper.error.Error error);

    void getListItems(String listID);

    void createNewList(String subTitle);

    void getUserLists();

    void postItems(String dataStr);

    void postUser();

}
