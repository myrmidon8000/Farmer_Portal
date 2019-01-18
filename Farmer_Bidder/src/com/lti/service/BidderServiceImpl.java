package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.IBidderDao;
import com.lti.model.AcceptedBid;
import com.lti.model.Bidder;
import com.lti.model.Farmer;
import com.lti.model.FinalCrop;


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

	@Override
	public boolean loginBidder(Bidder bidder) {
		
		return this.iBidderDao.loginBidders(bidder);
	}

	@Override
	public Bidder returnBidder(Bidder bidder) {
		
		return this.iBidderDao.returnBidder(bidder);
	}

	@Override
	public List<FinalCrop> listAllCrops() {
	
		return this.iBidderDao.listAllCrops();
	}

	@Override
	public FinalCrop placeBid(int id) {
		return this.iBidderDao.placeBid(id);
	}

	@Override
	public void successBid(FinalCrop placeBid,int id) {
		this.iBidderDao.successBid(placeBid,id);
		
	}

	@Override
	public List<AcceptedBid> listBids(int id) {

		return this.iBidderDao.listBids(id);
	}
}
