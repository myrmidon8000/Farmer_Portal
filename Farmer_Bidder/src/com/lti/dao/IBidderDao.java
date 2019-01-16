package com.lti.dao;

import org.springframework.stereotype.Repository;

import com.lti.model.Bidder;



@Repository
public interface IBidderDao {
	public void addBidders(Bidder bidder);
	public boolean loginBidders(Bidder bidder);
}
