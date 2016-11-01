package com.kohls.mcommerce.opal.helper.adapter.rest.config;

/**
 * @author neeraj.kumar@kohls.com
 *
 */
public class FormParameters {

    private String javaType;

    private String parameterType;

    public String getJavaType () {
        return javaType;
    }

    public void setJavaType (String javaType) {
        this.javaType = javaType;
    }

    public String getParameterType () {
        return parameterType;
    }

    public void setParameterType (String parameterType) {
        this.parameterType = parameterType;
    }

    @Override
    public String toString() {
        return "FormParameters [javaType = "+javaType+", parameterType = "+parameterType+"]";
    }
}