package com.efinance.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
/**
 * ¶©µ¥ ´¦ÀíÂß¼­
 * @author Administrator
 *
 */
@Entity
@Table(name="transactioninfo")
public class TransactionInfo {
	
	private int TransactionID;
	private String TransactionType;
	private User Buyer;
	private User Seller;
	private Goods goods;
	private float Price;
	private int GoodsNum;
	private float GoodsAmount;
	private Date date;
	
	
	@Id
	@GeneratedValue
	public int getTransactionID() {
		return TransactionID;
	}
	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}
	@OneToOne
	@JoinColumn(name="SellerID")
	public User getSeller() {
		return Seller;
	}
	public void setSeller(User Seller) {
		this.Seller = Seller;
	}
	@OneToOne
	@JoinColumn(name="BuyerID")
	public User getBuyer() {
		return Buyer;
	}
	public void setBuyer(User buyer) {
		Buyer = buyer;
	}
	@Column
	public String getTransactionType() {
		return TransactionType;
	}
	@Column
	public void setTransactionType(String transactionType) {
		TransactionType = transactionType;
	}
	public float getPrice() {
		return Price;
	}
	public void setPrice(float price) {
		Price = price;
	}
	public int getGoodsNum() {
		return GoodsNum;
	}
	public void setGoodsNum(int goodsNum) {
		GoodsNum = goodsNum;
	}
	public float getGoodsAmount() {
		return GoodsAmount;
	}
	public void setGoodsAmount(float goodsAmount) {
		GoodsAmount = goodsAmount;
	}
	@OneToOne
	@JoinColumn(name="GoodsID")
	public Goods getGoods() {
		return goods;
	}
	public void setGoods(Goods goods) {
		this.goods = goods;
	}
	@Column
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
}
