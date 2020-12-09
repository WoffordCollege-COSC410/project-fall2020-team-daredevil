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
    * Prompts and returns a Player's purchase choice
    * @param scan A Scanner object with the Player choice
    * @param chs An array with all valid choices of the Purchase Menu
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
    * Compiles all the properties a Player can buy or construct
    * @param available An array of all available Establishment Cards
    * @param cost An array of all Establishment Card Costs
    * @param coins A Player's current coins
    * @return All purchasable properties indexes
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
    
    /**
    * Print the Purchase Menu for a Human player
    * @param coins A Player's current money
    * @param cName An array of all Establishment Card names
    * @param icon An array of all Establishment Card icons
    * @param cost An array of all Establishment Card costs
    * @param activation An array of all Establishment Card Activation numbers
    * @param available An array of all Establishment Card remaining in the Market
    * @return The Purchase Menu
    */
    public static String printMenu(int coins, String[] cName, String[] icon, int[] cost, int[] activation, int[] available) {
        
        ArrayList<Integer> est = new ArrayList<>(0);
        for (int i = 0; i < available.length; i++) {
            if (coins >= cost[i] && available[i] > 0) {
                est.add(i);
            }
        }
        
        ArrayList<Integer> lm = new ArrayList<>();
        if (coins >= 7) {
            lm.add(1);
        }
        
        
        if ((est.size() + lm.size()) == 0) {
            return "";
        }
        
        String menu = "";
        for (int i = 0; i < est.size(); i++) {
            menu += " " + (i + 1) + ". " + cName[est.get(i)] + " " + icon[est.get(i)] + " (" + cost[est.get(i)] + ")  [" + activation[est.get(i)] + "]      #" + available[est.get(i)] + "\n";
        }
        
        if (lm.size() > 0) {
            menu += "---------       CONSTRUCT        ---------\n";
            menu += " " + (est.size() + 1) + ". City Hall          NT (7)  [ ]\n";
        }
        
        menu += "---------         CANCEL         ---------\n";
        menu += "99. Do nothing                            \n";
        menu += "==========================================";
        return PREAMBLE + menu;
    }
}


    