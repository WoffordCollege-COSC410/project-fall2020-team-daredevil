package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import org.junit.*;

public class PlayerTest {
	Player p1;
	
	@Before
	public void setup() {
		p1 = new Player();
	}
	
	@Test
	public void testConstructor() {
		assertThat(p1.ecards.length, is(20));
	}
	
	@Test
	public void testAddCard() {
		//assertThat(p1.ecards is longer?)
	}
	
	@Test
	public void testSetPlayerTurn() {
		assertThat(p1.getTurn(), is(false));
		p1.setTurn(true);
		assertThat(p1.getTurn(), is(true));
	}
	
	@Test
	public void testGetCoins() {
		assertThat(p1.getCoins(), is(3));
	}
	
	
	@Test
	public void testHasCityHall() {
		assertThat(p1.hasCityHall(), is(false));
	}
	
	@Test
	public void testGetPlayerStatus() {
		//assertThat(p1.ecards is longer?)
	}
//	public static void main(String[] args) {
//		
//	}
}