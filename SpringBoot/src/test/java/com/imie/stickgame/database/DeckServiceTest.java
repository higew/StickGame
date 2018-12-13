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
import com.imie.stickgame.models.Deck;

@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(locations="classpath:test.application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class DeckServiceTest {

	 @Autowired
	    private DeckRepository deckRepository;

	    @Test
	    public void createAndFind() {
	    	Deck deck = new Deck("deck1");
	        deckRepository.save(deck);
	     
	        Deck found = deckRepository.findByName(deck.getName());
	     
	        assertThat(found.getName())
	          .isEqualTo(deck.getName());
	    }
	    
	    @Test
	    public void findAndDelete() {
	        Deck finded = deckRepository.findByName("deck1");
	     
	        assertThat(finded.getName().equals("deck1"));
	        
	        deckRepository.delete(finded);
	        
	        Deck deleted = deckRepository.findByName("deck1");
	        
	        assertThat(deleted).isNull();
	    }
	
}
