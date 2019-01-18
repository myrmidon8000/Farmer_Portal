package com.lti.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.model.AcceptedBid;
import com.lti.model.Farmer;
import com.lti.model.FinalCrop;
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
		/*PotentialCrop potentialcrop=(PotentialCrop) session.get(PotentialCrop.class, id);
		potentialcrop.setRequestStatus("ACCEPTED");
		session.update(potentialcrop);*/
		String query="update PotentialCrop p set p.requestStatus='ACCEPTED' where p.cropId=:cropId";
		Query q=session.createQuery(query);
		q.setInteger("cropId", id);
		q.executeUpdate();
		tx.commit();
		session.close();
	}
	public void insertFinal() {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String query="insert into FinalCrop(cropId,cropType,cropName,fertilizerType,quantity,baseAmount,phCertificate,farmerId) "
				+ "select p.cropId,p.cropType,p.cropName,p.fertilizerType,p.quantity,p.baseAmount,p.phCertificate,p.farmerId from PotentialCrop p where p.requestStatus='ACCEPTED'"; 
		Query q=session.createQuery(query);
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
					/*PotentialCrop potentialcrop=(PotentialCrop) session.get(PotentialCrop.class, id);
					potentialcrop.setRequestStatus("REJECTED");
					session.update(potentialcrop);*/
					String query="update PotentialCrop p set p.requestStatus='REJECTED' where p.cropId=:cropId";
					Query q=session.createQuery(query);
					q.setInteger("cropId", id);
					q.executeUpdate();
					tx.commit();
					Transaction tx1=session.beginTransaction();
					String query1="delete from FinalCrop f where f.cropId=:cropId";
					Query q1=session.createQuery(query1);
					q1.setInteger("cropId", id);
					q1.executeUpdate();
					tx1.commit();
					session.close();
				}

				@Override
				public List<AcceptedBid> listAllFinalCrops() {
					Session session = this.sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					String query="from AcceptedBid";
					Query q=session.createQuery(query);
					List<AcceptedBid> bidList=q.list();
					tx.commit();
					session.close();
					return bidList;
				}

				@Override
				public void acceptBid(int id) {
					Session session = this.sessionFactory.openSession();
					Transaction tx=session.beginTransaction();
					/*AcceptedBid acceptedbid=(AcceptedBid) session.get(AcceptedBid.class, id);
					acceptedbid.setBidStatus("ACCEPTED");
					session.update(acceptedbid);*/
					String query="update AcceptedBid a set a.bidStatus='ACCEPTED' where a.cropId=:cropId";
					Query q=session.createQuery(query);
					q.setInteger("cropId", id);
					q.executeUpdate();
					tx.commit();
					Transaction tx1=session.beginTransaction();
					String query1="delete from FinalCrop f where f.cropId=:cropId";
					Query q1=session.createQuery(query1);
					q1.setInteger("cropId", id);
					q1.executeUpdate();
					tx1.commit();
					session.close();
				}
		
	}
	
