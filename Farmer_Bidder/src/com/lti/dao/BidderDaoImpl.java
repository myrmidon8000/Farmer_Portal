package com.lti.dao;

import java.util.Iterator;
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
import com.lti.model.Farmer;
import com.lti.model.FinalCrop;
import com.lti.model.PotentialCrop;

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
	public boolean loginBidders(Bidder bidder) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String email=bidder.getEmail();
		String password=bidder.getPassword();
		String query="from Bidder b where b.email=:email and b.password=:password";
		Query q=session.createQuery(query);
		q.setString("email", email);
		q.setString("password",password);
		List<Bidder> bidderList=q.list();
		tx.commit();
		session.close();
		if(bidderList.size()==0)
		return false;
		else
			return true;
	}
	@Override
	public Bidder returnBidder(Bidder bidder) {
		 Session session = this.sessionFactory.openSession();
			Transaction tx=session.beginTransaction();
			String email=bidder.getEmail();
			String password=bidder.getPassword();
			String query="from Bidder b where b.email=:email and b.password=:password";
			Query q=session.createQuery(query);
			q.setString("email", email);
			q.setString("password",password);
			List<Bidder> bidderList=q.list();
			tx.commit();
			session.close();
			Iterator<Bidder> itr= bidderList.iterator();
			Bidder b=new Bidder();
					while(itr.hasNext() )
					{
						 b= (Bidder) itr.next();
					}
		return b;
	}
	
	@Override
	public List<FinalCrop> listAllCrops() {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String query="from FinalCrop";
		Query q=session.createQuery(query);
		List<FinalCrop> finalCrop=q.list();
		tx.commit();
		session.close();
	return finalCrop;
		
	}
	@Override
	public FinalCrop placeBid(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String query="from FinalCrop where cropId=:cropId";
		Query q=session.createQuery(query);
		q.setInteger("cropId", id);
		List<FinalCrop> placeBid=q.list();
		tx.commit();
		session.close();
		Iterator<FinalCrop> itr= placeBid.iterator();
		FinalCrop finalcrop=new FinalCrop();
				while(itr.hasNext() )
				{
					 finalcrop= (FinalCrop) itr.next();
				}
	return finalcrop;
	}
	
	@Override
	public void successBid(FinalCrop placeBid,int id) {
		String amount=placeBid.getNewBid();
		String bidderId=placeBid.getBidderid();
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String query="update FinalCrop f set f.bidAmount=:newBid where f.cropId=:cropId";
		Query q=session.createQuery(query);
		q.setString("newBid", amount);
		q.setInteger("cropId", id);
		q.executeUpdate();
		tx.commit();
		Transaction tx1=session.beginTransaction();
		String query1="update FinalCrop f set f.bidderid=:bidderid where f.cropId=:cropId";
		Query q1=session.createQuery(query1);
		q1.setString("bidderid", bidderId);
		q1.setInteger("cropId", id);
		q1.executeUpdate();
		tx1.commit();
		session.close();

	}
	
	
		
}
