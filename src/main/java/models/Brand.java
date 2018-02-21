package models;

import java.sql.Date;

public class Brand {
	private int id;
	private String name;
	private Date constitution;

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

	public Date getConstitution() {
		return constitution;
	}

	public void setConstitution(Date constitution) {
		this.constitution = constitution;
	}
}
