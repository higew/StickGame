package com.imie.stickgame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imie.stickgame.database.RoleRepository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Role;
import com.imie.stickgame.services.base.BaseService;

@Service
public class RoleService extends BaseService<Role>{
	
	@Autowired
	private RoleRepository roleRepository;

	@Override
	protected List<Role> setItemsByCriterias(Role item, List<Role> result) {
		if (!item.getName().equals("")) {
			result = this.roleRepository.findByName(item.getName());
		}
		return result;
	}

	@Override
	protected BaseCRUDRepository<Role> getCRUDRepository() {
		return roleRepository;
	}
	
	public List<Role> findByName(String name) {
		return this.roleRepository.findByName(name);
	}
	
}
