package com.sfo.foodtrucks;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.sfo.foodtrucks.dto.Truck;
import com.sfo.foodtrucks.request.CurrentTimeRequest;
import com.sfo.foodtrucks.util.FoodTruckConstants;
/**
 * This FoodTruckFinder helps to find the current food trucks in SF 
 *     with following conditions
 *     a) NAME ADDRESS (Sorted alphabetically by name).
 *     b) Max 10 results on go, until user inputs.
 *     
 * 
 *
 */
public class FoodTruckFinder {

	public static void main(String[] args) {
		
		//Get current time and day request 
		
		CurrentTimeRequest currenttimereq = new CurrentTimeRequest();
	
		//Create the client request
		
		StringBuilder foodtruckurl = new StringBuilder();
		foodtruckurl.append(FoodTruckConstants.SFO_FOODTRUCK_URL);
		foodtruckurl.append(currenttimereq.getCurrentDay());
		
		List<Truck> trucks = new ArrayList<>();
		//Calling SF API
		try{
			
			URL url = new URL(foodtruckurl.toString());
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setConnectTimeout(5000);
	        connection.setReadTimeout(5000);
	        connection.connect();
	        
	        if (connection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
	        	BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line;
				int i=0;
				while ((line = rd.readLine()) != null) {
					if(i!=0){
						line = line.replaceAll("\",,\"", "\",\"\",\"");
						String[] data = line.replaceFirst("\"", "").split("\",\"");
						Truck truck = new Truck(data[0],data[1],data[2],data[3],data[5],data[10],data[11],data[18]);
						//System.out.println(truck.toString());
						trucks.add(truck);
					}
					i++;
				}
				System.out.println(i);
				rd.close();
				
	        } else { 
	            System.out.println("Not able to process the request. Please retry again.");
	        }
	        
		}catch(Exception ex){
			ex.printStackTrace();
		}
		//Processing the DTO to entity
		
		List<Truck> availabletrucks = trucks.stream().filter(
				x -> 
			parseTimeString(x.getStart24()) <= parseTimeString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+Calendar.getInstance().get(Calendar.MINUTE)) && 
					parseTimeString(x.getEnd24()) > parseTimeString(Calendar.getInstance().get(Calendar.HOUR_OF_DAY)+":"+Calendar.getInstance().get(Calendar.MINUTE))
		).collect(Collectors.toList());
		// Display the output
		
		// Read user input if more than 10 records
		Collections.sort(availabletrucks);

		int i=0;
		Scanner input = new Scanner(System.in);
		System.out.println(availabletrucks.size());
		
		for (Truck truck : availabletrucks) {
			if(i!=0 && i%10 == 0){
				String readString = input.nextLine();
				if (readString.equals("")){
					
				}
	
			}
			System.out.println(truck.getApplicant() + " "+truck.getLocation());
			i++;
		}
		System.out.println(i);
		input.close();
		 
	}
	
	public static int parseTimeString(String s) {
	    String[] t = s.split(":");
	    return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]); // minutes since 00:00
	}
}
