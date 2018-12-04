package com.imie.stickgame.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.imie.stickgame.database.base.DBItem;

@Entity
@Table(name = "message")
public class Message extends DBItem {
	
	@Column(name = "label")
	private String label;

	@Column(name = "date")
	private Date date;

//	@ManyToOne
//	private List<Conversation> conversations;
	
	@OneToMany(mappedBy = "messages")
	private List<User> users;

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

//	public List<Message> getMessages() {
//		return messages;
//	}
//
//	public void setMessages(List<Message> messages) {
//		this.messages = messages;
//	}

//	public List<Conversation> getConversations() {
//		return conversations;
//	}
//
//	public void setConversations(List<Conversation> conversations) {
//		this.conversations = conversations;
//	}

}
