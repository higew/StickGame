package com.imie.stickgame.models;


import java.util.ArrayList;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import javax.persistence.Table;


import com.imie.stickgame.database.base.DBItem;



@Entity
@Table(name="deck")
public class Deck extends DBItem {
	@ManyToMany
    private ArrayList<Card> cards;
	//test
	//private ArrayList<Card> cards;
	@Column(name="name")
    private String name;	
	@ManyToOne()
    private Classes classes;
	//TestAjout
	//@ManyToMany	
    //@JoinTable(name="deck_card")
	//public Set<Card> getCard() { 
	//	return cards; 
	//}
	
	/*
	@ManyToMany()
    private Player player;
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="player_deck", joinColumns=@JoinColumn(name="deck_id"), inverseJoinColumns=@JoinColumn(name="player_id"))  
    public Set<Player> getPlayers()  
    {  
        return getPlayers();  
    }  
    public void setPlayers(Set<Player> players)  
    {  
        this.players = players;  
    }  
    */

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