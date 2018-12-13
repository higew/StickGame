package com.imie.stickgame.database;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.imie.stickgame.models.User;


@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class UserServiceTest {


    @Autowired
    private UserRepository userRepository;

    @Test
    public void createAndFind() {
        User user = new User("email@site.com","heavyTest81442873",1,"test","user");
        userRepository.save(user);
     
        User found = userRepository.findByEmail(user.getEmail());
     
        assertThat(found.getEmail())
          .isEqualTo(user.getEmail());
    }
    
    @Test
    public void findAndDelete() {
        User finded = userRepository.findByEmail("email@site.com");
     
        assertThat(finded.getEmail().equals("email@site.com"));
        
        userRepository.delete(finded);
        
        User deleted = userRepository.findByEmail("email@site.com");
        
        assertThat(deleted).isNull();
    }

}
