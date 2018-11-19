package com.imie.stickgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.models.Classes;
import com.imie.stickgame.services.ClassesService;
import com.imie.stickgame.services.base.BaseService;

@Controller
@RequestMapping(ClassesController.BASE_URL)
public class ClassesController extends BaseController<Classes> {
	
	public static final String BASE_URL = "/classes";
	private static final String BASE_PAGE_NAME = "Classes";
	
	@Autowired
	private ClassesService ClassesService;

	@Override
	protected BaseService<Classes> getBaseService() {
		return ClassesService;
	}

	@Override
	protected String getBaseURL() {
		return BASE_URL;
	}

	@Override
	protected String getBasePageName() {
		return BASE_PAGE_NAME;
	}

}
