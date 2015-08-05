package com.learn.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.learn.model.User;
import com.learn.service.IUserService;

/**
 * 
 * @author 作者： zhanghaiwei
 * @date 创建时间：2015年8月2日 下午4:35:14
 * @version 1.0
 * @since jdk1.6.0_27
 */
@Controller
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/getuser.json")
	@ResponseBody
	public User getUser(Long id){
		return userService.getUser(id);
	}
	
	@RequestMapping("/update.json")
	@ResponseBody
	public User update(String name) throws Exception{
		User user = userService.getUser(1L);
		user.setName(name);
		userService.updateUser(user);
		return user;
	}
	
	@RequestMapping("/insert.json")
	@ResponseBody
	public User insert(String name) throws Exception{
		User user = new User();
		user.setName(name);
		user.setUsername(name);
		userService.insertUser(user);
		return user;
	}
	
	@RequestMapping("/delete.json")
	@ResponseBody
	public String delete(Long id) throws Exception{
		userService.deleteUser(id);
		return "success";
	}
	
	

}
