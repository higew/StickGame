package com.imie.stickgame.database;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.FixMethodOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import com.imie.stickgame.models.Card;
import com.imie.stickgame.models.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CardServiceTest {
	
	 @Autowired
	    private CardRepository cardRepository;

	    @Test
	    public void createAndFind() {
	        Card card = new Card("card1","src/main/resources/static/media/card1.png", 6,2,3, null, null);
	        cardRepository.save(card);
	     
	        Card found = cardRepository.findByName(card.getName());
	     
	        assertThat(found.getName())
	          .isEqualTo(card.getName());
	    }
	    
	    @Test
	    public void findAndDelete() {
	        Card finded = cardRepository.findByName("card1");
	     
	        assertThat(finded.getName().equals("card1"));
	        
	        cardRepository.delete(finded);
	        
	        Card deleted = cardRepository.findByName("card1");
	        
	        assertThat(deleted).isNull();
	    }


}
