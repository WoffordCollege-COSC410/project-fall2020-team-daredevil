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
    
    
    public static int getChoice(Scanner scan, ArrayList<Integer> chs) {
        System.out.println("Choose a number to purchase or construct: ");
        int choice = scan.nextInt();
        while (!chs.contains(choice)) {
            System.out.println("Choose a number to purchase or construct: ");
            choice = scan.nextInt();
        }
        return choice;
    }
    
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
            menu += " 4. City Hall          NT (7)  [ ]\n";
        }
        
        menu += "---------         CANCEL         ---------\n";
        menu += "99. Do nothing                            \n";
        menu += "==========================================";
        return PREAMBLE + menu;
    }

}


    