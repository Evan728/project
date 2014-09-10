package com.efinance.dao.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;
import com.efinance.dao.UserDao;
import com.efinance.model.User;

@Component("userDao")
public class UserDaoImpl extends BaseDao implements UserDao {
	
	public void save(User u) {
		getHibernateTemplate().save(u);		
	}
	
	public void delete(User user) {
		getHibernateTemplate().delete(user);	
	}
	public User verifyUser(String username, String password) {
		//�����ݿ�ȡuser
		List<User> users = getHibernateTemplate().find("from User u where u.username = '" + username + "' and u.password = '" + password + "'");
		if(users.isEmpty()){
			return null;
		}else{
			return users.get(0);
		}
	}
	public boolean checkUserExistsWithName(String username) {
		List<User> users = getHibernateTemplate().find("from User u where u.username = '" + username + "'");	
		if(users != null && users.size() > 0) {
			return true;
		}
		return false;
	}

	public User completeUserMessage(User user) {
		getHibernateTemplate().update(user);
		return null;
	}
/*
 * (non-Javadoc)�д���֤���÷����Ŵα�java.lang.NullPointerException
 * @see com.efinance.dao.UserDao#deleteUserById(int)
 */
	public void deleteUserById(int id) {
		
	/*	ֻ����this.getSession()��������Sessionʱ�Ų������
		����sessionFactory.getCurrentSession()��������java.lang.NullPointerException����;
		*/
		Session session=this.getSession();	
		Transaction trans=session.beginTransaction();
		String hql="delete from User user where user.id="+id;
		Query queryupdate=session.createQuery(hql);
		int ret=queryupdate.executeUpdate();
		trans.commit();
	}
//	public User findUserById(Integer id){
//		return (User)sessionFactory.getCurrentSession().createQuery("from User u where u.id = ?")
//		.setParameter(0, id)
//		.uniqueResult();
//	
//	}
	   
}
