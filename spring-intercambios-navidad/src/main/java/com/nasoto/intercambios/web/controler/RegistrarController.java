package com.nasoto.intercambios.web.controler;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
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

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes({"userFormCreated"})
public class RegistrarController {
	
	@Autowired
	private UserFormUtils userFormsUtils;
	
	@Autowired
	private Validator userFormValidator;
	
	@InitBinder("userForm")
	protected void initBinderUserForm(WebDataBinder binder) {
		binder.setValidator(userFormValidator);
	}
	
	
	@RequestMapping(value = {"/registrar","/registrar/"}, method = RequestMethod.GET)
	public String showRegistrar(Model model) {
		log.info("show registar page ------------------");
		
		model.addAttribute("userForm", new UserForm());
		
		return "login/registrar";
	}
	
	@RequestMapping(value= {"/registrar"}, method = RequestMethod.POST)
	public String registarUser(Model model,
			@Valid @ModelAttribute("userForm") UserForm userForm, BindingResult result) {
		
		if(result.hasErrors()) {
			return "login/registrar";
		}
		
			userFormsUtils.registraUserForm(userForm);
			model.addAttribute("userFormCreated",userForm);
		
		return "redirect:/registrarUsuario";
	}
	
	@RequestMapping(value = "/registrarUsuario", method = RequestMethod.GET)
	public String showUser(Model model,
			@ModelAttribute("userFormCreated") UserForm userFormCreated) {
		
		model.addAttribute("userFormCreated", userFormCreated);
		
		return "login/registrarUsuario";
	}
	
	@ModelAttribute("genders")
	public List<String> genders() {
		List<String> genders = new ArrayList<String>();
		genders.add("Femenino");
		genders.add("Masculino");
		return genders;
	}

}
