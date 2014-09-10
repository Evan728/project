package com.efinance.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.efinance.model.Ledger;
import com.efinance.model.ThirdPlat;
import com.efinance.service.NetbankService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * 此Action主要用于转账之类的逻辑处理
 * @author wwy
 *
 */
@Component("netbankAction")
@Scope("prototype")
public class NetbankAction extends ActionSupport {
	private String netbank_account;//银行卡账号
	private String password;//银行卡密码
	private String money;//网银转账金额
	private String trans_avail_money;//在第三方平台账户可用余额中转为存款的金额
	@Resource
	private NetbankService netbankService;
	public String login(){
		
		return "login_success";
		
	}
	/**
	 * 银行转账到第三方账户
	 * @return
	 */
	public String transfer_accounts(){
		Ledger ledger=new Ledger();
		ledger.setBalance(money);
		ThirdPlat thirdPlat=new ThirdPlat();
		thirdPlat.setBalance(money);
		netbankService.update(ledger, thirdPlat);
		return "transfer_success";
		
	}
	/**
	 * 可用余额转为第三方存款
	 * @return
	 */
	public String available_transfer(){

		
		return "available_transfer";
		
	}
	public String getNetbank_account() {
		return netbank_account;
	}

	public void setNetbank_account(String netbank_account) {
		this.netbank_account = netbank_account;
	}
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	public String getMoney() {
		return money;
	}
	public void setMoney(String money) {
		this.money = money;
	}
	public String getTrans_avail_money() {
		return trans_avail_money;
	}
	public void setTrans_avail_money(String trans_avail_money) {
		this.trans_avail_money = trans_avail_money;
	}

}
