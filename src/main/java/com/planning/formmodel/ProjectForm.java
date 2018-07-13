package com.planning.formmodel;

import java.util.List;

public class ProjectForm {

	private String name;
	private Float budget;
	private Long adminId;
	//private List<Long> phaseIds;
	// private Map<User, Float> users;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(long adminId) {
		this.adminId = adminId;
	}

//	public List<Long> getPhaseIds() {
//		return phaseIds;
//	}
//
//	public void setPhaseIds(List<Long> phaseIds) {
//		this.phaseIds = phaseIds;
//	}

}
