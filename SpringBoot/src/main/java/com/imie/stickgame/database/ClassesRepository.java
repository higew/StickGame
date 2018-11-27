package com.imie.stickgame.database;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Card;
import com.imie.stickgame.models.Classes;
import com.imie.stickgame.models.Deck;



@Repository
public interface ClassesRepository extends BaseCRUDRepository<Classes> {

	List<Card> findCardByName(String name);
	List<Deck> findDeckByName(String name);
	List<Classes> findByName(String name);
	
}
