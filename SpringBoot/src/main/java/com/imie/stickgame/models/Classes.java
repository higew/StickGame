package com.imie.stickgame.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;



import com.imie.stickgame.database.DBItem;

@Entity
@Table(name="Classes")
public class Classes extends DBItem {

	@Column(name="name")
	private String name;
	@Column(name="picture")
	private String picture;
	@OneToMany(mappedBy="classes")
	private List<Card> cards;
	@OneToMany(mappedBy="classes")
	private List<Deck> deck; 
		
	
	
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
	
	
}
