package edu.wofford.machiwoco;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import org.junit.*;


public class MarketMenuTest {
    MarketMenu m;
    GameState g;
    
    @Before
    public void setup() {
        g = new GameState();
        m = new MarketMenu(g);
    }
    
    @Test
    public void testMarketMenuConstructor() {
        String s = "";
        s = s + "(To view details of an item, type 'view'  \n";
        s = s + "followed by the item number. For example, \n";
        s += "to view item 6, type 'view 6'.)\n";
        s += "==========================================\n";
        s += "---------        PURCHASE        ---------\n";
        assertThat(m.printMenu(), is(s));
    }
    
    @Test
    public void testPrint() {
        String s = "";
        s = s + "(To view details of an item, type 'view'  \n";
        s = s + "followed by the item number. For example, \n";
        s += "to view item 6, type 'view 6'.)\n";
        s += "==========================================\n";
        s += "---------        PURCHASE        ---------\n";
        assertThat(m.printMenu(), is(s));
    }
    
    @Test
    public void testGetNumChoices() {
    }
}