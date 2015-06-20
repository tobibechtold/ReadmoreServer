package de.readmoreserver.data.parser;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import de.readmoreserver.data.beans.Beitrag;
import de.readmoreserver.data.beans.User;

public class BeitragParser {
	
	public List<Beitrag> getBeitraege(int forenId, int kategorieId, int threadId, int seite) {
		
		List<Beitrag> beitraege = new ArrayList<Beitrag>();
		Document doc = null;
		Document doc2 = null;
		
		try {
			doc = Jsoup.connect("http://www.readmore.de/forums/" 
								+ kategorieId + "/" 
								+ forenId + "/" 
								+ threadId).get();
			
			String text2 = doc.baseUri();
			
			String url = text2 + "&page=" + seite;
			
			doc2 = Jsoup.connect(url).get();
			
			
			Elements e = doc2.getElementsByClass("post");
			for(Element element : e) {
				
				Beitrag b = new Beitrag();
				Elements post = element.getElementsByTag("textarea");
				String text = post.get(0).text();
				b.setInhalt(text);
				beitraege.add(b);
			}
			
			Elements infos = doc2.getElementsByClass("info");
			int infoCount = 0;
			for(Element info : infos) {
				
				Elements users = info.getElementsByClass("user");
				Elements link = users.get(0).getElementsByTag("a");
				Element element = link.get(0);
				String userLink = element.attr("href");
				String userName = element.attr("title");
				
				Elements avatarInfo = info.getElementsByClass("avatar");
				Elements avatar = avatarInfo.get(0).getElementsByTag("a");
				Elements img = avatar.get(0).getElementsByTag("img");
				String avatarURL = img.get(0).attr("src");
				
				User u = new User();
				u.setAnzeigename(userName);
				u.setId(getUserId(userLink));
				u.setAvatar(avatarURL);
				
				beitraege.get(infoCount).setErsteller(u);
				infoCount++;				
			}
			
			Elements head = doc2.getElementsByClass("head");
			int headInfoCount = 0;
			for(Element headInfo : head) {
				
				String info = headInfo.text();
				String[] splittedInfos = info.split(" ");
				String beitragNummer = splittedInfos[0];
				String datum = splittedInfos[1].split(",")[0];
				String uhrzeit = splittedInfos[2];
				
				beitraege.get(headInfoCount).setBeitragNummer(beitragNummer);
				beitraege.get(headInfoCount).setTag(datum);
				beitraege.get(headInfoCount).setUhrzeit(uhrzeit);
				
				headInfoCount++;
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return beitraege;
	}
	
	public int getUserId(String link) {
		
		String id = link.split("http://www.readmore.de/users/")[1].split("-")[0];
		System.out.println(id);
		int intId = Integer.parseInt(id);
		return intId;
	}

}
