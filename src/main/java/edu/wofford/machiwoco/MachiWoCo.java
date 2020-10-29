package edu.wofford.machiwoco;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.ArrayList;



public class MachiWoCo {
    private static int cityHall;
    private static int turn;
    private static int[] availableCards = {6, 6, 6};
    private static int[] p1Cards = {1, 0, 0};
    private static int[] p2Cards = {1, 0, 0};
    private static int[] coins = {3, 3}; //better to make an array of players
    private static String[] cardName = {"Wheat Field", "Ranch", "Forest"};
    private static String[] cardIcon = {"       BW", "             BC", "            BG"};
    private static int[] cardCost = {1, 1, 3};
    private static int[] activation = {1, 2, 5};
    //available coices with n from loop below?

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
                
//                GameState g = new GameState();
//                //System.out.println("New Market");
//                System.out.println(g.printMarket());
//                //System.out.println("New PlayerState");
//                System.out.println(g.printPlayerState(turn));


                // Print Player 1 State
                if (turn == 0) {
                    System.out.println("             Player 1* [YOU]              ");
                } else {
                    System.out.println("             Player 1 [YOU]               ");
                }
                System.out.println("------------------------------------------");
                System.out.println("                (" + coins[0] + " coins)  ");
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
                 System.out.println("                (" + coins[1] + " coins)  ");
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
     
//                 Check to see if the dice roll activated any cards 
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
                System.out.println();
                
                //Prompt for purchase and show MarketMenu (Purchase/Construct screen)
                System.out.println("Player " + (turn + 1) + ", would you like to purchase an");
                System.out.println("establishment or construct a landmark? (" + coins[turn]);
                System.out.println("coins)");
                System.out.println("(To view details of an item, type 'view'  ");
                System.out.println("followed by the item number. For example, ");
                System.out.println("to view item 6, type 'view 6'.)           ");
                System.out.println("==========================================");
                System.out.println("---------        PURCHASE        ---------");
                int n = 0;
                for (int i = 0; i < 3; i++) {
                    if (coins[turn] >= cardCost[i] && availableCards[i] > 0) {
                        n++;
                        System.out.println(" " + (i + 1) + ". " + cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + availableCards[i]);
                    }
                }
                if (coins[turn] >= 7) {
                    n++;
                    System.out.println("---------       CONSTRUCT        ---------");
                    System.out.println(" " + n + ". " + "City Hall          NT (7)  [ ] " );
                }

                //STUB MAKE A ARRAY FOR NUMBER OF CHOICES
                ArrayList<Integer> chs = new ArrayList<Integer>(n);
                for (int i = 0; i < n; i++) {
                    chs.add(i + 1);
                }
                chs.add(99);
                
                System.out.println("---------         CANCEL         ---------");
                System.out.println("99. Do nothing                            ");
                System.out.println("==========================================");

                System.out.println("Choose a number to purchase or construct: ");
                Scanner scan = new Scanner(System.in);
                int choice = scan.nextInt();
                while (!chs.contains(choice)) {
                    System.out.println("Choose a number to purchase or construct: ");
                    choice = scan.nextInt();
                }

                int p = 0;
//                if none of possible options, repormpt, check at that first index
                while (p < 3) {
                    if (choice == p + 1 && coins[turn] >= cardCost[p]) {
                        System.out.println("Player " + (turn + 1) + " purchased the " + cardName[p]);
                        availableCards[p] -= 1;
                        if (turn == 0) {
                            p1Cards[p] += 1;
                            //NEED CHECK FOR keeping coins positive??
                            coins[0] -= cardCost[p];
                        } else if (turn == 1) {
                            p2Cards[p] += 1;
                            coins[1] -= cardCost[p];
                        }
                    } else if (coins[turn] >= 7 && choice == n) {
                        cityHall = turn + 1;
                        System.out.println("Player " + (turn + 1) + " constructed the City Hall");
                        if (turn == 0) {
                            //NEED CHECK FOR keeping coins positive??
                            coins[0] -= 7; //TODO put in cardCost arr?
                        } else if (turn == 1) {
                            coins[1] -= 7; //TODO put in cardCost arr?
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
                    System.out.println("                (" + coins[0] + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (p1Cards[i] > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + p1Cards[i]);
                        }
                    }
                    System.out.println("..........................................");
                    System.out.println("City Hall          NT (7)  [X]            ");
                    System.out.println("                                          ");
                    System.out.println("                 Player 2                 ");
                    System.out.println("------------------------------------------");
                    System.out.println("                (" + coins[1] + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (p2Cards[i] > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + p2Cards[i]);
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
                    System.out.println("                (" + coins[0] + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (p1Cards[i] > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + p1Cards[i]);
                        }
                    }
                    System.out.println("..........................................");
                    System.out.println("City Hall          NT (7)  [ ]            ");
                    System.out.println("                                          ");
                    System.out.println("                 Player 2*                ");
                    System.out.println("------------------------------------------");
                    System.out.println("                (" + coins[1] + " coins)  ");
                    for (int i = 0; i < 3; i++) {
                        if (p2Cards[i] > 0) {
                            System.out.println(cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + p2Cards[i]);
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
    }
}