package com.imie.stickgame.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imie.stickgame.database.CardRepository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Card;
import com.imie.stickgame.services.base.BaseService;

@Service
public class CardService extends BaseService<Card> {

	@Autowired
	private CardRepository cardRepository;

	@Override
	protected BaseCRUDRepository<Card> getCRUDRepository() {
		return cardRepository;
	}

	@Override
	protected List<Card> setItemsByCriterias(Card item, List<Card> result) {
		// TODO Auto-generated method stub
		return null;
	}
}
