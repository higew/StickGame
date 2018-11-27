package com.imie.stickgame.models;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;


import javax.persistence.ManyToOne;

import javax.persistence.Table;

import com.imie.stickgame.database.base.DBItem;





@Entity
@Table(name="Card")
public class Card extends DBItem {

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
	private Effect effect;
	
	@ManyToOne()
	private Classes classes;
	
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
	
	

	public Effect getEffect() {
		return effect;
	}

	public void setEffect(Effect effect) {
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
}
