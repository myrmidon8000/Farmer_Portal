package com.lti.controller;






import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.model.Farmer;
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
				System.out.println(farmer);
						// new farmer, add it
						this.iFarmerService.addFarmer(farmer);
					
					return "redirect:/farmer";
				}
				
	/*@RequestMapping(value="farmer/add", method = RequestMethod.POST)
	public String farmerRegister(@ModelAttribute("farmer") 
	@Valid Farmer f, 
	BindingResult result, 
	Model model)
	{
		if (!result.hasErrors()) {
				// new person, add it
				this.farmerService.addFarmer(f);
			} else {
		logger.
		
		
		return null;
	}
	public String farmerReg(Model model) {
		model.addAttribute("person", new Farmer());
		model.addAttribute("farmerReg",this.farmerService.farmerReg());
		return "farmer";
	}*/
}