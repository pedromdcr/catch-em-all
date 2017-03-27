package test;

import static org.junit.Assert.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.Before;
import org.junit.Test;

import com.premiumminds.challenge.CatchEmAll;
import com.premiumminds.challenge.InvalidDirectionException;
import com.premiumminds.challenge.Player;

public class CatchEmAllTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMain() {
			
		String path1 = "EONSOENSESESENOSNESSONESONESOOONSNEENNNES";
		String path2 = "ESESESESESOOOOOOOOO";
		String path3 = "";
		
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		ByteArrayInputStream in = new ByteArrayInputStream(path1.getBytes());
		System.setIn(in);
		CatchEmAll.main(null);
		assertTrue("19".equals(out.toString()));
		
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		in = new ByteArrayInputStream(path2.getBytes());
		System.setIn(in);
		CatchEmAll.main(null);
		assertEquals("20".toString(), out.toString());
		
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
		in = new ByteArrayInputStream(path3.getBytes());
		System.setIn(in);
		CatchEmAll.main(null);
		assertEquals("1", out.toString());

		// Reset System.in and System.out to their originals
		System.setIn(System.in);
		System.setOut(System.out);
	}

	@Test
	public void testCheckTrainerMap() {
		
		CatchEmAll adventure = new CatchEmAll();
		
		String path1 = "EONSOENSESESENOSNESSONESONESOOONSNEENNNES";
		String path2 = "ESESESESESOOOOOOOOO";
		String path3 = "";
		
		ByteArrayInputStream in = new ByteArrayInputStream(path1.getBytes());
		System.setIn(in);
		char[] steps = adventure.checkTrainerMap();
		assertArrayEquals(path1.toCharArray(), steps);

		in = new ByteArrayInputStream(path2.getBytes());
		System.setIn(in);
		steps = adventure.checkTrainerMap();
		assertArrayEquals(path2.toCharArray(), steps);

		in = new ByteArrayInputStream(path3.getBytes());
		System.setIn(in);
		steps = adventure.checkTrainerMap();
		assertArrayEquals(null, steps);
		
		// Reset System.in to its original
		System.setIn(System.in);
		
	}

	@Test
	public void testExploreWorld() {
		
		CatchEmAll adventure = new CatchEmAll();
		Player player1 = new Player();
		Player player2 = new Player();
		Player player3 = new Player();
		Player player4 = new Player();
		
		String path1 = "EONSOENSESESENOSNESSONESONESOOONSNEENNNES";
		String path2 = "ESESESESESOOOOOOOOO";
		String path3 = "";
		String path4 = "qwErty123";
		
		adventure.exploreWorld(player1, path1.toCharArray());
		assertEquals(3, player1.getPosition().getX());
		assertEquals(0, player1.getPosition().getY());
		
		adventure.exploreWorld(player2, path2.toCharArray());
		assertEquals(-4, player2.getPosition().getX());
		assertEquals(-5, player2.getPosition().getY());
		
		adventure.exploreWorld(player3, path3.toCharArray());
		assertEquals(0, player3.getPosition().getX());
		assertEquals(0, player3.getPosition().getY());
		
		try {
			adventure.exploreWorld(player4, path4.toCharArray());
		    fail( "Method should've thrown an InvalidDirectionException but didn't");
		} catch (InvalidDirectionException e) {
			
		}
				
	}

}
