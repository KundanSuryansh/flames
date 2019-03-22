package com.kundan.flames.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kundan.flames.dao.UserInfoDao;
import com.kundan.flames.entity.UserInfo;

@Controller
public class LoginController {
	@Autowired
	UserInfoDao udao;
	
	@Autowired
	private SessionFactory sessionFactory;
	@RequestMapping("/loginenter")
	public ModelAndView addInfo(@RequestParam("email") String email,@RequestParam("password") String password,HttpServletRequest request, HttpServletResponse response)
	{
		
		System.out.println("logincontroller");
		ModelAndView mv=new ModelAndView();
		List<UserInfo> l=udao.allusers();
		int n=0;
		for(UserInfo ui : l)
		{
			
			if(ui.getEmail().equals(email) && ui.getPassword().equals(password))
			{
				HttpSession session=request.getSession();
				session.setAttribute("email", email);
				mv.addObject("name", ui.getName());
				mv.setViewName("welcome");
				return mv;
			}
		}
			
				n=1;
				mv.addObject("error", n);
				mv.setViewName("login");
		
			
				
			return mv;
		}
	
}
