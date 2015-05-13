package de.readmoreserver.data.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import de.readmoreserver.data.beans.Forum;
import de.readmoreserver.data.pool.ForenPool;

public class ForenParser {
	
	public List<Forum> getForen() {
		
		ArrayList<Forum> forenListe = new ArrayList<Forum>();
		
		try {
			Document doc = Jsoup.connect("http://www.readmore.de/forums/").get();
			Elements e = doc.getElementsByClass("forum_forums");
			for (Element element : e) {
				Elements foren = element.getElementsByTag("tr");
				System.out.println(foren.get(0).children().size());
				for(Element forum : foren) {
					if(forum.children().size() > 4) {
						
						Elements attribute = forum.children();
						Forum f = new Forum();
						Elements linkTitel = attribute.get(1).getElementsByTag("a");
						
						f.setTitel(linkTitel.text());
						f.setBeschreibung(attribute.get(1).getElementsByClass("second_row").text());
						f.setIdKategorie(getKategorieId(linkTitel));
						f.setId(getForenId(linkTitel));
						
						forenListe.add(f);
						ForenPool.addForum(f);
					}
				}
			}
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		
		return forenListe;
	}

	private int getKategorieId(Elements linkTitel) {

		String forenLink = linkTitel.attr("href");
		String splitLink = forenLink.split("http://www.readmore.de/forums/")[1];
		String forenString = splitLink.split("/")[0];
		String forenId = forenString.split("-")[0];
		
		return Integer.parseInt(forenId);
	}

	private int getForenId(Elements linkTitel) {
		String forenLink = linkTitel.attr("href");
		String splitLink = forenLink.split("http://www.readmore.de/forums/")[1];
		String forenString = splitLink.split("/")[1];
		String forenId = forenString.split("-")[0];
		
		return Integer.parseInt(forenId);
	}

}
