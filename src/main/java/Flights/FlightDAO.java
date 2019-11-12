package Flights;

import DAO.DAO;
//import com.sun.org.apache.xpath.internal.operations.String;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class FlightDAO implements DAO<Flight> {
    List<Flight> flightList = new ArrayList<>();


    @Override
    public void SaveData(java.lang.String file) {

    }

    @Override
    public void LoadData(List<Flight> list) {

    }

    @Override
    public void ReadData(java.lang.String file) {

    }


    @Override
    public void save(Flight item)//creating
    {
        Flight flight = new Flight(item.getID(), item.getDestination(), item.getDepartureTime(), item.getSeats());//??????????
        flightList.add(flight);
    }

    @Override
    public Flight get(int ID) {
        return null;
    }

    @Override
    public Flight get(String ID) {
        for (Flight flight : flightList) {
            if (flight.ID == ID) {
                return flight;
            }
        }
        return null;
    }

    @Override
    public List<Flight> getAll() {
        return flightList;
    }

    @Override
    public boolean delete(int ID) {
        return false;
    }

    @Override
    public boolean delete(String ID) {
        for (Flight flight : flightList) {
            if (flight.ID.equals(ID)) {
                flightList.remove(flight);
                return true;
            }
        }
        return false;
    }

    @Override
    public void generate(Scanner sc) {
        while (sc.hasNext()) {
            String ID = sc.nextLine();
            java.lang.String Destination = sc.nextLine();
            java.lang.String Departure = sc.nextLine();
            int seats = sc.nextInt();
            Flight NewFlight = new Flight(ID, Destination, Departure, seats);
            flightList.add(NewFlight);

        }

    }


}
