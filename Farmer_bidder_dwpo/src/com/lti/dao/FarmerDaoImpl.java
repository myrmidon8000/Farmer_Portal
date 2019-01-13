package com.lti.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.lti.model.Farmer;
@Repository
public class FarmerDaoImpl implements IFarmerDao{
	static Transaction tx;

	
	private SessionFactory sessionFactory;
	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	public void addFarmer(Farmer farmer) {
		Session session = this.sessionFactory.openSession();
		 tx=session.beginTransaction();
		 
		session.save(farmer);
		tx.commit();
	
		session.close();
	
	}
}
	