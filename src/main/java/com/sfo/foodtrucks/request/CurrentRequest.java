package com.sfo.foodtrucks.request;

import java.util.Calendar;

/**
 * The Object creates the current details of the request
 * like currentDay(numeric), currentHour in 24Hr format, 
 * currentMinutes(numeric)
 */
public class CurrentRequest {
	
	public CurrentRequest() {
		super();
		Calendar calendar = Calendar.getInstance();
		//Fetching calendar Day of week minus 1
		this.currentDay = calendar.get(Calendar.DAY_OF_WEEK) -1;
		this.currentHour = calendar.get(Calendar.HOUR_OF_DAY);
		this.currentMinutes = calendar.get(Calendar.MINUTE);
	}
	
    /**
     * Gives currentDay value as following
     * SUNDAY = 0,MONDAY = 1, TUESDAY = 2, WEDNESDAY = 3, THURSDAY = 4, FRIDAY = 5, SATURDAY = 6
     */
	private int currentDay;
	
	/**
	 * Gives currentHour in 24Hrs format
	 */
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
