package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import org.junit.*;

public class GameStateTest {


    GameState m;
    private Player p1 = new Player();
    private Player p2 = new Player();
    private Player[] players;

	@Before
	public void setup() {
		m = new GameState();
        players = new Player[] {p1, p2};
        //        players = new Player[] {new Player(), new Player()};
    }
    
    @Test
    public void testPrintMarket() {
        String a = "";
        a += "******************************************\n";
        a += "                  MARKET                  \n";
        a += "------------------------------------------\n";
        a += "Wheat Field        BW (1)  [1]      #6\n";
        a += "Ranch              BC (1)  [2]      #6\n";
        a += "Forest             BG (3)  [5]      #6\n";
        
        assertThat(m.printMarket(), is(a));
    }
    
    
    @Test
    public void testPrintPlayerOnesTurn() {
        //TODO ???make players array public so can test dynamically?
        String a = "";
        
        
        a = a + "             Player 1* [YOU]              \n";
        a = a + "------------------------------------------\n" +
                "                (3 coins)  \n";
        a += "Wheat Field        BW (1)  [1]      #1\n" +
                "..........................................\n";
        a = a + "City Hall          NT (7)  [ ]\n";
        a = a + "                 Player 2                 \n";
        a = a + "------------------------------------------\n" +
                "                (3 coins)  \n";
        a += "Wheat Field        BW (1)  [1]      #1\n" + 
                "..........................................\n";
        a = a + "City Hall          NT (7)  [ ]\n";
        assertThat(m.printPlayerState(0, players), is(a));
    }
    
    @Test
    public void testPrintPlayerTwosTurn() {
        //TODO ???make players array public so can test dynamically?
        String a = "";
        
        
        a = a + "             Player 1 [YOU]               \n";
        a = a + "------------------------------------------\n" +
                "                (3 coins)  \n";
        a += "Wheat Field        BW (1)  [1]      #1\n" +
                "..........................................\n";
        a = a + "City Hall          NT (7)  [ ]\n";
        a = a + "                 Player 2*                \n";
        a = a + "------------------------------------------\n" +
                "                (3 coins)  \n";
        a += "Wheat Field        BW (1)  [1]      #1\n" + 
                "..........................................\n";
        a = a + "City Hall          NT (7)  [ ]\n";
        
        assertThat(m.printPlayerState(1, players), is(a));
    }

        @Test
        public void testGetCardName() {
                assertThat(m.getCardName(0), is("Wheat Field"));
        }
        @Test
        public void testGetCardIcon() {
                assertThat(m.getCardIcon(0), is("       BW"));
        }

        @Test
        public void testGetCardCost() {
                assertThat(m.getCardCost(1), is(1));
        }
        @Test
        public void testGetAvailableCards() {
                assertThat(m.getAvailableCards(0), is(6));
        }
        @Test
        public void testGetActivation() {
                assertThat(m.getActivation(2), is(5));
        }
    
/*

    @Test
    public void testPurchaseCard() {
        //TODO
    }



   
   
    @Test
    public void testMenuOptions() {
        p1.setTurn(true);
        assertThat(m.menuOptions(), is("1. Wheat Field         BW (1)  [1]      #" + m.getAvailableWheat() + "\n"
                            + "2. Ranch               BC (1)  [2]      #" + m.getAvailableRanch() + "\n"
                            + "3. Forest              BG (3)  [5]      #" + m.getAvailableForest()));
        p1.setTurn(false);
        p2.setTurn(true);
        assertThat(m.menuOptions(), is("1. Wheat Field         BW (1)  [1]      #" + m.getAvailableWheat() + "\n"
                            + "2. Ranch               BC (1)  [2]      #" + m.getAvailableRanch() + "\n"
                            + "3. Forest              BG (3)  [5]      #" + m.getAvailableForest()));
        assertThat(p1.getCoins(), is(3));
    }

    */

}
