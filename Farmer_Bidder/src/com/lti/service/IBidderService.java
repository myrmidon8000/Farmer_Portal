package com.lti.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lti.model.AcceptedBid;
import com.lti.model.Bidder;
import com.lti.model.Farmer;
import com.lti.model.FinalCrop;

@Service
public interface IBidderService {
public void addBidder(Bidder bidder);
public boolean loginBidder(Bidder bidder);
public Bidder returnBidder(Bidder bidder);
public List<FinalCrop> listAllCrops();
public FinalCrop placeBid(int id);
public void successBid(FinalCrop placeBid,int id);
public List<AcceptedBid> listBids(int id);
}
