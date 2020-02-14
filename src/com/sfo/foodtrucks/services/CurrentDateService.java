package com.sfo.foodtrucks.services;

/***
 * interface is responsible for shareing the current date related info as per our needs
 *
 */

public interface CurrentDateService {
	/**
	 * This method computes current time of the system and fetch current day
	 * ex: Monday or Tuesday ... etc
	 * @return string 
	 */
	public String currentDay();
	
	/**
	 * This method returns the current Hours and Minutes time of the system in 24hr format
	 *  ex: 06:00, 22:33 ... etc
	 * @return string  
	 */
	public String currentHHMMIn24();

}
