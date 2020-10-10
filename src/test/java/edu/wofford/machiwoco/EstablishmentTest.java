package edu.wofford.machiwoco; //change to class file

import org.junit.*;
//import static org.hamcrest.MatchersAssert.*;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;


public class EstablishmentTest {
	
	private Establishment e;
	
	@Before
	public void setup() {
		e = new Establishment("Wheat Field", 1, "blue", "wheat");
	}
	
	@Test
	public void testConstructor() {
		//assertThat('N', is(e.effectModifier));
		//assertThat(Establishment.W.color(), is(Establishment.Color.Blue));
	}
	
	@Test
	public void testGetName() {
		assertThat(e.getName(), is("Wheat Field"));
	}
	
	@Test
	public void testGetCost() {
		assertThat(e.getCost(), is(1));
	}
	
	@Test
	public void testGetColor() {
		assertThat(e.getColor(), is("blue"));
	}
	
	@Test
	public void testGetIcon() {
		assertThat(e.getIcon(), is("wheat"));
	}
	@Test
	public void testGetIcon() {
		assertThat(e.getActivation(), is(""));
	}
}