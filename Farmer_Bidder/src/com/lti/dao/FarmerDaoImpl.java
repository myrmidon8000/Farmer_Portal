package com.lti.dao;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import com.lti.model.Farmer;
import com.lti.model.FinalCrop;
import com.lti.model.PotentialCrop;
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
	public boolean loginFarmers(Farmer farmer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String email=farmer.getEmail();
		String password=farmer.getPassword();
		String query="from Farmer f where f.email=:email and f.password=:password";
		Query q=session.createQuery(query);
		q.setString("email", email);
		q.setString("password",password);
		List<Farmer> farmerList=q.list();
		tx.commit();
		session.close();
		if(farmerList.size()==0)
		return false;
		else
			return true;
		
	}
	
	public Farmer returnFarmer(Farmer farmer)
	 {
		 
		 Session session = this.sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			String email=farmer.getEmail();
			String password=farmer.getPassword();
			String query="from Farmer f where f.email=:email and f.password=:password";
			Query q=session.createQuery(query);
			q.setString("email", email);
			q.setString("password",password);
			List<Farmer> farmerList=q.list();
			tx.commit();
			session.close();
			Iterator<Farmer> itr= farmerList.iterator();
			Farmer f=new Farmer();
					while(itr.hasNext() )
					{
						 f= (Farmer) itr.next();
					}
					System.out.println(f);
			return f;
		}

	@Override
	public void addCrops(PotentialCrop potentialcrop) {
		Session session1 = this.sessionFactory.openSession();
		Transaction tx=session1.beginTransaction();
		session1.save(potentialcrop);
		logger.info("Crop details saved successfully as: "+potentialcrop);
		tx.commit();
		session1.close();
	}
	@Override
	public List<PotentialCrop> listAllCrops(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String query="from PotentialCrop p where p.farmerId=:farmerId";
		Query q=session.createQuery(query);
		q.setInteger("farmerId", id);
		List<PotentialCrop> cropList=q.list();
		tx.commit();
		session.close();
		return cropList;
	}
	@Override
	public List<FinalCrop> listBids(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String query="from FinalCrop f where f.farmerId=:farmerId";
		Query q=session.createQuery(query);
		q.setInteger("farmerId", id);
		List<FinalCrop> bidList=q.list();
		tx.commit();
		session.close();
		return bidList;
	}
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
/*	@Override
	public Boolean forgotpassword(Farmer farmer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String email=farmer.getEmail();
		String phrase=farmer.getSecurityQuestion();
		String query="from Farmer f where f.email=:email and f.securityQuestion=:phrase";
		Query q=session.createQuery(query);
		q.setString("email", email);
		q.setString("phrase", phrase);
		List<Farmer> farmerList=q.list();
		tx.commit();
		session.close();
		if(farmerList.size()==0)
		return false;
		else
			return true;
	}
	@Override
	public Farmer getpasswordfarmer(Farmer farmer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String email=farmer.getEmail();
		String query="from Farmer f where f.email=:email";
		Query q=session.createQuery(query);
		q.setString("email", email);
		List<Farmer> farmerList=q.list();
		tx.commit();
		session.close();
		Iterator<Farmer> itr= farmerList.iterator();
		Farmer f=new Farmer();
				while(itr.hasNext() )
				{
					 f= (Farmer) itr.next();
				}
				System.out.println(f);
		return f;
	}
	@Override
	public void setNewPassword(Farmer farmer) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		
	}*/



