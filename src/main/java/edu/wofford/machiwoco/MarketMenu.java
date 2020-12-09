package edu.wofford.machiwoco;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * @author Jacob Vannoy, Kristinn Sigurjonsson, Jaylen Muhammad, Evan Suggs
 */

public class MarketMenu {
    private static final String PREAMBLE = "(To view details of an item, type 'view'  \n" +
                                           "followed by the item number. For example, \n" +
                                           "to view item 6, type 'view 6'.)\n" +
                                           "==========================================\n" +
                                           "---------        PURCHASE        ---------\n";
    
    /**
     * Creates new instamce of MarketMenu
     */
    public MarketMenu() {
        
    }
    
    /**
     * Takes in choice from the user
     * @return choice
     * @param scan value of user input
     * @param chs list of valid choices
     */
    public static int getChoice(Scanner scan, ArrayList<Integer> chs) {
        System.out.println("Choose a number to purchase or construct: ");
        int choice = scan.nextInt();
        while (!chs.contains(choice)) {
            System.out.println("Choose a number to purchase or construct: ");
            choice = scan.nextInt();
        }
        return choice;
    }
    
    /**
     * Creates the list of available choices
     * @return c
     * @param available list of number of available cards
     * @param cost list of card costs
     * @param coins amount of coins player has
     */
    public ArrayList<Integer> listOfChoices(int[] available, int[] cost, int coins) {
        ArrayList<Integer> c = new ArrayList<>(0);
        for (int i = 0; i < available.length; i++) {
            if (coins >= cost[i] && available[i] > 0) {
                c.add(i);
            }
        }
        if (coins >= 7) {
            c.add(c.size() + 1);

        }
        return c;
    }
    
    //public ArrayList<Integer> getProperties(int coins, int[] cost, int[] available) {}
    
    /**
     * Constructs the Market menu
     * @return PREAMBLE + menu
     * @param coins amount of coins player has
     * @param cName list of card names 
     * @param icon list of card icons
     * @param cost list of costs for each card
     * @param activation list of activation numbers
     * @param available list of available cards
     */
    public static String printMenu(int coins, String[] cName, String[] icon, int[] cost, int[] activation, int[] available) {
        
        //put block in "get purchasable pro method"
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
        //
        
        
        if ((est.size() + lm.size()) == 0) {
            return "";
        }
        
        String menu = "";
        for (int i = 0; i < est.size(); i++) {
            menu += " " + (i + 1) + ". " + cName[est.get(i)] + " " + icon[est.get(i)] + " (" + cost[est.get(i)] + ")  [" + activation[est.get(i)] + "]      #" + available[est.get(i)] + "\n";
        }
        
        if (lm.size() > 0) {        //loop across lm
            menu += "---------       CONSTRUCT        ---------\n";
            menu += " 4. City Hall          NT (7)  [ ]\n";
        }
        
        menu += "---------         CANCEL         ---------\n";
        menu += "99. Do nothing                            \n";
        menu += "==========================================\n";
        return PREAMBLE + menu;
    }
   
    
    
//    public String purchaseCard(int choice, int turn) {
//        int index = choice - 1;
//        if (choice > 0 && est.size() + lm.size() > 0) {
//            if (choice == 99) {
//                return "Player " + (turn + 1) + " chose not to make any improvements.";
//            } else if (choice > est.size() && lm.size() > 0) {
//                //then it is a landmark
//                cityHall = turn + 1;
//                System.out.println("Player " + (turn + 1) + " constructed the City Hall");
//                players[turn].setCoins(-7);
//            } else { //it is a property
//                System.out.println("Player " + (turn + 1) + " purchased the " + cardName[est.get(index)]);
//                g.removeAvailableCards(est.get(index));
//                players[turn].setPCards(est.get(index));
//                players[turn].setCoins(-cardCost[est.get(index)]);
//            }
//        }
//    }

}


    