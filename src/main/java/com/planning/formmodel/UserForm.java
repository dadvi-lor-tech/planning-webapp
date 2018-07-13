package com.planning.formmodel;

import com.planning.model.RightsStatus;

public class UserForm {

	private long id;
	private String firstName, lastName;
	private long profileId;
	private RightsStatus rightsStatus;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getProfileId() {
		return profileId;
	}

	public void setProfileId(long profileId) {
		this.profileId = profileId;
	}

	public RightsStatus getRightsStatus() {
		return rightsStatus;
	}

	public void setRightsStatus(RightsStatus rightsStatus) {
		this.rightsStatus = rightsStatus;
	}

}
