package com.efinance.dao;

import com.efinance.model.Comment;


public interface CommentDao {
	
	public void addComment(Comment comment);							   
	public void updateComment(Comment comment);                       
	public void deleteComment(Comment comment);                      
	public Comment findCommentById(Integer id);

}
