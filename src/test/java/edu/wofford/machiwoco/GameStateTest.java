package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import org.junit.*;

public class GameStateTest {
    private GameState m;
    private Player p1 = new Player();
    private Player p2 = new Player();


	@Before
	public void setup() {
		m = new GameState(p1, p2);
    }
    
    @Test
    public void testGetAvailableWheat() {
        assertThat(m.getAvailableWheat(), is(6));
    }

    @Test
    public void testGetAvailableRanch() {
        assertThat(m.getAvailableRanch(), is(6));
    }

    @Test
    public void testGetAvailableForest() {
        assertThat(m.getAvailableForest(), is(6));
    }

    @Test
    public void testIsActivated() {
        assertThat(m.isActivated(0), is(false));
        assertThat(m.isActivated(1), is(true));
        assertThat(m.isActivated(2), is(true));
        assertThat(m.isActivated(5), is(true));
    }

    @Test
    public void testGetCurrentPlayer() {
        assertThat(m.getCurrentPlayer(), is(false));
        p1.setTurn(true);
        assertThat(m.getCurrentPlayer(), is(true));
    }

    @Test
    public void testPurchaseCard() {
        //TODO
    }

    @Test
    public void testPrintMarketState() {
        //TODO
    }

    @Test
    public void testPrintPlayerOneState() {
        //TODO
    }

    @Test
    public void testPrintPlayerTwoState() {
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
}
