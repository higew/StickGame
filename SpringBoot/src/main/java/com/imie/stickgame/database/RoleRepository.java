package com.imie.stickgame.database;

import java.util.List;

import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Role;

@org.springframework.stereotype.Repository
public interface RoleRepository extends BaseCRUDRepository<Role>{

	List<Role> findByName(String name);
	
}
