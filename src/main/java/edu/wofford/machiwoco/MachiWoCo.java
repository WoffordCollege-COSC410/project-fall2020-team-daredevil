package edu.wofford.machiwoco;




public class MachiWoCo {
//PHASE 0:::::
//full view of the establishments (in order) followed by landmarks is printed to the screen
//Each line is exactly 25 characters wide.

//The value in angled brackets is the abbreviation for color of the card (Blue, Green, Red, Purple, or None).
//The value in curly brackets is the abbreviation for the icon on the card (Wheat, Bread, Cow, Gear, Factory, Fruit O, Cup U, or Tower).
//The value in parentheses is the cost of the card.
//The value/range in the square brackets is the activation range of the card (if it's an establishment);
// if it's a landmark, then the square brackets (bottom-right) either have a space (not constructed) or a capital X (constructed).

//.-----------------------.
//| <B>      [1]      {W} |
//|      Wheat Field      |
//|                       |
//|  Get 1 coin from the  |
//|         bank.         |
//|    (anyone's turn)    |
//|                       |
//| (1)                   |
//|_______________________|

    public static void main(String[] args) {
        System.out.println("Let's play Machi WoCo!");
        System.out.println(".-----------------------.");
        System.out.println("| <B>      [1]      {W} |");
        System.out.println("Establishment is Wheat and costs 5");
    }
    

}
