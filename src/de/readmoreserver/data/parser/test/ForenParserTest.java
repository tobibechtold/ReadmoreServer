package de.readmoreserver.data.parser.test;


import org.junit.*;
import de.readmoreserver.data.beans.Forum;
import de.readmoreserver.data.beans.RMThread;
import de.readmoreserver.data.parser.ForenParser;
import de.readmoreserver.data.parser.ThreadParser;

public class ForenParserTest {
	
	ForenParser parser;
	ThreadParser tparser;

	@Before
	public void setUp() throws Exception {
		parser = new ForenParser();
		tparser = new ThreadParser();
	}

	@Test
	public void testGetAllForen() {

		for(Forum f : parser.getForen()) {
			System.out.println(f.getId() + " " + f.getTitel());
		}
		
		for(RMThread t : tparser.getThreads(10, 91)) {
			System.out.println(t.getId() + " " + t.getTitel() + " Seiten: " + t.getAnzahlSeiten());
		}
	}
	
	@Test
	public void testGetForenId() {
	}

}
