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

import com.lti.model.Farmer;

import com.lti.model.PotentialCrop;
import com.lti.service.IFarmerService;

@Controller
public class FarmerController {
	
	@Autowired
	private IFarmerService iFarmerService;
	
	public void setIFarmerService(IFarmerService iFarmerService) {
		this.iFarmerService = iFarmerService;
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
			potentialcrop.setRequestStatus("PENDING");
		Farmer f=(Farmer)session.getAttribute("farmer");
			this.iFarmerService.addCrop(potentialcrop);
			return "HomeFarmer";
			
		}
		@RequestMapping(value="/signout",method= RequestMethod.GET)
		public String signout(	Model model ,HttpSession session)
		{
			session.invalidate();
			model.addAttribute("farmer",new Farmer());
			return "FarmerLogin";
		}
		
	@RequestMapping(value="/cropstatus",method = RequestMethod.GET)
		public String cropStatus(Model model,HttpSession session)
		{
		Integer id=(Integer)session.getAttribute("farmerId");
		System.out.println(id);
			List<PotentialCrop> cropList=this.iFarmerService.listAllCrops(id);
			System.out.println(cropList);
			model.addAttribute("CropList",cropList);
			return "ViewStatus";
		}
}