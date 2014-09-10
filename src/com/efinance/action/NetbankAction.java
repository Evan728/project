package com.efinance.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.efinance.model.Ledger;
import com.efinance.model.ThirdPlat;
import com.efinance.service.NetbankService;
import com.opensymphony.xwork2.ActionSupport;
/**
 * ��Action��Ҫ����ת��֮����߼�����
 * @author wwy
 *
 */
@Component("netbankAction")
@Scope("prototype")
public class NetbankAction extends ActionSupport {
	private String netbank_account;//���п��˺�
	private String password;//���п�����
	private String money;//����ת�˽��
	private String trans_avail_money;//�ڵ�����ƽ̨�˻����������תΪ���Ľ��
	@Resource
	private NetbankService netbankService;
	public String login(){
		
		return "login_success";
		
	}
	/**
	 * ����ת�˵��������˻�
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
	 * �������תΪ���������
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
