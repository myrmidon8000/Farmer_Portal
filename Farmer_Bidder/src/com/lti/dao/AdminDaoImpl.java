package com.lti.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.Farmer;
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

	@Override
	public void acceptCrop(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String query="update PotentialCrop p set p.requestStatus='ACCEPTED' where p.cropId=:cropId";
		Query q=session.createQuery(query);
		q.setInteger("cropId", id);
		q.executeUpdate();
		
		tx.commit();
		session.close();
	}

				@Override
				public PotentialCrop getcrop(int id) {
					Session session = this.sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					String query="from PotentialCrop where cropId=:cropId";
					Query q=session.createQuery(query);
					q.setInteger("cropId", id);
					List<PotentialCrop> cropList=q.list();
					tx.commit();
					Iterator<PotentialCrop> itr= cropList.iterator();
					PotentialCrop potentialcrop=new PotentialCrop();
							while(itr.hasNext() )
							{
								potentialcrop= (PotentialCrop) itr.next();
							}
							return potentialcrop;				
							
				}

				@Override
				public void rejectCrop(int id) {
					Session session = this.sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					String query="update PotentialCrop p set p.requestStatus='REJECTED' where p.cropId=:cropId";
					Query q=session.createQuery(query);
					q.setInteger("cropId", id);
					q.executeUpdate();
					tx.commit();
					session.close();
					
				}
		
	}
	
