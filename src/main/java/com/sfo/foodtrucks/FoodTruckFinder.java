package com.sfo.foodtrucks;

import java.util.List;

import com.sfo.foodtrucks.business.FoodTrucksBusinessFacade;
import com.sfo.foodtrucks.dto.TruckDto;
import com.sfo.foodtrucks.request.CurrentRequest;

/**
 * This FoodTruckFinder helps to find the current food trucks in SF 
 *     with following features
 *     a) Displaying NAME ADDRESS (Sorted alphabetically by name) of truck.
 *     b) Max 10 results on go, Displays next 10 results when user inputs Enter key.
 *     
 *
 */
public class FoodTruckFinder{

	public static void main(String[] args) {
		
		//Get current time and day request 
	    CurrentRequest currentRequest = new CurrentRequest();

	    //Fetch All the Available Trucks
	    FoodTrucksBusinessFacade foodTrucksBusinessFacade = new FoodTrucksBusinessFacade();
		List<TruckDto> availableFTList = foodTrucksBusinessFacade.getCurrentlyRunningFoodTrucks(currentRequest);
		
		//Pagination max record on each page
		int maxRecords =10;
		
		//View creation for the Available Trucks with given Max records to show
		foodTrucksBusinessFacade.displayFoodTrucks(availableFTList, maxRecords);
		
		System.out.println("\n-------------Thank You----------");
	}
	
	

}