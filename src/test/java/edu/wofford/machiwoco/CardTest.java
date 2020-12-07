package edu.wofford.machiwoco; //change to class file

import org.junit.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;


public class CardTest {
	
	private Card c;
	
	@Before
	public void setup() {
		c = new Card("Wheat Field", 1, "blue", "wheat");
	}
	
	@Test
	public void testConstructor() {
		//assertThat('N', is(c.effectModifier));
		//assertThat(Establishment.W.color(), is(Establishment.Color.Blue));
	}
	
	@Test
	public void testGetName() {
		assertThat(c.getName(), is("Wheat Field"));
	}
	
	@Test
	public void testGetCost() {
		assertThat(c.getCost(), is(1));
	}
	
	@Test
	public void testGetColor() {
		assertThat(c.getColor(), is("blue"));
	}
	
	@Test
	public void testGetIcon() {
		assertThat(c.getIcon(), is("wheat"));
	}
	
	@Test
	public void testSetActivation() {
		c.setActivation(1);
		assertThat(c.getActivation(), is(1));
	}

	@Test
	public void testSetName() {
		c.setName("Wheat Field");
		assertThat(c.getName(), is("Wheat Field"));
	}

	@Test
	public void testSetCost() {
		c.setCost(0);
		assertThat(c.getCost(), is(0));
	}

	@Test
	public void testSetColor() {
		c.setColor("blue");
		assertThat(c.getColor(), is("blue"));
	}

}