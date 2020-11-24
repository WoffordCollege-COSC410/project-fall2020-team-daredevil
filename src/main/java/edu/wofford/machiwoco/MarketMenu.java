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
//    ArrayList<Integer> chs = new ArrayList<Integer>(0);
    
    public MarketMenu() { //Scanner scnr
        //TODO Add THE SCANNER OBJECT PARAMETER HERE
        

    }
        
    public static int getChoice(Scanner scan, ArrayList<Integer> chs) {
        
        System.out.println("Choose a number to purchase or construct: ");
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
        
        ArrayList<Integer> est = new ArrayList<>(0);
        for (int i = 0; i < available.length; i++) {
            if (coins >= cost[i] && available[i] > 0) {
                est.add(i);
            }
        }
        
        //ArrayList of valid landmarks to check
        ArrayList<Integer> lm = new ArrayList<>();
        if (coins >= 7) {
            lm.add(1);
        }
        
        //ArrayList of choices
        ArrayList<Integer> chs = new ArrayList<Integer>(0);
        for (int i = 0; i < (est.size()+lm.size()); i++) {
            chs.add(i + 1);
        }
        chs.add(99);
        
        return PREAMBLE + menu;
        
        //TODO refactor this method with code below to Truly print Purchase options
        
//        for (int i = 0; i < est.size(); i++) { //STUB make the 3 the number of available cards (or total cards
//            menu += " " + (i + 1) + ". " + cardName[est.get(i)] + " " + cardIcon[est.get(i)] + " (" + cardCost[est.get(i)] + ")  [" + activation[est.get(i)] + "]      #" + available[est.get(i)];
//        }
        
        
        //Default added
//        p = "---------         CANCEL         ---------\n";
//        p += "99. Do nothing                            \n";
//        p += "==========================================\n";
        

//        
//        //new for loop looing across landmark list... if true construct 
//        if (lm.size() > 0) {        //later loop across lm
//            System.out.println("---------       CONSTRUCT        ---------");
//            System.out.println(" " + (est.size()+1) + ". " + "City Hall          NT (7)  [ ] " );
//        }
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


