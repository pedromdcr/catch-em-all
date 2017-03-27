package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.premiumminds.challenge.Coordinate;
import com.premiumminds.challenge.Player;

public class PlayerTest {

	@Before
	public void setUp() throws Exception {
		
	}

	@Test
	public void testCatchPokemon() {
		
		Player ash = new Player();
		Coordinate location = new Coordinate(3, 3);
		
		ash.catchPokemon(location);
		assertTrue(ash.getVisitedLocations().containsKey("3;3"));
		assertTrue(ash.getVisitedLocations().get("3;3"));
		assertEquals(2, ash.getNumPokemon());
		
	}
	
	@Test
	public void testIsVisitingOldLocation() {
		
		Player ash = new Player();
		
		Coordinate location = new Coordinate(1, 1);
		assertFalse(ash.isVisitingOldLocation(location));
		
		Coordinate location2 = new Coordinate(3256, 2345);
		ash.getVisitedLocations().put("3256;2345", true);
		assertTrue(ash.isVisitingOldLocation(location2));
		
	}

}