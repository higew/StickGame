package com.imie.stickgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.models.Card;
import com.imie.stickgame.services.base.BaseService;
import com.imie.stickgame.services.CardService;

@Controller
@RequestMapping(CardController.BASE_URL)
public class CardController extends BaseController<Card> {
	
	public static final String BASE_URL = "/cards";
	private static final String BASE_PAGE_NAME = "Cards";
	
	@Autowired
	private CardService CardService;

	@Override
	protected BaseService<Card> getBaseService() {
		return CardService;
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
	protected void setupOtherFields(Card item) {
		// TODO Auto-generated method stub
		
	}
}
