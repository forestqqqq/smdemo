package com.learn.dao;

import com.learn.model.User;

public interface IUserDao {
	
	public User getUser(Long userId);
	
	public void updateUser(User user);
	
	public void insertUser(User user);
	public void deleteUser(Long userId);

}
