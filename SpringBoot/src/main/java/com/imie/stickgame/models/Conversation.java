package com.imie.stickgame.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.imie.stickgame.database.base.DBItem;

@Entity
@Table(name = "conversation")
public class Conversation extends DBItem {
	
//	@OneToMany
//	private List<Message> messages;
//
//	public List<Message> getMessages() {
//		return messages;
//	}
//
//	public void setMessages(List<Message> messages) {
//		this.messages = messages;
//	}

}
