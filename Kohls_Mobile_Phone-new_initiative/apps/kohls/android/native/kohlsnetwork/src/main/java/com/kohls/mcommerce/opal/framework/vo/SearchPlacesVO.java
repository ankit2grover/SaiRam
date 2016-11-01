
package com.kohls.mcommerce.opal.framework.vo;

import android.location.Address;

import java.util.Locale;

public class SearchPlacesVO extends Address implements IValueObject {

    public SearchPlacesVO(Locale locale) {
        super(locale);
    }

}
