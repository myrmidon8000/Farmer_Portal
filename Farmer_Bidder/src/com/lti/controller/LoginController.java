package com.lti.controller;

import java.util.List;

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

import com.lti.dao.IAdminDao;

import com.lti.model.Farmer;
import com.lti.model.PotentialCrop;

@Controller
public class LoginController {

	@RequestMapping(value = "/login")
	public String userType(Model model)
	{
		return "typeofuser";
	}
	
	
	
}
