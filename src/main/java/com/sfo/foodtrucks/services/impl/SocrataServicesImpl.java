package com.sfo.foodtrucks.services.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sfo.foodtrucks.builder.impl.TruckEntityBuilderImpl;
import com.sfo.foodtrucks.client.HttpClientUtils;
import com.sfo.foodtrucks.dto.TruckDTO;
import com.sfo.foodtrucks.entity.TruckEntity;
import com.sfo.foodtrucks.request.CurrentRequest;
import com.sfo.foodtrucks.services.SocrataServices;
import com.sfo.foodtrucks.util.FoodTruckConstants;

public class SocrataServicesImpl implements SocrataServices{


	@Override
	public List<TruckEntity> getFootTruckFilteredByDayOrderedByName(CurrentRequest currentRequest) {
		
		//Creating the URL for GET request
		String url = assembleSocrataURL(currentRequest.getCurrentDay());
		
		//GET Rest Client call
		String responseJSON = new HttpClientUtils().getRequest(url);
		
		// Convert StringJSON to List DTO's
		List<TruckDTO> trucksDTOs = convertJSONArrayStringToList(responseJSON);
		
		//building and returning Entity
		return (new TruckEntityBuilderImpl()).buildTruckEntityRunningNow(trucksDTOs, currentRequest);
	}

	@Override
	public List<TruckEntity> getCurrentFootTruckFilteredByDayOrderedByName(CurrentRequest currentRequest) {
		return getFootTruckFilteredByDayOrderedByName(currentRequest);
	}
	
	@Override
	public List<TruckEntity> getAllFootTruck() {
		
		return null;
	}

	@Override
	public List<TruckEntity> getFootTruckFiltered(CurrentRequest currentRequest) {
		
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
	public List<TruckDTO> convertJSONArrayStringToList(String jsonArray){
		
		ObjectMapper mapper = new ObjectMapper();
		List<TruckDTO> listT = new ArrayList<TruckDTO>();
		try {
			listT = Arrays.asList(mapper.readValue(jsonArray, TruckDTO[].class));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		return listT;
		
	}


}
