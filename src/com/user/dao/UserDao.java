package com.user.dao;

import java.util.List;

import com.user.model.User;

public interface UserDao {
	
	public void addUser(User user);

	public List<User> listUsers();
	
	public User getUser(int empid);
	
	public void deleteUser(User user);
}
