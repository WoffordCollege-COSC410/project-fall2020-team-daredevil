package edu.wofford.machiwoco;

public class Establishment {
	//A single Establishment card
	
	private String name;
	private int cost;
	private enum Color {B, G, R, P, N}; 
	private enum Icon {W, B, C, G, F, O, U, T};
	//private e[] = new 
	
	
	public Establishment(String name, int cost) {
		this.name = name;
		this.cost = cost;
	}
	
	public static void main(String[] args) {
		//USE ME TO TEST CLASS
	}
}