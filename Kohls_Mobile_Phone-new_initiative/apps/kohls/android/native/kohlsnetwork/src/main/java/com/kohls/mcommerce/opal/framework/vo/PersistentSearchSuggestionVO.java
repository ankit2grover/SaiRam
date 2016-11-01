package com.kohls.mcommerce.opal.framework.vo;

import java.io.Serializable;
import java.util.List;

public class PersistentSearchSuggestionVO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private List<String> Suggestions;

	public List<String> getSuggestions() {
		return Suggestions;
	}

	public void setSuggestions(List<String> suggestions) {
		Suggestions = suggestions;
	}
	
	

}
