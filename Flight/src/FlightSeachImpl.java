
import java.util.List;

public class FlightSeachImpl implements FlightSearchInterface {
	
	
	static List<Flight> flight = List.of(
            // date format DD-MM-YYYY
            new Flight(1,"Boston","New York","15-10-2019",50),
            new Flight(2,"Boston","New York","16-10-2019",10),
            new Flight(3,"Boston","New York","17-10-2019",1),


            new Flight(4,"Boston","Washington","15-10-2019",20),
            new Flight(5,"Boston","Washington","16-10-2019",7),
            new Flight(6,"Boston","Washington","17-10-2019",1),


            new Flight(7,"Boston","Atlanta","16-10-2019",3),
            new Flight(8,"Boston","Atlanta","17-10-2019",2),


            new Flight(9,"Boston","Chicago","16-10-2019",2),
            new Flight(10,"Boston","Chicago","17-10-2019",1),


            new Flight(11,"Chicago","New York","17-10-2019",5),
            new Flight(12,"Atlanta","Boston","18-10-2019",3),


            new Flight(13,"Washington","New York","19-10-2019",2),
            new Flight(14,"Washington","Boston","20-10-2019",1),


            new Flight(15,"New York","Boston","18-10-2019",2),
            new Flight(16,"New York","Boston","19-10-2019",2)

    );
	

    public List<Flight> getFlights(){

        return flight;

    }
}
