package edu.wofford.machiwoco;
import java.util.Scanner;
import java.io.*;
import java.util.Random;



public class MachiWoCo {


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
            while (!p1.hasCityHall() || !p2.hasCityHall()) {
            //Beginning of turn
                if (p1.getTurn()) {
                    System.out.println("Turn started for Player 1.");
                } else if (p2.getTurn()) {
                    System.out.println("Turn started for Player 2.");
                }
                
                //Current Game State
                    // 1. Get Market state from Market Class
                    // 2. Get Players' state from Players Class
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
                        p1.addCoins(1 * p1.getNumWheat()); //Times the number of Wheat Field cards that player has
                        p2.addCoins(1 * p2.getNumWheat()); // -----------------''--------------------
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
                        //p1.addCoins(1); if he has it and times how many
                        //p2.addCoins(1); if he has it and times how many
                    } 
                }

                game.printMarketMenu();
                Scanner scan = new Scanner(System.in);
                System.out.println("Choose a number to purchase or construct: ");
                int choice = scan.nextInt();
                // if else statements that checks what number the player entered...
                // and then do add coins/remove card etc...
                if (p1.getTurn()) {
                    System.out.println("Player 1 chose to..." + choice);
                } else if (p2.getTurn()) {
                    System.out.println("Player 2 chose to..." + choice);
                }

                //End turn for this player and then do this all again until the game ends...
                if (p1.getTurn()) {
                    System.out.println("Turn ended for Player 1.");
                    p1.setTurn(false);
                    p2.setTurn(true);
                } else if (p2.getTurn()) {
                    System.out.println("Turn ended for Player 2.");
                    p2.setTurn(false);
                    p1.setTurn(true);
                }
            }
        }
        //End of game
        if(p1.hasCityHall() == true) {
            System.out.println("The game is over. Player 1 is the winner.");
        }
        else if (p2.hasCityHall() == true){
            System.out.println("The game is over. Player 2 is the winner.");
        }
        //print final gamestate


    }
}

