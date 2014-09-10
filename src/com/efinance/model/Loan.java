package com.efinance.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
@Entity
public class Loan {
	private int id;
	private String state;
	private User loaner;
	private Date starttime;
	private float loan_fund;
	private Date endtime;
	private String credit_card;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	@OneToOne
	@JoinColumn(name="user_id",unique=true)
	public User getLoaner() {
		return loaner;
	}
	public void setLoaner(User loaner) {
		this.loaner = loaner;
	}
	public Date getStarttime() {
		return starttime;
	}
	public void setStarttime(Date starttime) {
		this.starttime = starttime;
	}
	public float getLoan_fund() {
		return loan_fund;
	}
	public void setLoan_fund(float loan_fund) {
		this.loan_fund = loan_fund;
	}
	public Date getEndtime() {
		return endtime;
	}
	public void setEndtime(Date endtime) {
		this.endtime = endtime;
	}
	public String getCredit_card() {
		return credit_card;
	}
	public void setCredit_card(String credit_card) {
		this.credit_card = credit_card;
	}
	
}
