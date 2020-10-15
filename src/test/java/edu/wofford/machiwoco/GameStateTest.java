package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import org.junit.*;

public class GameStateTest {
    private GameState m;
	
	@Before
	public void setup() {
		m = new GameState();
    }
    
    @Test
    public void testGetNumWheatfields() {
        assertThat(m.getNumWheatFields(), is(6));
    }

    @Test
    public void testGetNumRanches() {
        assertThat(m.getNumRanches(), is(6));
    }

    @Test
    public void testGetNumForrests() {
        assertThat(m.getNumForrests(), is(6));
    }

    @Test
    public void testIsActivated() {
        assertThat(m.isActivated(0), is(false));
    }

    @Test
    public void testPrintMarketState() {
        assertThat(m.printMarketState(), is("******************************************"));
    }
}
