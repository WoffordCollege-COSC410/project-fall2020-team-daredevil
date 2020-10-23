package edu.wofford.machiwoco;
import java.util.Scanner;
import java.io.*;
import java.util.Random;



public class MachiWoCo {
    private static int cityHall;
    private static int turn;
//    Player p1 = new Player("Player 1");
//    Player p2 = new Player("Player 2");
    private static int[] availableCards = {6, 6, 6};
    private static int[] p1Cards = {1, 0, 0};
    private static int[] p2Cards = {1, 0, 0};
    private static int[] coins = {3, 3};
    private static String[] cardName = {"Wheat Field", "Ranch", "Forest"};
    private static String[] cardIcon = {"       BW", "             BC", "            BG"};
    private static int[] cardCost = {1, 1, 3};
    private static int[] activation = {1, 2, 5};


    public static void main(String[] args) {
        cityHall = 0;
        turn = 0;
        Random random = new Random();

        // Determine which phase of the game we're playing
        if (args.length > 0 && args[0].equals("phase0")) {
            try {
                File p = new File("src/main/java/edu/wofford/machiwoco/phase0.txt");
                Scanner sc = new Scanner(p);
                while (sc.hasNextLine()) {
                    String l = sc.nextLine();
                    System.out.println(l);
                }
            } catch (Exception u) {
                System.out.println(u);
            }
        } else if (args.length > 0 && args[0].equals("phase1")) {
            // Start of game
            System.out.println("The game has started. Player 1 will go ");
            System.out.println("first.");

            // Loop begins
            while (cityHall == 0) {
                // Beginning of turn
                System.out.println("Turn started for Player " + (turn + 1) + ".");
                
                // Print Market State
                System.out.println("******************************************");
                System.out.println("                  MARKET                  ");
                System.out.println("------------------------------------------");
                for (int i = 0; i < 3; i++) {
                    if (availableCards[i] > 0) {
                        System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + availableCards[i]);
                    }
                }
                System.out.println();
                
                //System.out.println("              Player " + (turn + 1) + " [YOU]              ");
                //if ((turn == 0 && p1Cards[i] > 0) {}
                //else if (turn == 1 && p2Cards[i] > 0) {}
                // Print Player 1 State
                if (turn == 0) {
                    System.out.println("              Player 1* [YOU]             ");
                } else {
                    System.out.println("              Player 1 [YOU]              ");
                }
                System.out.println("------------------------------------------");
                System.out.println("             (" + coins[0] + " coins)     ");
                for (int i = 0; i < 3; i++) {
                    if (p1Cards[i] > 0) {
                        System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + p1Cards[i]);
                    }
                }
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");
                
                // Print Player 2 State
                if (turn == 1) {
                    System.out.println("                 Player 2*                ");
                } else {
                    System.out.println("                 Player 2                 ");
                }
                System.out.println("------------------------------------------");
                System.out.println("             (" + coins[1] + " coins)     ");
                for (int i = 0; i < 3; i++) {
                    if (p2Cards[i] > 0) {
                        System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + p2Cards[i]);
                    }
                }
                System.out.println("..........................................");
                System.out.println("City Hall          NT (7)  [ ]            ");
                System.out.println("                                          ");

                // Dice Roll
                int low = 1;
                int high = 7;
                int dice = random.nextInt(high - low) + low;
                System.out.println("******************************************");
                System.out.println("Player " + (turn + 1) + " rolled [" + dice + "] = " + dice + ".");
                System.out.println();
     
                // Check to see if the dice roll activated any cards 
                for (int i = 0; i < 3; i++) {
                    if (dice == activation[i]) {
                        coins[0] += 1 * p1Cards[i];
                        coins[1] += 1 * p2Cards[i];
                        if (p1Cards[i] > 0 && p2Cards[i] > 0) {
                            System.out.println(cardName[i] + " activated for Player 1");
                            System.out.println(cardName[i] + " activated for Player 2");
                        } else if (p1Cards[i] > 0) {
                            System.out.println(cardName[i] + " activated for Player 1");
                        } else if (p2Cards[i] > 0) {
                            System.out.println(cardName[i] + " activated for Player 2");
                        } 
                    } 
                }

                System.out.println("Player " + (turn + 1) + ", would you like to purchase an");
                System.out.println("establishment or construct a landmark? (" + coins[turn]);
                System.out.println("coins)");
                System.out.println("==========================================");
                System.out.println("---------        PURCHASE        ---------");
                int n = 0;
                for (int i = 0; i < 3; i++) {
                    if (coins[turn] >= cardCost[i] && availableCards[i] > 0) {
                        n++;
                        System.out.println(n + ". " + cardName[i] + "  " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + availableCards[i]);
                    }
                }
                System.out.println("==========================================");
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");

                System.out.println("Choose a number to purchase or construct: ");
                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();
//                if (turn == 0) {
//                    p1.purchaseCard(availableCards, cardCost, choice, cardName);
//                } else if (turn == 1) {
//                    p2.purchaseCard(availableCards, cardCost, choice, cardName);
//                }
                for (int i = 0; i < 3; i++) {
                    if (choice == i + 1) {
                        System.out.println("Player " + (turn + 1) + " purchased the " + cardName[i]);
                        availableCards[i] -= 1;
                        if (turn == 0) {
                            p1Cards[i] += 1;
                            coins[0] -= cardCost[i];
                        } else if (turn == 1) {
                            p2Cards[i] += 1;
                            coins[1] -= cardCost[i];
                        }  
                    }
                    else if (choice == 99) {
                        System.out.println("Player " + (turn + 1) + " chose not to make any improvements.");
                        break;
                    }
                }
                System.out.println("Turn ended for Player " + (turn + 1));
                turn = (turn + 1) % 2;
                //TODO print market and player cards with CityHall marked
                if (coins[0] >= 7) {
                    cityHall = 1;
                    System.out.println("The game is over. Player " + cityHall + " is the winner.");
                } else if (coins[1] >= 7) {
                    cityHall = 2;
                    System.out.println("The game is over. Player " + cityHall + " is the winner.");
                }
            }
        }

    }
}


    /*

    ------------------------------- OLD CODE -------------------------------------

    public static void main(String[] args) {
        //Establishment e = new Establishment("Wheat", 3, "red", "G");
        
        Random random = new Random();
        Player p1 = new Player();
        Player p2 = new Player();
        GameState game = new GameState(p1, p2);
        
        if (args.length > 0 && args[0].equals("phase0")) {
            try {
                File p = new File("src/main/java/edu/wofford/machiwoco/phase0.txt");
                Scanner sc = new Scanner(p);
                while (sc.hasNextLine()) {
                    String l = sc.nextLine();
                    System.out.println(l);
                }
            } catch (Exception u) {
                System.out.println(u);
            }
        } else if (args.length > 0 && args[0].equals("phase1")) {
        //Start of game
        p1.setTurn(true);
        System.out.println("The game has started. Player 1 will go first.");
        
        //Loop begins
            while (!p1.hasCityHall() && !p2.hasCityHall()) {
            //Beginning of turn
                if (p1.getTurn()) {
                    System.out.println("Turn started for Player 1.");
                } else if (p2.getTurn()) {
                    System.out.println("Turn started for Player 2.");
                }
                
                //Current Game State
                    // 1. Get Market state from Market Class
                    // 2. Get Players' states from Players Class
                game.printMarketState();
                game.printPlayerOneState();
                game.printPlayerTwoState();

                //Roll 
                    // 1. Player N rolls the dice and the result is displayed
                    // 2. Check to see if any cards are activated (pass dice to isActivated() method in GameState class)
                int low = 1;
                int high = 7;
                int dice = random.nextInt(high - low) + low;
                if (p1.getTurn()) {
                    System.out.println("Player 1 rolled [" + dice + "] = " + dice);
                } else if (p2.getTurn()) {
                    System.out.println("Player 2 rolled [" + dice + "] = " + dice);
                }
                if (game.isActivated(dice) == true) {
                    if (dice == 1) {
                        System.out.println("Wheat Field activated for Player 1.");
                        System.out.println("Wheat Field activated for Player 2.");
                        p1.addCoins(1 * p1.getNumWheat());
                        p2.addCoins(1 * p2.getNumWheat());
                    } else if (dice == 2) {  //And if one or both players own that card
                        if (p1.getNumRanch() > 0) {
                            System.out.println("Ranch activated for Player 1.");
                            p1.addCoins(1 * p1.getNumRanch());
                        }
                        if (p2.getNumRanch() > 0) {
                            System.out.println("Ranch activated for Player 2.");
                            p2.addCoins(1 * p2.getNumRanch());
                        }
                    } else if (dice == 5) {  //And if one ore both players own that card
                        if (p1.getNumForest() > 0) {
                            System.out.println("Forest activated for Player 1.");
                            p1.addCoins(1 * p1.getNumForest());
                        }
                        if (p2.getNumForest() > 0) {
                            System.out.println("Forest activated for Player 2.");
                            p2.addCoins(1 * p2.getNumForest());
                        }
                    } 
                }
                
                if (p1.getTurn()) {
                    System.out.println();
                    System.out.println("Player 1, would you like to purchase an");
                    System.out.println("establishment or construct a landmark? (" + p1.getCoins());
                    System.out.println("coins)");
                    System.out.println("To view details of an item, type 'view'");
                    System.out.println("followed by the item number. For example,");
                    System.out.println("to view item 6, type 'view 6'.");
                    game.printMarketMenu();
                    //Scanner scanString = new Scanner(System.in);
                    System.out.println("Choose a number to purchase or construct: ");
                    Scanner scanInt= new Scanner(System.in);
                    //String view = scanString.next();
                    int choice = scanInt.nextInt();
                    //game.viewCard(view, choice);
                    game.purchaseCard(choice);
                    System.out.println("Turn ended for Player 1.");
                    p1.setTurn(false);
                    p2.setTurn(true);
                }  else if (p2.getTurn()) {
                    System.out.println();
                    System.out.println("Player 2, would you like to purchase an");
                    System.out.println("establishment or construct a landmark? (" + p2.getCoins());
                    System.out.println("coins)");
                    System.out.println("To view details of an item, type 'view'");
                    System.out.println("followed by the item number. For example,");
                    System.out.println("to view item 6, type 'view 6'.");
                    game.printMarketMenu();
                    System.out.println("Choose a number to purchase or construct: ");
                    //Scanner scanString = new Scanner(System.in);
                    Scanner scanInt= new Scanner(System.in);
                    //String view = scanString.next();
                    int choice = scanInt.nextInt();
                    //game.viewCard(view, choice);
                    game.purchaseCard(choice);
                    System.out.println("Turn ended for Player 2.");
                    p1.setTurn(true);
                    p2.setTurn(false);
                }
            }
        }
        //End of game
        if(p1.hasCityHall()) {
            game.printPlayerOneState();
            System.out.println("Player 1 has the City Hall");
            System.out.println("The game is over. Player 1 is the winner.");
        }
        else if (p2.hasCityHall()){
            game.printPlayerTwoState();           
            System.out.println("Player 2 has the City Hall");
            System.out.println("The game is over. Player 2 is the winner.");
        }
    }

    ------------------------------------------------------------------------------------

}
    */


