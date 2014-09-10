package com.efinance.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.efinance.model.User;

@Repository
public interface UserDao {
	public void save(User u);
	public void delete(User user);
	public boolean checkUserExistsWithName(String username);  
//	public List<User> getUsers();
	public User verifyUser(String username, String password);
	public User completeUserMessage(User user);
//	public User findUserById(Integer id);
	public void deleteUserById(int id);

}

