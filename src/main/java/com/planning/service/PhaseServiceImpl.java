package com.planning.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planning.model.Charge;
import com.planning.model.Phase;
import com.planning.model.User;

@Service
public class PhaseServiceImpl implements PhaseService {
	
	@Autowired
	private UserService userService;

	//TODO: find phases in database
	@SuppressWarnings("deprecation")
	public List<Phase> findPhasesByProjectId(long id) {
		
		List<User> users = userService.getAllUsers();

		Date startDate1 = new Date(2018, 4, 8);
		Date endDate1 = new Date(2018, 8, 5);
		Phase phase1 = new Phase(14, "Première phase", startDate1, endDate1);

		Map<User, List<Charge>> contributors1 = new HashMap<User, List<Charge>>();
		contributors1.put(users.get(1), new ArrayList<Charge>());
		contributors1.put(users.get(2), new ArrayList<Charge>());
		phase1.setCharges(contributors1);

		Date startDate2 = new Date(2018, 1, 10);
		Date endDate2 = new Date(2019, 4, 10);
		Phase phase2 = new Phase(16, "Deuxième phase", startDate2, endDate2);
		Map<User, List<Charge>> contributors2 = new HashMap<User, List<Charge>>();
		contributors2.put(users.get(0), new ArrayList<Charge>());
		phase2.setCharges(contributors2);

		Phase phase3 = new Phase(51, "Troisème phase", startDate2, endDate1);
		List<Phase> prerequisites = new ArrayList<>();
		prerequisites.add(phase1);
		prerequisites.add(phase2);
		phase3.setPrerequisites(prerequisites);
		
		Map<User, List<Charge>> contributors3 = new HashMap<User, List<Charge>>();
		contributors3.put(users.get(2), new ArrayList<Charge>());
		contributors3.put(users.get(3), new ArrayList<Charge>());
		phase3.setCharges(contributors3);

		List<Phase> phases = new ArrayList<>();
		phases.add(phase1);
		phases.add(phase2);
		phases.add(phase3);
		return phases;
	}

}
