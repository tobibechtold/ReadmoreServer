package de.readmoreserver.data.parser.test;

import org.junit.Before;
import org.junit.Test;

import de.readmoreserver.data.beans.Beitrag;
import de.readmoreserver.data.parser.BeitragParser;
import de.readmoreserver.data.parser.ForenParser;
import de.readmoreserver.data.parser.ThreadParser;

public class ForenParserTest {
	
	ForenParser parser;
	ThreadParser tparser;
	BeitragParser bparser;

	@Before
	public void setUp() throws Exception {
		parser = new ForenParser();
		tparser = new ThreadParser();
		bparser = new BeitragParser();
	}

	@Test
	public void testGetAllForen() {

//		for(Forum f : parser.getForen()) {
//			System.out.println(f.getId() + " " + f.getTitel());
//		}
//		
//		for(RMThread t : tparser.getThreads(10, 91)) {
//			System.out.println(t.getId() + " " + t.getTitel() + " Seiten: " + t.getAnzahlSeiten());
//		}
		
		for(Beitrag b : bparser.getBeitraege(10, 91, 138496, 1)) {
			System.out.println(b.getErsteller().getAnzeigename() + "(" + b.getErsteller().getAvatar() + ")" + " : " + b.getInhalt());
		}
	}
	
	@Test
	public void testGetForenId() {
	}

}
