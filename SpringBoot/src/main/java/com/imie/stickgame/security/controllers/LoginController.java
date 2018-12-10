package com.imie.stickgame.security.controllers;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.imie.stickgame.models.User;
import com.imie.stickgame.security.CustomAuthenticationSuccessHandler;

@Controller
public class LoginController {
	
	public static final String FORM_PASSWORD = "password";
	public static final String FORM_USERNAME = "username";
	private static final String SECURITY_LOGIN = "/security/login";
	public static final String LOGIN = "/login";

	@RequestMapping(value = { LOGIN }, method = RequestMethod.GET)
	public String index(Model model, Principal principal, HttpServletRequest request) throws Exception {
		model.addAttribute("form_username",FORM_USERNAME);
		model.addAttribute("form_password",FORM_PASSWORD);
		
		//Ajout Test
//		String referer = request.getHeader("Referer");
//		
//		request.getSession().setAttribute(CustomAuthenticationSuccessHandler.REDIRECT_URL_SESSION_ATTRIBUTE_NAME, referer); 
		
		return SECURITY_LOGIN;
	}

}
