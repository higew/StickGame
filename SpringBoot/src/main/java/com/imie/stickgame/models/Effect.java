package com.imie.stickgame.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.imie.stickgame.database.DBItem;

@Entity
@Table(name="Effect")
public class Effect extends DBItem {

	@Column(name="name")
	private String name;
	@Column(name="picture")
	private String picture;
	@Column(name="hp")
	private int hp;
	@Column(name="atk")
	private int atk;
	@Column(name="inkCost")
	private String inkCost;
	
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

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public String getInkCost() {
		return inkCost;
	}

	public void setInkCost(String inkCost) {
		this.inkCost = inkCost;
	}

	public Effect() {
		super();
	}
}
