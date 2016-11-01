package com.kohls.mcommerce.opal.helper.adapter.rest.config;

/**
 * @author neeraj.kumar@kohls.com
 *
 */
public class Urls {
    private String javaMethodName;

    private String javaClass;

    private String method;

    private String uri;

    public String getJavaMethodName () {
        return javaMethodName;
    }

    public void setJavaMethodName (String javaMethodName) {
        this.javaMethodName = javaMethodName;
    }

    public String getJavaClass () {
        return javaClass;
    }

    public void setJavaClass (String javaClass) {
        this.javaClass = javaClass;
    }

    public String getMethod () {
        return method;
    }

    public void setMethod (String method) {
        this.method = method;
    }

    public String getUri () {
        return uri;
    }

    public void setUri (String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Urls [javaMethodName = "+javaMethodName+", javaClass = "+javaClass+", method = "+method+", uri = "+uri+"]";
    }
}