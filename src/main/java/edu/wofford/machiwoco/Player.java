package edu.wofford.machiwoco;


public class Player {
	private static int cityHall;
	private int[] pCards; 
	private int coins; 


	/**
	* Creates a new instance of Player
	*/
	public Player() {
		pCards = new int[] {1, 0, 0};
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

}