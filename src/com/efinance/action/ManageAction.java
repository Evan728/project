package com.efinance.action;


import java.util.LinkedHashMap;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.stereotype.Component;

import com.efinance.model.JournalAccount;
import com.efinance.model.Ledger;
import com.efinance.model.Subsidiary;
import com.efinance.model.ThirdPlat;
import com.efinance.model.TransactionInfo;
import com.efinance.model.User;
import com.efinance.util.DBUtilDao;
import com.efinance.util.impl.page.PageView;
import com.efinance.util.impl.page.ResultType;
import com.opensymphony.xwork2.ActionSupport;
@Component
public class ManageAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int page;
	private DBUtilDao utilDao;
	/**
	 * -------------查看所有订单---------------------------
	 * */
	public String findAllTransaction(){
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("TransactionID", "DESC");
		
		PageView<TransactionInfo> pageView=new PageView<TransactionInfo>(10,this.getPage());
		
		ResultType<TransactionInfo> rt= utilDao.fenye(TransactionInfo.class, pageView.getFirstResult(), pageView.getMaxResult(), orderby);
		pageView.setResultType(rt);
		
		ServletActionContext.getRequest().setAttribute("pageView", pageView);
		
		
		return "findAllTransaction";
	}
	
	/**
	 * -------------查看所有流水账---------------------------
	 * */
	public String findAllJournalAccount(){
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("j_id", "DESC");
		
		PageView<JournalAccount> pageView=new PageView<JournalAccount>(10,this.getPage());
		
		ResultType<JournalAccount> rt= utilDao.fenye(JournalAccount.class, pageView.getFirstResult(), pageView.getMaxResult(), orderby);
		pageView.setResultType(rt);
		
		ServletActionContext.getRequest().setAttribute("pageView", pageView);
		
		
		return "findAllJournalAccount";
	}
	/**
	 * 查看第三方账户
	 * */
	public String findThirdPlat(){
		
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("t_id", "DESC");
		
		PageView<ThirdPlat> pageView=new PageView<ThirdPlat>(10,this.getPage());
		
		ResultType<ThirdPlat> rt= utilDao.fenye(ThirdPlat.class, pageView.getFirstResult(), pageView.getMaxResult(), orderby);
		pageView.setResultType(rt);
		
		ServletActionContext.getRequest().setAttribute("pageView", pageView);
		
		return "findThirdPlat";
		
	}
	
	
	/**
	 * 
	 *查找所有分户账
	 **/
	public String findAllLedger(){
		
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("l_id", "DESC");
		
		PageView<Ledger> pageView=new PageView<Ledger>(10,this.getPage());
		
		ResultType<Ledger> rt= utilDao.fenye(Ledger.class, pageView.getFirstResult(), pageView.getMaxResult(), orderby);
		pageView.setResultType(rt);
		
		ServletActionContext.getRequest().setAttribute("pageView", pageView);
				
		return "findAllLedger";
	}
	
	/*查找所有明细账*/
	public String findAllSubsidiary(){
		
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("id", "DESC");
		
		PageView<Subsidiary> pageView=new PageView<Subsidiary>(10,this.getPage());
		
		ResultType<Subsidiary> rt= utilDao.fenye(Subsidiary.class, pageView.getFirstResult(), pageView.getMaxResult(), orderby);
		pageView.setResultType(rt);
		
		ServletActionContext.getRequest().setAttribute("pageView", pageView);
				
		return "findAllSubsidiary";
	}

	/**
	 * 查找所有用户
	 * */
	public String findAllUser(){
		
		LinkedHashMap<String, String> orderby = new LinkedHashMap<String, String>();
		orderby.put("id", "DESC");
		
		PageView<User> pageView=new PageView<User>(10,this.getPage());
		
		ResultType<User> rt= utilDao.fenye(User.class, pageView.getFirstResult(), pageView.getMaxResult(), orderby);
		pageView.setResultType(rt);
		
		ServletActionContext.getRequest().setAttribute("pageView", pageView);
				
		return "findAllUser";
	}
	
	
	
	/*---------------------SET和GET方法-----------------------------------*/
	public int getPage() {
		 return page<1?1:page;
	}
	public void setPage(int page) {
		this.page = page;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public DBUtilDao getDBUtilDao() {
		return utilDao;
	}

    @Resource(name="utilDao")
	public void setDBUtilDao(DBUtilDao utilDao) {
		this.utilDao = utilDao;
	}
	
	
}
