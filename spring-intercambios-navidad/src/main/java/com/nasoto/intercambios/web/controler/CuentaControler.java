package com.nasoto.intercambios.web.controler;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nasoto.intercambios.forms.UserForm;
import com.nasoto.intercambios.forms.UserFormUtils;


@Controller
@RequestMapping("/cuenta")
@SessionAttributes({"userCuenta"})
public class CuentaControler {
	
	@Autowired
	private UserFormUtils utils;
	
	@Autowired
	private Validator userFormValidator;
	
	@InitBinder("userCuenta")
	protected void initBinderUserForm(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String showCuenta(Model model) {
		
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		String usuarioForm = aut.getName();
		
		UserForm userSessionForm = utils.getUserForm(usuarioForm);
		
		model.addAttribute("userCuenta",userSessionForm);
		
		return "cuenta/showCuenta";
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.GET)
	private String updateCuenta(Model model,
			@ModelAttribute("userCuenta") UserForm userCuenta) {
		
			if(userCuenta == null) {
				return "redirect:/cuenta";
			}
		
			model.addAttribute("userCuenta", userCuenta);
		
		return "cuenta/updateCuenta";
	}
	
	@RequestMapping(value= {"/update"}, method = RequestMethod.POST)
	public String registarUser(Model model,
			@Valid @ModelAttribute("userCuenta") UserForm userCuenta, BindingResult result) {
		
		if(result.hasErrors()) {
			return "cuenta/updateCuenta";
		}
		
			utils.updateUserForm(userCuenta);
			model.addAttribute("userCuenta",userCuenta);
		
		return "redirect:/cuenta/updateCuenta";
	}
	
	@RequestMapping(value = "/updateCuenta", method = RequestMethod.GET)
	public String showUser(Model model,
			@ModelAttribute("userCuenta") UserForm userCuenta) {
		
		model.addAttribute("userCuenta", userCuenta);
		
		return "cuenta/updateCuentaOk";
	}
	
	@ModelAttribute("genders")
	public List<String> genders() {
		List<String> genders = new ArrayList<String>();
		genders.add("Femenino");
		genders.add("Masculino");
		return genders;
	}
}
