package com.lti.dao;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.slf4j.Logger;
import com.lti.model.Farmer;
@Repository
public class FarmerDaoImpl implements IFarmerDao{
	private static final Logger logger = 			
			LoggerFactory.getLogger(FarmerDaoImpl.class);
	public void addFarmer(Farmer farmer) {
		Session session = this.sessionFactory.openSession();
		session.save(farmer);
		logger.info("Employee details saved successfully as: "+farmer);
		session.close();
	}
	

}
