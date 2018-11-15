package com.imie.stickgame.entity.library;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="deck")
public class Deck {

    @Column(name="card")
    private String card;

    @Column(name="name")
    private String name;

    @Column(name="classe")
    private String classe;

}