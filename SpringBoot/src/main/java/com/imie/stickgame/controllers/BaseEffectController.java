package com.imie.stickgame.controllers;

import com.imie.stickgame.models.BaseEffect;
import com.imie.stickgame.services.BaseEffectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.services.base.BaseService;

@Controller
@RequestMapping(BaseEffectController.BASE_URL)
public class BaseEffectController extends BaseController<BaseEffect> {
	
	public static final String BASE_URL = "/baseeffects";
	private static final String BASE_PAGE_NAME = "BaseEffects";
	
	@Autowired
	private BaseEffectService BaseEffectService;

	@Override
	protected BaseService<BaseEffect> getBaseService() {
		return BaseEffectService;
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
	protected void setupOtherFields(BaseEffect item) {
		// TODO Auto-generated method stub
	}
}
