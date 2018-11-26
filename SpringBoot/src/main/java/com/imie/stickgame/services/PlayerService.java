package com.imie.stickgame.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imie.stickgame.database.PlayerRepository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Player;
import com.imie.stickgame.services.base.BaseService;

@Service
public class PlayerService extends BaseService<Player> {

	@Autowired
	private PlayerRepository PlayerRepository;

	@Override
	protected BaseCRUDRepository<Player> getCRUDRepository() {
		return PlayerRepository;
	}

	@Override
	protected List<Player> setItemsByCriterias(Player item, List<Player> result) {

		if (!item.getName().equals("") ){
			result = this.PlayerRepository.findByName(item.getName());
		}
		return result;
		
	}
}
