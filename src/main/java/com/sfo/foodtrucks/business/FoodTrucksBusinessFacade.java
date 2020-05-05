package com.sfo.foodtrucks.business;

import java.util.List;
import java.util.Scanner;

import com.sfo.foodtrucks.dto.TruckDto;
import com.sfo.foodtrucks.request.CurrentRequest;
import com.sfo.foodtrucks.services.SocrataServices;
import com.sfo.foodtrucks.services.impl.SocrataServicesImpl;


/**
 * This class is used for all the Business validation and
 *  Orchestrator of all the stuff need to find the FoodTrucks 
 *  around Me.
 */
public class FoodTrucksBusinessFacade {
	
	/**
	 * Method that gives the list of all current running
	 * trucks ordered by name for given day and time requested
	 * @param currentRequest
	 * @return List of trucks
	 */
	public List<TruckDto> getCurrentlyRunningFoodTrucks(CurrentRequest currentRequest){
		SocrataServices socrataServices = new SocrataServicesImpl();
		
		return socrataServices.getCurrentFootTruckFilteredByDayOrderedByName(currentRequest);
		
	}
	
	
	/**
	 * A method to process all the truckDto data with pagination of max records per each view,
	 * On user clicking enter will display next 10 TruckEnity 
	 * @param availableFTList
	 * @param maxRecordsToshow
	 */
	public void displayFoodTrucks(List<TruckDto> availableFTList, int maxRecordsToshow) {
		int truckCount=0;
		//Read user input
		Scanner input = new Scanner(System.in);
		System.out.println("NAME ADDRESS");
		for (TruckDto truck : availableFTList) {
			//Pagination max records and default to 1st page data
			if((truckCount!=0) && (truckCount%maxRecordsToshow == 0)){
				System.out.println("\nThere are still "+(availableFTList.size()-truckCount)+" trucks avaliable, Continue?[y/n] ");
				String continuity =  input.nextLine();
				if(continuity.equalsIgnoreCase("n")){
					input.close();	
					return;
				}
			}
			System.out.println(truck.toString());
			truckCount++;
		}
		input.close();	
	}

}
