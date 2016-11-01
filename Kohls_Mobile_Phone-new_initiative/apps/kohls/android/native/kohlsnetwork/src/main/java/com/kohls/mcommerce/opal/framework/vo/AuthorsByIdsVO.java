package com.kohls.mcommerce.opal.framework.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AuthorsByIdsVO implements IValueObject, Serializable {
	
    private static final long serialVersionUID = 1L;

	private Payload payload;

	public Payload getPayload() {
		return payload;
	}

	public void setPayload(Payload payload) {
		this.payload = payload;
	}

	public class Payload {

		@SerializedName("HasErrors")
		@Expose
		private Boolean hasErrors;
		@SerializedName("TotalResults")
		@Expose
		private Integer totalResults;
		@SerializedName("Results")
		@Expose
		private List<Result> results = new ArrayList<Result>();

		public Boolean getHasErrors() {
			return hasErrors;
		}

		public void setHasErrors(Boolean hasErrors) {
			this.hasErrors = hasErrors;
		}

		public Integer getTotalResults() {
			return totalResults;
		}

		public void setTotalResults(Integer totalResults) {
			this.totalResults = totalResults;
		}

		public List<Result> getResults() {
			return results;
		}

		public void setResults(List<Result> results) {
			this.results = results;
		}

	}

	public class Result {

		@SerializedName("UserNickname")
		@Expose
		private String userNickname;

		public String getUserNickname() {
			return userNickname;
		}

		public void setUserNickname(String userNickname) {
			this.userNickname = userNickname;
		}

	}
}
