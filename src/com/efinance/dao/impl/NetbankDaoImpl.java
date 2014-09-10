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
	 * ������ת�˵�������ƽ̨,�ṩʳ��ع�
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
			tx = session.beginTransaction();  //��Ĭ������£�����һ��JDBC����
			session.save(ledger);
			session.save(thirdPlat);
			tx.commit(); //�ύ����
			session.close();
			} catch(Exception e) {
			tx.rollback();   //����ع�
			}
	}
	/**
	 * ��ѯ��ǰ�ĵ������˻������
	 */
	
	
	/**
	 * ��ѯ��ǰ�ķֻ��˿��������
	 */
	   
}
