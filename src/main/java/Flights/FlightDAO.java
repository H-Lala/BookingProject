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
    public void SaveData(String file) {

    }

    @Override
    public void LoadData(List<Flight> list) {

    }

    @Override
    public void ReadData(String file) {

    }


    @Override
    public void save(Flight item)//creating
    {
        Flight flight = new Flight(item.getID(), item.getDestination(), item.getDepartureTime(), item.getSeats());//??????????
        flightList.add(flight);
    }



    @Override
    public Flight get(int ID) {
        for (Flight flight : flightList) {
            if (flight.ID == ID) {
                return flight;
            }

        }
         throw new IllegalArgumentException("Invalid ID");
    }

    @Override
    public List<Flight> getAll() {
        return flightList;
    }



    @Override
    public boolean delete(int ID) {
        for (Flight flight : flightList) {
            if (flight.ID==ID) {
                flightList.remove(flight);
                return true;
            }
        }
        return false;
    }

    @Override
    public void generate(Scanner sc) {
        while (sc.hasNext()) {
            int ID = sc.nextInt();
            sc.nextLine();
            String Destination = sc.nextLine();
            String Departure = sc.nextLine();

            Flight NewFlight = new Flight(ID, Destination, Departure);
            flightList.add(NewFlight);

        }

    }


}
