package com.nasoto.intercambios.web.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nasoto.intercambios.forms.AdminFormUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class LoginControler {
	
	@Autowired
	private AdminFormUtils adminUtils;
	
	@RequestMapping(value = {"","/","/login"}, method = RequestMethod.GET)
	public String showLoginPage(Model model,
				@RequestParam(required = false, value = "error") boolean error,
				@RequestParam(required = false, value = "sesion") boolean sesion) {
		
		log.info("show login page ------------------");
		
		if(error) {
			model.addAttribute("errorMessage","Nombre de usuario o password incorrectos.");
		}if(sesion) {
			model.addAttribute("errorMessage","Session Finalizada.");
		}
		
		//VALIDAR SI EL REGISTRO DE USUARIOS ESTA RESTRINGIDO		
		model.addAttribute("regUserBlock", adminUtils.findIdBlocks(2L));
		
		return "login/login";
	}
	
	@RequestMapping(value = "/access-denied", method = RequestMethod.GET)
	public String accessDenied() {
		
		return "error/403";
	}
}
