package edu.wofford.machiwoco;

import java.util.Random;

public class Player {
	private int[] pCards; 
	private static String[] cardName;
	private static int[] activation;
    private int coins; 


	/**
	* Creates new instance of Player
	*/
	public Player() {
		pCards = new int[] {1, 0, 0};
		cardName = new String[] {"Wheat Field", "Ranch", "Forest"};
		activation = new int[] {1, 2, 5};
		coins = 3;
	} 
	
//	public String purchaseCard(int choice, int[] cardCost, int[] availableCards, String[] cardName) {
//		int p = 0;
//		int n = 0;
//		String str = "";
//		
//		GameState g = new GameState();
//
//		//if none of possible options, reprompt, check at that first index
//		while (p < 3) {  //TODO need while loop?
//			if (choice == p + 1 && coins >= cardCost[p]) {
//				str = str + "Player " + (turn + 1) + " purchased the " + cardName[p] + "\n";
//				availableCards[p] -= 1;
//				coins -= cardCost[p];
//				pCards[p] += 1; 
//			} else if (coins >= 7 && choice == n) {
//				cityHall = turn + 1;
//				str = str + "Player " + (turn + 1) + " constructed the City Hall" + "\n";
//				coins -= 7; //TODO put in cardCost arr?
//				break;
//			} else if (choice == 99) {
//				str = str + "Player " + (turn + 1) + " chose not to make any improvements." + "\n";
//				break;
//			}
//			p++;
//		}
//		return str;
//	}
	
	/**
	* Get the number from a Player's deck. 
	* @param i the index to return
	* @return The 
	*/
	public int getPCards(int i) {
		return pCards[i];
	}
	public void setPCards(int i) {
		//set pcards at the index passed in
		pCards[i] += 1;
	}

	/**
	 * This method gets the amount of coins Player N has.
	 * @return coins
	 */
    public int getCoins() {
        return coins;
    }

	/**
	 * This method set coins for the Player
	 * @param num is the int value that a Player's coins will change.
	 */
    public void setCoins(int num) {
		coins += num;
	}
	
	public String cardActivation(int dice, Player players[]) {
		String d = "";
		/*
		int low = 1;
		int high = 7;
		Random random = new Random();
		int dice = random.nextInt(high - low) + low;
		d = d + "******************************************\n" + 
				"Player " + (turn + 1) + " rolled [" + dice + "] = " + dice + ".\n";
		*/
		for (int i = 0; i < 3; i++) {
			if (dice == activation[i]) {
				players[0].setCoins(1 * players[0].getPCards(i));
				players[1].setCoins(1 * players[1].getPCards(i));
				if (players[0].getPCards(i) > 0 && players[1].getPCards(i) > 0) {
					d = d + cardName[i] + " activated for Player 1\n" + 
						cardName[i] + " activated for Player 2\n";
				} else if (players[0].getPCards(i) > 0) {
					d = d + cardName[i] + " activated for Player 1\n";
				} else if (players[1].getPCards(i) > 0) {
					d = d + cardName[i] + " activated for Player 2\n";
				} 
			} 
		}
		return d;
	}


	/*
	
	/**
	* This method adds a card to Player N's deck. 
	* @param availableCards, cardCost, choice, cardName
	* 
	*/
	
	/*
	
	
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