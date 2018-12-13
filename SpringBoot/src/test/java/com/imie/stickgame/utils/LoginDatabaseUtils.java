package com.imie.stickgame.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imie.stickgame.database.RoleRepository;
import com.imie.stickgame.database.UserRepository;
import com.imie.stickgame.models.User;
import com.imie.stickgame.security.services.PreLaunchService;


@Service
public class LoginDatabaseUtils {

	@Autowired
	public PreLaunchService preLaunchService;

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public RoleRepository roleRepository;

	public void CreateAdminAndUser() {
		preLaunchService.createFirstAdmin();
		preLaunchService.createUserWithRole(new User("user@site.com", "greatUser", 1, "myUser", "forSite"), "USER");
	}

	public void RemoveAdminAndUser() {
		userRepository.delete(userRepository.findByEmail("admin@site.com"));
		userRepository.delete(userRepository.findByEmail("user@site.com"));
		roleRepository.delete(roleRepository.findByName("ADMIN"));
		roleRepository.delete(roleRepository.findByName("USER"));
	}
}
