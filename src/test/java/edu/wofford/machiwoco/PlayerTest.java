package edu.wofford.machiwoco;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.*;

public class PlayerTest {

	Player p;
	private Player p1 = new Player();
    private Player p2 = new Player();
    private Player[] players;

@Before
public void setup() {
	p = new Player();
	players = new Player[] {p1, p2};
}

@Test
public void testgetPCards() {
	assertThat(p.getPCards(1), is(0));
}

@Test
public void testsetPCards() {
	p.setPCards(1);
	assertThat(p.getPCards(0), is(1));
}

@Test
public void testgetCoins() {
	assertThat(p.getCoins(), is(3));
}

@Test
public void testsetCoins() {
	assertThat(p.getCoins(), is(3));
	p.setCoins(1);
	assertThat(p.getCoins(), is(4));
}

@Test
public void testCardActivation1() {
	String a = "";

	a = a + "Wheat Field activated for Player 1\n" + 
		"Wheat Field activated for Player 2\n";

	assertThat(p.cardActivation(1, players), is(a));
}

/*
@Test
public void testCardActivation2() {
	String b = "";

	b = b + "Ranch activated for Player 1\n";

	assertThat(p.cardActivation(2, players), is(b));
}


@Test
public void testCardActivation3() {
	String c = "";

	c = c + "Ranch activated for Player 2\n";

	assertThat(p.cardActivation(2, players), is(c));
}
*/



	/*
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
		p1.addCard("w");
		assertThat(p1.getNumWheat(), is(2));
		p1.addCard("W");
		assertThat(p1.getNumWheat(), is(3));
		
		p1.addCard("r");
		assertThat(p1.getNumRanch(), is(1));
		p1.addCard("R");
		assertThat(p1.getNumRanch(), is(2));
		
		p1.addCard("f");
		assertThat(p1.getNumForest(), is(1));
		p1.addCard("F");
		assertThat(p1.getNumForest(), is(2));
		
		p1.addCard("c");
		assertThat(p1.hasCityHall(), is(false));
		p1.addCard("city");
		assertThat(p1.hasCityHall(), is(true));
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

	*/

}