package com.lti.dao;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Repository;

import com.lti.model.AcceptedBid;
import com.lti.model.Bidder;
import com.lti.model.Farmer;
import com.lti.model.FinalCrop;
import com.lti.model.PotentialCrop;



@Repository
public interface IFarmerDao {
public void addFarmers(Farmer farmer);
public boolean loginFarmers(Farmer farmer);
public void addCrops(PotentialCrop potentialcrop);
public Farmer returnFarmer(Farmer farmer);
public List<PotentialCrop> listAllCrops(int id); 
public List<AcceptedBid> listBids(int id);
public Bidder getbidder(String id);






/*public Boolean forgotpassword(Farmer farmer);
public Farmer getpasswordfarmer(Farmer farmer);
public void setNewPassword(Farmer farmer);*/
}
