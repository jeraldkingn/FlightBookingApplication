import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FlightImpl implements FlightInterface{

	static int id = 0;
	static int totalPassengerCount = 0;
	static String passengerNum = "";
	static String fromDestination = "";
	static String toDestination = "";
	
	static FlightSearchService searchService = FlightSearchService.flightSearch();
	static List<Flight> allFlights = searchService.allFlights();

	@Override
	public void displayFlights(List<Flight> outboundFlights) {
		if (outboundFlights.isEmpty()) {
			System.out.println("No flights found for your search criteria.\n\nList of "
					+ "Available Flights based on your destination\n");
			alterFlights();
		} else {
			System.out.println("Flights found:\n");
			id = outboundFlights.get(0).getFlightId();
			totalPassengerCount = outboundFlights.get(0).getSeatsAvailable();
			System.out.println(Arrays.toString(outboundFlights.toArray()) + "\n");
			startBooking();
		}
	}
	@Override
	public void alterFlights() {
		allFlights.forEach(flights -> {
			if (flights.getFromDest().equals(fromDestination) && flights.getToDest().equals(toDestination) ){
				System.out.println(flights);
			}
		});
		getInput();
	}

	public void startBooking() {

		Scanner input = new Scanner(System.in);

		boolean isValid = false;
		while (!isValid) {
			System.out.println("Start booking?\n\n1)Yes\n2)No\n");
			try {
				int options = input.nextInt();
				switch (options) {
				case 1:
					bookFlight(id, Integer.parseInt(passengerNum), totalPassengerCount);
					isValid = true;
					break;
				case 2:
					getInput();
					isValid = true;
					break;

				default:
					System.out.println("Choose a valid option\n");
				}

			} catch (Exception e) {
				System.out.println("Invalid Input type input\n");
			}

		}
	}
	@Override
	public void searchFlight() {
		Scanner input = new Scanner(System.in);

		System.out.println("\nEnter details\n");
		System.out.print("Enter number of passengers : ");
		String pasNum = input.nextLine();

		System.out.print("Departure Date : ");
		String depDate = input.nextLine();

		System.out.print("From Destination : ");
		String fromDest = input.nextLine();

		System.out.print("To Destination : ");
		String toDest = input.nextLine();

		passengerNum = pasNum;
		String departDate = depDate;
		fromDestination = fromDest;
		toDestination = toDest;

		System.out.println("\nResult : \n");

		SearchService service = new SearchService(fromDestination, toDestination, departDate, passengerNum);

		List<Flight> outboundFlights = searchService.search(service);

		displayFlights(outboundFlights);

	}
	
	@Override
	public void bookFlight(int flightId, int passengerCount, int totalPassengerCount) {
		
		int currentPassengerCount = totalPassengerCount - passengerCount;

		allFlights.forEach(flights -> {
			if (flights.getFlightId() == flightId) {

				flights.setSeatsAvailable(currentPassengerCount);

				System.out.println("Ticket successfully booked");
			}
		});
		FlightSeachImpl.flight = allFlights;
		getInput();
	}
	
	@Override
	public void displayAllFlights() {
		allFlights.forEach(flights -> {
			System.out.println(flights);
		});
		getInput();
	}
	
	@Override
	public void getInput() {
		boolean isValid = false;
		while (!isValid) {
			System.out.print("\nSelect your service :\n\n1)Show all available flights\n2)Seach a flight\n3)Exit\n");
			Scanner input = new Scanner(System.in);

			try {
				int options = input.nextInt();
				switch (options) {
				case 1:
					displayAllFlights();
					isValid = true;
					break;
				case 2:
					searchFlight();
					isValid = true;
					break;
				case 3:
					exit();
					isValid = true;
					break;
				default:
					System.out.println("Choose a valid option\n");
				}

			} catch (Exception e) {
				e.printStackTrace();
				System.out.println("Invalid Input type input\n");
				getInput();
			}
		}
	}
	@Override
	public void exit() {
		System.out.println("Thank you");
	}

}
