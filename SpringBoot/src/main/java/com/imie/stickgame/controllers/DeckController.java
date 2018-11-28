package com.imie.stickgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imie.stickgame.models.Deck;
import com.imie.stickgame.services.DeckService;

import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.services.base.BaseService;

@Controller
@RequestMapping(DeckController.BASE_URL)
public class DeckController extends BaseController<Deck> {

	public static final String BASE_URL = "/deck";
	private static final String BASE_PAGE_NAME = "Deck";
	
	@Autowired
	private DeckService DeckService;

	@Override
	protected BaseService<Deck> getBaseService() {
		return DeckService;
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
	protected void setupOtherFields(Deck item) {
		// TODO Auto-generated method stub
		
	}
	
}
