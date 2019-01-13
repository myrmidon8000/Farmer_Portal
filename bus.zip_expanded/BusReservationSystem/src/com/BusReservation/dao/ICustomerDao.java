package com.BusReservation.dao;

import java.util.List;

import com.BusReservation.model.AuthorizedUser;


public interface ICustomerDao {
	public List<AuthorizedUser> fetchPassword(String email);
	
	public void AddUser(AuthorizedUser authuser);
}
