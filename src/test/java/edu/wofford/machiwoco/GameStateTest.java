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
    public void testGetAvailableWheat() {
        assertThat(m.getAvailableWheat(), is(6));
    }

    @Test
    public void testGetAvailableRanch() {
        assertThat(m.getAvailableRanch(), is(6));
    }

    @Test
    public void testGetAvailableForrest() {
        assertThat(m.getAvailableForrest(), is(6));
    }

    @Test
    public void testIsActivated() {
        assertThat(m.isActivated(0), is(false));
    }

    @Test
    public void testPrintMarketState() {
    }
}
