package edu.wofford.machiwoco;

public class Establishment {
	//A single Establishment card
	
	private String name;
	private int cost;
	private enum Color {B, G, R, P, N};
	private String color;
	private enum Icon {W, B, C, G, F, O, U, T};
	private String icon;
	private String activation;
	//0 is recieve, 1 is exchange
	private int effectType;
	//0 bank, 1 active, 2 choice, 3 others
	private int effectTarget;
	//The amount changed by the effect
	private int effectAmount;
	//TODO
	//modifierType
	//modifier
	
	public Establishment(String name, int cost, String color, String icon) {
		this.name = name;
		this.cost = cost;
		this.color = color;
		this.icon = icon;
		activation = "";
		effectType = 0;
		effectTarget = 0;
		effectAmount = 0;
	}
	
	//TODO setEffect() 
	public static void main(String[] args) {
		//USE ME TO TEST CLASS
	}
}