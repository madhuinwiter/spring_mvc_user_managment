package com.user.service;

import java.util.List;

import com.user.model.User;

public interface UserService {
	
	public void addUser(User user);

	public List<User> listUsers();
	
	public User getUser(int userID);
	
	public void deleteUser(User user);
}
