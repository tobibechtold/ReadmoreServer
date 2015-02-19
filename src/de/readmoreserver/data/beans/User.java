package de.readmoreserver.data.beans;

import java.util.Date;

public class User {
	
	int id;
	String anzeigename;
	String email;
	String passwort; //TODO gehashtes passwort
	RMStatus status;
	String name;
	int alter;
	Date registriertSeit;
	
	public User() {}

	public User(int id, String anzeigename, String email, String passwort,
			RMStatus status, String name, int alter, Date registriertSeit) {
		super();
		this.id = id;
		this.anzeigename = anzeigename;
		this.email = email;
		this.passwort = passwort;
		this.status = status;
		this.name = name;
		this.alter = alter;
		this.registriertSeit = registriertSeit;
	}

	public int getId() {
		return id;
	}

	public String getAnzeigename() {
		return anzeigename;
	}

	public String getEmail() {
		return email;
	}

	public String getPasswort() {
		return passwort;
	}

	public RMStatus getStatus() {
		return status;
	}

	public String getName() {
		return name;
	}

	public int getAlter() {
		return alter;
	}

	public Date getRegistriertSeit() {
		return registriertSeit;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setAnzeigename(String anzeigename) {
		this.anzeigename = anzeigename;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public void setStatus(RMStatus status) {
		this.status = status;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAlter(int alter) {
		this.alter = alter;
	}

	public void setRegistriertSeit(Date registriertSeit) {
		this.registriertSeit = registriertSeit;
	}
	
	

}
