package com.kohls.mcommerce.opal.framework.vo;

public class LoyaltyThresholdVO {
	
	private Profile profile;
	
	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public class Profile {
		
		private String pointThreshold;

		public void setPointThreshold(String pointThreshold) {
			this.pointThreshold = pointThreshold;
		}
		
	}

}
