package com.lti.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.lti.model.Farmer;

import com.lti.model.PotentialCrop;

@Service
public interface IFarmerService {
public void addFarmer(Farmer farmer);
public boolean loginFarmer(Farmer farmer);
public void addCrop(PotentialCrop potentialcrop);
public Farmer returnFarmer(Farmer farmer);
public List<PotentialCrop> listAllCrops(int id); 
}
