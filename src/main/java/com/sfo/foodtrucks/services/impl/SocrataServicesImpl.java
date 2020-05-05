package com.sfo.foodtrucks.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfo.foodtrucks.builder.impl.TruckDtoBuilderImpl;
import com.sfo.foodtrucks.client.HttpClientUtils;
import com.sfo.foodtrucks.dto.TruckDto;
import com.sfo.foodtrucks.entity.TruckEntity;
import com.sfo.foodtrucks.request.CurrentRequest;
import com.sfo.foodtrucks.services.SocrataServices;
import com.sfo.foodtrucks.util.FoodTruckConstants;

public class SocrataServicesImpl implements SocrataServices{


	@Override
	public List<TruckDto> getFootTruckFilteredByDayOrderedByName(CurrentRequest currentRequest) {
		
		//Creating the URL for GET request
		String url = assembleSocrataURL(currentRequest.getCurrentDay());
		
		//GET Rest Client call
		String responseJSON = new HttpClientUtils().getRequest(url);
		
		// Convert StringJSON to List Entities
		List<TruckEntity> trucksEntities = convertJSONArrayStringToList(responseJSON);
		
		//building and returning Dto
		return (new TruckDtoBuilderImpl()).buildTruckDtoRunningNow(trucksEntities, currentRequest);
	}

	@Override
	public List<TruckDto> getCurrentFootTruckFilteredByDayOrderedByName(CurrentRequest currentRequest) {
		return getFootTruckFilteredByDayOrderedByName(currentRequest);
	}
	
	@Override
	public List<TruckDto> getAllFootTruck() {
		
		return null;
	}

	@Override
	public List<TruckDto> getFootTruckFiltered(CurrentRequest currentRequest) {
		
		return null;
	}
	
	/**
	 * Method creates the Socrata QUERY url with select where and order for the day requested
	 * ex:https://{URI}/..?$select=applicant,location,start24,end24&$where=dayorder=5&$order=applicant
	 * @param dayOfWeek (requested day of the week)
	 * @return string (URL)
	 */
	public String assembleSocrataURL(int dayOfWeek){
		
		StringBuilder socrataUrl = new StringBuilder();
		socrataUrl.append(FoodTruckConstants.SFO_FOODTRUCK_URL_JSON);
		socrataUrl.append(FoodTruckConstants.QUESTION_MARK);
		socrataUrl.append(FoodTruckConstants.SFO_FOODTRUCK_URL_SELECT_QUERY);
		socrataUrl.append(FoodTruckConstants.APPLESENT);
		socrataUrl.append(FoodTruckConstants.SFO_FOODTRUCK_URL_WHERE_QUERY);
		socrataUrl.append(dayOfWeek);
		socrataUrl.append(FoodTruckConstants.APPLESENT);
		socrataUrl.append(FoodTruckConstants.SFO_FOODTRUCK_URL_ORDER_QUERY);
	
		return socrataUrl.toString();
	}
	
	/**
	 * Method is used to conver the JSONARRAY String to List Object
	 * 
	 * @param jsonArray
	 * @return list of truckDTO objects
	 */
	public List<TruckEntity> convertJSONArrayStringToList(String jsonArray){
		
		ObjectMapper mapper = new ObjectMapper();
		List<TruckEntity> listT = new ArrayList<TruckEntity>();
		try {
			listT = Arrays.asList(mapper.readValue(jsonArray, TruckEntity[].class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return listT;
		
	}


}
