package com.imie.stickgame.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.imie.stickgame.database.DBItem;

@Entity
@Table(name="deck")
public class Deck extends DBItem {
	@ManyToMany
    private ArrayList<Card> cards;
	@Column(name="name")
    private String name;	
	@ManyToOne()
    private Classes classes;

    public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(ArrayList<Card> cards) {
		this.cards = cards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



}