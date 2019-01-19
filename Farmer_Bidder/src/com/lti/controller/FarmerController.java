package com.lti.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.lti.model.AcceptedBid;
import com.lti.model.Bidder;
import com.lti.model.Farmer;
import com.lti.model.FinalCrop;
import com.lti.model.PotentialCrop;
import com.lti.service.IAdminService;
import com.lti.service.IFarmerService;

@Controller
public class FarmerController {
	
	@Autowired
	private IFarmerService iFarmerService;
	
	public void setIFarmerService(IFarmerService iFarmerService) {
		this.iFarmerService = iFarmerService;
	}
	@Autowired
	private IAdminService iAdminService;
	
	public void setIAdminService(IAdminService iAdminService) {
		this.iAdminService = iAdminService;
	}

	@RequestMapping(value="/farmer")
	public String gotofarmerregpage(Model model) {
	model.addAttribute("farmer",new Farmer());
		return "FarmerRegistration";
	}
	
// To add a farmer
			@RequestMapping(value = "/add", 
					method = RequestMethod.POST)
			public String addFarmer(
					@ModelAttribute("farmer") 
					@Valid Farmer farmer, 
					BindingResult result, 
					Model model) {
				if(!result.hasErrors())
				{// new farmer, add it
						this.iFarmerService.addFarmer(farmer);
				}
					return "redirect:/login";
				}
		
			
			@RequestMapping(value = "/farmerlogin")
			public String LoginPage(Model model) {
				model.addAttribute("farmer",new Farmer());
				return "FarmerLogin";
			}
					
		@RequestMapping(value = "/farmerloginprocess", 
					method = RequestMethod.POST)
			public String farmerLogin(
					@ModelAttribute("farmer") 
					@Valid Farmer farmer, 
					BindingResult result, 
					Model model,HttpSession session) {
			if(farmer.getEmail().equalsIgnoreCase("admin")&&farmer.getPassword().equalsIgnoreCase("admin"))
			{
				session.setAttribute("adminusername", farmer.getEmail());
				session.setAttribute("adminpassword", farmer.getPassword());
				List<PotentialCrop> croplist =this.iAdminService.listAllCrops();
				model.addAttribute("Croplist", croplist);
				return "AdminHome";
			}
			if(this.iFarmerService.loginFarmer(farmer))
				{				
						Farmer logFarmer = this.iFarmerService.returnFarmer(farmer);
						session.setAttribute("farmer",logFarmer);
						Integer id =  logFarmer.getFarmerId();
						session.setAttribute("farmerId", id);
						session.setAttribute("farmername", logFarmer.getFarmerName());
						return "HomeFarmer";
				}
				else
					return "redirect:/farmerlogin";
				}
		
		@RequestMapping(value="/profile")
		public String viewProfile(Model model,HttpSession session)
		{
			model.addAttribute(session.getAttribute("farmer"));
			return "FarmerProfile";
		}
		@RequestMapping(value="/sellcrop")
		public String sellCrop(Model model,HttpSession session) {
		model.addAttribute("potentialcrop",new PotentialCrop());
			return "CropSell";
		}
		
		@RequestMapping(value="/sellcropprocess", 
				method = RequestMethod.POST)
		public String addCrop(@ModelAttribute("potentialcrop") 
					@Valid PotentialCrop potentialcrop, 
					BindingResult result, 
					Model model,HttpSession session) {
			Farmer f=(Farmer)session.getAttribute("farmer");
			int id = potentialcrop.getFarmerId();
			if(id==f.getFarmerId())
			{
			potentialcrop.setRequestStatus("PENDING");
			this.iFarmerService.addCrop(potentialcrop);
			return "redirect:/farmerhome";
			}
			else 
			{
				return "redirect:/sellcrop";
			}
		}
		
		@RequestMapping(value="/cropstatus",method = RequestMethod.GET)
		public String cropStatus(Model model,HttpSession session)
		{
		Integer id=(Integer)session.getAttribute("farmerId");
		if(this.iFarmerService.checkAllCrops(id))
		{
			List<PotentialCrop> cropList=this.iFarmerService.listAllCrops(id);
			model.addAttribute("CropList",cropList);
			return "ViewStatus";
		}
		else
			return "redirect:/farmerhome";
	}
		
		@RequestMapping(value="/signout",method= RequestMethod.GET)
		public String signout(Model model ,HttpSession session)
		{
			session.invalidate();
			model.addAttribute("farmer",new Farmer());
			return "redirect:/farmerlogin";
		}
		
		
	@RequestMapping(value="bidstatus")
	public String viewBids(Model model,HttpSession session)
	{
		int id=(int)session.getAttribute("farmerId");
		if(this.iFarmerService.checklistBids(id))
		{
			List<AcceptedBid> bidList=this.iFarmerService.listBids(id);
			if(bidList.get(0).getBidStatus().equals("ACCEPTED"))
			{
				int id1=(int)bidList.get(0).getBidderid();
				Bidder finalbidder = this.iFarmerService.getbidder(id1);
				session.setAttribute("winBidder", finalbidder);
				model.addAttribute("bidList",bidList);
				return "BidList";
			}
			else 
			{
				model.addAttribute("bidList",bidList);
				return "BidList";
			}
		}
			else
				return "redirect:/farmerhome";
	}

	@RequestMapping(value="/viewWinnerDetails/{id}")
	public String viewWinnerDetails(@PathVariable("id") int id,Model model,HttpSession session)
	{
			int id1=(int)session.getAttribute("farmerId");
			List<AcceptedBid> bidList=this.iFarmerService.listBids(id1);
		
				if(bidList.get(0).getBidStatus().equals("ACCEPTED"))
				{
					Bidder finalbidder = this.iFarmerService.getbidder(id);
					model.addAttribute("winBidder", finalbidder);
					return "WinnerDetails";
			}
				else {
					model.addAttribute("bidList",bidList);
					return "BidList";	
				}
	}
	
	
	@RequestMapping("/farmerhome")
	public String farmerhome(Model model, HttpSession session)
	{

		Farmer farmer=(Farmer)session.getAttribute("farmer");
		int farmerId=(int)session.getAttribute("farmerId");
		String farmername=(String)session.getAttribute("farmername");
		session.setAttribute("farmer",farmer);
		session.setAttribute("farmerId", farmerId);
		session.setAttribute("farmername",farmername);
		return "HomeFarmer";
	}
	
	//ADMIN
	@RequestMapping("/accept/{id}")
	public String acceptCrop(
			@PathVariable("id") int id,Model model) 
	{
		this.iAdminService.acceptCrop(id);
		this.iAdminService.insertFinal();
		List<PotentialCrop> croplist=this.iAdminService.listAllCrops();
		model.addAttribute("Croplist", croplist);
		return "redirect:/adminhome";
	}
	
	
	//ADMIN
		@RequestMapping("/reject/{id}")
		public String rejectCrop(
				@PathVariable("id") int id,Model model) 
		{
			this.iAdminService.rejectCrop(id);
			List<PotentialCrop> croplist=this.iAdminService.listAllCrops();
			model.addAttribute("Croplist", croplist);
			return "redirect:/adminhome";
		}
	
	//ADMIN
	@RequestMapping(value="/acceptbid")
	public String acceptbid(Model model)
	{
		if(this.iAdminService.checkAllFinalCrops())
		{
		List<AcceptedBid> bidList=this.iAdminService.listAllFinalCrops();
		model.addAttribute("bidList",bidList);
		return "AcceptBids";
		}
		else 
		return "redirect:/adminhome";
	}
	
	//ADMIN
	@RequestMapping("/acceptbid/{id}")
	public String acceptBid(
			@PathVariable("id") int id,Model model) 
	{
		this.iAdminService.acceptBid(id);
		return "redirect:/acceptbid";
	}
	
	//ADMIN
	@RequestMapping("/adminhome")
	public String adminHome(Model model,HttpSession session)
	{
		String username=(String)session.getAttribute("username");
		String password=(String)session.getAttribute("password");
		session.setAttribute("username", username);
		session.setAttribute("password", password);
		List<PotentialCrop> croplist =this.iAdminService.listAllCrops();
		model.addAttribute("Croplist", croplist);
		return "AdminHome";
	}
	
	//ADMIN
	@RequestMapping("/home")
	public String gotohome()
	{
		return "redirect:/adminhome";
	}
	
	//ADMIN
			@RequestMapping(value="/adminsignout",method= RequestMethod.GET)
			public String adminsignout(	Model model ,HttpSession session)
			{
				session.invalidate();
				model.addAttribute("farmer",new Farmer());
				return "redirect:/farmerlogin";
			}
	
	
	
	
	
	
	
	
	
	
	
	@RequestMapping(value="/forgotpassword")
	public String forgotpassword(Model model) {
		model.addAttribute("farmer",new Farmer());
		return"FarmerForgotPassword";
	}
	
	/*@RequestMapping(value="/resetpassword",method = RequestMethod.POST)
	public String forgotpassword(@ModelAttribute("farmer") 
	@Valid Farmer farmer, 
	BindingResult result, 
	Model model,HttpSession session) {
		if(this.iFarmerService.forgotpassword(farmer))
		{
			Farmer f=this.iFarmerService.getpasswordfarmer(farmer);
			model.addAttribute("farmer",f);
			return "FarmerChangePassword";
		}
		else
			return "FarmerForgotPassword";
	}
	@RequestMapping(value="/resetpassword",method = RequestMethod.POST)
	public String setpassword(@ModelAttribute("farmer") 
	@Valid Farmer farmer, 
	BindingResult result, 
	Model model,HttpSession session) {
		this.iFarmerService.setNewPassword(farmer);
		model.addAttribute("farmer",new Farmer());
		return "FarmerLogin";
	}*/
	}
