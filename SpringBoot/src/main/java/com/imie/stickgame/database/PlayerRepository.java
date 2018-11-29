package com.imie.stickgame.database;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Player;

@Repository
public interface PlayerRepository extends BaseCRUDRepository<Player> {
	
	List<Player> findByName(String name);
}
