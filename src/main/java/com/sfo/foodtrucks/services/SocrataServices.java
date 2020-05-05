package com.sfo.foodtrucks.services;

import java.util.List;

import com.sfo.foodtrucks.dto.TruckDto;
import com.sfo.foodtrucks.request.CurrentRequest;

public interface SocrataServices {
	/**
	 * Gets all the Foodtrunk Entity and return the TruckDTO list
	 * @return List<TruckDto>
	 */
	public List<TruckDto> getAllFootTruck();
	
	/**
	 * Gets all the FoodTrucks for current day of the week
	 * and return the TruckDTO list
	 * @param currentRequest
	 * @return
	 */
	public List<TruckDto> getFootTruckFiltered(CurrentRequest currentRequest);
	
	/**
	 * Gets all the FoodTrucks for current day of the week and Ordered By the Name
	 * and return the TruckDTO list
	 * @param currentRequest
	 * @return
	 */
	public List<TruckDto> getFootTruckFilteredByDayOrderedByName(CurrentRequest currentRequest);
	
	/**
	 * Gets all the FoodTrucks currently running for current day of the week and Ordered By the Name
	 * and return the TruckDTO list
	 * @param currentRequest
	 * @return
	 */
	public List<TruckDto> getCurrentFootTruckFilteredByDayOrderedByName(CurrentRequest currentRequest);
}
