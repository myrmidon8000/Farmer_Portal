package com.lti.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.IFarmerDao;
import com.lti.model.Farmer;

import com.lti.model.PotentialCrop;
@Service
@Transactional
public class FarmerServiceImpl implements IFarmerService{

	
	private IFarmerDao iFarmerDao;
	@Autowired
	public void setiFarmerDao(IFarmerDao iFarmerDao) {
		this.iFarmerDao = iFarmerDao;
	}
	

	public void addFarmer(Farmer farmer) {
		this.iFarmerDao.addFarmers(farmer);
		
	}


	@Override
	public boolean loginFarmer(Farmer farmer) {
	return this.iFarmerDao.loginFarmers(farmer);
	
	}


	@Override
	public void addCrop(PotentialCrop potentialcrop) {
		this.iFarmerDao.addCrops(potentialcrop);
		
	}


	@Override
	public Farmer returnFarmer(Farmer farmer) {
		
		return this.iFarmerDao.returnFarmer(farmer);
	}


	@Override
	public List<PotentialCrop> listAllCrops(int id) {
		return this.iFarmerDao.listAllCrops(id);
	}


}
