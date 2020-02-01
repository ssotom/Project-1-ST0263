package com.ssotom.response;

public class DataSerie {
	private Float value;
	private String name;
	
	public DataSerie(Float value, String name) {
		super();
		this.value = value;
		this.name = name;
	}
	
	public Float getValue() {
		return value;
	}
	
	public void setValue(Float value) {
		this.value = value;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
