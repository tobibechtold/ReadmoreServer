package de.readmoreserver.data.beans;

import java.util.Date;

public class Beitrag {
	
	int id;
	int threadId;
	String inhalt;
	User ersteller;
	String tag;
	String uhrzeit;
	String beitragNummer;

	public String getBeitragNummer() {
		return beitragNummer;
	}

	public void setBeitragNummer(String beitragNummer) {
		this.beitragNummer = beitragNummer;
	}

	public String getTag() {
		return tag;
	}

	public String getUhrzeit() {
		return uhrzeit;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public void setUhrzeit(String uhrzeit) {
		this.uhrzeit = uhrzeit;
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


}
