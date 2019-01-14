package com.lti.service;

import org.springframework.stereotype.Service;

import com.lti.model.Farmer;
import com.lti.model.Login;

@Service
public interface IFarmerService {
public void addFarmer(Farmer farmer);
public boolean  loginFarmer(Login login);
}
