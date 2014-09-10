package com.efinance.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.efinance.dao.UserDao;
import com.efinance.model.User;
import com.efinance.service.UserService;

@Component("userService")
public class UserServiceImpl implements UserService{
	@Resource
	private UserDao userDao;
	
	public UserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	public void add(User user) {
		userDao.save(user);
	}
	public User verifyUser(String userName, String password){
		return (User)userDao.verifyUser(userName, password);
	}
	public boolean exists(User u) throws Exception {		
		return userDao.checkUserExistsWithName(u.getUsername());
	}

	public User completeUserMessage(User user) {
		return (User)userDao.completeUserMessage(user);
	}

	public void delete(User user) {
		userDao.delete(user);
	}

	public void deleteUserById(int id) {
		userDao.deleteUserById(id);
	}
}
