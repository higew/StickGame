package com.imie.stickgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.models.Effect;
import com.imie.stickgame.services.base.BaseService;
import com.imie.stickgame.services.EffectService;

@Controller
@RequestMapping(EffectController.BASE_URL)
public class EffectController extends BaseController<Effect> {
	
	public static final String BASE_URL = "/Effects";
	private static final String BASE_PAGE_NAME = "Effects";
	
	@Autowired
	private EffectService EffectService;

	@Override
	protected BaseService<Effect> getBaseService() {
		return EffectService;
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
