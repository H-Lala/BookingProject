package Flights;

import java.util.List;
import java.text.SimpleDateFormat;
import java.util.stream.Collectors;

public class FlightService {
    private FlightDAO flightDao=new FlightDAO();
    public void createNew(Flight item){
        flightDao.save(item);
    }

    public List<Flight> getAllFlights(){
        return flightDao.getAll();
    }

    public Flight getById(int ID){
        return flightDao.get(ID);
    }

    public boolean delete(int ID){
        return flightDao.delete(ID);
    }

    void displayAllFlights(){
        getAllFlights().stream().forEach(System.out::println);
    }

    public List<Flight> requestFlight(String destination, String date, int numOfPassengers){
        return getAllFlights().stream().filter(x->x.getDestination().equalsIgnoreCase(destination)
        && x.getSeats()>=numOfPassengers
        && x.getDepartureTime().equals(date)).collect(Collectors.toList());
    }
    public void displayRequestedFlights(String destination, String departure, int numOfPassengers) {
        requestFlight(destination, departure, numOfPassengers)
                .stream()
                .forEach(System.out::println);
    }

}
