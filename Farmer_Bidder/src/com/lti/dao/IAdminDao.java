package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.model.AcceptedBid;
import com.lti.model.FinalCrop;
import com.lti.model.PotentialCrop;

@Repository
public interface IAdminDao {
	public List<PotentialCrop> listAllCrops();
	public void acceptCrop(int id);
	public void rejectCrop(int id);
	public List<AcceptedBid> listAllFinalCrops();
	public PotentialCrop getcrop(int id);
	public void acceptBid(int id);
	public void insertFinal(int id);
	public boolean checkAllFinalCrops();
}
