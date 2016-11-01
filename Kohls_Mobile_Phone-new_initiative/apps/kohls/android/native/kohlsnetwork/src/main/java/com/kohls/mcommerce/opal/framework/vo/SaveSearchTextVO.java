
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.util.List;

public class SaveSearchTextVO implements IValueObject {

    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Expose
    private List<SubType> subtypes;

    public List<SubType> getSubtypes() {
        return subtypes;
    }

    public void setSubtypes(List<SubType> subtypes) {
        this.subtypes = subtypes;
    }

    public class SubType implements IValueObject {

        @Expose
        private String type;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        @Expose
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
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
            private String searchText;

            public String getSearchText() {
                return searchText;
            }

            public void setSearchText(String searchText) {
                this.searchText = searchText;
            }

        }

    }
}
