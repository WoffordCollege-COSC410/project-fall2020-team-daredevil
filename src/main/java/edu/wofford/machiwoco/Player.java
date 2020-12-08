package edu.wofford.machiwoco;


public class Player {
	private int[] pCards; 
	private static String[] cardName;
	private static int[] activation;
	private int coins; 

	/**
	* Creates a new instance of Player
	*/
	public Player() {
		pCards = new int[] {1, 0, 0};
		cardName = new String[] {"Wheat Field", "Ranch", "Forest"};
		activation = new int[] {1, 2, 5};
		coins = 3;
	} 
	
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
	
	/**
	 * This method checks if any cards are activated
	 * @param dice
	 * @param players
	 * @return the string d
	 */
	public String cardActivation(int dice, Player players[]) {
		String d = "";
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
}