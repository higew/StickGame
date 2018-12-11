package com.imie.stickgame.models;

import com.imie.stickgame.database.base.DBItem;

import javax.persistence.*;

@Entity
@Table(name="Card")
public class Card extends DBItem  {

	@Column(name="name")
	private String name;
	@Column(name="picture")
	private String picture;
	@Column(name="hp")
	private Integer hp;
	@Column(name="atk")
	private Integer atk;
	@Column(name="inkCost")
	private Integer inkCost;
	@ManyToOne()
	private BaseEffect baseEffect;
	@ManyToOne()
	private Classes classes;
    @Transient
    private int atkTemp;
	@Transient
    private Effect effect;

	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
		this.effect = effect;
	}

	public int getAtkTemp() {
        return atkTemp;
    }

    public void setAtkTemp(int atkTemp) {
        this.atkTemp = atkTemp;
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

	public Integer getAtk() {
		return atk;
	}

	public void setAtk(Integer atk) {
		this.atk = atk;
	}

	public Integer getInkCost() {
		return inkCost;
	}

	public void setInkCost(Integer inkCost) {
		this.inkCost = inkCost;
	}

	public BaseEffect getBaseEffect() {
		return baseEffect;
	}

	public void setBaseEffect(BaseEffect baseEffect) {
		this.baseEffect = baseEffect;
	}

	public Classes getClasses() {
		return classes;
	}

	public void setClasses(Classes classes) {
		this.classes = classes;
	}

	public Card() {
		super();
	}

	public Card(String name, String picture, Integer hp, Integer atk, Integer inkCost, BaseEffect baseEffect, Classes
			classes) {
    	super();
		this.name = name;
		this.picture = picture;
		this.hp = hp;
		this.atk = atk;
		this.inkCost = inkCost;
		this.baseEffect = baseEffect;
		this.classes = classes;
	}
}
