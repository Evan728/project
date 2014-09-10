package com.efinance.dao.impl;

import javax.annotation.Resource;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;

import com.efinance.dao.CommentDao;
import com.efinance.model.Comment;
import com.efinance.util.DBUtilDao;



@Component("commentDao")
public  class CommentDaoImpl extends BaseDao implements CommentDao{
	
	private DBUtilDao utilDao;
	private SessionFactory sessionFactory;

	public void addComment(Comment comment) {
		utilDao.save(comment);
	}

	public void deleteComment(Comment comment) {
		utilDao.delete(comment);
	}

	public Comment findCommentById(Integer id) {
		
		return (Comment) sessionFactory.getCurrentSession().createQuery("from Comment c where c.c_id=?")
		       .setParameter(0, id).uniqueResult();
	}

	public void updateComment(Comment comment) {
		utilDao.update(comment);
		
	}

	
	
	public DBUtilDao getDBUtilDao() {
		return utilDao;
	}
@Resource(name="utilDao")
	public void setDBUtilDao(DBUtilDao utilDao) {
		this.utilDao = utilDao;
	}

	
}
