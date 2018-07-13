package com.planning.service;

import java.util.List;

import com.planning.model.Profile;

public interface ProfileService {

	@Deprecated
	List<Profile> getProfilesByProjectId(long projectId);
	
	List<Profile> getAllProfiles();

	Profile findProfileById(long profileId);

}
