package com.imie.stickgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.models.Conversation;
import com.imie.stickgame.services.ConversationService;
import com.imie.stickgame.services.base.BaseService;

@Controller
@RequestMapping(SocialController.BASE_URL)
public class SocialController extends BaseController<Conversation> {

	public static final String BASE_URL = "/social";
	private static final String BASE_PAGE_NAME = "Social";
	
	@Autowired
	private ConversationService conversationService;

	@Override
	protected String getBaseURL() {
		return BASE_URL;
	}

	@Override
	protected String getBasePageName() {
		return BASE_PAGE_NAME;
	}

	@Override
	protected BaseService<Conversation> getBaseService() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void setOtherAttributes(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void setupOtherFields(Conversation item) {
		// TODO Auto-generated method stub
		
	}
}
