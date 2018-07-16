package io.github.trochel.planning.formmodel;

import java.util.Date;
import java.util.List;

import io.github.trochel.planning.model.Phase;
import io.github.trochel.planning.model.User;

public class PhaseForm {

	private long id;
	
	private long idParentProject;
	
	private String name;
	private int startWeek;
	private int endWeek;
	private String startEvent;
	private String endEvent;

	private List<Phase> prerequisites;
	private List<User> contributors;
	// private Map<YearMonth, Charge> charges;
	// private Map<User, Integer> contributors;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getIdParentProject() {
		return idParentProject;
	}

	public void setIdParentProject(long idParentProject) {
		this.idParentProject = idParentProject;
	}

	public int getStartWeek() {
		return startWeek;
	}

	public void setStartWeek(int startWeek) {
		this.startWeek = startWeek;
	}

	public int getEndWeek() {
		return endWeek;
	}

	public void setEndWeek(int endWeek) {
		this.endWeek = endWeek;
	}

	public String getStartEvent() {
		return startEvent;
	}

	public void setStartEvent(String startEvent) {
		this.startEvent = startEvent;
	}

	public String getEndEvent() {
		return endEvent;
	}

	public void setEndEvent(String endEvent) {
		this.endEvent = endEvent;
	}

	public List<Phase> getPrerequisites() {
		return prerequisites;
	}

	public void setPrerequisites(List<Phase> prerequisites) {
		this.prerequisites = prerequisites;
	}

	public List<User> getContributors() {
		return contributors;
	}

	public void setContributors(List<User> contributors) {
		this.contributors = contributors;
	}

	

}
