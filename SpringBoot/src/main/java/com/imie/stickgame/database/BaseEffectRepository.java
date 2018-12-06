package com.imie.stickgame.database;

import java.util.List;

import com.imie.stickgame.models.BaseEffect;
import org.springframework.stereotype.Repository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Effect;

@Repository
public interface BaseEffectRepository extends BaseCRUDRepository<BaseEffect> {

	List<BaseEffect> findByEffectIdentifier(Integer effectIdentifier);

	List<BaseEffect> findByDescription(String description);
}
