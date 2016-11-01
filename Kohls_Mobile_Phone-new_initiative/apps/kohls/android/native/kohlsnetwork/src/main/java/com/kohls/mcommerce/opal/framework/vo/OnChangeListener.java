
package com.kohls.mcommerce.opal.framework.vo;

/**
 * Interface to bind contract for all model listeners
 * 
 * @author Perminder.Singh
 */
public interface OnChangeListener<T> {
    void onChange(T model);
}
