package de.readmoreserver.data.beans;
import java.util.List;


public class RMThread {
	
	String titel;
	int id;
	int forumId;
	int anzahlSeiten;
	User erstelltVon;
	int anzahlBeitraege;
	String letzterBeitrag;
	String letzterBeitragDatum;
	
	public RMThread() {
		
	}

	public RMThread(String titel, int id, User erstelltVon,
			List<Beitrag> beitraege) {
		super();
		this.titel = titel;
		this.id = id;
		this.erstelltVon = erstelltVon;
	}

	public int getAnzahlBeitraege() {
		return anzahlBeitraege;
	}

	public String getLetzterBeitrag() {
		return letzterBeitrag;
	}

	public String getLetzterBeitragDatum() {
		return letzterBeitragDatum;
	}

	public void setAnzahlBeitraege(int anzahlBeitraege) {
		this.anzahlBeitraege = anzahlBeitraege;
	}

	public void setLetzterBeitrag(String letzterBeitrag) {
		this.letzterBeitrag = letzterBeitrag;
	}

	public void setLetzterBeitragDatum(String letzterBeitragDatum) {
		this.letzterBeitragDatum = letzterBeitragDatum;
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
