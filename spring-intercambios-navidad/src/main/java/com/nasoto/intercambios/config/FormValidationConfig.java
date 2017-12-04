package com.nasoto.intercambios.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.Validator;

import com.nasoto.intercambios.forms.validator.UserFormValidator;

@Configuration
public class FormValidationConfig {
	
	@Bean
	public Validator userFormValidator() {
		return new UserFormValidator();
	}
	
	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
		messageBundle.setBasename("classpath:messages");
		messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}

}
