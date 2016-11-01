
package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;

import java.io.Serializable;
import java.util.List;

public class ListUIVO implements IValueObject {

    /**
	 * 
	 */
    private static final long serialVersionUID = 1L;

    @Expose
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Expose
    private Header header;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public class Header implements Serializable {

        /**
		 * 
		 */
        private static final long serialVersionUID = 2L;

        @Expose
        private String title;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Expose
        private List<WebButton> buttons;

        public List<WebButton> getButtons() {
            return buttons;
        }

        public void setButtons(List<WebButton> buttons) {
            this.buttons = buttons;
        }

        public class WebButton implements Serializable {

            /**
			 * 
			 */
            private static final long serialVersionUID = 3L;

            @Expose
            private String pos;

            @Expose
            private String type;

            @Expose
            private String title;

            @Expose
            private String click;

            @Expose
            private String jscallback;

            public String getPos() {
                return pos;
            }

            public void setPos(String pos) {
                this.pos = pos;
            }

            public String getType() {
                return type;
            }

            public void setType(String type) {
                this.type = type;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getClick() {
                return click;
            }

            public void setClick(String click) {
                this.click = click;
            }

            public String getJscallback() {
                return jscallback;
            }

            public void setJscallback(String jscallback) {
                this.jscallback = jscallback;
            }
        }

    }

}
