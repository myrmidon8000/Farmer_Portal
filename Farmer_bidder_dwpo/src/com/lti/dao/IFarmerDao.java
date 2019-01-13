package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.model.Farmer;



@Repository
public interface IFarmerDao {
public void addFarmer(Farmer farmer);

}
