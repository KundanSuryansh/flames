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
public class SignupController {


	@Autowired
	UserInfoDao udao;
	
	@RequestMapping("/addinfo")
	public ModelAndView addInfo(@ModelAttribute("UserInfo") UserInfo userinfo)
	{
		System.out.println("signupcontroller");
		ModelAndView mv=new ModelAndView();
		List<UserInfo> l=udao.allusers();
		int n=0;
		for(UserInfo ui : l)
		{
			
			if(ui.getEmail().equals(userinfo.getEmail()))
			{
				n=1;
				mv.setViewName("signup");
				mv.addObject("error",n);
				return mv;
			}
		}
			
				udao.addUser(userinfo);
				mv.addObject("error",n);
				mv.setViewName("login");
			return mv;
		}
	
}
