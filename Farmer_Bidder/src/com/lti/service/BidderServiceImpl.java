package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.IBidderDao;
import com.lti.model.Bidder;

@Service
@Transactional
public class BidderServiceImpl implements IBidderService{
	@Autowired
	private IBidderDao iBidderDao;
	
	
	public void setiBidderDao(IBidderDao iBidderDao) {
		this.iBidderDao = iBidderDao;
	}


	@Override
	public void addBidder(Bidder bidder) {
		this.iBidderDao.addBidders(bidder);
		
	}

}
