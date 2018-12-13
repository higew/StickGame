package com.imie.stickgame.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imie.stickgame.controllers.base.BaseController;
import com.imie.stickgame.models.User;
import com.imie.stickgame.services.UserService;
import com.imie.stickgame.services.base.BaseService;
import com.imie.stickgame.validators.ProfilValidator;

@Controller
@RequestMapping(ProfilController.BASE_URL)
public class ProfilController extends BaseController<User> {

	public static final String BASE_URL = "/profil";
	private static final String BASE_PAGE_NAME = "Profil";
	
	@Autowired
	private UserService userService;
	
	@Autowired
    private ProfilValidator profilValidator;
	
	@Override
	protected BaseService<User> getBaseService() {
		return userService;
	}

	@RequestMapping(value = "", method = RequestMethod.POST)
    public String profil(@ModelAttribute() User user,@RequestParam String chgtPasswordConfirm, BindingResult bindingResult, Model model) {
        profilValidator.validate(user, bindingResult);
        
        if (bindingResult.hasErrors() || !user.getPassword().equals(chgtPasswordConfirm)) {
            model.addAttribute("postresult",bindingResult);
        	return "redirect:/";
        }

        userService.save(user);
        
        
        return "redirect:/";
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
		SecurityContext securityContext = SecurityContextHolder.getContext();
		User user = userService.findByEmail(securityContext.getAuthentication().getName());
	  	model.addAttribute("user", user);
	}

	@Override
	protected void setupOtherFields(User item) {
		// TODO Auto-generated method stub
		
	}
}
