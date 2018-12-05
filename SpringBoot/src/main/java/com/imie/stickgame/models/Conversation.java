package com.imie.stickgame.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.imie.stickgame.database.base.DBItem;

@Entity
@Table(name = "conversation")
public class Conversation extends DBItem {
	
	@OneToMany(mappedBy = "conversations")
	private List<User> users;
	
}
