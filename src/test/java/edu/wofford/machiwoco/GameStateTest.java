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
    }

    @Test
    public void testGetCurrentPlayer() {
        assertThat(m.getCurrentPlayer(), is(false));
    }
   
    @Test
    public void testPrintMarketState() {
    }
}
