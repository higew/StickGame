package com.imie.stickgame.models;

import com.imie.stickgame.database.base.DBItem;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

@Entity
@Table(name="BaseEffect")
public class BaseEffect extends DBItem {

    @Column(name="effectIdentifier")
    private Integer effectIdentifier;
    @Column(name="description")
    private String description;
    @OneToMany(targetEntity=Card.class,mappedBy="baseEffect")
    private List<Card> cards;
    @Column(name="effectPhase")
    private EffectPhase effectPhase;

    public Integer getEffectIdentifier() {
        return effectIdentifier;
    }

    public void setEffectIdentifier(Integer effectIdentifier) {
        this.effectIdentifier = effectIdentifier;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
