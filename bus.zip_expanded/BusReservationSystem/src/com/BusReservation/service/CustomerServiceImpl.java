package com.BusReservation.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BusReservation.dao.ICustomerDao;
import com.BusReservation.model.AuthorizedUser;
@Service
@Transactional
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	ICustomerDao customerDao;
	
	@Override
	public List<AuthorizedUser> fetchPassword(String email) {
		
		return null;
	}

	@Override
	public void AddUser(AuthorizedUser authuser) {
	customerDao.AddUser(authuser);
		
	}

}
