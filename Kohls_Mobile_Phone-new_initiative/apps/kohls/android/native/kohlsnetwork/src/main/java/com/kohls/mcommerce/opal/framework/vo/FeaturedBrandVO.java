
package com.kohls.mcommerce.opal.framework.vo;

import java.util.ArrayList;
import java.util.List;

public class FeaturedBrandVO {

    private List<Featuredbrand> featuredbrands = new ArrayList<Featuredbrand>();

    public List<Featuredbrand> getFeaturedbrands() {
        return featuredbrands;
    }

    public void setFeaturedbrands(List<Featuredbrand> featuredbrands) {
        this.featuredbrands = featuredbrands;
    }

    public class Featuredbrand {

        private String resourceID;

        private String title;

        public String getResourceID() {
            return resourceID;
        }

        public void setResourceID(String resourceID) {
            this.resourceID = resourceID;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

    }

}
