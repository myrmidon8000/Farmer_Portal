package com.lti.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.lti.dao.IAdminDao;
import com.lti.model.Admin;
import com.lti.model.Farmer;
import com.lti.model.PotentialCrop;

@Controller
public class LoginController {
	@Autowired
	private IAdminDao iAdminDao;

	public void setiAdminDao(IAdminDao iAdminDao) {
		this.iAdminDao = iAdminDao;
	}
	
	@RequestMapping(value = "/login")
	public String userType(Model model)
	{
		return "typeofuser";
	}
	@RequestMapping(value="/adminlogin")
	public String admin(Model model)
	{
		model.addAttribute("admin",new Admin());
		return "AdminLogin";
	}
	@RequestMapping(value="/adminloginprocess",method = RequestMethod.POST)
	public String adminLogin(
			@ModelAttribute("admin") 
			@Valid Admin admin, 
			BindingResult result, 
			Model model,HttpSession session) {
		if(admin.getAdminUserName().equalsIgnoreCase("admin")&&admin.getAdminPassword().equalsIgnoreCase("admin"))
			{
			session.setAttribute("admin", admin);
			List<PotentialCrop> cropList=this.iAdminDao.listAllCrops();
			System.out.println(cropList);
			model.addAttribute("CropList", cropList);
			return "AdminHome";
			}
		else {
	return "AdminLogin";
			}
	
	}
	
	
}
