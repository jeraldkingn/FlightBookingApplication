public class Flight {

    private String fromDest;
    private String toDest;
    private String date;
    private int seatsAvailable;
    private int flightId;

    public Flight(int flightId,String fromDest,
                  String toDesst,
                  String date,
                  int seatsAvailable){
    	this.flightId = flightId;
        this.fromDest = fromDest;
        this.toDest = toDesst;
        this.date = date;
        this.seatsAvailable = seatsAvailable;
    }
    
    public void setSeatsAvailable(int seatsAvailable){
    	this.seatsAvailable = seatsAvailable;
    }

    public String getFromDest() {
        return fromDest;
    }

    public String getToDest() {
        return toDest;
    }

    public String getDate() {
        return date;
    }
    
    public int getFlightId() {
        return flightId;
    }

    public int getSeatsAvailable() {
        return seatsAvailable;
    }
    
    @Override
    public String toString(){
        return String.format("From %s to %s. Date: %s. Available seats left: %s", fromDest, toDest, date, seatsAvailable);
    }
}
