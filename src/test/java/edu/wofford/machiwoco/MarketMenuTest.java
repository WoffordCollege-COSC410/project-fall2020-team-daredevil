package edu.wofford.machiwoco;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import org.junit.*;


public class MarketMenuTest {
    MarketMenu m;
    GameState g;
    private static int[] availableCards;
    private static String[] cardName;
    private static String[] cardIcon;
    private static int[] cardCost;
    private static int[] activation;
//    Scanner sc;
    
//    ArrayList<Integer> chs = new ArrayList<Integer>(0);
//
//    //STUB MAKE A ARRAY FOR NUMBER OF CHOICES
//    for (int i = 0; i < n; i++) {
//        chs.add(i + 1);
//    }
//    chs.add(99);

    
    @Before
    public void setup() {
        g = new GameState();
        m = new MarketMenu(g);
        cardName = new String[] {"Wheat Field", "Ranch", "Forest"};
        cardIcon = new String[] {"       BW", "             BC", "            BG"};
        cardCost = new int[] {1, 1, 3};
        activation = new int[] {1, 2, 5};
        availableCards = new int[] {6, 6, 6};
    }
    
    @Test
    public void testMarketMenuConstructor() {
//        cName, String[] icon, int[] cost, int[] activation, int[] available
        String s = "";
        s = s + "(To view details of an item, type 'view'  \n";
        s = s + "followed by the item number. For example, \n";
        s += "to view item 6, type 'view 6'.)\n";
        s += "==========================================\n";
        s += "---------        PURCHASE        ---------\n";
        String a = m.printMenu(3, cardName, cardIcon, cardCost, activation, availableCards);
        assertThat(a, is(s));
    }
    
    @Test
    public void testPrint() {
        String s = "";
        s = s + "(To view details of an item, type 'view'  \n";
        s = s + "followed by the item number. For example, \n";
        s += "to view item 6, type 'view 6'.)\n";
        s += "==========================================\n";
        s += "---------        PURCHASE        ---------\n";
        String a = m.printMenu(3, cardName, cardIcon, cardCost, activation, availableCards);

        assertThat(a, is(s));
    }
    
    @Test
    public void testGetNumChoices() {
        String str = "99\n";
//        sc = new Scanner(s);
        assertThat(m.getChoice(str), is(99));
    }
}