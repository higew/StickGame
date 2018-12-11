package com.imie.stickgame.database;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Card;

@Repository
public interface CardRepository extends BaseCRUDRepository<Card> {

	Card findByName(String name);
	List<Card> findByHp(Integer hp);
	List<Card> findByAtk(Integer atk);
	List<Card> findByInkCost(Integer inkCost);
	List<Card> findByHpAndAtk(Integer hp, Integer atk);
	List<Card> findByHpAndInkCost(Integer hp, Integer inkCost);
	List<Card> findByAtkAndInkCost(Integer atk, Integer inkCost);
	List<Card> findByHpAndAtkAndInkCost(Integer hp, Integer atk, Integer inkCost);

}
