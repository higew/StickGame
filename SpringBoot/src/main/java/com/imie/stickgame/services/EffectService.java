package com.imie.stickgame.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imie.stickgame.database.EffectRepository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Effect;
import com.imie.stickgame.services.base.BaseService;

@Service
public class EffectService extends BaseService<Effect> {

	@Autowired
	private EffectRepository EffectRepository;

	@Override
	protected BaseCRUDRepository<Effect> getCRUDRepository() {
		return EffectRepository;
	}

	@Override
	protected List<Effect> setItemsByCriterias(Effect item, List<Effect> result) {

		if (!item.getName().equals("") ){
			result = this.EffectRepository.findByName(item.getName());
		}
		return result;
	}
}
