package com.learn.model;

/**
 * 用户信息
 * @author 作者： zhanghaiwei
 * @date 创建时间：2015年8月2日 下午4:22:25
 * @version 1.0
 * @since jdk1.6.0_27
 */
public class User {
	
	private Long id;
	private String username;
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
