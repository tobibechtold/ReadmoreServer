package de.readmoreserver.data.beans;
import java.util.List;


public class RMThread {
	
	String titel;
	int id;
	int forumId;
	int anzahlSeiten;
	User erstelltVon;
	
	public RMThread() {
		
	}

	public RMThread(String titel, int id, User erstelltVon,
			List<Beitrag> beitraege) {
		super();
		this.titel = titel;
		this.id = id;
		this.erstelltVon = erstelltVon;
	}

	public int getAnzahlSeiten() {
		return anzahlSeiten;
	}

	public void setAnzahlSeiten(int anzahlSeiten) {
		this.anzahlSeiten = anzahlSeiten;
	}

	public int getForumId() {
		return forumId;
	}

	public void setForumId(int forumId) {
		this.forumId = forumId;
	}

	public String getTitel() {
		return titel;
	}

	public int getId() {
		return id;
	}

	public User getErstelltVon() {
		return erstelltVon;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setErstelltVon(User erstelltVon) {
		this.erstelltVon = erstelltVon;
	}

	
}
