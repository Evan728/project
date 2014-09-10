package com.efinance.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import com.efinance.dao.NetbankDao;
import com.efinance.dao.UserDao;
import com.efinance.model.Ledger;
import com.efinance.model.ThirdPlat;
import com.efinance.model.User;
import com.efinance.util.DBUtilDao;

@Component("netbankDao")
public class NetbankDaoImpl extends BaseDao implements NetbankDao {
	private DBUtilDao utilDao;
	/**
	 * 从银行转账到第三方平台,提供食物回滚
	 */
	
	public void saveOrUpdate(Ledger ledger, ThirdPlat thirdPlat) {	
		
		
//		Session session=this.getSession();	
//		Transaction trans=session.beginTransaction();
//		String hql="insert into ThirdPlat plat where plat.id="+userId;
//		Query queryupdate=session.createQuery(hql);
//		int ret=queryupdate.executeUpdate();
		
//		trans.commit();
		Transaction tx=null;
		try {
			Session session = this.getSession();
			tx = session.beginTransaction();  //在默认情况下，开启一个JDBC事物
			session.save(ledger);
			session.save(thirdPlat);
			tx.commit(); //提交事务
			session.close();
			} catch(Exception e) {
			tx.rollback();   //事务回滚
			}
	}
	/**
	 * 查询当前的第三方账户的余额
	 */
	
	
	/**
	 * 查询当前的分户账可用余额、存款
	 */
	   
}
