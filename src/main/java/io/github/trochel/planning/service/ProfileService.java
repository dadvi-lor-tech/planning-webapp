package io.github.trochel.planning.service;

import java.util.List;

import io.github.trochel.planning.model.Profile;

public interface ProfileService {

	@Deprecated
	List<Profile> getProfilesByProjectId(long projectId);
	
	List<Profile> getAllProfiles();

	Profile findProfileById(long profileId);

}
