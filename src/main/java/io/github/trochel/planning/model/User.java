package io.github.trochel.planning.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String firstName, lastName;
	@ManyToOne
	private Profile profile;
	private RightsStatus rightsStatus;
	@ManyToMany
	private List<Project> projects;
	// @OneToMany
	// private List<Charge> charges;

	// CONSTRUCTORS
	public User(long id, String firstName, String lastName, Profile profile, RightsStatus rightsStatus) {
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.profile = profile;
		this.rightsStatus = rightsStatus;
	}

	public User(RightsStatus rightsStatus) {
		this.rightsStatus = rightsStatus;
	}

	public User() {
	}

	// GETTERS / SETTERS
	public RightsStatus getRightsStatus() {
		return rightsStatus;
	}

	public void setRightsStatus(RightsStatus rightsStatus) {
		this.rightsStatus = rightsStatus;
	}

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

	public Profile getProfile() {
		return profile;
	}

	public void setProfile(Profile profile) {
		this.profile = profile;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	// public List<Charge> getCharges() {
	// return charges;
	// }
	//
	// public void setCharges(List<Charge> charges) {
	// this.charges = charges;
	// }

}
