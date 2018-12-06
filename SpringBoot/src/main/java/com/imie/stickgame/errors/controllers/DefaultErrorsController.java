package com.imie.stickgame.errors.controllers;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException.NotFound;
import org.springframework.web.client.HttpClientErrorException.Unauthorized;
import org.springframework.web.client.HttpServerErrorException.InternalServerError;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;



@ControllerAdvice
public class DefaultErrorsController {
	
	@ExceptionHandler(value= {Exception.class})
	public ModelAndView handleAllExceptions(Exception ex, WebRequest request) throws Exception {
		
		ModelAndView modelAndView = new ModelAndView();
		
		if (ex instanceof AccessDeniedException || ex instanceof Unauthorized) {
			modelAndView.setViewName("/errors/403");
		}else if (ex instanceof NotFound) {
			modelAndView.setViewName("/errors/404");	
		}else if (ex instanceof InternalServerError) {
			modelAndView.setViewName("/errors/500");	
		} 
//		else {
//			modelAndView.setViewName("/errors/500");
//		}
		return modelAndView;
	}
	
	

}
