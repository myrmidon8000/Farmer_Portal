package com.BusReservation.controller;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.BusReservation.model.AuthorizationDetails;
import com.BusReservation.model.AuthorizedUser;
import com.BusReservation.service.ICustomerService;

@Controller
public class BusController {

@Autowired
ICustomerService customerService;

	@RequestMapping("/Login")
	public String showLoginView(Model modal)
	{
		modal.addAttribute("authuser", new AuthorizedUser());
		String view="LoginView";
		return view;
	}
	
	@RequestMapping(value="/registerPage",method=RequestMethod.POST)
	public String validateregistrationPage(@Valid @ModelAttribute("authuser") 
	AuthorizedUser authuser ,BindingResult bindingResult,Model model,HttpServletRequest req)
	{
		String view="";
	if(bindingResult.hasErrors())
	{
		view="successPage";
		return view;
	}
	else
	{
		System.out.println(authuser.getFirstname());
		customerService.AddUser(authuser);
		
		view="successPage";
		return view;
		
	}
	}
	
	@RequestMapping("/Forgot")
	public String showForgetPassword(Model model,HttpServletRequest request)
	{
		model.addAttribute("useremail", new AuthorizationDetails());
		String view="ForgetPassword";
	
		return view;
	}
	
	@RequestMapping("/ForgotProcessing")
public void  ProcessPassword(@RequestParam("email") String email ,BindingResult bindingResult,Model model,HttpServletRequest req)
{
	
		
		List<AuthorizedUser> UserDetails=customerService.fetchPassword(email);
		//String view="success";
				
				
}
}
