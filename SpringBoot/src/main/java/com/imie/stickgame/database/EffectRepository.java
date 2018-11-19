package com.imie.stickgame.database;

import org.springframework.stereotype.Repository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Effect;

@Repository
public interface EffectRepository extends BaseCRUDRepository<Effect> {

}
