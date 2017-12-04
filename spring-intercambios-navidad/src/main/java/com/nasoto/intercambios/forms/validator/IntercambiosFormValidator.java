package com.nasoto.intercambios.forms.validator;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.nasoto.intercambios.forms.IntercambioForm;
import com.nasoto.intercambios.forms.IntercambiosForm;

@Component("intercambiosFormValidator")
public class IntercambiosFormValidator implements Validator {

	//No permite espacios en blanco en el nombre del archivo a cargar
	//private static final String IMAGE_PATTERN = "([^\\s]+(\\.(?i)(jpg|png|gif|bmp))$)"; 
	//Permite espacios en blanco en el nombre del archivo a cargar
	//SOLO CARGA IMAGENES EN FORMATO JPG,PNG,GIF y BMP
	private static final String IMAGE_PATTERN = "(.+(\\.(?i)(jpg|png|gif|bmp))$)";

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(IntercambiosForm.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		IntercambiosForm intForm = (IntercambiosForm)obj;
		
		if(intForm.getIntercambiosForms() != null && intForm.getIntercambiosForms().size() >0) {
			int index =0;
			int formVacio = 0;
			for(IntercambioForm i: intForm.getIntercambiosForms()) {
				
				if(i.getOpcion().isEmpty()) formVacio++;
				
				if(formVacio == 5) {
					errors.rejectValue("intercambiosForms[0].opcion", 
							"intercambio.opcion.empty",
							"Ingresa tu Intercambio.");
				}
				
				if(i.getOpcion().isEmpty() && !i.getFile().getOriginalFilename().isEmpty()) {
					errors.rejectValue("intercambiosForms["+index+"].opcion", 
							"intercambio.opcion.required", 
							new Object[]{(index+1)},
							"Ingresa tu Intercambio.");
				}
				
				if(!i.getOpcion().isEmpty() && !i.getFile().getOriginalFilename().isEmpty()) {
					if(!i.getFile().getOriginalFilename().matches(IMAGE_PATTERN)) {
						errors.rejectValue("intercambiosForms["+index+"].file", 
								"intercambio.file.required" ,
								new Object[]{i.getFile().getOriginalFilename(),"jpg","png","gif","bmp"},
								"Ingresa un formato valido.");
					}
				}
				
				index++;
			}
			
		}
		
	}
	
}
