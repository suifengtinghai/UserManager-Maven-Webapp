package com.guozhq.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.guozhq.entity.User;
import com.guozhq.service.IUserService;

@Controller
@RequestMapping(value = "/user")
public class UserController {
	@Resource
	private IUserService userService;
	
	@RequestMapping(value = "/login",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String login(User user,HttpServletRequest request ,HttpSession session){
		User localuser = userService.login(user);
		if(localuser == null){
			return user.toString() + "该用户不存在";
		}else{
			return "当前用户:" + user.getUsername();
		}
	}
	
	@RequestMapping(value = "/register",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String register(User user){
		if(userService.register(user)){
			return "注册成功";
		}
		return "注册失败";
	}
	@RequestMapping(value = "/queryAllUser",produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String queryAllUser(){
		return userService.queryAllUser().toString();
	}
}
