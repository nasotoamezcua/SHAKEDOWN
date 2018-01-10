package com.nasoto.intercambios.web.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.nasoto.intercambios.forms.AdminFormUtils;
import com.nasoto.intercambios.forms.UserFormUtils;
import com.nasoto.intercambios.service.api.IUsuarioService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/root")
public class AdminController {
	
	@Autowired
	private UserFormUtils userFormUtils;
	
	@Autowired
	private IUsuarioService userService;
	
	@Autowired
	private AdminFormUtils adminUtils;
	
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String showUsersAdmin(Model model) {
		
		log.info("showUsersAdmin ---->");
		
		model.addAttribute("userFormsAll", userFormUtils.userFormsAll());
		
		return "admin/showUserAdmin";
	}
	
	@RequestMapping(value = "/deleteUser/{idUser}", method = RequestMethod.GET )
	public String deleteUsersAdmin(@PathVariable("idUser") Long idUser) {
		
		userService.delete(idUser);
		
		return "redirect:/root";
	}
	
	@RequestMapping(value = "/blocks", method = RequestMethod.GET)
	public String block(Model model) {
		
		model.addAttribute("listBlocks", adminUtils.findAllBlocks());
		
		return "admin/showBlock";
	}
	
	@RequestMapping(value = "/blocks/desactive/{id}", method = RequestMethod.GET)
	public String blockActive(@PathVariable("id")Long idBlock) {
		
		adminUtils.blockActiveAdmin(idBlock);
		
		return "redirect:/root/blocks";
	}
	
	@RequestMapping(value = "blocks/active/{id}", method = RequestMethod.GET)
	public String blockInActive(@PathVariable("id")Long idBlock) {
		
		adminUtils.blockInactiveAdmin(idBlock);;
		
		return "redirect:/root/blocks";
	}

}
