package com.imie.stickgame.security.services;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
	
	//Modif en cours
//	
//	public Role RoleTableExist (EntityManager em, String name) {
//	    TypedQuery<Role> query = em.createQuery(
//	        "SELECT c FROM Role c WHERE c.name = :name", Role.class);
//	    return query.setParameter("name", name).getSingleResult();
//	  } 
	
	public void createFirstAdmin() {
		
		Role role = new Role("ROLE_ADMIN");
		
		this.serviceRole.save(role);
		
		User user = new User("admin@admin.admin", "admin", 1, "stick", "game");
		user.getRoles().add(role);
		this.serviceUser.save(user);
	
	}

	public void createUSER() {
		Role role = new Role("ROLE_USER");
		
		this.serviceRole.save(role);
		
	}

}
