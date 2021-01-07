import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class SearchService {

    private int passengerNum;
    private String fromDestination;
    private String toDestination;
    private LocalDate departDate;
    
//    @Test
//    public void assertion_error_message_differentiates_expected_and_actual_persons() {
//      try {
//        assertThat(SearchService("Boston","New York","15-10-2019","2"));
//      } catch (AssertionError e) {
//        logAssertionErrorMessage("isEqualTo differentiating expected and actual having same toString representation", e);
//      }
//    }

    
    public SearchService(String fromDest,String toDest,String depDate,String passNum) {
        if(fromDest == "" && toDest == "" && depDate == "" && passNum == "" ) {throw new IllegalArgumentException("There should be exactly 4 arguments provided");}
        this.passengerNum = validatePassengerNum(passNum);
        this.departDate = validateDate(depDate);
        this.toDestination = isInvalidString(toDest);
        this.fromDestination = isInvalidString(fromDest);

        if(fromDestination.equalsIgnoreCase(toDestination)){
            throw new IllegalArgumentException("From and To Destinations cannot be the same. You input " + fromDestination);
        }

    }

    private LocalDate validateDate(String stringDate) {
        String date = isInvalidString(stringDate);
        return parseInputDate(date);
    }

    private int validatePassengerNum(String inputPassengers) {
        int passengerNum = Integer.parseInt(inputPassengers);
        if(passengerNum < 1 || passengerNum > 7){
            throw new IllegalArgumentException("The number of passengers must be between 1 and 7");
        }
        return passengerNum;
    }

    public String getFromDestination() {
        return fromDestination;
    }

    public String getToDestination() {
        return toDestination;
    }

    public LocalDate getDepartureDate() {
        return departDate;
    }

    public int getPassengerNum() {
        return passengerNum;
    }


    private LocalDate parseInputDate(String departDate) {
        LocalDate date;

        try {
            date = LocalDate.parse(departDate, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException exception){
            throw new IllegalArgumentException(String.format("Could not parse input date %s, please input a date in format dd-MM-YYYY", departDate));
        }
        return date;
    }

    private String isInvalidString(String s){
        if(s == null || s.trim().isEmpty()){
            throw new IllegalArgumentException("You have provided the following argument, but it cannot be null or empty:" + s);
        }
        return s;

    }
}
