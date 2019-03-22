package com.kundan.flames.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import com.kundan.flames.entity.UserInfo;

@Component
public class UserInfoDao {
	@Autowired
	private SessionFactory sessionFactory;


	
	@Transactional 
	public void addUser(UserInfo ui)
	{
		Session session;
		System.out.println(ui);
	session=sessionFactory.getCurrentSession();
	session.save(ui);
		
	}
	@Transactional 
	public List<UserInfo> allusers()
	{
		
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from UserInfo");
		List<UserInfo> l=(List<UserInfo>)q.list();
		System.out.println(l);
		return l;
	}

}
