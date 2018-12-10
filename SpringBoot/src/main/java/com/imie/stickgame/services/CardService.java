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
		
	public List<Card> setItemsByCriterias(Card item, List<Card> result) {
		
		if (!item.getHp().equals("")) {
			result = this.cardRepository.findByHp(item.getHp());
		} else if (!item.getAtk().equals("")) {
			result = this.cardRepository.findByAtk(item.getAtk());
		} else if (!item.getInkCost().equals("")) {
			result = this.cardRepository.findByInkCost(item.getInkCost());	
		} else if (!item.getHp().equals("") && !item.getAtk().equals("")) {
			result = this.cardRepository.findByHpAndAtk(item.getHp(), item.getAtk());
		} else if (!item.getHp().equals("") && !item.getInkCost().equals("")) {
			result = this.cardRepository.findByHpAndInkCost(item.getHp(), item.getInkCost());
		} else if (!item.getAtk().equals("") && !item.getInkCost().equals("")) {
			result = this.cardRepository.findByAtkAndInkCost(item.getAtk(), item.getInkCost());
		} else if (!item.getHp().equals("") && !item.getAtk().equals("") && !item.getInkCost().equals("")) {
			result = this.cardRepository.findByHpAndAtkAndInkCost(item.getHp(), item.getAtk(), item.getInkCost());		
		}
		return result;
	}

	public Card findByName(String name) {
		return this.cardRepository.findByName(name);
	}
	
}
