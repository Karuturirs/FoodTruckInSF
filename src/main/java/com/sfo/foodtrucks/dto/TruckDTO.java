package com.sfo.foodtrucks.dto;

/*
 * TruckEntity holds the data name and location related 
 * to the current available truck and has implementation to sort on the name 
 */
public class TruckDto implements Comparable<TruckDto>{
	
	private String name;
	private String address;
	
	public TruckDto(String name, String address) {
		super();
		this.name = name;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Override
	public int compareTo(TruckDto t) {
		return this.name.compareTo(t.getName());
	}
	@Override
	public String toString() {
		return  name + " " + address;
	}
	
	
	
}
