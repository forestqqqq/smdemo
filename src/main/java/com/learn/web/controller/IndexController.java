package com.learn.web.controller;

import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;

/**
 * 首页
 * @author 作者： zhanghaiwei
 * @date 创建时间：2015年8月2日 上午11:53:54
 * @version 1.0
 * @since jdk1.6.0_27
 */
@Controller
public class IndexController {
	
	
	@RequestMapping("/index.html")
	public String index(){
		return "welcome";
	}
	
	@RequestMapping("json.html")
	public void json(HttpServletResponse response) throws IOException{
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("code", 0);
		result.put("data", "success");
		Writer w = response.getWriter();
		w.write(JSONObject.fromObject(result).toString());
	}
	
	@RequestMapping("a.json")
	@ResponseBody
	public Map<String,Object> json2(HttpServletResponse response) throws IOException{
		Map<String,Object> result = new HashMap<String,Object>();
		result.put("code", 0);
		result.put("data", "success");
		return result;
	}

}
