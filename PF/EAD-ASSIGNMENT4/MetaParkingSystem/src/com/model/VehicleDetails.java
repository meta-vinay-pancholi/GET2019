package com.metaparking.model;
public class VehicleDetails {
	private int id;
	private String vnumber;
	private String type;	

	public VehicleDetails(int id, String vnumber, String type) {
		super();
		this.id = id;
		this.vnumber = vnumber;
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVnumber() {
		return vnumber;
	}

	public void setVnumber(String vnumber) {
		this.vnumber = vnumber;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}


}