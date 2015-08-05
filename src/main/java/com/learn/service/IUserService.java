package com.learn.service;

import com.learn.model.User;

public interface IUserService {
	
	public User getUser(Long userId);
	
	public void updateUser(User user) throws Exception;
	
	public void insertUser(User user) throws Exception;
	
	public void deleteUser(Long userId) throws Exception;

}
