package com.citiustech.contact.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST)
@ControllerAdvice
public class ExceptionHandle {
	
	@ExceptionHandler(value=Exception.class)
	public String exceotionHandler(){
		return "Exception";
	}

}
