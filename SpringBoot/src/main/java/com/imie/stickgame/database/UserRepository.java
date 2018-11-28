package com.imie.stickgame.database;

import java.util.List;

import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.User;

@org.springframework.stereotype.Repository
public interface UserRepository extends BaseCRUDRepository<User>{
	
	User findByEmail(String email);
	List<User> findByFirstname(String firstname);
	List<User> findByLastname(String lastname);
	List<User> findByFirstnameAndLastname(String firstname, String lastname);

}
