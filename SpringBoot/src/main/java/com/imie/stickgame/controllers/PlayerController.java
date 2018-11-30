package com.imie.stickgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.models.Player;
import com.imie.stickgame.services.base.BaseService;
import com.imie.stickgame.services.PlayerService;

@Controller
@RequestMapping(PlayerController.BASE_URL)
public class PlayerController extends BaseController<Player> {

	public static final String BASE_URL = "/players";
	private static final String BASE_PAGE_NAME = "Players";

	@Autowired
	private PlayerService PlayerService;

	@Override
	protected BaseService<Player> getBaseService() {
		return PlayerService;
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
	protected void setupOtherFields(Player item) {
		// TODO Auto-generated method stub
		
	}
}
