package com.imie.stickgame.models;

import javax.persistence.*;

import com.imie.stickgame.database.base.DBItem;

@Entity
@Table(name="Card")
public class Card extends DBItem  {
// implements Effect
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
	private BaseEffect effect;
	@ManyToOne()
	private Classes classes;
	@Transient
    private int atkTemp;

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

	public BaseEffect getEffect() {
		return effect;
	}

	public void setEffect(BaseEffect effect) {
		this.effect = effect;
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

	public Card(String name, String picture, Integer hp, Integer atk, Integer inkCost, BaseEffect effect, Classes
			classes) {
    	super();
		this.name = name;
		this.picture = picture;
		this.hp = hp;
		this.atk = atk;
		this.inkCost = inkCost;
		this.effect = effect;
		this.classes = classes;
	}
}
