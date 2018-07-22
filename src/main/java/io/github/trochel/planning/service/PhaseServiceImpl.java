package io.github.trochel.planning.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.trochel.planning.model.Charge;
import io.github.trochel.planning.model.Phase;
import io.github.trochel.planning.model.User;

@Service
public class PhaseServiceImpl implements PhaseService {

	@Autowired
	private UserService userService;

	// TODO: find phases in database
	public List<Phase> findPhasesByProjectId(long id) {

		List<User> users = userService.getAllUsers();

		Date startDate1 = new Date(2018, 4, 8);
		Date endDate1 = new Date(2018, 8, 5);
		Phase phase1 = new Phase(14, "Première phase", startDate1, endDate1);

		Map<User, List<Charge>> chargesByUser1 = new HashMap<>();
		chargesByUser1.put(users.get(1), new ArrayList<Charge>());
		chargesByUser1.put(users.get(2), new ArrayList<Charge>());
		phase1.setChargesByUser(chargesByUser1);

		Date startDate2 = new Date(2018, 1, 10);
		Date endDate2 = new Date(2019, 4, 10);
		Phase phase2 = new Phase(16, "Deuxième phase", startDate2, endDate2);
		Map<User, List<Charge>> chargesByUser2 = new HashMap<>();
		chargesByUser2.put(users.get(0), new ArrayList<Charge>());
		phase2.setChargesByUser(chargesByUser2);

		Phase phase3 = new Phase(51, "Troisème phase", startDate2, endDate1);
		List<Phase> prerequisites = new ArrayList<>();
		prerequisites.add(phase1);
		prerequisites.add(phase2);
		phase3.setPrerequisites(prerequisites);

		Map<User, List<Charge>> chargesByUser3 = new HashMap<>();
		chargesByUser3.put(users.get(2), new ArrayList<Charge>());
		chargesByUser3.put(users.get(3), new ArrayList<Charge>());
		phase3.setChargesByUser(chargesByUser3);

		List<Phase> phases = new ArrayList<>();
		phases.add(phase1);
		phases.add(phase2);
		phases.add(phase3);
		return phases;
	}

}
