package com.nasoto.intercambios.web.controler.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.nasoto.intercambios.web.controler.CuentaControler;
import com.nasoto.intercambios.web.controler.HomeControler;
import com.nasoto.intercambios.web.controler.IntercambioController;
import com.nasoto.intercambios.web.controler.LoginControler;
import com.nasoto.intercambios.web.controler.RegistrarController;


@ControllerAdvice(assignableTypes = {LoginControler.class, RegistrarController.class,
		CuentaControler.class, HomeControler.class, IntercambioController.class  })
public class ErrorHandlingControllerAdvice {
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ModelAndView onException(Exception re) {
		
		ModelAndView model = new ModelAndView();
		
		RestResponseError rre = new RestResponseError(HttpStatus.BAD_REQUEST, re.getMessage(), re.getClass().getSimpleName());
		model.addObject("rre", rre);
		model.setViewName("error/403");
		
		return model;
		
	}

}
