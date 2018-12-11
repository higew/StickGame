package com.imie.stickgame.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.models.Role;
import com.imie.stickgame.services.RoleService;
import com.imie.stickgame.services.base.BaseService;

@Controller
@RequestMapping(RoleController.BASE_URL)
public class RoleController extends BaseController<Role> {
	
	public static final String BASE_URL = "/roles";
	private static final String BASE_PAGE_NAME = "Roles";
	
	@Autowired
	private RoleService roleService;

	@Override
	protected BaseService<Role> getBaseService() {
		return roleService;
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
	protected void setupOtherFields(Role item) {
		// TODO Auto-generated method stub
		
	}


}
