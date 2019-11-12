package Flights;

import Booking.Booking;
import DAO.DAO;
//import com.sun.org.apache.xpath.internal.operations.String;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.SimpleFormatter;

public class FlightDAO implements DAO<Flight> {
    List<Flight> flightList = new ArrayList<>();


    @Override
    public void SaveData(String file) {
        try {
            if (new File(file).getParentFile().mkdirs()) {
                FileOutputStream fileOutput = new FileOutputStream(file);
                ObjectOutputStream OutputStream = new ObjectOutputStream(fileOutput);
                OutputStream.writeObject(flightList);
                OutputStream.close();
                fileOutput.close();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void LoadData(List<Flight> list) {
        if (flightList != null) {
            flightList.forEach(this::save);
        }
    }

    @Override
    public void ReadData(String file) {
        List<Flight> flightList = null;
        try {
            FileInputStream FileInput = new FileInputStream(file);
            ObjectInputStream InputStream = new ObjectInputStream(FileInput);
            flightList = (List<Flight>) InputStream.readObject();
            InputStream.close();
            FileInput.close();
            LoadData(flightList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


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
