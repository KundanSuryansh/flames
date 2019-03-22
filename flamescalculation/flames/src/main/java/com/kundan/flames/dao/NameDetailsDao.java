package com.kundan.flames.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.kundan.flames.entity.NameDetails;

@Component
public class NameDetailsDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	public void addDetails(NameDetails namedetails)
	{
		Session session;
		System.out.println(namedetails);
	session=sessionFactory.getCurrentSession();
	session.save(namedetails);
	}
	
	@Transactional 
	public List<NameDetails> allDetails()
	{
		
		Session session=sessionFactory.getCurrentSession();
		Query q=session.createQuery("from NameDetails");
		List<NameDetails> l=(List<NameDetails>)q.list();
		System.out.println(l);
		return l;
	}
}
