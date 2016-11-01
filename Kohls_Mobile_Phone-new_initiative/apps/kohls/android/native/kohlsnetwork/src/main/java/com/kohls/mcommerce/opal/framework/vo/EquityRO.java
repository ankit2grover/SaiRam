
package com.kohls.mcommerce.opal.framework.vo;

import java.util.ArrayList;
import java.util.List;

public class EquityRO {

    private Payload payload;

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public class Payload {

        private List<Equity> equities = new ArrayList<Equity>();

        public List<Equity> getEquities() {
            return equities;
        }

        public void setEquities(List<Equity> equities) {
            this.equities = equities;
        }

    }

    public static class Equity {

        private String type;

        private String resourcePathLarge;

        private String resourcePathSmall;

        private String resourcePath;

        private Integer index;

        private Integer ID;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getResourcePathLarge() {
            return resourcePathLarge;
        }

        public void setResourcePathLarge(String resourcePathLarge) {
            this.resourcePathLarge = resourcePathLarge;
        }

        public String getResourcePathSmall() {
            return resourcePathSmall;
        }

        public void setResourcePathSmall(String resourcePathSmall) {
            this.resourcePathSmall = resourcePathSmall;
        }

        public String getResourcePath() {
            return resourcePath;
        }

        public void setResourcePath(String resourcePath) {
            this.resourcePath = resourcePath;
        }

        public Integer getIndex() {
            return index;
        }

        public void setIndex(Integer index) {
            this.index = index;
        }

        public Integer getID() {
            return ID;
        }

        public void setID(Integer ID) {
            this.ID = ID;
        }

    }
}
