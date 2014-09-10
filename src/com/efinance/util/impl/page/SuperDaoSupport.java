package com.efinance.util.impl.page;


import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;
@Component
public class SuperDaoSupport extends HibernateDaoSupport{
	@Resource(name="sessionFactory")
	public void setHibernateSessionFatory(SessionFactory SessionFactory){
		this.setSessionFactory(SessionFactory);
	}
}
