package com.nasoto.intercambios.web.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nasoto.intercambios.forms.UserFormUtils;



@Controller
@RequestMapping("/welcome")
public class HomeControler {

	@Autowired
	private  UserFormUtils userFormUtils;
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("userFormsAll",userFormUtils.userFormsAll());
		model.addAttribute("usuCap",this.userForm());
		
		return "home/home";
	}
	
	private String userForm() {
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		return aut.getName();
	}
	
	
	
}
