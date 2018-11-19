package com.imie.stickgame.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.imie.stickgame.database.DBItem;

@Entity
@Table(name="Effect")
public class Effect extends DBItem {

	@Column(name="name")
	private String name;
	@Column(name="inkCost")
	private Integer inkCost;

	@OneToMany(targetEntity=Card.class,mappedBy="effect")
	private List<Card>cards;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

	public Integer getInkCost() {
		return inkCost;
	}

	public void setInkCost(Integer inkCost) {
		this.inkCost = inkCost;
	}

	public Effect() {
		super();
	}
}
