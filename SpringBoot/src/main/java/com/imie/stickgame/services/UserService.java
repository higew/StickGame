package com.imie.stickgame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imie.stickgame.database.UserRepository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.User;
import com.imie.stickgame.services.base.BaseService;


@Service
public class UserService extends BaseService<User>{

	@Autowired
	private UserRepository userRepository;
	
//	@Autowired
//	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User item) {
		//item.setPassword(bCryptPasswordEncoder.encode(item.getPassword()));
		item.setActive(1);
		super.save(item);
	}

	@Override
	protected BaseCRUDRepository<User> getCRUDRepository() {
		return userRepository;
	}

	@Override
	protected List<User> setItemsByCriterias(User item, List<User> result) {
		if (!item.getFirstname().equals("") && !item.getLastname().equals("")) {
			result = this.userRepository.findByFirstnameAndLastname(item.getFirstname(), item.getLastname());
		} else if (!item.getFirstname().equals("")) {
			result = this.userRepository.findByFirstname(item.getFirstname());
		} else if (!item.getLastname().equals("")) {
			result = this.userRepository.findByLastname(item.getLastname());
		}
		return result;
	}
	
}
