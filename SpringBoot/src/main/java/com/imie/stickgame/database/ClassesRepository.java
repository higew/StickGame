package com.imie.stickgame.database;

import org.springframework.stereotype.Repository;


import com.imie.stickgame.database.base.BaseCRUDRepository;
import com.imie.stickgame.models.Classes;


@Repository
public interface ClassesRepository extends BaseCRUDRepository<Classes> {

}
