package com.lti.service;

import java.util.List;

import com.lti.model.AcceptedBid;
import com.lti.model.PotentialCrop;

public interface IAdminService {
	public List<PotentialCrop> listAllCrops();
public void acceptCrop(int id);
public void rejectCrop(int id);
public PotentialCrop getcrop(int id);
public List<AcceptedBid> listAllFinalCrops();
public void acceptBid(int id);
public void insertFinal(int id);
public boolean checkAllFinalCrops();
}
