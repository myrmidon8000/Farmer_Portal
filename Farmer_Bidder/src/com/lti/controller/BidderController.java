package com.lti.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.model.Bidder;

import com.lti.service.IBidderService;

@Controller
public class BidderController {
	@Autowired
	private IBidderService iBidderService;

	public void setiBidderService(IBidderService iBidderService) {
		this.iBidderService = iBidderService;
	}
	
	@RequestMapping(value="/bidder")
	public String gotobidderregpage(Model model) {
	model.addAttribute("bidder",new Bidder());
		return "BidderRegistration";
	}
	// To add a farmer
			@RequestMapping(value = "/bidder/add", 
					method = RequestMethod.POST)
			public String addBidder(
					@ModelAttribute("bidder") 
					@Valid Bidder bidder, 
					BindingResult result, 
					Model model) {
						// new farmer, add it
						this.iBidderService.addBidder(bidder);
					return "redirect:/login";
				}
			@RequestMapping(value = "/bidderlogin")
			public String LoginPage1(Model model) {
				model.addAttribute("bidder",new Bidder());
				return "BidderLogin";
			}					
		@RequestMapping(value = "/bidderloginprocess", 
					method = RequestMethod.POST)
			public String bidderLogin(
					@ModelAttribute("bidder") 
					@Valid Bidder bidder, 
					BindingResult result, 
					Model model) 
		{
				if(this.iBidderService.loginBidder(bidder))
					return "SuccessBidder";
				else
					return "redirect:/bidderlogin";
		}

}