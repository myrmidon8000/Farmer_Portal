package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.IFarmerDao;
import com.lti.model.Farmer;
@Service
public class FarmerServiceImpl implements IFarmerService{

	@Autowired
	private IFarmerDao iFarmerDao;
	
	public void setiFarmerDao(IFarmerDao iFarmerDao) {
		this.iFarmerDao = iFarmerDao;
	}
	
@Transactional
	public void addFarmer(Farmer farmer) {
		this.iFarmerDao.addFarmer(farmer);
		
	}


}
