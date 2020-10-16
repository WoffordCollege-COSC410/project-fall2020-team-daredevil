package edu.wofford.machiwoco;

/**
 * 
 */
public class Player {
	
	int[] ecards;
	private boolean cityHall;
	private int coins;
	private boolean myTurn;
	
	/**
	 * Creates new instance of Player
	 */
	public Player() {
		//1 starting card of Wheat
		ecards = new int[3];
		//array only stores num of cards for each type
		ecards[0] = 1;
		cityHall = false;
		coins = 3;
		myTurn = false;
	}

	/**
	 * @return cityHall 
	 */
	public boolean hasCityHall() {
		return cityHall;
	}
	
	/**
	 * 
	 * @param s is which Establishment or Landmark to add 
	 */
	public void addCard(String s) {
		if (s.equals("w") || s.equals("W")) {
			ecards[0] = ecards[0] + 1;
		} else if (s.equals("r") || s.equals("R")) {
			ecards[1] = ecards[1] + 1;
		} else if (s.equals("f") || s.equals("F")) {
			ecards[2] = ecards[2] + 1;
		} else if (s.equals("city")) {
			cityHall = true;
		}
	}
	
	/**
	 * @return ecards[0]
	 */
	public int getNumWheat(){
		return ecards[0];
	}
	
	/**
	 * @return ecards[1]
	 */
	public int getNumRanch(){
		return ecards[1];
	}
	
	/**
	 * @return ecard[2]
	 */
	public int getNumForest(){
		return ecards[2];
	}
	
	/**
	 * @return myTurn
	 */
	public boolean getTurn() {
		return myTurn;
	}
	
	/**
	 * @param b is true or false to set
	 */
	public void setTurn(boolean b) {
		myTurn = b;
	}
	
	//how many of each card?
	/**
	 * @return coins
	 */
	public int getCoins() {
		return coins;
	}
	
	/**
	 * @param c
	 */
	public void addCoins(int c) {
		coins = c + coins;
	}
	
	/**
	 * @param c
	 */
	public void removeCoins(int c) {
		coins = coins - c;
	}
	
//	public static void main(String[] args) {
//		Player p1 = new Player();
//		System.out.println(p1.getLastCard());
//	}
}