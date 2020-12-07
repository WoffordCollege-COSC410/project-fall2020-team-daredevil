package edu.wofford.machiwoco;
/**
 * @author Jacob Vannoy, Kristinn Sigurjonsson, Jaylen Muhammad, Evan Suggs
 */
public class GameState {

    private static Player[] players;
    private static int[] availableCards;
    private static String[] cardName;
    private static String[] cardIcon;
    private static int[] cardCost;
    private static int[] activation;
    private static Card[] cards;


    /**
    * Constructs a new instance of GameState
    */
    public GameState() {
        availableCards = new int[] {6, 6, 6};
        cardName = new String[] {"Wheat Field", "Ranch", "Forest"};
        cardIcon = new String[] {"       BW", "             BC", "            BG"};
        cardCost = new int[] {1, 1, 3};
        activation = new int[] {1, 2, 5};
        cards = new Card[availableCards.length];
        
        //TODO work-in-progress
        //how method is called public Card(String name, int cost, String color, String icon)
        for (int i = 0; i < availableCards.length; i++) {
            cards[i] = new Card(cardName[i], cardCost[i], "blue", cardIcon[i]);
        }
    }

    /**
    * Prints the current Market
    * @return The Market display as a string
    */
    public String printMarket() {
        String str = "******************************************\n" +
                     "                  MARKET                  \n" +
                     "------------------------------------------\n";
        for (int i = 0; i < 3; i++) {
            if (availableCards[i] > 0) {
                str = str + cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + availableCards[i] + "\n";
            }
        }
        return str;
    }

    /**
    * Prints the current Player States (Cards owned, Coins in hand etc)
    * @param turn The current turn of the game
    * @param players The array of all players in the game
    * @return All Player States
    */
    public String printPlayerState(int turn, Player players[]) {
        String str = "";
        
        //p1 state
        if (turn == 0) {
            str = str + "             Player 1* [YOU]              \n";
        } else {
            str = str + "             Player 1 [YOU]               \n";
        }
        str = str + "------------------------------------------" + "\n" + "                (" + players[0].getCoins() + " coins)  \n";
        for (int i = 0; i < 3; i++) {
            if (players[0].getPCards(i) > 0) {
                //note the extra newline character at the end of the added string
                str = str + cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + players[0].getPCards(i) + "\n";
            }
        }
        str = str + ".........................................." + "\n" + "City Hall          NT (7)  [ ]\n" + "\n";
        
        //p2 state
        if (turn == 1) {
            str = str + "                 Player 2*                " + "\n";
        } else {
            str = str + "                 Player 2                 " + "\n";
        }
        str = str + "------------------------------------------" + "\n" + "                (" + players[1].getCoins() + " coins)  \n";
        for (int i = 0; i < 3; i++) {
            if (players[1].getPCards(i) > 0) {
                str = str + cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + players[1].getPCards(i) + "\n";
            }
        }
        str = str + "..........................................\n" + "City Hall          NT (7)  [ ]\n";
        
        return str;
    }
    
    
    
    
    /**
    * @param i The index to return
    * @return The name of a Card
    */
    public String getCardName(int i) {
        return cardName[i];
    }

    /**
    * @param i The index to return
    * @return The Icon of a Card
    */
    public String getCardIcon(int i) {
        return cardIcon[i];
    }
    
    /**
    * @param i The index to return
    * @return The cost of a Card
    */
    public int getCardCost(int i) {
        return cardCost[i];
    }
    
    /**
    * @param i The index to return
    * @return How many Cards of that index are available
    */
    public int getAvailableCards(int i) {
        return availableCards[i];
    }
    
    /**
    * Removes a card from the given index of Available Cards
    * @param i The index to change
    */
    public void removeAvailableCards(int i) {
        availableCards[i] -= 1;
    }
    
    /**
    * @param i The index of a Card
    * @return The Activation number of a Card
    */
    public int getActivation(int i) {
        return activation[i];
    }
    
//    public static void main(String[] args) {
//        GameState g = new GameState();
//        System.out.println(g.printPlayerState(0));
//        System.out.print("*************************");
//    }


}
