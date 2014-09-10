package com.efinance.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
/**
 * �˻���������ϸ�ˣ����ֻ���ϸ��
 * @author Administrator
 *
 */
@Entity
public class Subsidiary
 {
	private int id;
	private String accrual;//������
	private String direction;//�������
	private Date time;
	private User user;	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int s_id) {
		this.id = s_id;
	}
	@Column
	public String getAccrual() {
		return accrual;
	}
	public void setAccrual(String accrual) {
		this.accrual = accrual;
	}
	@Column
	public Date getTime() {
		return time;
	}
	public String getDirection() {
		return direction;
	}
	public void setDirection(String direction) {
		this.direction = direction;
	}
	public void setTime(Date time) {
		this.time = time;
	}		
	@ManyToOne(targetEntity=User.class)
	@JoinColumn(name="user_id")
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
