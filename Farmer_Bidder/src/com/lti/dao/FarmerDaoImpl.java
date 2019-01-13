package com.lti.dao;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import com.lti.model.Farmer;
@Repository
public class FarmerDaoImpl implements IFarmerDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private static final Logger logger = 			
			LoggerFactory.getLogger(FarmerDaoImpl.class);
	public void addFarmers(Farmer farmer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(farmer);
		logger.info("Farmer details saved successfully as: "+farmer);
		tx.commit();
		session.close();
		
	}
	

}
