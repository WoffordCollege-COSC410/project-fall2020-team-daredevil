package edu.wofford.machiwoco;

public class Card {
	//A single Establishment card
	
	private String name;
	private int cost;
	private String color;
	private String icon;
	private int activation;
	
	/**
	* Initializes a Card
	* @param name Card name
	* @param cost Card cost
	* @param color Card color
	* @param icon Card icon
	*/
	public Card(String name, int cost, String color, String icon) {
		this.name = name;
		this.cost = cost;
		this.color = color;
		this.icon = icon;
		activation = 0;
	}

	/**
	* Sets a Card's name
	* @param name The desired name of the Card
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* Returns a Card's name
	* @return The name of the Card
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets a Card's cost
	* @param cost The desired cost of the Card
	*/
	public void setCost(int cost) {
		this.cost = cost;
	}
	
	/**
	* Returns a Card's cost
	* @return The cost of the Card
	*/
	public int getCost() {
		return cost;
	}

	/**
	* Sets a Card's color
	* @param color The desired color of the Card
	*/
	public void setColor(String color) {
		this.color = color;
	}
	
	/**
	* Returns a Card's color
	* @return The color of the Card
	*/
	public String getColor() {
		return color;
	}

	/**
	* Returns a Card's icon
	* @return The icon of the Card
	*/
	public String getIcon() {
		return icon;
	}

	/**
	* Returns a Card's activation number
	* @return The activation number of the Card
	*/
	public int getActivation() {
		return activation;
	}
	
	/**
	* Sets a Card's activation number
	* @param a The desired activation number of the Card
	*/
	public void setActivation(int a) {
		this.activation = a;
	}

}