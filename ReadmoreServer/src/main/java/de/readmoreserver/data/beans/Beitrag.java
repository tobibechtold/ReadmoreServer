package de.readmoreserver.data.beans;

import java.util.Date;

public class Beitrag {
	
	int id;
	int threadId;
	String inhalt;
	User ersteller;
	Date datum;
	
	public Beitrag() {}
	
	public Beitrag(int id, int threadId, String inhalt, User ersteller,
			Date datum) {
		super();
		this.id = id;
		this.threadId = threadId;
		this.inhalt = inhalt;
		this.ersteller = ersteller;
		this.datum = datum;
	}

	public int getId() {
		return id;
	}

	public int getThreadId() {
		return threadId;
	}

	public String getInhalt() {
		return inhalt;
	}

	public User getErsteller() {
		return ersteller;
	}

	public Date getDatum() {
		return datum;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setThreadId(int threadId) {
		this.threadId = threadId;
	}

	public void setInhalt(String inhalt) {
		this.inhalt = inhalt;
	}

	public void setErsteller(User ersteller) {
		this.ersteller = ersteller;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}
		
}
