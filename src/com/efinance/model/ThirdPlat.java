package com.efinance.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ThirdPlat {
	
	private int t_id;

	private String balance;
	@Id
	@GeneratedValue
	public int getT_id() {
		return t_id;
	}
	
	public void setT_id(int t_id) {
		this.t_id = t_id;
	}
	
	public String getBalance() {
		return balance;
	}
	public void setBalance(String balance) {
		this.balance = balance;
	}
}
