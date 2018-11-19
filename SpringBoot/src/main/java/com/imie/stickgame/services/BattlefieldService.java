package com.imie.stickgame.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imie.stickgame.database.BattlefieldRepository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Battlefield;
import com.imie.stickgame.services.base.BaseService;

@Service
public class BattlefieldService extends BaseService<Battlefield> {

	@Autowired
	private BattlefieldRepository BattlefieldRepository;

	@Override
	protected BaseCRUDRepository<Battlefield> getCRUDRepository() {
		return BattlefieldRepository;
	}

	@Override
	protected List<Battlefield> setItemsByCriterias(Battlefield item, List<Battlefield> result) {
		// TODO Auto-generated method stub
		return null;
	}
}
