package com.w3bsurf.maven.serialization;

public class TestData implements java.io.Serializable {
	public String title;
	public String type;
	public int id;
	public double number;
	
	public TestData(String title, String type, int id, double number) {
		this.title = title;
		this.type = type;
		this.id = id;
		this.number = number;
	}

	public double testMethod() {
		number++;
		System.out.println(title + ", id: " + id + ".");
		return number;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void SetTitle(String new_title) {
		title = new_title;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String new_type) {
		type = new_type;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int new_id) {
		id = new_id;
	}
	
	public double getNumber() {
		return number;
	}
	
	public void setNumber(double new_number) {
		number = new_number;
	}
}
