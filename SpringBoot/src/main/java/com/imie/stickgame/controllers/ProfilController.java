package com.imie.stickgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.models.User;
import com.imie.stickgame.services.UserService;
import com.imie.stickgame.services.base.BaseService;

@Controller
@RequestMapping(ProfilController.BASE_URL)
public class ProfilController extends BaseController<User> {

	public static final String BASE_URL = "/profil";
	private static final String BASE_PAGE_NAME = "Profil";
	
	@Autowired
	private UserService userService;
	
	@Override
	protected BaseService<User> getBaseService() {
		return userService;
	}

	@Override
	protected String getBaseURL() {
		return BASE_URL;
	}

	@Override
	protected String getBasePageName() {
		return BASE_PAGE_NAME;
	}

	@Override
	protected void setOtherAttributes(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setupOtherFields(User item) {
		// TODO Auto-generated method stub
		
	}
}
