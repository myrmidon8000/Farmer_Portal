package com.lti.dao;


import org.springframework.stereotype.Repository;

import com.lti.model.Farmer;
import com.lti.model.Login;



@Repository
public interface IFarmerDao {
public void addFarmers(Farmer farmer);
public boolean loginFarmers(Login login);
}
