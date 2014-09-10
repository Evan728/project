package com.efinance.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

//贫血模型 充血模型
@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private int id;
	private String username;
	private String password;
	private String email;
	public User(){
		
	}
	public User(int id, String username, String password,String email){
		
		this.id = id;
		this.username = username;
		this.email = email;
		this.password=password;
	}
	public String getEmail() {
		return email;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public String getPassword() {
		return password;
	}
	public String getUsername() {
		return username;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setUsername(String username) {
		this.username = username;
	}
}
