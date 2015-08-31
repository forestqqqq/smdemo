package com.learn.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author 作者： zhanghaiwei
 * @version 1.0
 * @date 创建时间：2015/8/23 18:40
 * @since jdk1.6.0_27
 */
@Controller
public class LoginController {

    @RequestMapping(value="/login.html")
    public String login(String username,String password){

        return "login";
    }


}
