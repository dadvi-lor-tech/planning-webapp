package com.planning.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Charge implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	private int year; // A peut être rechanger
	private int monthNumber;
	private float numberOfDaysEstim;
	private float numberOfDaysReal;
	private float expenseEstim;
	private float expenseReal;
	@ManyToOne
	private Phase parentPhase;
//	@ManyToOne
//	private User user;


	// CONSTRUCTORS
	public Charge(long id, float numberOfDaysEstim, float numberOfDaysReal, float expenseEstim, float expenseReal) {
		this.id = id;
		this.numberOfDaysEstim = numberOfDaysEstim;
		this.numberOfDaysReal = numberOfDaysReal;
		this.expenseEstim = expenseEstim;
		this.expenseReal = expenseReal;
	}

	public Charge() {
	}

	// GETTERS / SETTERS
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public float getNumberOfDaysEstim() {
		return numberOfDaysEstim;
	}
	public void setNumberOfDaysEstim(float numberOfDaysEstim) {
		this.numberOfDaysEstim = numberOfDaysEstim;
	}
	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonthNumber() {
		return monthNumber;
	}

	public void setMonthNumber(int monthNumber) {
		this.monthNumber = monthNumber;
	}	
	public float getNumberOfDaysReal() {
		return numberOfDaysReal;
	}
	public void setNumberOfDaysReal(float numberOfDaysReal) {
		this.numberOfDaysReal = numberOfDaysReal;
	}
	public float getExpenseEstim() {
		return expenseEstim;
	}
	public void setExpenseEstim(float expenseEstim) {
		this.expenseEstim = expenseEstim;
	}
	public float getExpenseReal() {
		return expenseReal;
	}
	public void setExpenseReal(float expenseReal) {
		this.expenseReal = expenseReal;
	}
	public Phase getParentPhase() {
		return parentPhase;
	}

	public void setParentPhase(Phase parentPhase) {
		this.parentPhase = parentPhase;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}

}
