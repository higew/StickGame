package com.imie.stickgame.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

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
	private User user;
	@Transient
	private Integer size;

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

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Deck() {
		super();
		this.cards = new ArrayList<>();
		this.size = cards.size();
	}

	public Deck(String string) {
		// TODO Auto-generated constructor stub
	}
}