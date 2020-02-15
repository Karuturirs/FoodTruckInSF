package com.sfo.foodtrucks.builder;

import java.util.List;

import com.sfo.foodtrucks.dto.TruckDTO;
import com.sfo.foodtrucks.entity.TruckEntity;
import com.sfo.foodtrucks.request.CurrentRequest;

public interface TruckEntityBuilder {
	/**
	 * Method used to build TruckEntity's for all the TruckDTO's
	 * @param truckDTOs
	 * @return
	 */
	public List<TruckEntity> buildTruckEntity(List<TruckDTO> truckDTOs);
	
	
	/**
	 * Method used to build TruckEntity from all TruckDTO by filtering 
	 * available trucks for currentRequest  
	 * @param truckDTOs
	 * @param currentRequest
	 * @return List<TruckEntity>
	 */
	public List<TruckEntity> buildTruckEntityRunningNow(List<TruckDTO> truckDTOs, CurrentRequest currentRequest);

}
