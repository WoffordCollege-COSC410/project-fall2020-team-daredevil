package edu.wofford.machiwoco;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;


// Feature 1: LINE 60~
// Feature 2: LINE 80~
// Feature 3: LINE 315~


public class MachiWoCo {
    private static int cityHall;
    private static int turn;
    private static int[] availableCards = {6, 6, 6};
    // private static int[] p1Cards = {1, 0, 0};
    // private static int[] p2Cards = {1, 0, 0};
    // private static int[] coins = {3, 3}; //better to make an array of players
    private static Player[] players;
    private static String[] cardName = {"Wheat Field", "Ranch", "Forest"};
    private static String[] cardIcon = {"       BW", "             BC", "            BG"};
    private static int[] cardCost = {1, 1, 3};
    private static int[] activation = {1, 2, 5};
    //available coices with n from loop below?

    public static void main(String[] args) {
        cityHall = 0;
        turn = 0;
        int choice = 0;
        players = new Player[] {new Player(), new Player()};
        Random random = new Random();

// ************************************************** SHADOW/TRIAL CODE ********************************************************************









                                            // Try out refactored code here
                                            // before mixing it with original code











// ***************************************************************************************************************************************




// **************************************************** FEATURE 1 (Phase 0) ***************************************************************

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




// *************************************************  FEATURE 2 (2 Human Players) *********************************************************

          else if (args.length == 1 && args[0].equals("phase1")) {
            // Start of game
            System.out.println("The game has started. Player 1 will go    ");
            System.out.println("first.                                    ");

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

                // Print Player 1 State
                if (turn == 0) {
                    System.out.println("             Player 1* [YOU]              ");
                } else {
                    System.out.println("             Player 1 [YOU]               ");
                }
                System.out.println("------------------------------------------");
                System.out.println("                (" + players[0].getCoins() + " coins)  ");
                for (int i = 0; i < 3; i++) {
                    if (players[0].getPCards(i) > 0) {
                        System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + players[0].getPCards(i));
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
                 System.out.println("                (" + players[1].getCoins() + " coins)  ");
                 for (int i = 0; i < 3; i++) {
                     if (players[1].getPCards(i) > 0) {
                         System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + players[1].getPCards(i));
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
     
//                 Check to see if the dice roll activated any cards 
                for (int i = 0; i < 3; i++) {
                    if (dice == activation[i]) {
                        players[0].setCoins(1 * players[0].getPCards(i));
                        players[1].setCoins(1 * players[1].getPCards(i));
                        if (players[0].getPCards(i) > 0 && players[1].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " activated for Player 1");
                            System.out.println(cardName[i] + " activated for Player 2");
                        } else if (players[0].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " activated for Player 1");
                        } else if (players[1].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " activated for Player 2");
                        } 
                    } 
                }
                System.out.println();
                
                //Prompt for purchase and show MarketMenu (Purchase/Construct screen)
                System.out.println("Player " + (turn + 1) + ", would you like to purchase an");
                System.out.println("establishment or construct a landmark? (" + players[turn].getCoins());
                System.out.println("coins)");
                System.out.println("(To view details of an item, type 'view'  ");
                System.out.println("followed by the item number. For example, ");
                System.out.println("to view item 6, type 'view 6'.)           ");
                System.out.println("==========================================");
                System.out.println("---------        PURCHASE        ---------");


                int n = 0;
                for (int i = 0; i < 3; i++) {
                    if (players[turn].getCoins() >= cardCost[i] && availableCards[i] > 0) {
                        n++;
                        System.out.println(" " + (i + 1) + ". " + cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + availableCards[i]);
                    }
                }
                if (players[turn].getCoins() >= 7) {
                    n++;
                    System.out.println("---------       CONSTRUCT        ---------");
                    System.out.println(" " + n + ". " + "City Hall          NT (7)  [ ] " );
                }

                ArrayList<Integer> chs = new ArrayList<Integer>(0);

                //STUB MAKE A ARRAY FOR NUMBER OF CHOICES
                for (int i = 0; i < n; i++) {
                    chs.add(i + 1);
                }
                chs.add(99);
                
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");

                System.out.println("Choose a number to purchase or construct: ");
                Scanner scan = new Scanner(System.in);
                choice = scan.nextInt();
                while (!chs.contains(choice)) {
                    System.out.println("Choose a number to purchase or construct: ");
                    choice = scan.nextInt();
                }

                int p = 0;
//                if none of possible options, repormpt, check at that first index
                while (p < 3) {
                    if (choice == p + 1 && players[turn].getCoins() >= cardCost[p]) {
                        System.out.println("Player " + (turn + 1) + " purchased the " + cardName[p]);
                        availableCards[p] -= 1;
                        if (turn == 0) {
                            players[turn].setPCards(p);
                            //NEED CHECK FOR keeping coins positive??
                            players[turn].setCoins(-cardCost[p]);
                        } else if (turn == 1) {
                            players[1].setPCards(p);
                            players[1].setCoins(-cardCost[p]);
                        }
                    } else if (players[turn].getCoins() >= 7 && choice == n) {
                        cityHall = turn + 1;
                        System.out.println("Player " + (turn + 1) + " constructed the City Hall");
                        if (turn == 0) {
                            //NEED CHECK FOR keeping coins positive??
                            players[0].setCoins(-7); //TODO put in cardCost arr?
                        } else if (turn == 1) {
                            players[1].setCoins(-7); //TODO put in cardCost arr?
                        }
                        break;
                    } else if (choice == 99) {
                        System.out.println("Player " + (turn + 1) + " chose not to make any improvements.");
                        break;
                    } 
                    p++;
                }
                
                //TURN ENDED MESSAGE
                System.out.println("Turn ended for Player " + (turn + 1));
                
                // Print Market State if cityHall is bought
                if (cityHall > 0) {
                    System.out.println("******************************************");
                    System.out.println("                  MARKET                  ");
                    System.out.println("------------------------------------------");
                    for (int i = 0; i < 3; i++) {
                        if (availableCards[i] > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + availableCards[i]);
                        }
                    }
                    System.out.println();
                }
                if (cityHall == 1) {
                    System.out.println("             Player 1* [YOU]              ");
                    System.out.println("------------------------------------------");
                    System.out.println("                (" + players[0].getCoins() + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (players[0].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" +  players[0].getPCards(i));
                        }
                    }
                    System.out.println("..........................................");
                    System.out.println("City Hall          NT (7)  [X]            ");
                    System.out.println("                                          ");
                    System.out.println("                 Player 2                 ");
                    System.out.println("------------------------------------------");
                    System.out.println("                (" + players[1].getCoins() + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (players[1].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" +  players[1].getPCards(p));
                        }
                    }
                    System.out.println("..........................................");
                    System.out.println("City Hall          NT (7)  [ ]            ");
                    System.out.println("                                          ");
                    System.out.println("******************************************");
                    System.out.println("The game is over. Player " + cityHall + " is the winner.");
                } else if (cityHall == 2) {
                    System.out.println("             Player 1 [YOU]               ");
                    System.out.println("------------------------------------------");
                    System.out.println("                (" + players[0].getCoins() + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (players[0].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + players[0].getPCards(p));
                        }
                    }
                    System.out.println("..........................................");
                    System.out.println("City Hall          NT (7)  [ ]            ");
                    System.out.println("                                          ");
                    System.out.println("                 Player 2*                ");
                    System.out.println("------------------------------------------");
                    System.out.println("                (" + players[1].getCoins() + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (players[1].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + players[1].getPCards(p));
                        }
                    }
                    System.out.println("..........................................");
                    System.out.println("City Hall          NT (7)  [X]            ");
                    System.out.println("                                          ");
                    System.out.println("******************************************");
                    System.out.println("The game is over. Player " + cityHall + " is the winner.");
                } else {
                    //TURN changes like normal
                    turn = (turn + 1) % 2;
                }
            }
        }

// ****************************************************************************************************************************************




// *************************************************  FEATURE 2 (2 Human Players) *********************************************************

        else if (args.length == 2 && args[0].equals("phase1") && args[1].equals("--ai")) {
            // Start of game
            System.out.println("The game has started. Player 1 will go    ");
            System.out.println("first.                                    ");

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
                 
                // Print Player 1 State
                if (turn == 0) {
                    System.out.println("             Player 1* [YOU]              ");
                } else {
                    System.out.println("             Player 1 [YOU]               ");
                }
                System.out.println("------------------------------------------");
                System.out.println("                (" + players[0].getCoins() + " coins)  ");
                for (int i = 0; i < 3; i++) {
                    if (players[0].getPCards(i) > 0) {
                        System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + players[0].getPCards(i));
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
                 System.out.println("                (" + players[1].getCoins() + " coins)  ");
                 for (int i = 0; i < 3; i++) {
                     if (players[1].getPCards(i) > 0) {
                         System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + players[1].getPCards(i));
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

                // Check if any cards are activated
                for (int i = 0; i < 3; i++) {
                    if (dice == activation[i]) {
                        players[0].setCoins(1 * players[0].getPCards(i));
                        players[1].setCoins(1 * players[1].getPCards(i));
                        if (players[0].getPCards(i) > 0 && players[1].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " activated for Player 1");
                            System.out.println(cardName[i] + " activated for Player 2");
                        } else if (players[0].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " activated for Player 1");
                        } else if (players[1].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " activated for Player 2");
                        } 
                    } 
                }
                
                int n = 0;
                // Check to see if the acitve player is Human or the Random AI
                if (turn == 0) { //player is human
                    // count the number of possible options
                    for (int i = 0; i < 3; i++) {
                        if (players[turn].getCoins() >= cardCost[i] && availableCards[i] > 0) {
                            n++;
                        }
                    }


                    if (n > 0) { // player has at least 1 option to buy
                        //Prompt for purchase and show MarketMenu (Purchase/Construct screen)
                        System.out.println();
                        System.out.println("Player " + (turn + 1) + ", would you like to purchase an");
                        System.out.println("establishment or construct a landmark? (" + players[turn].getCoins());
                        System.out.println("coins)");
                        System.out.println("(To view details of an item, type 'view'  ");
                        System.out.println("followed by the item number. For example, ");
                        System.out.println("to view item 6, type 'view 6'.)           ");
                        System.out.println("==========================================");
                        System.out.println("---------        PURCHASE        ---------");
                        for (int i = 0; i < n; i++) {
                            System.out.println(" " + (i + 1) + ". " + cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + availableCards[i]);
                        }

                        if (players[turn].getCoins() >= 7) {
                            n++;
                            System.out.println("---------       CONSTRUCT        ---------");
                            System.out.println(" " + n + ". " + "City Hall          NT (7)  [ ] " );
                        }


                        // create an array of choices
                        ArrayList<Integer> chs = new ArrayList<Integer>(0);

                        for (int i = 0; i < n; i++) {
                            chs.add(i + 1);
                        }
                        chs.add(99);
                        
                        System.out.println("---------         CANCEL         ---------");
                        System.out.println("99. Do nothing                            ");
                        System.out.println("==========================================");
                        System.out.println("Choose a number to purchase or construct: ");
                        Scanner scan = new Scanner(System.in);
                        choice = scan.nextInt();
                        while (!chs.contains(choice)) {
                            System.out.println("Choose a number to purchase or construct: ");
                            choice = scan.nextInt();
                        }
                    } else { //player has no possible options
                        System.out.println("Player 1 did not enough money to make improvements");
                    }
                } else if (turn == 1) { // player is AI
                        // count the number of possible options
                        for (int i = 0; i < 3; i++) {
                            if (players[turn].getCoins() >= cardCost[i] && availableCards[i] > 0) {
                                n++;
                            }
                        }
                        // if the AI player has 7 or more coins, he automatically wins the game
                        if (players[turn].getCoins() >= 7) {
                            cityHall = 2;
                            break;
                        }

                        if (n > 0) { // if AI has at least one option
                            

                            // create an array of choices
                            ArrayList<Integer> chs = new ArrayList<Integer>(0);

                            for (int i = 0; i < n; i++) {
                                chs.add(i + 1);
                            }
                            chs.add(99);

                            // use a random number generator to make the choice for the AI
                            Random random2 = new Random();
                            choice = chs.get(random2.nextInt(n));
                            System.out.println(chs);
                        } else {
                            System.out.println("Player 1 did not enough money to make improvements");
                        }
                }
                
                int p = 0;
//                if none of possible options, repormpt, check at that first index
                while (p < 3) {
                    if (choice == p + 1 && players[turn].getCoins() >= cardCost[p]) {
                        System.out.println("Player " + (turn + 1) + " purchased the " + cardName[p]);
                        availableCards[p] -= 1;
                        if (turn == 0) {
                            players[turn].setPCards(p);
                            //NEED CHECK FOR keeping coins positive??
                            players[turn].setCoins(-cardCost[p]);
                        } else if (turn == 1) {
                            players[1].setPCards(p);
                            players[1].setCoins(-cardCost[p]);
                            break;
                        }
                    } else if (players[turn].getCoins() >= 7 && choice == n) {
                        cityHall = turn + 1;
                        System.out.println("Player " + (turn + 1) + " constructed the City Hall");
                        if (turn == 0) {
                            //NEED CHECK FOR keeping coins positive??
                            players[0].setCoins(-7); //TODO put in cardCost arr?
                        } else if (turn == 1) {
                            players[1].setCoins(-7); //TODO put in cardCost arr?
                        }
                        break;
                    } else if (choice == 99) {
                        System.out.println("Player " + (turn + 1) + " chose not to make any improvements.");
                        break;
                    } 
                    p++;
                }
                
                //TURN ENDED MESSAGE
                System.out.println("Turn ended for Player " + (turn + 1));
                // Print Market State if cityHall is bought
                if (cityHall > 0) {
                    System.out.println("******************************************");
                    System.out.println("                  MARKET                  ");
                    System.out.println("------------------------------------------");
                    for (int i = 0; i < 3; i++) {
                        if (availableCards[i] > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + availableCards[i]);
                        }
                    }
                    System.out.println();
                }
                if (cityHall == 1) {
                    System.out.println("             Player 1* [YOU]              ");
                    System.out.println("------------------------------------------");
                    System.out.println("                (" + players[0].getCoins() + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (players[0].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" +  players[0].getPCards(i));
                        }
                    }
                    System.out.println("..........................................");
                    System.out.println("City Hall          NT (7)  [X]            ");
                    System.out.println("                                          ");
                    System.out.println("                 Player 2                 ");
                    System.out.println("------------------------------------------");
                    System.out.println("                (" + players[1].getCoins() + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (players[1].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" +  players[1].getPCards(p));
                        }
                    }
                    System.out.println("..........................................");
                    System.out.println("City Hall          NT (7)  [ ]            ");
                    System.out.println("                                          ");
                    System.out.println("******************************************");
                    System.out.println("The game is over. Player " + cityHall + " is the winner.");
                } else if (cityHall == 2) {
                    System.out.println("             Player 1 [YOU]               ");
                    System.out.println("------------------------------------------");
                    System.out.println("                (" + players[0].getCoins() + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (players[0].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + players[0].getPCards(p));
                        }
                    }
                    System.out.println("..........................................");
                    System.out.println("City Hall          NT (7)  [ ]            ");
                    System.out.println("                                          ");
                    System.out.println("                 Player 2*                ");
                    System.out.println("------------------------------------------");
                    System.out.println("                (" + players[1].getCoins() + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (players[1].getPCards(i) > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + players[1].getPCards(p));
                        }
                    }
                    System.out.println("..........................................");
                    System.out.println("City Hall          NT (7)  [X]            ");
                    System.out.println("                                          ");
                    System.out.println("******************************************");
                    System.out.println("The game is over. Player " + cityHall + " is the winner.");
                } else {
                    //TURN changes like normal
                    turn = (turn + 1) % 2;
                }
            }

// *******************************************************************************************************************************************

        }
    }
}