package com.sfo.foodtrucks.builder.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sfo.foodtrucks.builder.TruckDtoBuilder;
import com.sfo.foodtrucks.dto.TruckDto;
import com.sfo.foodtrucks.entity.TruckEntity;
import com.sfo.foodtrucks.request.CurrentRequest;
import com.sfo.foodtrucks.util.FoodTruckConstants;

public class TruckDtoBuilderImpl implements TruckDtoBuilder {

	@Override
	public List<TruckDto> buildTruckDto(List<TruckEntity> truckEntities) {
		List<TruckDto> truckDtoList = new ArrayList<TruckDto>();
		truckEntities.forEach(x -> {
			truckDtoList.add(new TruckDto(x.getApplicant(),x.getLocation()));
		});
		return truckDtoList;
	}

	@Override
	public List<TruckDto> buildTruckDtoRunningNow(List<TruckEntity> truckEntities, CurrentRequest currentRequest) {
		//filtering the current running trucks
		// comparing if starttime <= time < endtime 
		List<TruckEntity> currentRunningTrucks = truckEntities.stream().filter(
													x -> 
														parseTimeString(x.getStart24()) <= parseTimeString(currentRequest.getCurrentHour()+":"+currentRequest.getCurrentMinutes()) && 
														parseTimeString(x.getEnd24()) > parseTimeString(currentRequest.getCurrentHour()+":"+currentRequest.getCurrentHour())
										).collect(Collectors.toList());
		return buildTruckDto(currentRunningTrucks);
	}
	
	
	/**
	 * Method to convert String of format "HH:MM" to minutes
	 * and return the minutes since 00:00, if not a proper string returns -1 
	 * @param s
	 * @return minutes of the times
	 */
	public int parseTimeString(String s) {
		if(s.contains(FoodTruckConstants.COLON)){
		    String[] t = s.split(FoodTruckConstants.COLON);
		    return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]); // minutes since 00:00
		}else{
			return -1;
		}
	}

	
	

}
