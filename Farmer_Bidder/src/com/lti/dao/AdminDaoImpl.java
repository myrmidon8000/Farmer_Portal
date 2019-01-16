package com.lti.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.PotentialCrop;
@Repository
public class AdminDaoImpl implements IAdminDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public List<PotentialCrop> listAllCrops() {
			Session session = this.sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			String query="from PotentialCrop";
			Query q=session.createQuery(query);
			List<PotentialCrop> cropList=q.list();
			tx.commit();
			session.close();
			return cropList;
		}
	}
