package com.imie.stickgame.models;

import java.util.ArrayList;

public class Battlefield {

    private ArrayList<Card> discardDeck;
    private Card[] monsterZone;
    
	public ArrayList<Card> getDiscardDeck() {
		return discardDeck;
	}
	
	public Card[] getMonsterZone() {
		return monsterZone;
	}

	public Battlefield() {
	    this.discardDeck = new ArrayList<Card>();
	    this.monsterZone = new Card[5];
    }
}

