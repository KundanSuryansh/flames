package com.kundan.flames.controller;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kundan.flames.dao.NameDetailsDao;
import com.kundan.flames.dao.UserInfoDao;
import com.kundan.flames.entity.NameDetails;
import com.kundan.flames.entity.UserInfo;

@Controller
public class WelcomeController {

@Autowired
UserInfoDao udao;
@Autowired
NameDetailsDao namedao;
@Autowired
NameDetails namedetails;
	
@RequestMapping("/welcome")
public String welcome()
{
	return "welcome";
}
@RequestMapping ("/logout")
public ModelAndView logout(HttpServletRequest request, HttpServletResponse response)
{
	ModelAndView mv=new ModelAndView();
	HttpSession session=request.getSession();
	session.removeAttribute("email");
	session.invalidate();
	mv.setViewName("login");
	return mv;
	
}
@RequestMapping("/calculate")
public ModelAndView calculate(@RequestParam("name1")String name1,@RequestParam("name2")String name2,HttpServletRequest request)
{
	ModelAndView mv=new ModelAndView();
	int n=0;
	String UniqueCharacterInName1=uniqueness(name1);
	String UniqueCharacterInName2=uniqueness(name2);
	String concat_name=UniqueCharacterInName1+UniqueCharacterInName2;
	String UniqueConcat=uniqueness(concat_name);
	System.out.println(UniqueConcat);
	int length=UniqueConcat.length();
	HttpSession session=request.getSession();
	String email=session.getAttribute("email").toString();
	List<UserInfo> l=udao.allusers();
	String name="";
	String flames="";
	for(UserInfo ui :l)
	{
		if(ui.getEmail().equals(email))
		{
			name+=ui.getName();
		}
	}
	mv.addObject("name", name);
	if(length==0)
	{
		n=1;
		mv.addObject("result",n);
	}
	else
	{
	String result=flameresult(length);

	switch(result)
	{
	case "F" : flames+="Friend";
				break;
	case "L" : flames+="Lover";
				break;
	case "A" : flames+="Affection";
				break;
	case "M" : flames+="Marriage";
				break;
	case "E" : flames+="Enemy";
				break;
	case "S" : flames+="Sister";
				break;
	}
	mv.addObject("result", n);
	mv.addObject("flames", flames);
	}
	addname(email,name1,name2,flames);
	mv.setViewName("welcome");
	return mv;
	
	
}

private void addname(String email, String name1, String name2,String flames) {
	namedetails.setEmailid(email);
	namedetails.setName1(name1);
	namedetails.setName2(name2);
	namedetails.setFlamedata(flames);
	namedao.addDetails(namedetails);
	
}
private String flameresult(int length) {
	// TODO Auto-generated method stub
	LinkedHashMap<Character,Integer> hashmap=new LinkedHashMap<Character,Integer>();
	hashmap.put('F',1);
	hashmap.put('L',1);
	hashmap.put('A',1);
	hashmap.put('M',1);
	hashmap.put('E',1);
	hashmap.put('S',1);
	int count=0,c=0;
	System.out.println(length);
	while(count!=5)
	{
		Set<Entry<Character, Integer>> s1=hashmap.entrySet();
		Iterator<Entry<Character, Integer>> itr=s1.iterator();
		while(itr.hasNext())
		{
			Map.Entry<Character, Integer> m1=itr.next();
			if(m1.getValue()!=-1)
			{
				c++;
			}
			if(c==length)
			{
				m1.setValue(-1);
				System.out.println(m1.getKey());
				count++;
				c=0;
			}
		
		}
	}
	Set<Entry<Character, Integer>> s1=hashmap.entrySet();
	Iterator<Entry<Character, Integer>> itr=s1.iterator();
	char k = 0;
	while(itr.hasNext())
	{
		Map.Entry<Character, Integer> m1=itr.next();
		if(m1.getValue()==1)
		{
			k=m1.getKey();
			break;
		}
	}
	return String.valueOf(k);
	
	
}
public String uniqueness(String s)
{
	HashSet<Character> hs=new HashSet<Character>();
	HashSet<Character> hs1=new HashSet<Character>();
	for(int i=0;i<s.length();i++)
	{
		if((!hs.contains(s.charAt(i))) &&(!hs1.contains(s.charAt(i))))
		{
			hs.add(s.charAt(i));
		}
		else
		{
			hs.remove(s.charAt(i));
			hs1.add(s.charAt(i));
		}
		
	}
	Iterator<Character> itr=hs.iterator();
	String sum="";
	while(itr.hasNext())
	{
		sum+=itr.next().toString();
	}
	return sum;
}
}
