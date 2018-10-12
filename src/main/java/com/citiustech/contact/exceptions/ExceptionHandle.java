package com.citiustech.contact.exceptions;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(value=Exception.class)
	public String exceotionHandler(){
		return "Exception";
	}

}
