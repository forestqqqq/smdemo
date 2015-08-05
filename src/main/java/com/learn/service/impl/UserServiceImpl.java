package com.learn.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.learn.dao.IUserDao;
import com.learn.model.User;
import com.learn.service.IUserService;

@Service("userService")
public class UserServiceImpl implements IUserService {
	
	@Resource
	private IUserDao iUserDao;

	@Override
	public User getUser(Long userId) {
		return iUserDao.getUser(userId);
	}
	
	@Transactional
	public void updateUser(User user) throws Exception{
		iUserDao.updateUser(user);
	}

	@Override
	public void insertUser(User user) throws Exception {
		iUserDao.insertUser(user);
	}

	@Override
	public void deleteUser(Long userId) throws Exception {
		iUserDao.deleteUser(userId);
	}

}
