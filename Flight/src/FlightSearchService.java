import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static java.util.stream.Collectors.toList;

public class FlightSearchService {

    private FlightSearchInterface flightStore;
    
    public FlightSearchService(FlightSearchInterface store){
        this.flightStore = store;
    }
    
    public FlightSearchService() {
	}

	public List<Flight> search(SearchService service){
        List<Flight> flights = flightStore.getFlights();

        return flights.stream()
                .filter(f -> f.getFromDest().equals(service.getFromDestination()))
                .filter(f -> f.getToDest().equals(service.getToDestination()))
                .filter(f -> LocalDate.parse(f.getDate(), DateTimeFormatter.ofPattern("dd-MM-yyyy")).equals(service.getDepartureDate()))
                .filter(f -> f.getSeatsAvailable() >= service.getPassengerNum())
                .collect(toList());
    }


    public static FlightSearchService flightSearch(){
        return new FlightSearchService(new FlightSeachImpl());
    }
    
    public List<Flight> allFlights(){
    	return flightStore.getFlights();	
    }
    
}
