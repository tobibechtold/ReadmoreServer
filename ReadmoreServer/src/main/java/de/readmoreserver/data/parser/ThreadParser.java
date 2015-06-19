package de.readmoreserver.data.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import de.readmoreserver.data.beans.RMThread;

public class ThreadParser {
	
	public List<RMThread> getThreads(int forenId, int kategorieId) {
		
		List<RMThread> threads = new ArrayList<RMThread>();
		Document doc = null;
		try {
			doc = Jsoup.connect("http://www.readmore.de/forums/" + kategorieId + "/" + forenId).get();
			Elements e = doc.getElementsByClass("forum_threads");
			for(Element element : e) {
				Elements rows = element.getElementsByTag("tr");
				for (Element row : rows) {
					Elements children = row.children();
					RMThread thread = new RMThread();
					for (Element tr : children)  {
						Elements childChildren = tr.children();
						for(Element a : childChildren) {
							
							if(a.tagName().equals("a")) {
								if(childChildren.size() > 3) {
									
									String anzahlBeitraege = children.get(children.size() - 2).text().split(" ")[0];
									String anzahl = anzahlBeitraege.replace(".", "");
									thread.setAnzahlBeitraege(Integer.parseInt(anzahl));
									Element letzterBeitrag = children.get(children.size() - 1);
									String user = letzterBeitrag.getElementsByTag("a").get(0).text();
									String uhrzeit = letzterBeitrag.getElementsByTag("span").get(0).text();
									thread.setLetzterBeitrag(user);
									thread.setLetzterBeitragDatum(uhrzeit);
									String[] s = a.text().split(" Erstellt von ");
									thread.setTitel(s[0]);
									thread.setForumId(forenId);
									String link = a.attr("href");
									thread.setId(getThreadId(link));
								}
								
							}
							if(a.tagName().equals("span") && a.className().equals("second_row") && !a.text().contains("Uhr")) {
								Elements seiten = a.children();
								
								if(seiten.size() > 0) {	
									
									Element seite = seiten.get(seiten.size() - 1);
									thread.setAnzahlSeiten(Integer.parseInt(seite.text()));
								}
							}
							
						}
					}
					threads.add(thread);
				}
			}
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		return threads;
	}

	private int getThreadId(String link) {

		String s = link.split("http://www.readmore.de/forums/")[1];
		String s2 = s.split("/")[2];
		String id = s2.split("-")[0];
		
		return Integer.parseInt(id);
	}

}
