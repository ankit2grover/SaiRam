
package com.kohls.mcommerce.opal.common.po;

import java.util.List;

public class FlushCachePO {

    private Params params;

    public Params getparams() {
        return params;
    }

    public void setparams(Params params) {
        this.params = params;
    }

    public class Params {

        private List<Object> dataObject;

        public List<Object> getDataObject() {
            return dataObject;
        }

        public void setDataObject(List<Object> dataObject) {
            this.dataObject = dataObject;
        }
    }
}
