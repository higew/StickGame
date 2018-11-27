package com.imie.stickgame.dtos.base;

import java.util.ArrayList;
import java.util.List;

import com.imie.stickgame.database.base.DBItem;


public abstract class BaseDeleteCriteriaDTO <T extends DBItem> {

	List<T> items;

	public List<T> getItems() {
		return items;
	}

	public void setItems(List<T> items) {
		this.items = items;
	}

	public BaseDeleteCriteriaDTO() {
		this.items = new ArrayList<T>();
	}
}
