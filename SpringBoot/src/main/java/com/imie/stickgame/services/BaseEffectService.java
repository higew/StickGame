package com.imie.stickgame.services;

import java.util.List;

import com.imie.stickgame.database.BaseEffectRepository;
import com.imie.stickgame.models.BaseEffect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.services.base.BaseService;

@Service
public class BaseEffectService extends BaseService<BaseEffect> {

	@Autowired
	private BaseEffectRepository BaseEffectRepository;

	@Override
	protected BaseCRUDRepository<BaseEffect> getCRUDRepository() {
		return BaseEffectRepository;
	}

	@Override
	protected List<BaseEffect> setItemsByCriterias(BaseEffect item, List<BaseEffect> result) {

		if (!item.getDescription().equals("") ){
			result = this.BaseEffectRepository.findByEffectIdentifier(item.getEffectIdentifier());
		}
		return result;
	}
}
