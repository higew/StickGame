package com.imie.stickgame.database;

import org.springframework.stereotype.Repository;

import com.imie.stickgame.database.base.BaseCRUDRepository;

import com.imie.stickgame.models.Deck;



@Repository
public interface DeckRepository extends BaseCRUDRepository<Deck> {
	
}
