package com.imie.stickgame.controllers;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	//TEST
	public String card(Model model) {
		ArrayList<String> roles = new ArrayList<>();
        SecurityContext securityContext = SecurityContextHolder.getContext();
		Collection<? extends GrantedAuthority> role = securityContext.getAuthentication().getAuthorities();
        for (GrantedAuthority grantedAuthority : role) {
            roles.add(grantedAuthority.getAuthority());
        }
        model.addAttribute("roles", roles);
        return "/cards";
	}

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
