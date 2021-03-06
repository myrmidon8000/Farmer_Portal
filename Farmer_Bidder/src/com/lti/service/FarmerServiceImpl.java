package com.lti.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.IFarmerDao;
import com.lti.model.AcceptedBid;
import com.lti.model.Bidder;
import com.lti.model.Farmer;
import com.lti.model.FinalCrop;
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


	@Override
	public List<AcceptedBid> listBids(int id) {
	
		return this.iFarmerDao.listBids(id);
	}


	@Override
	public Bidder getbidder(int id) {
		return this.iFarmerDao.getbidder(id);
	}


	@Override
	public boolean checkAllCrops(int id) {

		return this.iFarmerDao.checkAllCrops(id);
	}


	@Override
	public boolean checklistBids(int id) {

		return this.iFarmerDao.checklistBids(id);
	}

}
	/*@Override
	public boolean forgotpassword(Farmer farmer) {
	
		return this.iFarmerDao.forgotpassword(farmer);
	}


	@Override
	public void setNewPassword(Farmer farmer) {
		this.iFarmerDao.setNewPassword(farmer);
		
	}


	@Override
	public Farmer getpasswordfarmer(Farmer farmer) {

		return this.iFarmerDao.getpasswordfarmer(farmer);
	}
*/

	
	
	
	
	

