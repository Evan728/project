package com.efinance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
/**
 * 交易流水账
 * @author Administrator
 *
 */
@Entity
public class JournalAccount {
	private int j_id;
	private User buyer;
	private User seller;
	private String amount;
	private Date date;
	private Goods goods;
	/**
	 * 第几次结算,正在交易、交易成功、退货、交易失败
	 */
	private int sequence;
	@Id
	@GeneratedValue
	public int getJ_id() {
		return j_id;
	}
	public void setJ_id(int j_id) {
		this.j_id = j_id;
	}
	@OneToOne
	@JoinColumn(name="buyer_id")
	public User getBuyer() {
		return buyer;
	}
	public void setBuyer(User buyer) {
		this.buyer = buyer;
	}
	@Column
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	@OneToOne
	@JoinColumn(name="seller_id")
	public User getSeller() {
		return seller;
	}
	public void setSeller(User seller) {
		this.seller = seller;
	}
	@Column
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@OneToOne
	@JoinColumn(name="goods_id")
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	
	public int getSequence() {
		return sequence;
	}
	@Column
	public void setSequence(int sequence) {
		this.sequence = sequence;
	}
	
}
