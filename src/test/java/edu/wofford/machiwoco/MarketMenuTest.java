package edu.wofford.machiwoco;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import org.junit.*;
import java.util.ArrayList;
import java.util.*;


public class MarketMenuTest {
    MarketMenu m;
//    GameState g;
    private static int[] availableCards;
    private static String[] cardName;
    private static String[] cardIcon;
    private static int[] cardCost;
    private static int[] activation;
//    Scanner sc;

    
    @Before
    public void setup() {
//        g = new GameState();
        m = new MarketMenu();
        cardName = new String[] {"Wheat Field", "Ranch", "Forest"};
        cardIcon = new String[] {"       BW", "             BC", "            BG"};
        cardCost = new int[] {1, 1, 3};
        activation = new int[] {1, 2, 5};
        availableCards = new int[] {6, 6, 6};
        
    }
    
//    @Test
//    public void testMarketMenuConstructor() {
////        cName, String[] icon, int[] cost, int[] activation, int[] available
//        String s = "";
//        s = s + "(To view details of an item, type 'view'  \n";
//        s = s + "followed by the item number. For example, \n";
//        s += "to view item 6, type 'view 6'.)\n";
//        s += "==========================================\n";
//        s += "---------        PURCHASE        ---------\n";
////        String a = m.printMenu(3, cardName, cardIcon, cardCost, activation, availableCards);
//        
//        assertThat(s, is(s));
//    }
    
    @Test
    public void testPrintEmpty() {
        String s = "";
        String a = m.printMenu(0, cardName, cardIcon, cardCost, activation, availableCards);
        assertThat(a, is(s));
    }

    @Test
    public void testPrintNoLandmarks() {
        String s = "";
        s = s + "(To view details of an item, type 'view'  \n";
        s = s + "followed by the item number. For example, \n";
        s += "to view item 6, type 'view 6'.)\n";
        s += "==========================================\n";
        s += "---------        PURCHASE        ---------\n";
//        s += " 3. Forest             BG (3)  [5]      #6\n";
        String a = m.printMenu(3, cardName, cardIcon, cardCost, activation, availableCards);

        assertThat(a, is(s));
    }
    
    @Test
    public void testGetNumChoices() {
        Scanner str = new Scanner("99\n");
//        sc = new Scanner(s);
        //ARRAY FOR NUMBER OF CHOICES
        ArrayList<Integer> chs = new ArrayList<Integer>(0);
        for (int i = 0; i < 4; i++) {
            chs.add(i + 1);
        }
        chs.add(99);
        
        assertThat(m.getChoice(str, chs), is(99));
    
    }
    
    @Test
    public void testGetInvalidChoices() {
        Scanner str = new Scanner("5\n-1\n17\n0\n3\n");
//        sc = new Scanner(s);
        //ARRAY FOR NUMBER OF CHOICES
        ArrayList<Integer> chs = new ArrayList<Integer>(0);
        for (int i = 0; i < 4; i++) {
            chs.add(i + 1);
        }
        chs.add(99);
        
        assertThat(m.getChoice(str, chs), is(3));
    }
}