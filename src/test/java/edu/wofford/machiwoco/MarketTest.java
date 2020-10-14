package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import org.junit.*;

public class MarketTest {
    private Market m;
	
	@Before
	public void setup() {
		m = new Market();
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

}
