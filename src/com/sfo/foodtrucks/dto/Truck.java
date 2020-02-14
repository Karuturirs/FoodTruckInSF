package com.sfo.foodtrucks.dto;

public class Truck implements Comparable<Truck>{
	
	private String dayorder;
	private String dayofweekstr;
	private String starttime;
	private String endtime;
	private String location;
	private String start24;
	private String end24;
	private String applicant;
	
	
	public Truck(String dayorder, String dayofweekstr, String starttime, String endtime, String location,
			String start24, String end24, String applicant) {
		super();
		this.dayorder = dayorder;
		this.dayofweekstr = dayofweekstr;
		this.starttime = starttime;
		this.endtime = endtime;
		this.location = location;
		this.start24 = start24;
		this.end24 = end24;
		this.applicant = applicant;
	}
	public String getDayorder() {
		return dayorder;
	}
	public void setDayorder(String dayorder) {
		this.dayorder = dayorder;
	}
	public String getDayofweekstr() {
		return dayofweekstr;
	}
	public void setDayofweekstr(String dayofweekstr) {
		this.dayofweekstr = dayofweekstr;
	}
	public String getStarttime() {
		return starttime;
	}
	public void setStarttime(String starttime) {
		this.starttime = starttime;
	}
	public String getEndtime() {
		return endtime;
	}
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStart24() {
		return start24;
	}
	public void setStart24(String start24) {
		this.start24 = start24;
	}
	public String getEnd24() {
		return end24;
	}
	public void setEnd24(String end24) {
		this.end24 = end24;
	}
	public String getApplicant() {
		return applicant;
	}
	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}
	

	@Override
	public int compareTo(Truck o) {
		
		return this.applicant.compareTo(o.getApplicant());
	}
	@Override
	public String toString() {
		return "Truck [dayorder=" + dayorder + ", dayofweekstr=" + dayofweekstr + ", starttime=" + starttime
				+ ", endtime=" + endtime + ", location=" + location + ", start24=" + start24 + ", end24=" + end24
				+ ", applicant=" + applicant + "]";
	}
	
	
	

}
