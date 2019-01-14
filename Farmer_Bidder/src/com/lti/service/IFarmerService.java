package com.lti.service;

import org.springframework.stereotype.Service;

import com.lti.model.Farmer;
import com.lti.model.Login;
import com.lti.model.PotentialCrop;

@Service
public interface IFarmerService {
public void addFarmer(Farmer farmer);
public boolean loginFarmer(Login login);
public void addCrop(PotentialCrop potentialcrop);
}
