package edu.wofford.machiwoco;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;



public class MachiWoCo {
    private static int cityHall;
    private static int turn;
    private static int[] availableCards = {6, 6, 6};
    private static Player[] players;
    private static String[] cardName = {"Wheat Field", "Ranch", "Forest"};
    private static String[] cardIcon = {"       BW", "             BC", "            BG"};
    private static int[] cardCost = {1, 1, 3};
    private static int[] activation = {1, 2, 5};
    private static GameState g = new GameState();
    private static MarketMenu m = new MarketMenu();
    private static Player p = new Player();
    private static Dice d = new Dice(new Random());
    
    public static void main(String[] args) {
        cityHall = 0;
        turn = 0;
        int choice = 0;
        players = new Player[] {new Player(), new Player()};


// **************************************************** FEATURE 1 (Phase 0) **************************************************************

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
        }
//*****************************************************************************************************************************************




// *************************************************  FEATURE 2 (Phase 1 - 2 Human Players) ***********************************************

          else if (args.length == 1 && args[0].equals("phase1")) {
            // Start of game
            System.out.println("The game has started. Player 1 will go    ");
            System.out.println("first.                                    ");

            // Loop begins
            while (cityHall == 0) {
                // Beginning of turn
                System.out.println("Turn started for Player " + (turn + 1) + ".");
                
                // Print Market State
                 System.out.println(g.printMarket());
                
                // Print Player States
                System.out.println(g.printPlayerState(turn, players));

                // Dice Roll
                int dice = d.roll();
                System.out.println("******************************************");
                System.out.println("Player " + (turn + 1) + " rolled [" + dice + "] = " + dice + ".");
     
                // Check to see if the dice roll activated any cards 
                System.out.println(p.cardActivation(dice, players));
                
                
                // Get the number available of each card, and store it in a new array
                int[] cardCount = new int[availableCards.length];
                for (int i = 0; i < availableCards.length; i++) {
                    cardCount[i] += g.getAvailableCards(i);
                }

                // Print the market menu 
                String purchase = m.printMenu(players[turn].getCoins(), cardName, cardIcon, cardCost, activation, cardCount);
                if (purchase == "") {
                    System.out.println("Player " + (turn + 1) + " did not enough money to make improvements");
                } else {
                    System.out.println(purchase);
                }
                
                //TODO Add three arrays below into MarketMenu Class??? (But it is currently a static class)
                //ArrayList of valid indexes -> ex: [0,1,2] or [1,2]...
                ArrayList<Integer> est = new ArrayList<>(0);
                for (int i = 0; i < availableCards.length; i++) {
                    if (players[turn].getCoins() >= cardCost[i] && g.getAvailableCards(i) > 0) {
                        est.add(i);
                    }
                }
                
                //ArrayList of valid landmarks to check
                ArrayList<Integer> lm = new ArrayList<>();
                if (players[turn].getCoins() >= 7) {
                    lm.add(1);
                }
                
//                //ArrayList of choices
                ArrayList<Integer> chs = new ArrayList<Integer>(0);
                for (int i = 0; i < (est.size()+lm.size()); i++) {
                    chs.add(i + 1);
                }
                chs.add(99);
                
                
                Scanner scan = new Scanner(System.in);
                choice = m.getChoice(scan, chs);
                
                //TODO Dependent on conditionals above
                int index = choice - 1;
                if (choice > 0 && est.size() + lm.size() > 0) {
                    if (choice == 99) {
                        System.out.println("Player " + (turn + 1) + " chose not to make any improvements.");
                    } else if (choice > est.size() && lm.size() > 0) {
                        //then it is a landmark
                        cityHall = turn + 1;
                        System.out.println("Player " + (turn + 1) + " constructed the City Hall");
                        players[turn].setCoins(-7);
                    } else { //it is a property
                        System.out.println("Player " + (turn + 1) + " purchased the " + cardName[est.get(index)]);
                        g.removeAvailableCards(est.get(index));
                        players[turn].setPCards(est.get(index));
                        players[turn].setCoins(-cardCost[est.get(index)]);
                    }
                }
                
                //TURN ENDED MESSAGE
                System.out.println("Turn ended for Player " + (turn + 1));
                
                if (cityHall > 0) {
                    System.out.println(g.printMarket());
                    System.out.println(g.printPlayerState(cityHall, players));
                    System.out.println("The game is over. Player " + cityHall + " is the winner.");
                } else {
                    //TURN changes like normal
                    turn = (turn + 1) % 2;
                }
            }
        }

// ***********************************************************************************************************************************************************




// ******************************************************  FEATURE 3 (Phase 1 - Human vs. Random AI) *********************************************************

        else if (args.length == 2 && args[0].equals("phase1") && args[1].equals("--ai")) {
            // Start of game
            System.out.println("The game has started. Player 1 will go    ");
            System.out.println("first.                                    ");

            // Loop begins
            while (cityHall == 0) {
                // Beginning of turn
                System.out.println("Turn started for Player " + (turn + 1) + ".");

                // Print Market State
                System.out.println(g.printMarket());
                
                // Print Players' State
                System.out.println(g.printPlayerState(turn, players));

                // Dice Roll
                int dice = d.roll();
                System.out.println("******************************************");
                System.out.println("Player " + (turn + 1) + " rolled [" + dice + "] = " + dice + ".");

                // Check for activation
                System.out.println(p.cardActivation(dice, players));
     
                
                //TODO Add three arrays below into MarketMenu Class??? (But it is currently a static class)
                //ArrayList of valid indexes -> ex: [0,1,2] or [1,2]...
                ArrayList<Integer> est = new ArrayList<>(0);
                for (int i = 0; i < availableCards.length; i++) {
                    if (players[turn].getCoins() >= cardCost[i] && g.getAvailableCards(i) > 0) {
                        est.add(i);
                    }
                }
                
                //ArrayList of valid landmarks to check
                ArrayList<Integer> lm = new ArrayList<>();
                if (players[turn].getCoins() >= 7) {
                    lm.add(1);
                }

                //ArrayList of choices
                ArrayList<Integer> chs = new ArrayList<Integer>(0);
                for (int i = 0; i < (est.size()+lm.size()); i++) {
                    chs.add(i + 1);
                }
                chs.add(99);

                // Get the number available of each card, and store it in a new array
                int[] cardCount = new int[availableCards.length];
                for (int i = 0; i < availableCards.length; i++) {
                    cardCount[i] += g.getAvailableCards(i);
                }

                
                
                //Nothing can be purchased
                if (est.size() + lm.size() == 0) {
                    System.out.println("Player " + (turn + 1) + " did not enough money to make improvements");
                } else { //Something can be purchased
                    if (turn == 0) { //player is human
                        // Print the market menu 
                        String purchase = m.printMenu(players[turn].getCoins(), cardName, cardIcon, cardCost, activation, cardCount);
                        System.out.println(purchase);
                    } else if (turn == 1) { // player is AI
                        //System.out.println("AI makes a choice");
                        Random random2 = new Random();
                        choice = chs.get(random2.nextInt(est.size()+lm.size()));
                        
                    }
                }
                
                
                
                //TODO Dependent on conditionals above
                int index = choice - 1;
                if (choice > 0 && est.size() + lm.size() > 0) {
                    if (choice == 99) {
                        System.out.println("Player " + (turn + 1) + " chose not to make any improvements.");
                    } else if (choice > est.size() && lm.size() > 0) {
                        //then it is a landmark
                        cityHall = turn + 1;
                        System.out.println("Player " + (turn + 1) + " constructed the City Hall");
                        players[turn].setCoins(-7);
                    } else { //it is a property
                        System.out.println("Player " + (turn + 1) + " purchased the " + cardName[est.get(index)]);
                        g.removeAvailableCards(est.get(index));
                        players[turn].setPCards(est.get(index));
                        players[turn].setCoins(-cardCost[est.get(index)]);
                    }
                }
                
                //TURN ENDED MESSAGE
                System.out.println("Turn ended for Player " + (turn + 1));
                // Print Market State if cityHall is bought

                // If cityHall is constructed
                if (cityHall > 0) {
                    System.out.println(g.printMarket());
                    System.out.println(g.printPlayerState(cityHall, players));
                    System.out.println("The game is over. Player " + cityHall + " is the winner.");
                } else {
                    //TURN changes like normal
                    turn = (turn + 1) % 2;
                }
            }
        }

// *******************************************************************************************************************************************************




// *************************************************  FEATURE 4 (Phase 2 - Human and 1 Random AI) *********************************************************

        else if (args.length == 2 && args[0].equals("phase2") && args[1].equals("2")) {

        }








// *********************************************************************************************************************************************************




// *************************************************  FEATURE 4 (Phase 2 - Human and 2 Random AIs) *********************************************************

        else if (args.length == 2 && args[0].equals("phase2") && args[1].equals("3")) {

        }








// *******************************************************************************************************************************************

    }
}