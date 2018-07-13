package com.planning.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Profile implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	private float tjmBase;
	@OneToMany
	private List<User> users;

	// CONSTRUCTORS
	public Profile(long id, String name, float tjmBase) {
		this.id = id;
		this.name = name;
		this.tjmBase = tjmBase;
	}

	public Profile() {
	}

	// GETTERS / SETTERS
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

	public float getTjmBase() {
		return tjmBase;
	}

	public void setTjmBase(float tjmBase) {
		this.tjmBase = tjmBase;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

}
