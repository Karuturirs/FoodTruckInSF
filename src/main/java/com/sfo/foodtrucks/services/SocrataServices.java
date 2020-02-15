package com.sfo.foodtrucks.services;

import java.util.List;

import com.sfo.foodtrucks.entity.TruckEntity;
import com.sfo.foodtrucks.request.CurrentRequest;

public interface SocrataServices {
	/**
	 * Gets all the Foottrunk DTO and return the TruckEntity list
	 * @return List<TruckEntity>
	 */
	public List<TruckEntity> getAllFootTruck();
	
	/**
	 * Gets all the FoodTrucks for current day of the week
	 * and return the TruckEntity list
	 * @param currentRequest
	 * @return
	 */
	public List<TruckEntity> getFootTruckFiltered(CurrentRequest currentRequest);
	
	/**
	 * Gets all the FoodTrucks for current day of the week and Ordered By the Name
	 * and return the TruckEntity list
	 * @param currentRequest
	 * @return
	 */
	public List<TruckEntity> getFootTruckFilteredByDayOrderedByName(CurrentRequest currentRequest);
	
	/**
	 * Gets all the FoodTrucks currently running for current day of the week and Ordered By the Name
	 * and return the TruckEntity list
	 * @param currentRequest
	 * @return
	 */
	public List<TruckEntity> getCurrentFootTruckFilteredByDayOrderedByName(CurrentRequest currentRequest);
}
