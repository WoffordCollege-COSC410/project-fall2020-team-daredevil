package edu.wofford.machiwoco;
import java.util.Scanner;
import java.util.ArrayList;


/**
*/
public class MarketMenu {
    private static final String PREAMBLE = "(To view details of an item, type 'view'  \n" +
                                           "followed by the item number. For example, \n" +
                                           "to view item 6, type 'view 6'.)\n" +
                                           "==========================================\n" +
                                           "---------        PURCHASE        ---------\n";
//    static String menu;
    //Add a gametate 
//    GameState g;
    ArrayList<Integer> chs = new ArrayList<Integer>(0);
    
    public MarketMenu() { //Scanner scnr
        //TODO Add THE SCANNER OBJECT PARAMETER HERE
        

    }
        
    public static int getChoice(Scanner scan, ArrayList<Integer> chs) {
        
        //TODO Add code below in here (to remove from MachiWoco?
        //        //ARRAY FOR NUMBER OF CHOICES
        //        for (int i = 0; i < n; i++) {
        //            chs.add(i + 1);
        //        }
        //        chs.add(99);
        
        System.out.println("Choose a number to purchase or construct: "); //TODO LEAVE THIS TO MACHIWOCO???
        int choice = scan.nextInt();
        while (!chs.contains(choice)) {
            System.out.println("Choose a number to purchase or construct: ");
            choice = scan.nextInt();
        }
        return choice;
    }
    
    
    public static String printMenu(int coins, String[] cName, String[] icon, int[] cost, int[] activation, int[] available) {
        String menu = "";
        //ASSumes coins > 0
        if (coins == 0) {
            return menu;
        }
//        n is the possible numbers to buy, for loop shows all purchasable cards to player
        int n = 0;
        for (int i = 0; i < 3; i++) { //STUB make the 3 the number of available cards (or total cards
            if (coins >= cost[i] && available[i] > 0) {
                n++;
                menu = " " + (i + 1) + ". " + cName[i] + " " + icon[i] + " (" + cost[i] + ")  [" + activation[i] + "]      #" + available[i] + "\n";
            }
        }
        
        if (coins >= 7) {
            n++;
            System.out.println("---------       CONSTRUCT        ---------");
            System.out.println(" " + n + ". " + "City Hall          NT (7)  [ ] ");
        }
        
        //Default added
//        p = "---------         CANCEL         ---------\n";
//        p += "99. Do nothing                            \n";
//        p += "==========================================\n";
//        System.out.println(menu);
        return PREAMBLE + menu;
    }
    
    
    
//    System.out.println("(To view details of an item, type 'view'  ");
//    System.out.println("followed by the item number. For example, ");
//    System.out.println("to view item 6, type 'view 6'.)           ");
//    System.out.println("==========================================");
//    System.out.println("---------        PURCHASE        ---------");

//    int n = 0;
//    for (int i = 0; i < 3; i++) {
//        if (coins[turn] >= cardCost[i] && availableCards[i] > 0) {
//            n++;
//            System.out.println(" " + (i + 1) + ". " + cardName[i] + " " + cardIcon[i] + " (" + cardCost[i] + ")  [" + activation[i] + "]      #" + availableCards[i]);
//        }
//    }
//    if (coins[turn] >= 7) {
//        n++;
//        System.out.println("---------       CONSTRUCT        ---------");
//        System.out.println(" " + n + ". " + "City Hall          NT (7)  [ ] " );
//    }
//    System.out.println("---------         CANCEL         ---------");
//    System.out.println("99. Do nothing                            ");
//    System.out.println("==========================================");

    
//                //STUB MAKE A ARRAY FOR NUMBER OF CHOICES
//                ArrayList<Integer> chs = new ArrayList<Integer>(n);
//                for (int i = 0; i < n; i++) {
//                    chs.add(i + 1);
////                    System.out.println(chs.get(i));
//                }
//                chs.add(99); 
   

//                    System.out.println("Choose a number to purchase or construct: ");
//                    Scanner scan = new Scanner(System.in);
//                    int choice = scan.nextInt();
//                    while (!chs.contains(choice)) {
//                        System.out.println("Choose a number to purchase or construct: ");
//                        choice = scan.nextInt();
//                    }
//                int p = 0;
////                if none of possible options, repormpt, check at that first index
//                while (p < 3) {  //TODO need while loop?
//                    if (choice == p + 1 && coins[turn] >= cardCost[p]) {
//                        System.out.println("Player " + (turn + 1) + " purchased the " + cardName[p]);
//                        availableCards[p] -= 1;
//                        if (turn == 0) {
//                            p1Cards[p] += 1;
//                            //NEED CHECK FOR keeping coins positive
//                            coins[0] -= cardCost[p];
//                        } else if (turn == 1) {
//                            p2Cards[p] += 1;
//                            coins[1] -= cardCost[p];
//                        }
//                    } else if (choice == 99) {
//                        System.out.println("Player " + (turn + 1) + " chose not to make any improvements.");
//                        break;
//                    } 
//                    p++;
//                }
                



}


