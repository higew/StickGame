package com.imie.stickgame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.imie.stickgame.database.DBItem;

@Entity
@Table(name="deck")
public class Deck extends DBItem {

    @Column(name="card")
    private String card;

    @Column(name="name")
    private String name;

    @Column(name="classe")
    private String classe;

}