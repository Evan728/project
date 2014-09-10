package com.efinance.service;

import com.efinance.model.User;


public interface UserService {

	public void add(User user);
	public boolean exists(User u) throws Exception;

//	public void delete(int id);
//
	public void delete(User user);
//	
//	public void update(User user);
//
//	public User get(int id);
//	
	public User verifyUser(String userName, String password);
	public User completeUserMessage(User suer);
//	public User findUserById(Integer id);
	public void deleteUserById(int id);

}