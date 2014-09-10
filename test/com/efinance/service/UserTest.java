package com.efinance.service;

import static org.junit.Assert.*;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.Test;

public class UserTest {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Test
	public void test() {
		Session session=getSessionFactory().getCurrentSession();	
		Transaction trans=session.beginTransaction();
		String hql="delete from User user where user.id=2";
		Query queryupdate=session.createQuery(hql);
		int ret=queryupdate.executeUpdate();
		trans.commit();
		fail("Not yet implemented");
	}

}
