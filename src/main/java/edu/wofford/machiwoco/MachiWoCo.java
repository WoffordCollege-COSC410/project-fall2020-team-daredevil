package edu.wofford.machiwoco;
import java.util.Scanner;
import java.io.*;



public class MachiWoCo {
//PHASE 0:::::
//full view of the establishments (in order) followed by landmarks is printed to the screen
//Each line is exactly 25 characters wide.

//The value in angled brackets is the abbreviation for color of the card (Blue, Green, Red, Purple, or None).
//The value in curly brackets is the abbreviation for the icon on the card (Wheat, Bread, Cow, Gear, Factory, Fruit O, Cup U, or Tower).
//The value in parentheses is the cost of the card.
//The value/range in the square brackets is the activation range of the card (if it's an establishment);
// if it's a landmark, then the square brackets (bottom-right) either have a space (not constructed) or a capital X (constructed).


    public static void main(String[] args) {
        Establishment e = new Establishment("Wheat", 3, "red", "G");

        
        if (args.length > 0 && args[0].equals("phase0")) {
            try {
                File p = new File("src/main/java/edu/wofford/machiwoco/phase0.txt");
                Scanner sc = new Scanner(p);
                while (sc.hasNextLine()) {
                    //System.out.println("in LOOP");
                    String l = sc.nextLine();
                    System.out.println(l);
                }
            } catch (Exception u) {
                System.out.println(u);
            }
        }
    }
}

