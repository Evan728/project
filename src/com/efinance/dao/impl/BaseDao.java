package com.efinance.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Component;


@Component("baseDao")
public class BaseDao extends HibernateDaoSupport{
	//为父类HibernateDaoSupport注入sessionFactory的值
	  @Resource(name="sessionFactory")
	public void baseSessionFactory(SessionFactory sessionFactory){
		super.setSessionFactory(sessionFactory);
	}
}
