package com.imie.stickgame.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.imie.stickgame.database.ClassesRepository;
import com.imie.stickgame.database.base.BaseCRUDRepository;

import com.imie.stickgame.models.Classes;
import com.imie.stickgame.services.base.BaseService;

@Service
public class ClassesService extends BaseService<Classes> {
	
	@Autowired
	private ClassesRepository classesRepository;

	@Override
	protected BaseCRUDRepository<Classes> getCRUDRepository() {
		return classesRepository;
	}

	@Override
	protected List<Classes> setItemsByCriterias(Classes item, List<Classes> result) {
		// TODO Auto-generated method stub
		return null;
	}

}
