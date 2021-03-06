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
    private static final int HPSTART = 20;

	private String name;
	private String picture;
	private Integer hp;
	private Deck deck;
	private Battlefield battlefield;
	private List<Card> hand;
	private Integer sizeHand;
	private Integer ink;
    private Integer inkTurn;
    private Boolean isWaiting;

    public Boolean getWaiting() {
        return isWaiting;
    }

    public void setWaiting(Boolean waiting) {
        isWaiting = waiting;
    }

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

	public Integer getSizeHand() {
		return sizeHand;
	}

	public void setSizeHand(Integer sizeHand) {
		this.sizeHand = sizeHand;
	}

	public Player() {
		super();
	}

	public Player(String name, Deck deck, String picture) {
        super();
        this.name = name;
        this.picture = picture;
        this.hp = HPSTART;
        this.deck = deck;
        this.battlefield = new Battlefield();
        this.hand = new ArrayList<>();
        this.ink = INKSTART;
        this.inkTurn = this.ink;
        this.sizeHand = this.hand.size();
    }
}