# FoodTruckInSF

This Application helps to find the current running food trucks in San Franscio with name and location

### Features:
 * A command line application, with shows only current running truck.
 * Pagination implemented with 10 results on each view.
 * All the data is sorted on the NAME of the Truck.
 * Implemented with maven build tool.
 * Dockerfile implemented with OpenJDK 1.11 and maven(for testing)


 ## Environment Setup and Execution
 * Install JDK 1.8 or higher
 * Install maven 3.3.6 or higher
 * Download the source code and Navigate to FoodTruckInSF Project folder
	 	``` cd FoodTruckInSF ```	
 * create the jar, Run
		​```
		mvn package
		```
 * execute the jar (Make sure to check latest version of jar in below command, in case)
	​		``` 
			java -jar target/FoodTruckInSF-1.0.2-jar-with-dependencies.jar 
		```

