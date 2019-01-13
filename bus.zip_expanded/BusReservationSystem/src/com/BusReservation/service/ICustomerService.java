package com.BusReservation.service;

import java.util.List;

import com.BusReservation.model.AuthorizedUser;

public interface ICustomerService {

List<AuthorizedUser> fetchPassword(String email);

void AddUser(AuthorizedUser authuser);
	
	
}
