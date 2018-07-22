package io.github.trochel.planning.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.trochel.planning.model.Charge;
import io.github.trochel.planning.model.Phase;
import io.github.trochel.planning.model.Profile;
import io.github.trochel.planning.model.Project;
import io.github.trochel.planning.model.RightsStatus;
import io.github.trochel.planning.model.User;

@Service
public class ProjectServiceImpl implements ProjectService {

	// @Autowired
	// ProjectDao projectDao;
	@Autowired
	private PhaseService phaseService;
	@Autowired
	private UserService userService;

	// Calcule le vrai budget du projet en fonction du nombre de jours de charge par
	// contributeur et des TJM spécifiques au projet
	public float computeRealBudget(Project project) {
		float realBudget = 0;
		for (Phase phase : project.getPhases()) {
			for (Entry<User, List<Charge>> entry : phase.getChargesByUser().entrySet()) {
				// récupère le tjm du contributeur (spécifique à ce projet)
				Float realTjm = project.getContributors().get(entry.getKey());

				// produit du tjm et du nombre de jours travaillés par ce contributeur pour
				// cette phase
				for (Charge charge : entry.getValue()) {
					realBudget += realTjm * charge.getNumberOfDaysReal();
				}
			}
		}
		return realBudget;
	}

	// TODO: find project in database
	public Project findProjectById(long id) {

		if (id != 2)
			return null; // Simule le fait que l'on ait qu'un projet d'id 2 en BDD

		Project proj = new Project(2, "Projet2", 1000, null);

		proj.setPhases(phaseService.findPhasesByProjectId(id));
		proj.setContributors(populateProject());
		return proj;
	}

	// TODO: get all projects from database
	public List<Project> getAllProjects() {
		List<Project> projectList = new ArrayList<>();

		Profile profil1 = new Profile(1, "TestProfile", (float) 100.0);
		User admin1 = new User(12, "Jean", "Dupont", profil1, RightsStatus.ADMIN);

		Project projet1 = new Project(1, "projet1", 3000, admin1);
		Project projet2 = new Project(2, "projet2", 3000, admin1);

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
