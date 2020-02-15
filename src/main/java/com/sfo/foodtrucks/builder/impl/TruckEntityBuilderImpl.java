package com.sfo.foodtrucks.builder.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.sfo.foodtrucks.builder.TruckEntityBuilder;
import com.sfo.foodtrucks.dto.TruckDTO;
import com.sfo.foodtrucks.entity.TruckEntity;
import com.sfo.foodtrucks.request.CurrentRequest;
import com.sfo.foodtrucks.util.FoodTruckConstants;

public class TruckEntityBuilderImpl implements TruckEntityBuilder {

	@Override
	public List<TruckEntity> buildTruckEntity(List<TruckDTO> truckDTOs) {
		List<TruckEntity> truckEntityList = new ArrayList<TruckEntity>();
		truckDTOs.forEach(x -> {
			truckEntityList.add(new TruckEntity(x.getApplicant(),x.getLocation()));
		});
		return truckEntityList;
	}

	@Override
	public List<TruckEntity> buildTruckEntityRunningNow(List<TruckDTO> truckDTOs, CurrentRequest currentRequest) {
		List<TruckDTO> currentRunningTrucks = truckDTOs.stream().filter(
													x -> 
														parseTimeString(x.getStart24()) <= parseTimeString(currentRequest.getCurrentHour()+":"+currentRequest.getCurrentMinutes()) && 
														parseTimeString(x.getEnd24()) > parseTimeString(currentRequest.getCurrentHour()+":"+currentRequest.getCurrentHour())
										).collect(Collectors.toList());
		return buildTruckEntity(currentRunningTrucks);
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
