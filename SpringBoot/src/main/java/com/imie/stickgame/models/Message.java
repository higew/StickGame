package com.imie.stickgame.models;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.imie.stickgame.database.base.DBItem;

@Entity
@Table(name = "message")
public class Message extends DBItem {
	
	@Column(name = "content")
	private String content;

	@Column(name = "date")
	private Date date;

	@OneToMany(mappedBy = "messages")
	private List<User> users;
	
	@OneToOne  
    private Conversation conversations ;


	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) {
		this.content = content;
	}

	/**
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(List<User> users) {
		this.users = users;
	}

	/**
	 * @return the conversations
	 */
	public Conversation getConversations() {
		return conversations;
	}

	/**
	 * @param conversations the conversations to set
	 */
	public void setConversations(Conversation conversations) {
		this.conversations = conversations;
	}
	
}
