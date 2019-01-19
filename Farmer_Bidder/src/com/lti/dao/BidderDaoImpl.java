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

import com.lti.model.AcceptedBid;
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
	/*	FinalCrop finalcrop1=(FinalCrop) session.get(FinalCrop.class, id);
		finalcrop1.setBidderid("1");
		session.update(finalcrop1);*/
		String query="update FinalCrop f set f.bidderid='0' where cropId=:cropId";
		Query q=session.createQuery(query);
		q.setInteger("cropId", id);
		q.executeUpdate();
		tx.commit();
		Transaction tx1=session.beginTransaction();
		String query1="from FinalCrop where cropId=:cropId";
		Query q1=session.createQuery(query1);
		q1.setInteger("cropId", id);
		List<FinalCrop> placeBid=q1.list();
		tx1.commit();
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
		long amount=placeBid.getNewBid();
		int bidderId=placeBid.getBidderid();
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		/*FinalCrop finalcrop=(FinalCrop) session.get(FinalCrop.class, id);
		finalcrop.setBidAmount(amount);
		finalcrop.setBidderid(bidderId);
		session.update(finalcrop);*/
		String query="update FinalCrop f set f.bidAmount=:newBid,f.bidderid=:bidderid where f.cropId=:cropId";
		Query q=session.createQuery(query);
		q.setLong("newBid", amount);
		q.setInteger("bidderid", bidderId);
		q.setInteger("cropId", id);
		q.executeUpdate();
		tx.commit();
		Transaction tx2=session.beginTransaction();
		String query2="insert into AcceptedBid(cropId,cropType,cropName,fertilizerType,quantity,baseAmount,"
				+ "phCertificate,farmerId,bidAmount,bidderid) select f.cropId,f.cropType,f.cropName,"
				+ "f.fertilizerType,f.quantity,f.baseAmount,f.phCertificate,f.farmerId,f.bidAmount,f.bidderid from FinalCrop f where f.cropId=:cropId";
		Query q2=session.createQuery(query2);
		q2.setInteger("cropId", id);
		q2.executeUpdate();
		tx2.commit();
		Transaction tx3=session.beginTransaction();
		/*AcceptedBid acceptedbid=(AcceptedBid) session.get(AcceptedBid.class, id);
		acceptedbid.setBidStatus("ONGOING");
		session.update(acceptedbid);*/
		String query3="update AcceptedBid a set a.bidStatus='ONGOING' where a.cropId=:cropId";
		Query q3=session.createQuery(query3);
		q3.setInteger("cropId", id);
		q3.executeUpdate();
		tx3.commit();
		session.close();
	}
	@Override
	public List<AcceptedBid> listBids(int id) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String query="from AcceptedBid a where a.bidderid=:bidderid";
		Query q=session.createQuery(query);
		q.setInteger("bidderid", id);
		List<AcceptedBid> bidList=q.list();
		tx.commit();
		session.close();
		return bidList;
	}
	@Override
	public boolean checklistBids(int bidderId) {
		Session session = this.sessionFactory.openSession();
		Transaction tx=session.beginTransaction();
		String query="from AcceptedBid a where a.bidderid=:bidderid";
		Query q=session.createQuery(query);
		q.setInteger("bidderid", bidderId);
		List<AcceptedBid> bidList=q.list();
		tx.commit();
		session.close();
		return false;
	}
	
	
		
}
