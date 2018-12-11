package com.imie.stickgame.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imie.stickgame.database.ProfilRepository;


@Service
public class ProfilService {

	@Autowired
	private ProfilRepository profilRepository;

}
