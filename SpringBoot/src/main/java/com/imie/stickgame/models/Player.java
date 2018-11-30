package com.imie.stickgame.models;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
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
	@OneToMany
	private List<Deck> decks;
	@Transient
	private Deck deck;
	@Transient
	private Battlefield battlefield;
	@Transient
	private ArrayList<Card> hand;
	@Transient
	private int ink;
	@Transient
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

	public List<Deck> getDecks() {
		return decks;
	}

	public void setDecks(List<Deck> decks) {
		this.decks = decks;
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
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

	public Player(String name, Deck deck) {
        super();
        this.name = name;
        this.hp = 20;
        this.deck = deck;
        this.battlefield = new Battlefield();
        this.hand = new ArrayList<Card>();
        this.ink = 1;
        this.inkTurn = 1;
    }
}

// Pioche une carte à chaque tour ou le nombre de carte manquante pour retourner au max ?