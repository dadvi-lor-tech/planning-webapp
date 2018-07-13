package com.planning.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.planning.model.Profile;

@Service
public class ProfileServiceImpl implements ProfileService {

	// @Autowired
	// private ProfileDao profileDao;

	// TODO: récupérer le profil en BDD
	public Profile findProfileById(long profileId) {
		return new Profile(1, "Développeur", (float) 80.0);
	}

	// TODO: récuperer en BDD tous les profils
	public List<Profile> getAllProfiles() {
		List<Profile> profiles = new ArrayList<Profile>();

		Profile profil1 = new Profile(1, "Développeur", (float) 80.0);
		Profile profil2 = new Profile(2, "Consultant", (float) 90.0);
		profiles.add(profil1);
		profiles.add(profil2);
		return profiles;
	}

	// TODO: récuperer en BDD la liste des profils associés aux contributeurs du
	// projet
	@Deprecated
	public List<Profile> getProfilesByProjectId(long projectId) {
		List<Profile> profileList = new ArrayList<>();
		Profile profile = new Profile(23, "super profile", 15);
		profileList.add(profile);
		return profileList;
	}

}
