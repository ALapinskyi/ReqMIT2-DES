package bw.khpi.reqmit.des.currentInfo;

import bw.khpi.reqmit.des.model.Requirement;

public class SelectedRequirement {
	
	private static Requirement requirement;

	public static Requirement getRequirement() {
		return requirement;
	}

	public static void setRequirement(Requirement requirement) {
		SelectedRequirement.requirement = requirement;
	}
	
	

}
