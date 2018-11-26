package com.imie.stickgame.models;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import javax.persistence.Table;
import javax.persistence.Transient;



import com.imie.stickgame.database.base.DBItem;



@Entity
@Table(name="Player")
public class Player extends DBItem {

	@Column(name="name")
	private String name;
	@Column(name="picture")
	private String picture;
	@Column(name="hp")
	private Integer hp;
	
	
	@ManyToMany()
	private Deck deck;
	
	//En TEst
		/*
	 @ManyToMany(cascade=CascadeType.ALL, mappedBy="players")  
	    public Set<Deck> getDecks()  
	    {  
	        return getDecks();  
	    }  
	    public void setDecks(Set<Deck> deck)  
	    {  
	        this.Decks = decks;  
	    }  
	*/
	    
	@Transient
	private Battlefield battlefield;

	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getHp() {
		return hp;
	}

	public void setHp(Integer hp) {
		this.hp = hp;
	}

	public Player() {
		super();
	}

	public Deck getDeck() {
		return deck;
	}

	public void setDeck(Deck deck) {
		this.deck = deck;
	}

	public Battlefield getBattlefield() {
		return battlefield;
	}

	public void setBattlefield(Battlefield battlefield) {
		this.battlefield = battlefield;
	}
	
	
}
