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
//.-----------------------.
//| <B>      [2]      {C} |
//|         Ranch         |
//|                       |
//|  Get 1 coin from the  |
//|         bank.         |
//|    (anyone's turn)    |
//|                       |
//| (1)                   |
//|_______________________|
//.-----------------------.
//| <G>     [2-3]     {B} |
//|        Bakery         |
//|                       |
//|  Get 1 coin from the  |
//|         bank.         |
//|   (your turn only)    |
//|                       |
//| (1)                   |
//|_______________________|
//.-----------------------.
//| <R>      [3]      {U} |
//|         Cafe          |
//|                       |
//| Take 1 coin from the  |
//|    active player.     |
//|   (opponent's turn)   |
//|                       |
//| (2)                   |
//|_______________________|
//.-----------------------.
//| <G>      [4]      {B} |
//|   Convenience Store   |
//|                       |
//| Get 3 coins from the  |
//|         bank.         |
//|   (your turn only)    |
//|                       |
//| (2)                   |
//|_______________________|
//.-----------------------.
//| <B>      [5]      {G} |
//|        Forest         |
//|                       |
//|  Get 1 coin from the  |
//|         bank.         |
//|    (anyone's turn)    |
//|                       |
//| (3)                   |
//|_______________________|
//.-----------------------.
//| <P>      [6]      {T} |
//|        Stadium        |
//|                       |
//|   Take 2 coins from   |
//|    each opponent.     |
//|   (your turn only)    |
//|                       |
//| (6)                   |
//|_______________________|
//.-----------------------.
//| <P>      [6]      {T} |
//|      TV Station       |
//|                       |
//| Take 5 coins from an  |
//|       opponent.       |
//|   (your turn only)    |
//|                       |
//| (7)                   |
//|_______________________|
//.-----------------------.
//| <P>      [6]      {T} |
//|   Business Complex    |
//|                       |
//| Exchange one of your  |
//|       non-tower       |
//| establishments for 1  |
//|   an opponent owns.   |
//|   (your turn only)    |
//|                       |
//| (8)                   |
//|_______________________|
//.-----------------------.
//| <G>      [7]      {F} |
//|    Cheese Factory     |
//|                       |
//| Get 3 coins from the  |
//|   bank for each {C}   |
//|   establishment you   |
//|         own.          |
//|   (your turn only)    |
//|                       |
//| (5)                   |
//|_______________________|
//.-----------------------.
//| <G>      [8]      {F} |
//|   Furniture Factory   |
//|                       |
//| Get 3 coins from the  |
//|   bank for each {G}   |
//|   establishment you   |
//|         own.          |
//|   (your turn only)    |
//|                       |
//| (3)                   |
//|_______________________|
//.-----------------------.
//| <B>      [9]      {G} |
//|         Mine          |
//|                       |
//| Get 5 coins from the  |
//|         bank.         |
//|    (anyone's turn)    |
//|                       |
//| (6)                   |
//|_______________________|
//.-----------------------.
//| <R>    [9-10]     {U} |
//|   Family Restaurant   |
//|                       |
//| Take 2 coins from the |
//|    active player.     |
//|   (opponent's turn)   |
//|                       |
//| (3)                   |
//|_______________________|
//.-----------------------.
//| <B>     [10]      {W} |
//|     Apple Orchard     |
//|                       |
//| Get 3 coins from the  |
//|         bank.         |
//|    (anyone's turn)    |
//|                       |
//| (3)                   |
//|_______________________|
//.-----------------------.
//| <G>    [11-12]    {O} |
//|    Farmers Market     |
//|                       |
//| Get 2 coins from the  |
//|   bank for each {W}   |
//|   establishment you   |
//|         own.          |
//|   (your turn only)    |
//|                       |
//| (2)                   |
//|_______________________|
//.-----------------------.
//| <N>   LANDMARK    {T} |
//|     Train Station     |
//|                       |
//|  You may roll 1 or 2  |
//|         dice.         |
//|                       |
//| (4)               [ ] |
//|_______________________|
//.-----------------------.
//| <N>   LANDMARK    {T} |
//|     Shopping Mall     |
//|                       |
//|   Your {U} and {B}    |
//|  establishments earn  |
//|     +1 coin when      |
//|      activated.       |
//|                       |
//| (10)              [ ] |
//|_______________________|
//.-----------------------.
//| <N>   LANDMARK    {T} |
//|    Amusement Park     |
//|                       |
//| If you roll doubles,  |
//|   take another turn   |
//|    after this one.    |
//|                       |
//| (16)              [ ] |
//|_______________________|
//.-----------------------.
//| <N>   LANDMARK    {T} |
//|      Radio Tower      |
//|                       |
//|  Once per turn, you   |
//| may reroll the dice.  |
//|                       |
//| (22)              [ ] |
//|_______________________|

    public static void main(String[] args) {
        Establishment e = new Establishment("Wheat", 3, "red", "G");
        System.out.println("Let's play Machi WoCo!");
        System.out.println(".-----------------------.");
        System.out.println("| <B>      [1]      {W} |");
        System.out.println("Establishment is Wheat and costs 5");
    }
    

}
