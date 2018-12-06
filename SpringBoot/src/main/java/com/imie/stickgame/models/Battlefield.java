package com.imie.stickgame.models;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {

    private List<Card> discardDeck;
    private List<Card> monsterZone;
    
	public List<Card> getDiscardDeck() {
		return discardDeck;
	}
	
	public List<Card> getMonsterZone() {
		return monsterZone;
	}

	public Battlefield() {
	    this.discardDeck = new ArrayList<Card>();
	    this.monsterZone = new ArrayList<Card>();
    }
}

