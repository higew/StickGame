package com.imie.stickgame.firebase.controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imie.stickgame.models.User;
import com.imie.stickgame.services.UserService;

@Controller
@RequestMapping("/social")
public class SocialController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value= {"", "/"})
	public String index(Model model) throws IOException {
	SecurityContext securityContext = SecurityContextHolder.getContext();
    User user = userService.findByEmail(securityContext.getAuthentication().getName());
	model.addAttribute("user", user);
		
		return "/social/index";
	}

}
