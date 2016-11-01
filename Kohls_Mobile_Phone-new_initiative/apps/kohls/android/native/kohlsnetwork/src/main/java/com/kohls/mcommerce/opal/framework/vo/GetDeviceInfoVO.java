
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

public class GetDeviceInfoVO implements IValueObject {

    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Expose
    private Params params;

    public Params getParams() {
        return params;
    }

    public void setParams(Params params) {
        this.params = params;
    }

    public class Params implements IValueObject {
        @Expose
        private String jscallback;

        public String getJscallback() {
            return jscallback;
        }

        public void setJscallback(String jscallback) {
            this.jscallback = jscallback;
        }

    }
}
