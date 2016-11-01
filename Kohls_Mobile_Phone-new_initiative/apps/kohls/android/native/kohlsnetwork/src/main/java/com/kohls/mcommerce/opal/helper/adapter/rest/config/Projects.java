package com.kohls.mcommerce.opal.helper.adapter.rest.config;

/**
 * @author neeraj.kumar@kohls.com
 *
 */
public class Projects {

    private String name;

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "Projects [name = "+name+"]";
    }
}