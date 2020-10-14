package edu.wofford.machiwoco;


public class Player {
	
	Establishment[] ecards;
	private boolean cityHall;
	private int coins;
	
	
	public Player() {
		//3 starting cards WheatField, Forest, Ranch
		ecards = new Establishment[20];
		ecards[0] = new Establishment("Wheat Field", 1, "blue", "wheat");
		ecards[1] = new Establishment("Ranch", 1, "blue", "cow");
		ecards[2] = new Establishment("Forest", 3, "blue", "gear");
		cityHall = false;
		coins = 3;
		
	}
	
	public boolean hasCityHall() {
		return cityHall;
	}
	
	public void getCards() {
		
	}
	
	//how many of each card?
	
	public int getCoins() {
		return coins;
	}
	
	
	public static void main(String[] args) {
		
	}
}