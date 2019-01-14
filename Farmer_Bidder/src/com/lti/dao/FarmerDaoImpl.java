package com.lti.dao;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import com.lti.model.Farmer;
import com.lti.model.Login;
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
	@Override
	public boolean loginFarmers(Login login) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String email=login.getEmail();
		String password=login.getPassword();
		String query="from Login l where l.email=:email and l.password=:password";
		Query q=session.createQuery(query);
		q.setString("email", email);
		q.setString("password",password);
		List<Login> farmerList=q.list();
		tx.commit();
		session.close();
		if(farmerList.size()==0)
		return false;
		else
			return true;
		
	}
	

}
