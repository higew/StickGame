package com.imie.stickgame.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class IndexController {

	
	@RequestMapping(value= {"","/","/index"}, method=RequestMethod.GET)
	public String index(Model model) {
		ArrayList<String> roles = new ArrayList<>();
        SecurityContext securityContext = SecurityContextHolder.getContext();
		Collection<? extends GrantedAuthority> role = securityContext.getAuthentication().getAuthorities();
        for (GrantedAuthority grantedAuthority : role) {
            roles.add(grantedAuthority.getAuthority());
        }
        model.addAttribute("roles", roles);
		return "/index";
	}

}
