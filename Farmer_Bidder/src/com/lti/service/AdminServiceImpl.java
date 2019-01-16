package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.IAdminDao;
import com.lti.model.PotentialCrop;
@Service
public class AdminServiceImpl implements IAdminService{
@Autowired
private IAdminDao iAdminDao;

public void setiAdminDao(IAdminDao iAdminDao) {
	this.iAdminDao = iAdminDao;
}


	@Override
	public List<PotentialCrop> listAllCrops() {
		
		return this.iAdminDao.listAllCrops();
	}

}
