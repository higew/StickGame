package com.imie.stickgame.models;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.assertj.core.internal.Classes;

import com.imie.stickgame.database.DBItem;

@Entity
@Table(name="deck")
public class Deck extends DBItem {

    @Column(name="card")
    private ArrayList<Card> cards;
    
	@Column(name="name")
    private String name;
	
	@Column(name="classes")
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