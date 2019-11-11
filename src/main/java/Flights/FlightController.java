package Flights;

import java.util.Date;
import java.util.List;

public class FlightController {
    private FlightService flightService = new FlightService();
    public void createNewFlight(Flight item){
        flightService.createNew(item);
    }
    public List<Flight> getAllFlights(){
        return flightService.getAllFlights();
    }
    public void showAllFlights(){
        flightService.displayAllFlights();
    }
    public List<Flight> requestFlight(String Destination, Date DepartureTime, int numOfPassengers){
        return flightService.requestFlight(Destination,DepartureTime,numOfPassengers);
    }
    public void showRequestedFlights(String Destination, Date DepartureTime, int numOfPassengers){
        flightService.displayRequestedFlights(Destination,DepartureTime,numOfPassengers);
    }
    public Flight getFlightByID(int ID){
        return flightService.getById(ID);
    }
    public boolean deleteFlight(int ID){
        return flightService.delete(ID);
    }

}
