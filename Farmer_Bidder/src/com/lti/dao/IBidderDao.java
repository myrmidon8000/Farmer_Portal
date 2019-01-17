package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.model.Bidder;
import com.lti.model.Farmer;
import com.lti.model.FinalCrop;


@Repository
public interface IBidderDao {
public void addBidders(Bidder bidder);
public boolean loginBidders(Bidder bidder);
public Bidder returnBidder(Bidder bidder);
public List<FinalCrop> listAllCrops();

public FinalCrop placeBid(int id);
public void successBid(FinalCrop placeBid,int id);


}
