package com.kohls.mcommerce.opal.helper.adapter.rest.config;

/**
 * @author neeraj.kumar@kohls.com
 *
 */
public class QueryParameters {

    private String javaType;

    private String name;

    private String parameterType;

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getParameterType() {
        return parameterType;
    }

    public void setParameterType(String parameterType) {
        this.parameterType = parameterType;
    }

    @Override
    public String toString() {
        return "QueryParameters [javaType = " + javaType + ", name = " + name + ", parameterType = " + parameterType + "]";
    }
}