import java.util.List;

public class FlightService {

	private FlightInterface flightInterface;

	public FlightService(FlightInterface flightInterface) {
		this.flightInterface = flightInterface;
	}

	public static FlightService getInterfaceObj() {
		return new FlightService(new FlightImpl());
	}

	public void displayFlights(List<Flight> outboundFlights) {
		flightInterface.displayAllFlights();
	}

	public void alterFlights() {
		flightInterface.alterFlights();
	}

	public void startBooking() {
		flightInterface.startBooking();
	}

	public void searchFlight() {
		flightInterface.searchFlight();
	}

	public void bookFlight(int flightId, int passengerCount, int totalPassengerCount) {
		flightInterface.bookFlight(flightId, passengerCount, totalPassengerCount);
	}

	public void displayAllFlights() {
		flightInterface.displayAllFlights();
	}

	public void getInput() {
		flightInterface.getInput();
	}

	public void exit() {
		flightInterface.getInput();
	}

}
