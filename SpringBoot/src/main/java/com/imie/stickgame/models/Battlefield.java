package com.imie.stickgame.models;

import java.util.ArrayList;
import java.util.List;

public class Battlefield {

    private List<Card> discardDeck;
    private List<Card> monsterZone;
    private Integer sizeDiscardDeck;
    private Integer sizeMonsterZone;
    
	public List<Card> getDiscardDeck() {
		return discardDeck;
	}
	
	public List<Card> getMonsterZone() {
	    return monsterZone;
	}

    public Integer getSizeDiscardDeck() {
        return sizeDiscardDeck;
    }

    public Integer getSizeMonsterZone() {
        return sizeMonsterZone;
    }

    public Battlefield() {
	    this.discardDeck = new ArrayList<>();
	    this.monsterZone = new ArrayList<>();
	    this.sizeDiscardDeck = this.discardDeck.size();
	    this.sizeMonsterZone = this.monsterZone.size();
    }
}

