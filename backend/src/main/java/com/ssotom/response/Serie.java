package com.ssotom.response;

import java.util.LinkedList;
import java.util.List;

public class Serie {
	
	private String name;
	private List<DataSerie> series;
	
	public Serie(String name) {
		this.name = name;
		series = new LinkedList<DataSerie>();
	}
	
	public void add(DataSerie data) {
		series.add(data);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<DataSerie> getSeries() {
		return series;
	}

	public void setSerie(List<DataSerie> series) {
		this.series = series;
	}

}
