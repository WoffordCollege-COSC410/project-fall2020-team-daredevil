package edu.wofford.machiwoco;


public class Player {
	
	int[] ecards;
	private boolean cityHall;
	private int coins;
	private boolean myTurn;
	private int index = 0;
	
	
	public Player() {
		//3 starting cards WheatField, Forest, Ranch
		ecards = new int[3];
		//array only stores num of cards for each type
		ecards[0] = 1;
		System.out.println(ecards[0]);
		cityHall = false;
		coins = 3;
		myTurn = false;
		index++;
	}
	
	public boolean hasCityHall() {
		return cityHall;
	}
	
	public void addCard(String s) {
		if (s.equals("w") || s.equals("W")) {
			ecards[0] = ecards[0] + 1;
		} else if (s.equals("r") || s.equals("R")) {
			ecards[1] = ecards[1] + 1;
		} else if (s.equals("f") || s.equals("F")) {
			ecards[2] = ecards[2] + 1;
		}
	}
	
//	public String getLastCard() {
//		//String e = ecards[index].getName();
//		//return e;
//	}
	
	public boolean getTurn() {
		return myTurn;
	}
	
	public void setTurn(boolean b) {
		myTurn = b;
	}
	
	//how many of each card?
	
	public int getCoins() {
		return coins;
	}
	
	public void addCoins(int c) {
		coins = c + coins;
	}
	
	public void removeCoins(int c) {
		coins = coins - c;
	}
	
//	public static void main(String[] args) {
//		Player p1 = new Player();
//		System.out.println(p1.getLastCard());
//	}
}