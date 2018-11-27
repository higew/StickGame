package com.imie.stickgame.database.base;

import org.springframework.data.repository.CrudRepository;
import com.imie.stickgame.database.base.DBItem;

public interface BaseCRUDRepository<T extends DBItem> extends CrudRepository<T, Integer>  {
	
}
