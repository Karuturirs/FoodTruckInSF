package com.sfo.foodtrucks.request;

import java.util.Calendar;

public class CurrentTimeRequest {
	
	
	
	public CurrentTimeRequest() {
		super();
		Calendar calendar = Calendar.getInstance();
		this.currentDay = calendar.get(Calendar.DAY_OF_WEEK) -1;
		this.currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		this.currentMinutes = calendar.get(Calendar.MINUTE);
		System.out.println(this.currentHour+":"+this.currentMinutes);
	}

	private int currentDay;
	
	private int currentHour;
	
	private int currentMinutes;

	public int getCurrentDay() {
		return currentDay;
	}

	public void setCurrentDay(int currentDay) {
		this.currentDay = currentDay;
	}

	public int getCurrentHour() {
		return currentHour;
	}

	public void setCurrentHour(int currentHour) {
		this.currentHour = currentHour;
	}

	public int getCurrentMinutes() {
		return currentMinutes;
	}

	public void setCurrentMinutes(int currentMinutes) {
		this.currentMinutes = currentMinutes;
	}
	
	

}
