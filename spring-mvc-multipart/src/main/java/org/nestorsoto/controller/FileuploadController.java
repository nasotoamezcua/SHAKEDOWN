package org.nestorsoto.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

import org.nestorsoto.bean.Intercambio;
import org.nestorsoto.forms.IntercambioForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "multipart")
public class FileuploadController {

	@Autowired
	private ServletContext context;
	
	@RequestMapping(value = {"/",""} , method = RequestMethod.GET)
	public String uploadMultipart(Model model) {
		model.addAttribute("intercambioForm", new IntercambioForm());
		return "formMultipart";
	}
	
	@RequestMapping(value = {"/", ""} , method = RequestMethod.POST)
	public String uploadMultipartPost(Model model, @ModelAttribute("intercambioForm") IntercambioForm intercambioForm) {
		
		 List<Intercambio> viewIntercambios = this.cargaArchivos(intercambioForm);
		 
		 System.out.println(viewIntercambios);
		
			if(viewIntercambios != null && viewIntercambios.size() >0 ) {
				model.addAttribute("listIntercambios", viewIntercambios);
				return "showMultipart";
			}
			else return "showMultipart";
	}
	
	private List<Intercambio>  cargaArchivos(IntercambioForm intercambioForm){
		
		if(intercambioForm.getIntercambios() != null && intercambioForm.getIntercambios().size()>0) {
			try {
				List<Intercambio> lisIntercambios = new ArrayList<Intercambio>();
				for(Intercambio intercambio : intercambioForm.getIntercambios()) {
					
					// Comentar cuando este en produccion
					String path = "C:/Documents and Settings/vngae40/workspace-sts/spring-mvc-multipart/src/main/webapp/resources/imgIntercambios/nestor";
					//String path = context.getRealPath("/imgIntercambios/nestor");
					File carpeta = new File(path);
					carpeta.mkdir();
					File destinationFile  = new File(path,intercambio.getFile().getOriginalFilename());
					if(!destinationFile.exists())	intercambio.getFile().transferTo(destinationFile);
					lisIntercambios.add(new Intercambio(intercambio.getName(), "A", destinationFile.getName(),path));
				}
				return lisIntercambios;
			}catch (Exception e) {
				// TODO: handle exception
				return null;
			}
		}else return null;
		
		
		
		
		
	}
	
}
