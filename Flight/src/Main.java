public class Main {
	
	/**
	 * 
	 * 
	 * ---------Flight Service--------------
	 * 
	 * Made with scanner for Interaction 
	 * 
	 * Options:
	 * 
	 * 1) Show all the available flights - display all flights
	 * 2) Search flight - 
	 * 		Enter passenger count,from,to,date
	 * 		If search found
	 * 			Book now opens 
	 * 				if yes - ticket will be booked  |  No - returns to the option menu  
	 * 		if not
	 * 			Alternative flights will be shown based on from,to
	 * 3) Exit - end the program
	 * 
	 * Provide sample search flight input, for example: 2 "15-10-2019" "Boston" "New York"
	 */

	static FlightService flightServiceObject = FlightService.getInterfaceObj();

	public static void main(String[] args) {
		flightServiceObject.getInput();
	}
}
