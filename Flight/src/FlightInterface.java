import java.util.List;

public interface FlightInterface {
	public void getInput(); 
	public void exit();
	public void displayFlights(List<Flight> outboundFlights);
	public void alterFlights();
	public void startBooking(); 
	public void searchFlight();
	public void displayAllFlights();
	public void bookFlight(int flightId, int passengerCount, int totalPassengerCount);
}
