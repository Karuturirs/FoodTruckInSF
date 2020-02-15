package com.sfo.foodtrucks.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import com.sfo.foodtrucks.exception.CustomExceptionHandling;

public class HttpClientUtils {
	
	public String getRequest(final String uri) {
		
		StringBuilder responseBody = new StringBuilder();
		try{
			
			URL url = new URL(uri);
			HttpURLConnection connection = (HttpURLConnection)url.openConnection();
	        connection.setRequestMethod("GET");
	        connection.setConnectTimeout(5000);
	        connection.setReadTimeout(5000);
	        connection.connect();
	        
	        if (connection.getResponseCode() < HttpURLConnection.HTTP_BAD_REQUEST) {
	        	BufferedReader rd = new BufferedReader(new InputStreamReader(connection.getInputStream()));
				String line;
				while ((line = rd.readLine()) != null) {
					responseBody.append(line);
				}

				rd.close();
				
	        } else { 
	            System.out.println("Not able to process the request. Please retry again.");
	            throw new CustomExceptionHandling("3000", connection.getResponseCode()+" :: Bad Response code for Socrata Service");
	        }
	        
		}catch(Exception ex){
			throw new CustomExceptionHandling("4000", ex.getMessage());
		}
		return responseBody.toString();
	}

}
