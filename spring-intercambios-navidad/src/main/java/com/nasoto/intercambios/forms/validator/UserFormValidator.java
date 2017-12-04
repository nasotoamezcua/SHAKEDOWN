package com.nasoto.intercambios.forms.validator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.nasoto.intercambios.entities.Usuario;
import com.nasoto.intercambios.forms.UserForm;
import com.nasoto.intercambios.service.api.IUsuarioService;

public class UserFormValidator implements Validator {
	
	@Autowired
	private IUsuarioService usuarioService;
	
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isAssignableFrom(UserForm.class);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		
		UserForm userForm = (UserForm)obj;
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "user.nombre.required", "El Nombre es requerido.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "mail", "user.mail.required", "El E-Mail es requerido.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "user", "user.user.required", "El Usuario es requerido.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "user.password.required", "El Password es requerido.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirPassword", "user.confirPassword.required", "Confirma tu Password.");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "genero", "user.genero.required", "Selecciona tu Genero.");
		
		//Obtener lista de usuarios tambien accedemos a los correos
		List<Usuario> usuarios = usuarioService.findAll();
		
		//VALIDAR QUE EL USUARIO Y EL CORREO NO SE ENCUENTRE EN LA BASE DE DATOS - SOLO APLICA PARA EL REGISTRO
		if(userForm.getFlagSaveUpdate().trim().equals("save")) {
			if(usuarios != null && usuarios.size()>0) {
				for(Usuario u: usuarios) {
					if(u.getNom_usua().trim().equals(userForm.getUser())) {
						errors.rejectValue("user", "user.user.validBD", new Object[]{userForm.getUser()},"Este Usuario ya esta registrado.");
					}
					if(u.getCusotmer().getMail().trim().equals(userForm.getMail())) {
						errors.rejectValue("mail", "user.mail.validBD", new Object[]{userForm.getMail()},"Este E-Mail ya esta registrado.");
					}
				}
			}
		}
		
		//SI SE ACTULIZA EL CORREO VALIDAR QUE EL NUEVO CORREO NO SE ENCUENTRE EN LA BASE DE DATOS
		if(userForm.getFlagSaveUpdate().trim().equals("update")) {
			
			//Obtener el suario tambien accedemos a su correo
			Usuario usuario = usuarioService.findByUserNameService(userForm.getUser());
			
			if(usuario != null) {
				if(!usuario.getCusotmer().getMail().trim().equals(userForm.getMail())) {
					if(usuarios != null && usuarios.size()>0) {
						for(Usuario u: usuarios) {
							if(u.getCusotmer().getMail().trim().equals(userForm.getMail())) {
								errors.rejectValue("mail", "user.mail.validBD", new Object[]{userForm.getMail()},"Este E-Mail ya esta registrado.");
							}
						}
					}
				}
			}
		}
		
		if(!userForm.getMail().matches(EMAIL_PATTERN)) {
			errors.rejectValue("mail", "user.mail.valid", "Ingresa un email valido.");
		}
		
		if(!userForm.getPassword().trim().equals(userForm.getConfirPassword())) {
			errors.rejectValue("confirPassword", "user.password.valid", "El password no coincide.");
		}
		
	}

}
