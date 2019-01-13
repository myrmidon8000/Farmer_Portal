package com.lti.dao;


import org.springframework.stereotype.Repository;

import com.lti.model.Farmer;



@Repository
public interface IFarmerDao {
public void addFarmers(Farmer farmer);

}
