package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;

public class PlayerTest {
	Player p1;
	
	@Before
	public void setup() {
		p1 = new Player();
	}
	
	@Test
	public void testConstructor() {
		//assertThat(p1.ecards.length, is(20));
	}
	
	@Test 
	public void testGetNumWheat() {
		assertThat(p1.getNumWheat(), is(1));
	}
	
	@Test 
	public void testGetNumRanch() {
		assertThat(p1.getNumRanch(), is(0));
	}
	
	@Test 
	public void testGetNumForest() {
		assertThat(p1.getNumForest(), is(0));
	}
	
	@Test
	public void testAddCard() {
		p1.addCard("r");
		assertThat(p1.getNumRanch(), is(1));
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
	public void testAddCoins() {
		assertThat(p1.getCoins(), is(3));
		p1.addCoins(1);
		assertThat(p1.getCoins(), is(4));
	}
	@Test
	public void testRemoveCoins() {
		assertThat(p1.getCoins(), is(3));
		p1.removeCoins(1);
		assertThat(p1.getCoins(), is(2));
	}


//	public static void main(String[] args) {
//		
//	}
}