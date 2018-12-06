package com.imie.stickgame.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Deck;
import com.imie.stickgame.database.DeckRepository;
import com.imie.stickgame.services.base.BaseService;

@Service
public class DeckService extends BaseService<Deck> {

	@Autowired
	private DeckRepository DeckRepository;

	@Override
	protected BaseCRUDRepository<Deck> getCRUDRepository() {
		return DeckRepository;
	}

	@Override
	protected List<Deck> setItemsByCriterias(Deck item, List<Deck> result) {

		if (!item.getName().equals("") ){
			result = this.DeckRepository.findByName(item.getName());
		}
		return result;
	}

	/**
	 * @return the deckRepository
	 */
	public DeckRepository getDeckRepository() {
		return DeckRepository;
	}

	/**
	 * @param deckRepository the deckRepository to set
	 */
	public void setDeckRepository(DeckRepository deckRepository) {
		DeckRepository = deckRepository;
	}
}
