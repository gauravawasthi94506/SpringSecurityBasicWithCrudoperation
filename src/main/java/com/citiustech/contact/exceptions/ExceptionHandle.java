package com.citiustech.contact.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;




@ControllerAdvice(basePackages = "com.citiustech.contact")
public class ExceptionHandle {

	private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
	
	@ExceptionHandler(Exception.class)
	public String handleSQLException(HttpServletRequest request, Exception ex){
		logger.info("SQLException Occured:: URL="+request.getRequestURL());
		return "Exception";
	}
	

}