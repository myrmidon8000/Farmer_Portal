package com.lti.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.Bidder;
import com.lti.model.Login;
@Repository
public class BidderDaoImpl implements IBidderDao {
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	private static final Logger logger = 			
			LoggerFactory.getLogger(BidderDaoImpl.class);
	@Override
	public void addBidders(Bidder bidder) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		session.save(bidder);
		logger.info("Bidder details saved successfully as: "+bidder);
		tx.commit();
		session.close();
		
	}
	@Override
	public boolean loginBidders(Login login) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String email=login.getEmail();
		String password=login.getPassword();
		String query="from Login l where l.email=:email and l.password=:password";
		Query q=session.createQuery(query);
		q.setString("email", email);
		q.setString("password",password);
		List<Login> bidderList=q.list();
		tx.commit();
		session.close();
		if(bidderList.size()==0)
		return false;
		else
			return true;
	}

}
