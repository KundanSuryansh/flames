package com.kundan.flames.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.kundan.flames.dao.UserInfoDao;
import com.kundan.flames.entity.UserInfo;

@Controller
public class IndexController {

	@Autowired
	UserInfoDao udao;
	
	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
		
	@RequestMapping("/signup")
	public String signup()
	{
		return "signup";
	}
	
	@RequestMapping("/login")
	public String login()
	{
		return "login";
	}
}
