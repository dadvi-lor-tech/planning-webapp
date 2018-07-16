package io.github.trochel.planning.model;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Project implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private float budget;
	@ManyToMany
	private Map<User, Float> contributors; // Associate User with real TJM for this project
	@OneToMany
	private List<Phase> phases;
	@ManyToOne
	private User admin;

	// CONSTRUCTORS
	public Project(long id, String name, float budget, User admin) {
		this.id = id;
		this.name = name;
		this.budget = budget;
		this.admin = admin;
	}

	public Project() {
	}

	// GETTERS/SETTERS
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

	public float getBudget() {
		return budget;
	}

	public void setBudget(float budget) {
		this.budget = budget;
	}

	public Map<User, Float> getContributors() {
		return contributors;
	}

	public void setContributors(Map<User, Float> contributors) {
		this.contributors = contributors;
	}

	public List<Phase> getPhases() {
		return phases;
	}

	public void setPhases(List<Phase> phases) {
		this.phases = phases;
	}

	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

}
