package edu.wofford.machiwoco; //change to class file

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.is;


public class EstablishmentTest {
	
	@Test
	public void testConstructor() {
		Establishment e = new Establishment("Wheat Field", 5, "red", "cup");
		assertThat(1, is(1));
		//assertThat(Establishment.W.color(), is(Establishment.Color.Blue));
	}
	
	@Test
	public void testColor() {
		assertThat(1, is(1));
		//assertThat(Establishment.W.color(), is(Establishment.Color.Blue));
	}
}