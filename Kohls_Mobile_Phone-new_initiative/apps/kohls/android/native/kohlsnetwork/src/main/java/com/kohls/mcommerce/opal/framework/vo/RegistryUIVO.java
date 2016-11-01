package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;
import java.util.List;

public class RegistryUIVO implements IValueObject {

	private static final long serialVersionUID = 1L;

	private String type;
	
	private List<SubTypes> subtypes;
	
	public List<SubTypes> getSubtypes() {
		return subtypes;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public class SubTypes implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 8430016243570918646L;
		
		private String type;
		
		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}
		
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
			private static final long serialVersionUID = -8174351239289493009L;
			
			private List<WebButtonReg> buttons = null;
			
			private String title;
			
			public List<WebButtonReg> getButtons() {
				return buttons;
			}

			public void setButtons(List<WebButtonReg> buttons) {
				this.buttons = buttons;
			}
			
			public String getTitle() {
				return title;
			}

			public void setTitle(String title) {
				this.title = title;
			}
			
			public class WebButtonReg implements Serializable {

				/**
				 * 
				 */
				private static final long serialVersionUID = 6144686097814055867L;
				
				private String type;
				
				private String title;
				
				private String pos;
				
				private String jscallback;

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

				public String getPos() {
					return pos;
				}

				public void setPos(String pos) {
					this.pos = pos;
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
}
