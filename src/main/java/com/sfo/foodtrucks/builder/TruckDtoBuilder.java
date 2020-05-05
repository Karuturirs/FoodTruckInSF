package com.sfo.foodtrucks.builder;

import java.util.List;

import com.sfo.foodtrucks.dto.TruckDto;
import com.sfo.foodtrucks.entity.TruckEntity;
import com.sfo.foodtrucks.request.CurrentRequest;

public interface TruckDtoBuilder {
	/**
	 * Method used to build TruckDTO's for all the TruckEntity's
	 * @param truckDTOs
	 * @return
	 */
	public List<TruckDto> buildTruckDto(List<TruckEntity> truckEntities);
	
	
	/**
	 * Method used to build TruckDTO from all TruckEntity by filtering 
	 * available trucks for currentRequest  
	 * @param truckEntities
	 * @param currentRequest
	 * @return List<TruckDto>
	 */
	public List<TruckDto> buildTruckDtoRunningNow(List<TruckEntity> truckEntities, CurrentRequest currentRequest);

}
