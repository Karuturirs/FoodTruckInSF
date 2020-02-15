package com.sfo.foodtrucks;

import java.util.List;

import com.sfo.foodtrucks.business.FoodTrucksBusinessFacade;
import com.sfo.foodtrucks.entity.TruckEntity;
import com.sfo.foodtrucks.request.CurrentRequest;

/**
 * This FoodTruckFinder helps to find the current food trucks in SF 
 *     with following conditions
 *     a) NAME ADDRESS (Sorted alphabetically by name).
 *     b) Max 10 results on go, Displays next 10 results when user inputs Enter key.
 *     
 *
 */
public class FoodTruckFinder{

	public static void main(String[] args) {
		
		//Get current time and day request 
	    CurrentRequest currentRequest = new CurrentRequest();
	    currentRequest.setCurrentHour(11);
	    currentRequest.setCurrentDay(4);
	    //Fetch All the Available Trucks
	    FoodTrucksBusinessFacade foodTrucksBusinessFacade = new FoodTrucksBusinessFacade();
		List<TruckEntity> availableFTList = foodTrucksBusinessFacade.getCurrentlyRunningFoodTrucks(currentRequest);
		
		//View creation for the Available Trucks 
		foodTrucksBusinessFacade.displayFoodTrucks(availableFTList);
		
		 
	}
	
	

}