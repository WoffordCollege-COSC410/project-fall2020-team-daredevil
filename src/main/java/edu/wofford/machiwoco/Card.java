package edu.wofford.machiwoco;

public class Card {
	//A single Establishment card
	
	private String name;
	private int cost;
	private String color;
	private String icon;
	private int activation;
	
	public Card(String name, int cost, String color, String icon) {
		this.name = name;
		this.cost = cost;
		this.color = color;
		this.icon = icon;
		activation = 0;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	public int getCost() {
		return cost;
	}

	public void setColor(String color) {
		this.color = color;
	}
	
	public String getColor() {
		return color;
	}

	public String getIcon() {
		return icon;
	}

	public int getActivation() {
		return activation;
	}
	
	public void setActivation(int a) {
		this.activation = a;
	}

}