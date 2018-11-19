package com.imie.stickgame.database;

import java.util.List;

import org.springframework.stereotype.Repository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Card;

@Repository
public interface CardRepository extends BaseCRUDRepository<Card> {

	List<Card> findByName(String name);

}
