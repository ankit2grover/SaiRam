
package com.kohls.mcommerce.opal.framework.vo;

import android.location.Location;
import android.location.LocationManager;

/**
 * Location Model used to interact with Location Controller.
 */
public class LocationVO {

    private Location location;

    private LocationManager locManager;

    private String keyWord;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public LocationManager getLocManager() {
        return locManager;
    }

    public void setLocManager(LocationManager locManager) {
        this.locManager = locManager;
    }

    public void setUserKeyWord(String keyWord) {
        this.locManager = locManager;
    }

}
