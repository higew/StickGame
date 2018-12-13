package com.imie.stickgame.database;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.imie.stickgame.models.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RoleServiceTest {
	
	 @Autowired
	    private RoleRepository roleRepository;

	    @Test
	    public void createAndFind() {
	    	Role role = new Role("ROLE_TEST");
	        roleRepository.save(role);
	     
	        Role found = roleRepository.findByName(role.getName());
	     
	        assertThat(found.getName())
	          .isEqualTo(role.getName());
	    }
	    
	    @Test
	    public void findAndDelete() {
	        Role finded = roleRepository.findByName("ROLE_TEST");
	     
	        assertThat(finded.getName().equals("ROLE_TEST"));
	        
	        roleRepository.delete(finded);
	        
	        Role deleted = roleRepository.findByName("ROLE_TEST");
	        
	        assertThat(deleted).isNull();
	    }
	    

}
