package com.sfo.foodtrucks.business;

import java.util.List;
import java.util.Scanner;

import com.sfo.foodtrucks.entity.TruckEntity;
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
	public List<TruckEntity> getCurrentlyRunningFoodTrucks(CurrentRequest currentRequest){
		SocrataServices socrataServices = new SocrataServicesImpl();
		
		return socrataServices.getCurrentFootTruckFilteredByDayOrderedByName(currentRequest);
		
	}
	
	
	/**
	 * A method to process all the truckEntity data with pagination of max 10 per each view,
	 * On user clicking enter will display next 10 TruckEnity 
	 * @param availableFTList
	 */

	public void displayFoodTrucks(List<TruckEntity> availableFTList) {
		int i=0;
		//Read user input
		Scanner input = new Scanner(System.in);
		System.out.println("NAME ADDRESS");
		for (TruckEntity truck : availableFTList) {
			if(i!=0 && i%10 == 0){
				input.nextLine();
			}
			System.out.println(truck.toString());
			i++;
		}
		
		input.close();	
	}

}
