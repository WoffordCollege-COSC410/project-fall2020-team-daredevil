package edu.wofford.machiwoco;

/**
 * 
 */
public class Player {
	/*
	private static int[] pCards = {1, 0, 0};
	//private static int[] coins = {3, 3};
	private int coins;
	private String pName;
	//private int turn;


	/**
	* Creates new instance of Player
	*/

	/*
	public Player(String name) {
		pName = name;
		//array only stores num of cards for each type
		coins = 3;
//		turn = 0;
	}

	/**
	* This method adds a card to Player N's deck. 
	* @param availableCards, cardCost, choice, cardName
	* 
	*/
	
	/*
	public void purchaseCard(int[] availableCards, int[] cardCost, int choice, String[] cardName) {
		if (choice == 99) {
			System.out.println(pName + " chose not to make any improvements.");
			System.out.println();
		} else {
			for (int i = 0; i < 3; i++) {
				if (choice == i + 1) {
					System.out.println(pName + " purchased a " + cardName[i]);
					System.out.println();
					availableCards[i] -= 1;
					pCards[i] += 1;
					coins -= cardCost[i];  
				}	
			}
		}
	}
	
//	TODO setName()
	
	/**
	 * This method gets the amount of coins Player N has.
	 * @return coins
	 */

	/*
	public int getCoins() {
		return coins;
	}
		
	/**
	 * This method adds coins to Player N's inventory.
	 * @param c is the int value that Player N's coins should increase.
	 */

	/*
	public void addCoins(int c) {
		if (c >= 0) {
			coins = c + coins;
		} 
	}
	
	/**
	 * This method removes coins from Player N's inventory.
	 * @param c is the int value that Player N's coins should decrease.
	 */

	/*
	public void removeCoins(int c) {
		if (c > 0) {
			coins = coins - c;
		}
	}
		



	int[] ecards;
	private boolean cityHall;
	
	/**
	 * Creates new instance of Player
	 */

	/*
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
	 * This method checks if Player N has constructed the City Hall.
	 * @return cityHall 
	 */

	/*
	public boolean hasCityHall() {
		return cityHall;
	}
	
	/**
	 * This method adds a card to Player N's inventory. 
	 * @param s is the string "w", "r", "f", or "city" representing the 
	 * card that will be given to player N.
	 */


	/*
	public void addCard(String s) {
		if (s.equals("w") || s.equals("W")) { //Adding extra coins here?
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
	 * This method gets the amount of Wheat Field cards Player N has.
	 * @return ecards[0]
	 */


	/*
	public int getNumWheat(){
		return ecards[0];
	}
	
	/**
	 * This method gets the amount of Ranch cards Player N has.
	 * @return ecards[1]
	 */

	/*
	public int getNumRanch(){
		return ecards[1];
	}
	
	/**
	 * This method gets the amount of Forest cards Player N has.
	 * @return ecard[2]
	 */


	/*
	public int getNumForest(){
		return ecards[2];
	}
	
	/**
	 * This method gets the turn of Player N.
	 * @return myTurn
	 */


	/*
	public boolean getTurn() {
		return myTurn;
	}
	
	/**
	 * @param b is true or false to set
	 * This method sets the turn for Player N.
	 * @param b is a boolean value that sets player N's turn.
	 */

	/*
	public void setTurn(boolean b) {
		myTurn = b;
	}
	
	/**
	 * This method gets the amount of coins Player N has.
	 * @return coins
	 */

	/*
	public int getCoins() {
		return coins;
	}
	
	/**
	 * This method adds coins to Player N's inventory.
	 * @param c is the int value that Player N's coins should increase.
	 */


	/*
	public void addCoins(int c) {
		coins = c + coins;
	}
	
	/**
	 * This method removes coins from Player N's inventory.
	 * @param c is the int value that Player N's coins should decrease.
	 */

	/*
	public void removeCoins(int c) {
		coins = coins - c;
	}
	
//	public static void main(String[] args) {
//		Player p1 = new Player();
//		System.out.println(p1.getLastCard());
//	}
	*/
}