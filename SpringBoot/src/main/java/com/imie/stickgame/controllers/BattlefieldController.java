package com.imie.stickgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.models.Battlefield;
import com.imie.stickgame.services.base.BaseService;
import com.imie.stickgame.services.BattlefieldService;

@Controller
@RequestMapping(BattlefieldController.BASE_URL)
public class BattlefieldController extends BaseController<Battlefield> {
	
	public static final String BASE_URL = "/battlefields";
	private static final String BASE_PAGE_NAME = "Battlefields";
	
	@Autowired
	private BattlefieldService BattlefieldService;

	@Override
	protected BaseService<Battlefield> getBaseService() {
		return BattlefieldService;
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
