package com.imie.stickgame.firebase.controllers;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/social")
public class SocialController {
	
	@RequestMapping
	public String index(Model model) throws IOException {
		
	
		
		return "/social";
	}

}
