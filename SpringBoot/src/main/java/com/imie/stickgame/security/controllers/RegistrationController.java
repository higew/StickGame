package com.imie.stickgame.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.imie.stickgame.models.User;
import com.imie.stickgame.services.RoleService;
import com.imie.stickgame.services.UserService;
import com.imie.stickgame.validators.UserValidator;

@Controller
public class RegistrationController {

	@Autowired
    private UserService userService;
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
    private UserValidator userValidator;
	
	
	@RequestMapping(value = "/registration", method = RequestMethod.GET)
    public String registration(Model model) {
        return "/security/registration";
    }
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
    public String registration(@ModelAttribute() User user, @RequestParam String passwordconfirm, BindingResult bindingResult, Model model) {
        userValidator.validate(user, bindingResult);

        if (bindingResult.hasErrors() || !user.getPassword().equals(passwordconfirm)) {
            model.addAttribute("postresult",bindingResult);
        	return "redirect:/registration";
        }

        user.getRoles().add(roleService.findByName("ROLE_USER"));
        userService.save(user);
        
        
        return "redirect:/";
    }
}
