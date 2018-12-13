package com.imie.stickgame.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.imie.stickgame.controllers.UserController;
import com.imie.stickgame.services.RoleService;
import com.imie.stickgame.services.UserService;
import com.imie.stickgame.services.base.BaseService;
import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.models.User;

@Controller
@RequestMapping(UserController.BASE_URL)
//@SessionAttributes("connection")
public class UserController extends BaseController<User>{
	
	public static final String BASE_URL = "/users";
	private static final String BASE_PAGE_NAME = "Users";
	
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

	@Autowired
	RoleService serviceRole;

	@Override
	protected void setOtherAttributes(Model model) {
		model.addAttribute("roles",serviceRole.findAll());
	}

	@Override
	protected void setupOtherFields(User item) {
		//item.setRole(serviceRole.find(item.getRole().getId()).get());
	}
}
