package com.lti.service;

import org.springframework.stereotype.Service;

import com.lti.model.Bidder;
import com.lti.model.Login;

@Service
public interface IBidderService {
public void addBidder(Bidder bidder);
public boolean loginBidder(Login login);
}
