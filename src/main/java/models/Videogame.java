package models;

import java.sql.Date;

public class Videogame {
	private int id;
	private String name;
	private Date launch;
	private String PEGI;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getLaunch() {
		return launch;
	}

	public void setLaunch(Date launch) {
		this.launch = launch;
	}

	public String getPEGI() {
		return PEGI;
	}

	public void setPEGI(String pEGI) {
		PEGI = pEGI;
	}
}
