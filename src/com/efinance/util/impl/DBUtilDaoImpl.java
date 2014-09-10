package com.efinance.util.impl;

import java.util.LinkedHashMap;

import javax.persistence.Entity;

import org.hibernate.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.efinance.dao.impl.BaseDao;
import com.efinance.util.DBUtilDao;
import com.efinance.util.impl.page.ResultType;

@Transactional
@Component("utilDao")
public class DBUtilDaoImpl extends BaseDao implements DBUtilDao {
	
	public  void delete(Object o) {
		this.getHibernateTemplate().delete(o);
	}

	public  void delete(Object[] os) {
		for(Object o : os){
			this.getHibernateTemplate().delete(o);
		}
	}
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> T get(Class<T> entityClass, Integer oId) {
		return	(T)this.getSession().get(entityClass, oId);
		
	}

	public void save(Object o) {
		this.getHibernateTemplate().save(o);
	}

	public void update(Object o) {
		this.getHibernateTemplate().merge(o);
	}


	// 分页排序主代码
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	// o.x1=?1 and o.x2=?2.....
	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult, String wherespql, Object[] queryParams,
			LinkedHashMap<String, String> orderBy) {
		ResultType<T> rt = new ResultType<T>();

		String entityName = getEntityClass(entityClass);
		String orderby = createOrderBy(orderBy);
		
		Query query = this.getSession().createQuery("select o from " + entityName + " o " + (wherespql == null ? "" : "where " + wherespql)
						+ orderby);
		if(firstIndex!=-1 && maxResult!=-1)query.setFirstResult(firstIndex).setMaxResults(maxResult);
		setQueryParam(query, queryParams);
		rt.setResultList(query.list());

		query = this.getSession().createQuery(
				"select o from " + entityName + " o "+ (wherespql == null ? "" : "where " + wherespql)+ orderby);
		setQueryParam(query, queryParams);
		rt.setTotalRecord(query.list().size());

		return rt;
	}

	// 不带条件的分页查询
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult, LinkedHashMap<String, String> orderBy) {

		return fenye(entityClass,firstIndex,maxResult,null,null,orderBy);
	}

    //  最简单的分页查询
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult) {

		return fenye(entityClass,firstIndex,maxResult,null,null,null);
	}

	
     //  不排序的待条件分页查询
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> ResultType<T> fenye(Class<T> entityClass, int firstIndex,
			int maxResult, String wherespql, Object[] queryParams) {
		return fenye(entityClass,firstIndex,maxResult,wherespql,queryParams,null);
	}
	
    //  不分页查询
	@Transactional(readOnly = true, propagation = Propagation.NOT_SUPPORTED)
	public <T> ResultType<T> fenye(Class<T> entityClass) {
		return fenye(entityClass,-1,-1,null,null,null);
	}

	protected void setQueryParam(Query query, Object[] queryParams) {
		if (queryParams != null && queryParams.length > 0) {
			for (int i = 0; i < queryParams.length; i++) {
				query.setParameter(i, queryParams[i]);
			}
		}
	}

	// 获取实体名称
	protected <T> String getEntityClass(Class<T> entityClass) {
		String entityName = "";
		entityName = entityClass.getSimpleName();
		Entity entity = entityClass.getAnnotation(Entity.class);
		if (entity != null & !"".equals(entity.name())) {
			entityName = entity.name();
		}
		return entityName;
	}

	// 指定排序条件
	// order by o.key desc,o.key2 AES
	protected String createOrderBy(LinkedHashMap<String, String> orderBy) {
		StringBuffer orderby = new StringBuffer("");
		if (orderBy != null && orderBy.size() > 0) {
			orderby.append(" order by ");
			for (String key : orderBy.keySet()) {
				orderby.append("o.").append(key).append(" ").append(
						orderBy.get(key)).append(",");
			}
			orderby.deleteCharAt(orderby.length() - 1);
		}
		return orderby.toString();
	}

}
