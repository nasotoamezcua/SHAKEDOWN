package com.nasoto.intercambios.web.controler;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.nasoto.intercambios.entities.Intercambios;
import com.nasoto.intercambios.forms.IntercambioForm;
import com.nasoto.intercambios.forms.IntercambioFormUtils;
import com.nasoto.intercambios.forms.IntercambiosForm;
import com.nasoto.intercambios.forms.UserFormUtils;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/intercambio")
@SessionAttributes({"intercambios","sizeInterReg","userIntercambios"})
public class IntercambioController {
	
	@Autowired
	private ServletContext context;
	
	@Autowired
	private IntercambioFormUtils interFormUtils;
	
	@Autowired
	private UserFormUtils userFormUtils;
	
	@Autowired
	private Validator intercambiosFormValidator;
	
	@InitBinder("newInter")
	protected void initinterCambiosFormValidator(WebDataBinder binder) {
		binder.setValidator(intercambiosFormValidator);
	}
	
		
	@RequestMapping(value = {"/",""}, method = RequestMethod.GET)
	public String newIntercambio(Model model) {
		log.info("new Intercambio ------------------");
		model.addAttribute("newInter", this.newInterForm());
		return "intercambio/newIntercambio";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String registraIntercambio(Model model, 
			@Valid @ModelAttribute("newInter") IntercambiosForm newInter, BindingResult result) throws IllegalStateException, IOException{
		
		if(result.hasErrors()) {
			return "intercambio/newIntercambio";
		}
		
		List<IntercambioForm> intercambios = this.cargarArchivos(newInter,this.userForm());
		
		Integer sizeInterReg =(intercambios!= null && intercambios.size()>0)? intercambios.size():0;
		
		model.addAttribute("intercambios",intercambios);
		model.addAttribute("sizeInterReg",sizeInterReg);
		
		return "redirect:/intercambio/addOk";
	}
	
	@RequestMapping(value = {"/addOk"}, method = RequestMethod.GET )
	public String adIntercambioOk(Model model, 
			@ModelAttribute("intercambios") List<IntercambioForm> intercambios, 
			@ModelAttribute("sizeInterReg") Integer sizeInterReg) {
		
		model.addAttribute("intercambios",intercambios);
		model.addAttribute("sizeInterReg",sizeInterReg);
		
		return "intercambio/showintercambio";
	}
	
	
	@RequestMapping(value = "/showUserIntercambios", method = RequestMethod.GET)
	public String showIntercambios(Model model) {
		model.addAttribute("listIntercambios", listIntercambios());
		model.addAttribute("usuCap",this.userForm());
		
		int userIntercambios = (listIntercambios() != null && listIntercambios().size()>0) ? listIntercambios().size() : 0;
		
		model.addAttribute("userIntercambios", userIntercambios);
		
		return "intercambio/showIntercambiosReg";
	}
	
	@RequestMapping(value = "/deleteIntercambio/{idInter}", method = RequestMethod.GET)
	public String deleteIntercambio(Model model, @PathVariable("idInter") Long idInter) {
		
		interFormUtils.deleteIntercambio(idInter);
		
		return "redirect:/intercambio/showUserIntercambios";
	}
	
	@ModelAttribute("instrucciones")
	private List<String> instrucciones(){
		
		List<String> lista = new ArrayList<String>();
		lista.add("<span class=\"glyphicon glyphicon-chevron-right\"></span> Registra por lo menos un Intercambio.");
		lista.add("<strong> <span class=\"glyphicon glyphicon-chevron-right\"></span> Para cargar una imagen,  es obligatorio ingresar la opci&oacute;n del Intercambio.</strong> ");
		lista.add("<span class=\"glyphicon glyphicon-chevron-right\"></span> Solo se permite cargar im&aacute;genes con formato:   <strong>jpg, png, gif, bmp</strong> ");
		lista.add("<strong> <span class=\"glyphicon glyphicon-chevron-right\"></span> La imagen a cargar no puede exceder de 5MB.</strong> ");
		lista.add("<strong> <span class=\"glyphicon glyphicon-chevron-right\"></span> No es obligatorio cargar una imagen  por cada opci&oacute;n  de Intercambio.</strong> ");
		lista.add("<strong> <span class=\"glyphicon glyphicon-chevron-right\"></span> Fecha Limite para Registrar Intercambios: 15/12/2017.</strong> ");
		lista.add("</br><strong><span class=\"glyphicon glyphicon-exclamation-sign\"></span> Nota: Los intercambios una vez registrados no puden ser modificados.</strong> ");
		
		
		return lista;
	}
	
	
	private List<IntercambioForm> cargarArchivos(IntercambiosForm newInter, String usuCap) 
			throws IllegalStateException, IOException{
		
		List<IntercambioForm> list = null;
		
		if(newInter.getIntercambiosForms() != null && newInter.getIntercambiosForms().size()>0) {
			list = new ArrayList<IntercambioForm>();
			// Comentar cuando este en produccion
			String path = "C:/Documents and Settings/vngae40/workspace-sts/spring-intercambios-navidad/src/main/webapp/resources/img/intercambios/" +usuCap + "/";
			//String path = context.getRealPath("/resources/img/intercambios/" +usuCap + "/");
			log.info("path --->: {}", path);
			File carpeta = new File(path);
			carpeta.mkdir();
				
				for(IntercambioForm i:newInter.getIntercambiosForms()) {
					
					if(i.getOpcion() != null && !i.getOpcion().isEmpty()) {
						if(i.getFile().getOriginalFilename() != null && !i.getFile().getOriginalFilename().isEmpty()) {
							//if(this.validaImAgen(i.getFile().getOriginalFilename())) {
								File destinationFile = new File(path, i.getFile().getOriginalFilename());	
								i.getFile().transferTo(destinationFile);
								list.add(new IntercambioForm(i.getOpcion(),destinationFile.getName(),path,"glyphicon glyphicon-picture"));
								interFormUtils.registraIntercambio(i, usuCap,destinationFile.getName(),path);
							//}
						}else {
							list.add(new IntercambioForm(i.getOpcion()
									,"no-define","no-define","glyphicon glyphicon-ban-circle"));
							interFormUtils.registraIntercambio(i, usuCap,"no-define","no-define");
						}
					}
				}
		}
		
		return list;
	}
	
	private IntercambiosForm newInterForm() {
		IntercambiosForm intercambiosForm = new IntercambiosForm();
		List<IntercambioForm> listinterForm = new ArrayList<IntercambioForm>();
		for(int i=0;i<5;i++) {
			listinterForm.add(new IntercambioForm());
		}
		
		intercambiosForm.setIntercambiosForms(listinterForm);
		return  intercambiosForm;
	}
	
	private List<Intercambios>listIntercambios() {
		return interFormUtils.listIntercambios(userFormUtils.getUserForm(this.userForm()).getIdCustomer());
	}
	
	private String userForm() {
		Authentication aut = SecurityContextHolder.getContext().getAuthentication();
		return aut.getName();
	}
	
}
