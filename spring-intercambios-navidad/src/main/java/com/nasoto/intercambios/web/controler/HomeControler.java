package com.nasoto.intercambios.web.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nasoto.intercambios.forms.AdminFormUtils;
import com.nasoto.intercambios.forms.UserFormUtils;



@Controller
@RequestMapping("/welcome")
@SessionAttributes("regIntercambioBlock")
public class HomeControler {

	@Autowired
	private  UserFormUtils userFormUtils;
	
	@Autowired
	private AdminFormUtils adminUtils;
	
	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public String home(Model model) {
		
		model.addAttribute("userFormsAll",userFormUtils.userFormsAll());
		model.addAttribute("usuCap",this.userForm());
		
		//VALIDAR SI EL REGISTRO DE INTERCAMBIOS ESTA RESTRINGIDO
		model.addAttribute("regIntercambioBlock", adminUtils.findIdBlocks(1L));
		
		return "home/home";
	}
	
	private String userForm() {
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		return aut.getName();
	}
	
	
	
}
