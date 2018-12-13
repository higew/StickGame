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
     
        User foundEmail = userRepository.findByEmail(user.getEmail());
     
        assertThat(foundEmail.getEmail())
          .isEqualTo(user.getEmail());
        
        List<User> foundFirstname = userRepository.findByFirstname(user.getFirstname());
        
        List<User> foundLastname = userRepository.findByLastname(user.getLastname());
        
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
