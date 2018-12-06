package com.imie.stickgame.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.imie.stickgame.database.base.DBItem;

public class Player extends DBItem {

    private static final int INKSTART = 1;

	private String name;
	private String picture;
	private Integer hp;
	private Deck deck;
	private Battlefield battlefield;
	private List<Card> hand;
	private int ink;
    private int inkTurn;

    public int getInkTurn() {
        return inkTurn;
    }

    public void setInkTurn(int inkTurn) {
        this.inkTurn = inkTurn;
    }

    public int getInk() {
		return ink;
	}

	public void setInk(int ink) {
		this.ink = ink;
	}

	public List<Card> getHand() {
		return hand;
	}

	public void setHand(List<Card> hand) {
		this.hand = hand;
	}

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

	public Player() {
		super();
	}

	public Player(String name, Deck deck, String picture) {
        super();
        this.name = name;
        this.picture = picture;
        this.hp = 20;
        this.deck = deck;
        this.battlefield = new Battlefield();
        this.hand = new ArrayList<>();
        this.ink = INKSTART;
        this.inkTurn = this.ink;
    }
}