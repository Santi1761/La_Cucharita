package model;

import java.io.Serializable;

public class Products implements Comparable<Products>, Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String type;
	private String[] ingredients;
	private String size;
	private double price;
	public boolean state;
	
	
	public Products (String name, String type, String[] ingredients, String size, double price) {
		this.name=name;
		this.price=price;
		state=true;
		this.type=type;
		this.size=size;
	
	}
	
	public String getAllIngredients(String separator) {
		String temp="";
		for(int i=0;i<ingredients.length-1;i++) {
			temp+=ingredients[i]+separator;
		}
		temp+=ingredients[ingredients.length];
		String a=temp+"";
		return a;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name=name;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public String[] getIngredients() {
		return ingredients;
	}
	
	public void setIngredients(String[] ingredients) {
		this.ingredients=ingredients;
	}
	
	public String getSize() {
		return size;
	}
	
	public void setSize(String size) {
		this.size=size;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
	
	
	public boolean getState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state=state;
	}
	
	
	
	
	@Override
	public int compareTo(Products o) {
		
		
		return (int) (price-o.price);
	}
		
	}

