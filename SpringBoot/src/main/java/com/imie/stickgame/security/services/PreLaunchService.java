package com.imie.stickgame.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imie.stickgame.models.Role;
import com.imie.stickgame.models.User;
import com.imie.stickgame.services.RoleService;
import com.imie.stickgame.services.UserService;



@Service
public class PreLaunchService {
	
	@Autowired
	private RoleService serviceRole;
	
	@Autowired
	private UserService serviceUser;
	
	public void createFirstAdmin() {
		
		Role role = new Role("ADMIN");
		
		this.serviceRole.save(role);
		
		User user = new User("admin@admin.admin", "admin", 1, "stick", "game");
		user.getRoles().add(role);
		this.serviceUser.save(user);
	
	}

}
