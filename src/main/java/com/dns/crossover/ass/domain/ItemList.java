package com.dns.crossover.ass.domain;

import java.util.List;

public class ItemList<T> {
	
	public ItemList(List<T> lis) {
		this.list = lis;
	}
	
	private List<T> list ;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	

}
