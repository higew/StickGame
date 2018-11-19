package com.imie.stickgame.models;

import java.util.ArrayList;

public class Battlefield {

    private ArrayList<Card> discardDeck;
    private Card[] monsterZone; // Mettre la taille du tableau à 5
    
	public ArrayList<Card> getDiscardDeck() {
		return discardDeck;
	}
	public void setDiscardDeck(ArrayList<Card> discardDeck) {
		this.discardDeck = discardDeck;
	}
	public Card[] getMonsterZone() {
		return monsterZone;
	}
	public void setMonsterZone(Card[] monsterZone) {
		this.monsterZone = monsterZone;
	}
    
	public Battlefield() {
		// TODO Auto-generated constructor stub
	}
}