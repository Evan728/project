package com.efinance.model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
@Entity
public class Goods {
	private int p_id;
	private String name;
	private User seller;
	private Set<User> buyer;
	
	@Id
	@GeneratedValue
	public int getP_id() {
		return p_id;
	}
	public void setP_id(int p_id) {
		this.p_id = p_id;
	}
	@Column
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@OneToOne
	@JoinColumn(name="seller_id",unique=true)
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	@OneToMany
	@JoinColumn(name="buyer_id")
	public Set<User> getBuyer() {
		return buyer;
	}
	public void setBuyer(Set<User> buyer) {
		this.buyer = buyer;
	} 
}
