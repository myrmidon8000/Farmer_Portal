package com.lti.controller;



import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.model.Farmer;
import com.lti.service.IFarmerService;
@Controller
@Component
public class FarmerController {
	
	private IFarmerService farmerService;
	@Autowired
	@Qualifier
	public void setFarmerService(IFarmerService fs) {
		this.farmerService = fs;
	}
	
	@RequestMapping(value="/farmer")
	public String gotofarmerregpage(Model model) {
	model.addAttribute("farmer",new Farmer());
		return "FarmerRegistration";
	}
	// For add and update person both
			@RequestMapping(value = "/farmer/add", 
					method = RequestMethod.POST)
			
			public String addFarmer(
					@ModelAttribute("farmer") 
					@Valid Farmer f, 
					BindingResult result, 
					Model model) {
				if (!result.hasErrors()) {
				
						// new farmer, add it
						this.farmerService.addFarmer(f);
					} 
					
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