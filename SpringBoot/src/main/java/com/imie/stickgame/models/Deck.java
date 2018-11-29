package com.imie.stickgame.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.imie.stickgame.database.base.DBItem;

@Entity
@Table(name = "deck")
public class Deck extends DBItem {

	@ManyToMany
	private List<Card> cards;
	@Column(name = "name")
	private String name;
	@ManyToOne
	private Classes classes;
	@ManyToOne
	private Player player;

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Deck() {
		super();
	}
}