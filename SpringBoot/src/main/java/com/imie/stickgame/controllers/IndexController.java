package com.imie.stickgame.controllers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import com.imie.stickgame.models.User;
import com.imie.stickgame.services.UserService;


@Controller
public class IndexController {

	@Autowired
	UserService userService;

	@RequestMapping(value= {"","/","/index"}, method=RequestMethod.GET)
	public String index(Model model, HttpServletResponse response, HttpServletRequest request) throws UnsupportedEncodingException {
		ArrayList<String> roles = new ArrayList<>();
        SecurityContext securityContext = SecurityContextHolder.getContext();
		Collection<? extends GrantedAuthority> role = securityContext.getAuthentication().getAuthorities();
        for (GrantedAuthority grantedAuthority : role) {
            roles.add(grantedAuthority.getAuthority());	 
        }
        model.addAttribute("roles", roles);

        User user = userService.findByEmail(securityContext.getAuthentication().getName());
  	    model.addAttribute("user", user);
        
		return "/index";
	}

}
