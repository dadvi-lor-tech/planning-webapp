package com.planning.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planning.model.Phase;
import com.planning.model.Profile;
import com.planning.model.Project;
import com.planning.model.RightsStatus;
import com.planning.model.User;

@Service
public class ProjectServiceImpl implements ProjectService {

	// @Autowired
	// ProjectDao projectDao;
	@Autowired
	private PhaseService phaseService;
	@Autowired
	private UserService userService;

	// TODO: find project in database
	public Project findProjectById(long id) {

		if (id != 2) return null; // Simule le fait que l'on ait qu'un projet d'id 2 en BDD
		
		Project proj = new Project(2, "Projet2", 1000, null, null, null);

		proj.setPhases(phaseService.findPhasesByProjectId(id));
		proj.setContributors(populateProject());
		return proj;
	}

	// TODO: get all projects from database
	public List<Project> getAllProjects() {
		List<Project> projectList = new ArrayList<>();

		Profile profil1 = new Profile(1, "TestProfile", (float) 100.0);
		User admin1 = new User(12, "Jean", "Dupont", profil1, RightsStatus.ADMIN);

		Project projet1 = new Project(1, "projet1", 3000, new HashMap<User, Float>(), new ArrayList<Phase>(), admin1);
		Project projet2 = new Project(2, "projet2", 3000, new HashMap<User, Float>(), new ArrayList<Phase>(), admin1);

		User user1 = new User(RightsStatus.BASIC_USER);
		user1.setId(1);
		user1.setFirstName("Louis");
		user1.setLastName("Guinard");

		User user2 = new User(RightsStatus.BASIC_USER);
		user2.setId(2);
		user2.setFirstName("David");
		user2.setLastName("Trochel");

		User user3 = new User(RightsStatus.BASIC_USER);
		user3.setId(3);
		user3.setFirstName("Samuel");
		user3.setLastName("Truffier-Blanc");

		Map<User, Float> map1 = new HashMap<User, Float>();
		map1.put(user1, (float) 1.0);
		map1.put(user2, (float) 2.0);
		projet1.setContributors(map1);

		Map<User, Float> map2 = new HashMap<User, Float>();
		map2.put(user2, (float) 1.0);
		map2.put(user3, (float) 2.0);
		projet2.setContributors(map2);

		projectList.add(projet1);
		projectList.add(projet2);
		return projectList;
	}

	// mockup pour ajouter des utilisateurs avec des tjm
	// TODO: delete this method after providing db access
	private Map<User, Float> populateProject() {
		List<User> allUserList = userService.getAllUsers();
		Map<User, Float> contributors = new HashMap<>();
		float tjm = 40;
		for (User user : allUserList) {
			contributors.put(user, tjm);
			tjm += 10;
		}
		return contributors;
	}

}
