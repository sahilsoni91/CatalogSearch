package com.catalog.search.entities;

import java.util.List;

public class Filter {

	private List<String> type;
	private List<String> name;
	private List<String> color;
	private List<Integer> size;
	private List<String> brand;
	private Double minValue;
	private Double maxValue;
	
	public Filter() {
		super();
	}
	
	public List<String> getType() {
		return type;
	}

	public void setTypes(List<String> type) {
		this.type = type;
	}

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}

	public List<String> getColor() {
		return color;
	}

	public void setColor(List<String> color) {
		this.color = color;
	}

	public List<Integer> getSize() {
		return size;
	}

	public void setSize(List<Integer> size) {
		this.size = size;
	}

	public List<String> getBrand() {
		return brand;
	}

	public void setBrand(List<String> brand) {
		this.brand = brand;
	}

	public Double getMinValue() {
		return minValue;
	}
	
	public void setMinValue(Double minValue) {
		this.minValue = minValue;
	}
	
	public Double getMaxValue() {
		return maxValue;
	}
	
	public void setMaxValue(Double maxValue) {
		this.maxValue = maxValue;
	}
}
