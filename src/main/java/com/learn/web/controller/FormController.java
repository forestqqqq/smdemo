package com.learn.web.controller;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

import com.learn.service.IUserService;

@Controller
public class FormController {
	
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/users.html")
	public ModelAndView users(HttpServletRequest request,String p1,String p2){
		System.out.println("p1=="+p1);
		System.out.println("p2=="+p2);
		
		Map<String,Object> data = new HashMap<String,Object>();
		data.put("user", userService.getUser(1L));
		data.put("kk", "ppppp");
		request.setAttribute("aa", userService.getUser(1L));
		
		ModelAndView mv = new ModelAndView("users",data);
		return mv;
	}
	
	@RequestMapping(value = "/post.html", method = RequestMethod.POST)
	public String getParam(HttpServletRequest request,HttpServletResponse response){
		System.out.println("p1=="+request.getParameter("p1"));
		System.out.println("p2=="+request.getParameter("p2"));
		return "welcome";
	}
	
	@RequestMapping(value = "/file.html", method = RequestMethod.POST)
	public String getParam(MultipartHttpServletRequest request,HttpServletResponse response){
		System.out.println("p1=="+request.getParameter("p1"));
		System.out.println("p2=="+request.getParameter("p2"));
		MultipartFile f = request.getFile("file");
		System.out.println(f.getName());
		System.out.println(f.getOriginalFilename());
		System.out.println(f.getSize());
		return "welcome";
	}

}
