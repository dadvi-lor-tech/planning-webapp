package io.github.trochel.planning.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Phase implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private String name;
	private Date startDate;
	private Date endDate;
	private String startEvent;
	private String endEvent;
	private List<Phase> prerequisites;
	@ManyToOne
	private Project parentProject;
	@OneToMany  
	private Map<User, List<Charge>> charges;

	// CONSTRUCTORS
	public Phase() {
	}

	public Phase(long id, String name, Date startDate, Date endDate) {
		this.id = id;
		this.name = name;
		this.startDate = startDate;
		this.endDate = endDate;
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

	public Date getStartDate() {
		return startDate;
	}

	public Project getParentProject() {
		return parentProject;
	}

	public void setParentProject(Project parentProject) {
		this.parentProject = parentProject;
	}

	public Map<User, List<Charge>> getCharges() {
		return charges;
	}

	public void setCharges(Map<User, List<Charge>> charges) {
		this.charges = charges;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

}
