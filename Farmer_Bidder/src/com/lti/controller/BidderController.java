package com.lti.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.model.AcceptedBid;
import com.lti.model.Bidder;
import com.lti.model.FinalCrop;
import com.lti.model.PotentialCrop;
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
			@RequestMapping(value = "/bidderadd", 
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
					Model model,HttpSession session) 
		{
				if(this.iBidderService.loginBidder(bidder))
				{
				Bidder logBidder = this.iBidderService.returnBidder(bidder);
				session.setAttribute("bidder",logBidder);
				session.setAttribute("bidderId",logBidder.getBidderId());
				session.setAttribute("biddername", logBidder.getBidderName());
				List<FinalCrop> finalCrop =this.iBidderService.listAllCrops();
				session.setAttribute("Finalcrop", finalCrop);
					return "HomeBidder";
				}
				else
					return "redirect:/bidderlogin";
		}
		
		@RequestMapping(value = "/bidderhome")
		public String bidderHome(HttpSession session)
		{
			Bidder bidder=(Bidder)session.getAttribute("bidder");
			int bidderId=(int)session.getAttribute("bidderId");
			String biddername=(String)session.getAttribute("biddername");
			List<FinalCrop> finalCrop =this.iBidderService.listAllCrops();
			session.setAttribute("Finalcrop", finalCrop);
			return "HomeBidder";
		}
		
		
		@RequestMapping(value="/biddersignout",method= RequestMethod.GET)
		public String signout(Model model ,HttpSession session)
		{
			session.invalidate();
			model.addAttribute("bidder",new Bidder());
			return "BidderLogin";
		}

		@RequestMapping("/placebid/{id}")
		public String placeBid(
				@PathVariable("id") int id,Model model,HttpSession session) 
		{
			session.setAttribute("cropId", id);
			FinalCrop placeBid=this.iBidderService.placeBid(id);
			model.addAttribute("placeBid",placeBid);
			return "BidForm";
			
		}
		
		@RequestMapping("/placebid/successbidding")
		public String afterbid(@ModelAttribute("placeBid") 
		@Valid FinalCrop placeBid, 
		BindingResult result, 
		Model model,HttpSession session)
		{
		
			int id=(int)session.getAttribute("cropId");
			this.iBidderService.successBid(placeBid,id);
			List<FinalCrop> finalCrop =this.iBidderService.listAllCrops();
			session.setAttribute("Finalcrop", finalCrop);
			return "redirect:/bidderhome";
			
		}
		
		@RequestMapping("/winningbid")
		public String viewBids(Model model,HttpSession session)
		{
			int bidderId=(int)session.getAttribute("bidderId");
			if(this.iBidderService.checklistBids(bidderId))
			{
				List<AcceptedBid> bidList=this.iBidderService.listBids(bidderId);
				model.addAttribute("bidList",bidList);
				return"Winbid";
			}
			else
				return "redirect:/bidderhome";
		}
}