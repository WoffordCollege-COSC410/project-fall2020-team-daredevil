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



    /*
    --------------------------- OLD CODE -----------------------------

    For Phase 1, really the only thing updated on the market
    is the number of available cards
    */

    /*
    private int availableWheat;
    private int availableRanch;
    private int availableForest;
    private boolean activated;
    private Player p1;
    private Player p2;
    String options; 
    
    /**
     * Initializes the number of cards for Wheat Field, Ranch, and Forest
     * @param p1 is Player 1
     * @param p2 is Player 2
     */

    
    /*
    public GameState(Player p1, Player p2) {
        availableWheat = 6;
        availableRanch = 6;
        availableForest = 6;
        activated = false;
        this.p1 = p1;
        this.p2 = p2;
    }

    /**
     * This method creates a new instance of getAvailableWheat
     * @return availableWheat The int value of the number of Wheat Field cards available
     */
    /*
    public int getAvailableWheat() {
        return availableWheat;
    }

    /**
     * This method creates a new instance of getAvailableRanch
     * @return availableRanch The int value of the number of Ranch cards available
     */

     /*
    public int getAvailableRanch() {
        return availableRanch;
    }

    /**
     * This method creates a new instance of getAvailableForest
     * @return availableForest The int value of the number of Forest cards available
     */

    /*
    public int getAvailableForest() {
        return availableForest;
    }

    /**
     * @param r: The int value of the number rolled
     * @return activated: if roll is 1, 2, or 5 activated becomes true
     */

    /*
    public boolean isActivated(int r) {
        if (r == 1 || r == 2 || r == 5) {
            activated = true;
            p1.addCoins(1);
            p2.addCoins(1);
        } 
        return activated;
    }
    
    /**
     * @return true initilizes turn for Player 1.
     * flase initilizes turn for Player 2.
     * 
    */

    /*
    public boolean getCurrentPlayer() {
        if (p1.getTurn()) {
            return true;
        } else {
            return false;
        }
    }

    /*
    public void viewCard(String view, int choice) { 
        //TODO
            // Adjust condititons so the card desired is viewed
            // For now, WF is the only one that can be viewd
        if (view.equals("view")) {
            if (choice == 1) {
                System.out.println(".-----------------------.");
                System.out.println("| <B>      [1]      {W} |");
                System.out.println("|      Wheat Field      |");
                System.out.println("|                       |");
                System.out.println("|  Get 1 coin from the  |");
                System.out.println("|         bank.         |");
                System.out.println("|    (anyone's turn)    |");
                System.out.println("|                       |");
                System.out.println("| (1)                   |");
                System.out.println("|_______________________|");
                System.out.println("                         ");
            } 
        } else {
            purchaseCard(choice);
        }
    }
    */

    /**
     * This method prints the correct text output of what player N has 
     * purchased/constructed depending on the players choice.
     * @param choice is the int value of the players choice from "Purchase" menu
     */

    /*
    public void purchaseCard(int choice) {
        if (getCurrentPlayer()) {
            if (options.contains("3.")) {
                if (choice == 1) {
                    System.out.println("Player 1 purchased a Wheat Field.");
                    p1.addCard("W");
                    p1.removeCoins(1);
                    availableWheat -= 1;
                } else if (choice == 2) {
                    System.out.println("Player 1 purchased a Ranch.");
                    p1.addCard("R");
                    p1.removeCoins(1);
                    availableRanch -= 1;
                } else if (choice == 3) {
                    System.out.println("Player 1 purchased a Forest.");
                    p1.addCard("F");
                    p1.removeCoins(3);
                    availableForest -= 1;
                } else if (choice == 4) {
                    p1.addCard("city");
                    p1.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 1 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else if (options.contains("1. W") && options.contains("2. R")) {
                if (choice == 1) {
                    System.out.println("Player 1 purchased a Wheat Field.");
                    p1.addCard("W");
                    p1.removeCoins(1);
                    availableWheat -= 1;
                } else if (choice == 2) {
                    System.out.println("Player 1 purchased a Ranch.");
                    p1.addCard("R");
                    p1.removeCoins(1);
                    availableRanch -= 1;
                } else if (choice == 4) {
                    p1.addCard("city");
                    p1.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 1 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else if (options.contains("1. W") && options.contains("2. F")) {
                if (choice == 1) {
                    System.out.println("Player 1 purchased a Wheat Field.");
                    p1.addCard("W");
                    p1.removeCoins(1);
                    availableWheat -= 1;
                } else if (choice == 2) {
                    System.out.println("Player 1 purchased a Forest.");
                    p1.addCard("F");
                    p1.removeCoins(3);
                    availableForest -= 1;
                } else if (choice == 4) {
                    p1.addCard("city");
                    p1.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 1 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else if (options.contains("1. R") && options.contains("2. F")) {
                if (choice == 1) {
                    System.out.println("Player 1 purchased a Ranch.");
                    p1.addCard("R");
                    p1.removeCoins(1);
                    availableRanch -= 1;
                } else if (choice == 2) {
                    System.out.println("Player 1 purchased a Forest.");
                    p1.addCard("F");
                    p1.removeCoins(3);
                    availableForest -= 1;
                } else if (choice == 4) {
                    p1.addCard("city");
                    p1.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 1 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else if (options.contains("1. W")) {
                if (choice == 1) {
                    System.out.println("Player 1 purchased a Wheat Field.");
                    p1.addCard("W");
                    p1.removeCoins(1);
                    availableWheat -= 1;
                } else if (choice == 4) {
                    p1.addCard("city");
                    p1.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 1 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else if (options.contains("1. R")) {
                if (choice == 1) {
                    System.out.println("Player 1 purchased a Ranch.");
                    p1.addCard("R");
                    p1.removeCoins(1);
                    availableRanch -= 1;
                } else if (choice == 4) {
                    p1.addCard("city");
                    p1.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 1 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else if (options.contains("1. F")) {
                if (choice == 1) {
                    System.out.println("Player 1 purchased a Forest.");
                    p1.addCard("F");
                    p1.removeCoins(3);
                    availableForest -= 1;
                } else if (choice == 4) {
                    p1.addCard("city");
                    p1.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 1 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else {
                if (choice == 4) {
                    p1.addCard("city");
                    p1.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 1 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            }
        } else {
            if (options.contains("3.")) {
                if (choice == 1) {
                    System.out.println("Player 2 purchased a Wheat Field.");
                    p2.addCard("W");
                    p2.removeCoins(1);
                    availableWheat -= 1;
                } else if (choice == 2) {
                    System.out.println("Player 2 purchased a Ranch.");
                    p2.addCard("R");
                    p2.removeCoins(1);
                    availableRanch -= 1;
                } else if (choice == 3) {
                    System.out.println("Player 2 purchased a Forest.");
                    p2.addCard("F");
                    p2.removeCoins(3);
                    availableForest -= 1;
                } else if (choice == 4) {
                    p2.addCard("city");
                    p2.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 2 chose not to make improvements.");
                } else {
                    System.out.println("Player 2 chose not to make improvements.");
                }
            } else if (options.contains("1. W") && options.contains("2. R")) {
                if (choice == 1) {
                    System.out.println("Player 2 purchased a Wheat Field.");
                    p2.addCard("W");
                    p2.removeCoins(1);
                    availableWheat -= 1;
                } else if (choice == 2) {
                    System.out.println("Player 2 purchased a Ranch.");
                    p2.addCard("R");
                    p2.removeCoins(1);
                    availableRanch -= 1;
                } else if (choice == 4) {
                    p2.addCard("city");
                    p2.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 2 chose not to make improvements.");
                } else {
                    System.out.println("Player 2 chose not to make improvements.");
                }
            } else if (options.contains("1. W") && options.contains("2. F")) {
                if (choice == 1) {
                    System.out.println("Player 2 purchased a Wheat Field.");
                    p2.addCard("W");
                    p2.removeCoins(1);
                    availableWheat -= 1;
                } else if (choice == 2) {
                    System.out.println("Player 2 purchased a Forest.");
                    p2.addCard("F");
                    p2.removeCoins(3);
                    availableForest -= 1;
                } else if (choice == 4) {
                    p2.addCard("city");
                    p2.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 2 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else if (options.contains("1. R") && options.contains("2. F")) {
                if (choice == 1) {
                    System.out.println("Player 2 purchased a Ranch.");
                    p2.addCard("R");
                    p2.removeCoins(1);
                    availableRanch -= 1;
                } else if (choice == 2) {
                    System.out.println("Player 2 purchased a Forest.");
                    p2.addCard("F");
                    p2.removeCoins(3);
                    availableForest -= 1;
                } else if (choice == 4) {
                    p2.addCard("city");
                    p2.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 2 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else if (options.contains("1. W")) {
                if (choice == 1) {
                    System.out.println("Player 2 purchased a Wheat Field.");
                    p2.addCard("W");
                    p2.removeCoins(1);
                    availableWheat -= 1;
                } else if (choice == 4) {
                    p2.addCard("city");
                    p2.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 2 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else if (options.contains("1. R")) {
                if (choice == 1) {
                    System.out.println("Player 2 purchased a Ranch.");
                    p2.addCard("R");
                    p2.removeCoins(1);
                    availableRanch -= 1;
                } else if (choice == 4) {
                    p2.addCard("city");
                    p2.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 2 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else if (options.contains("1. F")) {
                if (choice == 1) {
                    System.out.println("Player 2 purchased a Forest.");
                    p2.addCard("F");
                    p2.removeCoins(3);
                    availableForest -= 1;
                } else if (choice == 4) {
                    p2.addCard("city");
                    p2.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 2 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            } else {
                if (choice == 4) {
                    p2.addCard("city");
                    p2.removeCoins(7);
                } else if (choice == 99) {
                    System.out.println("Player 2 chose not to make improvements.");
                } else {
                    System.out.println("Invalid input. Try again.");
                }
            }
        }
    }

    /**
    *   The Market State will always be displayed after each turn, regardless of how many coins
    *   the players have. The only thing that affects the Market State for now is the number of 
    *   available cards. The **MARKET MENU** (see below) however is formatted and displayed on 
    *   depending on what the players can afford and are allowed to buy.  
    */

    /*
    public void printMarketState() {
        if (availableWheat > 0 && availableRanch > 0 && availableForest > 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + availableWheat);
            System.out.println("Ranch              BC (1)  [2]      #" + availableRanch);
            System.out.println("Forest             BG (3)  [5]      #" + availableForest);
            System.out.println("                                          ");
        } else if (availableWheat > 0 && availableRanch > 0 && availableForest == 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + availableWheat);
            System.out.println("Ranch              BC (1)  [2]      #" + availableRanch);
            System.out.println("                                          ");
        } else if (availableWheat > 0 && availableRanch == 0 && availableForest > 0){
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + availableWheat);
            System.out.println("Forest             BG (3)  [5]      #" + availableForest);
            System.out.println("                                          ");
        } else if (availableWheat == 0 && availableRanch > 0 && availableForest > 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Ranch              BC (1)  [2]      #" + availableRanch);
            System.out.println("Forest             BG (3)  [5]      #" + availableForest);
            System.out.println("                                          ");
        } else if (availableWheat > 0 && availableRanch == 0 && availableForest == 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Wheat Field        BW (1)  [1]      #" + availableWheat);
            System.out.println("                                          ");
        } else if (availableWheat == 0 && availableRanch > 0 && availableForest == 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Ranch              BC (1)  [2]      #" + availableRanch);
            System.out.println("                                          ");
        } else if (availableWheat == 0 && availableRanch == 0 && availableForest > 0) {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("Forest             BG (3)  [5]      #" + availableForest);
            System.out.println("                                          ");
        } else {
            System.out.println("******************************************");
            System.out.println("                  MARKET                  ");
            System.out.println("------------------------------------------");
            System.out.println("                                          ");
        }
    }

    /**
     * This method prints the Player State of player 1
     */

    /*
    public void printPlayerOneState() {
        if (getCurrentPlayer()) {
            if (p1.ecards[0] > 0 && p1.ecards[1] == 0 && p1.ecards[2] == 0) {
                System.out.println("              Player 1* [YOU]             ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p1.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p1.ecards[0]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            } else if (p1.ecards[0] > 0 && p1.ecards[1] > 0 && p1.ecards[2] == 0) {
                System.out.println("              Player 1* [YOU]             ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p1.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p1.ecards[0]);
                System.out.println("Ranch              BC (1)  [2]      #" + p1.ecards[1]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            } else {
                System.out.println("              Player 1* [YOU]             ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p1.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p1.ecards[0]);
                System.out.println("Ranch              BC (1)  [2]      #" + p1.ecards[1]);
                System.out.println("Ranch              BC (1)  [2]      #" + p1.ecards[2]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            }
        } else {
            if (p1.ecards[0] > 0 && p1.ecards[1] == 0 && p1.ecards[2] == 0) {
                System.out.println("              Player 1  [YOU]             ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p1.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p1.ecards[0]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            } else if (p1.ecards[0] > 0 && p1.ecards[1] > 0 && p1.ecards[2] == 0) {
                System.out.println("              Player 1  [YOU]             ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p1.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p1.ecards[0]);
                System.out.println("Ranch              BC (1)  [2]      #" + p1.ecards[1]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            } else {
                System.out.println("              Player 1  [YOU]             ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p1.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p1.ecards[0]);
                System.out.println("Ranch              BC (1)  [2]      #" + p1.ecards[1]);
                System.out.println("Ranch              BC (1)  [2]      #" + p1.ecards[2]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            }
        }
    }

    /**
     * This method prints the Player State of player 2
     */

    /*
    public void printPlayerTwoState() {
        if (getCurrentPlayer()) {
            if (p2.ecards[0] > 0 && p2.ecards[1] == 0 && p2.ecards[2] == 0) {
                System.out.println("                 Player 2                  ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p2.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p2.ecards[0]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            } else if (p2.ecards[0] > 0 && p2.ecards[1] > 0 && p2.ecards[2] == 0) {
                System.out.println("                 Player 2                 ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p2.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p2.ecards[0]);
                System.out.println("Ranch              BC (1)  [2]      #" + p2.ecards[1]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            } else {
                System.out.println("                 Player 2                 ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p2.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p2.ecards[0]);
                System.out.println("Ranch              BC (1)  [2]      #" + p2.ecards[1]);
                System.out.println("Forest             BC (1)  [2]      #" + p2.ecards[2]); //TODO this should be a Forest
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            }
        } else {
            if (p2.ecards[0] > 0 && p2.ecards[1] == 0 && p2.ecards[2] == 0) {
                System.out.println("                 Player 2*                ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p2.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p2.ecards[0]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            } else if (p2.ecards[0] > 0 && p2.ecards[1] > 0 && p2.ecards[2] == 0) {
                System.out.println("                 Player 2*                ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p2.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p2.ecards[0]);
                System.out.println("Ranch              BC (1)  [2]      #" + p2.ecards[1]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            } else {
                System.out.println("                 Player 2*                ");
                System.out.println("------------------------------------------");
                System.out.println("                (" + p2.getCoins() + " coins)                 ");
                System.out.println("Wheat Field        BW (1)  [1]      #" + p2.ecards[0]);
                System.out.println("Ranch              BC (1)  [2]      #" + p2.ecards[1]);
                System.out.println("Ranch              BC (1)  [2]      #" + p2.ecards[2]);
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
            }
        }
    }

    /**
     * This method provides the selection of cards that should be printed in the "Purchase" menu
     * depending on player N's coins and # of remaining cards
     * @return op1 if all cards are available
     * @return op2 if only Ranch and Forest cards are available
     * @return op3 if only Wheat Field and Forest cards are available 
     * @return op4 if only Wheat Field and Ranch cards are available
     * @return op5 if only Forest card is available
     * @return op6 if only Ranch card is available
     * @return op7 if only Wheat Field card is available
     * @return op8 if no cards are available
     */

    /*
    public String menuOptions() {
        options = "";
        //all
        String op1 = "1. Wheat Field         BW (1)  [1]      #" + availableWheat + "\n"
                    + "2. Ranch               BC (1)  [2]      #" + availableRanch + "\n"
                    + "3. Forest              BG (3)  [5]      #" + availableForest;
        //no wheat
        String op2 = "1. Ranch               BC (1)  [2]      #" + availableRanch + "\n"
                    + "2. Forest              BG (3)  [5]      #" + availableForest;
        //no ranch
        String op3 = "1. Wheat Field         BW (1)  [1]      #" + availableWheat + "\n"
                    + "2. Forest              BG (3)  [5]      #" + availableForest;
        //no forest
        String op4 = "1. Wheat Field         BW (1)  [1]      #" + availableWheat + "\n"
                    + "2. Ranch               BC (1)  [2]      #" + availableRanch;
        //no wheat & ranch
        String op5 = "1. Forest              BG (3)  [5]      #" + availableForest;
        //no wheat & forest
        String op6 = "1. Ranch               BC (1)  [2]      #" + availableRanch;
        //no ranch & forest
        String op7 = "1. Wheat Field         BW (1)  [1]      #" + availableWheat;
        //none
        String op8 = "";
        
        if (getCurrentPlayer()) {
            if (p1.getCoins() >= 3) {
                if (availableWheat == 0 && availableRanch == 0 && availableForest == 0) {
                    return op8;
                } else if (availableWheat == 0) {
                    options = op2;
                    return op2;
                } else if (availableRanch == 0) {
                    options = op3;
                    return op3;
                } else if (availableForest == 0) {
                    options = op4;
                    return op4;
                } else if (availableWheat == 0 && availableRanch == 0) {
                    options = op5;
                    return op5;
                } else if (availableWheat == 0 && availableForest == 0) {
                    options = op6;
                    return op6;
                } else if (availableRanch == 0 && availableForest == 0) {
                    options = op7;
                    return op7;
                } else {
                    options = op1;
                    return op1;
                }
            } else if (p1.getCoins() <= 3 && p1.getCoins() > 0) {
                if (availableWheat == 0 && availableRanch == 0) {
                    return op8;
                } else if (availableWheat == 0) {
                    options = op6;
                    return op6;
                } else if (availableRanch == 0) {
                    options = op7;
                    return op7;
                } else {
                    options = op4;
                    return op4;
                }
            } else {
                options = op8;
                return op8;
            }
        } else {
            if (p2.getCoins() >= 3) {
                if (availableWheat == 0 && availableRanch == 0 && availableForest == 0) {
                    return op8;
                } else if (availableWheat == 0) {
                    options = op2;
                    return op2;
                } else if (availableRanch == 0) {
                    options = op3;
                    return op3;
                } else if (availableForest == 0) {
                    options = op4;
                    return op4;
                } else if (availableWheat == 0 && availableRanch == 0) {
                    options = op5;
                    return op5;
                } else if (availableWheat == 0 && availableForest == 0) {
                    options = op6;
                    return op6;
                } else if (availableRanch == 0 && availableForest == 0) {
                    options = op7;
                    return op7;
                } else {
                    options = op1;
                    return op1;
                }
            } else if (p2.getCoins() <= 3 && p2.getCoins() > 0) {
                if (availableWheat == 0 && availableRanch == 0) {
                    return op8;
                } else if (availableWheat == 0) {
                    options = op6;
                    return op6;
                } else if (availableRanch == 0) {
                    options = op7;
                    return op7;
                } else {
                    options = op4;
                    return op4;
                }
            } else {
                options = op8;
                return op8;
            }
        }
    }

    public void printMarketMenu() {
        if (getCurrentPlayer()) {
            if (p1.getCoins() >= 7) {
                System.out.println("==========================================");
                System.out.println("---------        PURCHASE        ---------");
                System.out.println(menuOptions());
                System.out.println("---------       CONSTRUCT        ---------");
                System.out.println("4. City Hall           NT (7)  [ ]        ");
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");
            } else if (p1.getCoins() < 7 && p1.getCoins() >=3) {
                System.out.println("==========================================");
                System.out.println("---------        PURCHASE        ---------");
                System.out.println(menuOptions());
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");
            } else if (p1.getCoins() > 0 && p1.getCoins() < 3) {
                System.out.println("==========================================");
                System.out.println("---------        PURCHASE        ---------");
                System.out.println(menuOptions());
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");
            } else {
                System.out.println("==========================================");
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");
            }
        } else {
            if (p2.getCoins() >= 7) {
                System.out.println("==========================================");
                System.out.println("---------        PURCHASE        ---------");
                System.out.println(menuOptions());
                System.out.println("---------       CONSTRUCT        ---------");
                System.out.println("4. City Hall           NT (7)  [ ]        ");
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");
            } else if (p2.getCoins() < 7 && p2.getCoins() >=3) {
                System.out.println("==========================================");
                System.out.println("---------        PURCHASE        ---------");
                System.out.println(menuOptions());
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");
            } else if (p2.getCoins() > 0 && p2.getCoins() < 3) {
                System.out.println("==========================================");
                System.out.println("---------        PURCHASE        ---------");
                System.out.println(menuOptions());
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");
            } else {
                System.out.println("==========================================");
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");
            }
        }
    }

    ------------------------------------------------------------------------------

    */

}
