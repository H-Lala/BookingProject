package Flights;

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
    public void SaveData(java.lang.String file) {
        LoadData(flightList);
    }

    @Override
    public void LoadData(List<Flight> list) {
        File file = new File("/Users/User/IdeaProjects/BookingProject/FlightsDatabase.txt");
        FileWriter fr = null;
        try {
            fr = new FileWriter(file);
            fr.write(String.valueOf(list));
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            //close resources
            try {
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void ReadData(java.lang.String file) {
        BufferedReader bufferedReader = null;
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            int val = 0;
            while ((val = bufferedReader.read()) != -1) {
                char c = (char) val;
                //prints the character
                System.out.print(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }


    @Override
    public void save(Flight item)//creating
    {
        Flight flight = new Flight(item.getID(), item.getDestination(), item.getDepartureTime(), item.getSeats());
        flightList.add(flight);
        SaveData("FlightsDatabase.txt");

    }

    @Override
    public Flight get(int ID) {
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
        for (Flight flight : flightList) {
            if (flight.ID == ID) {
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
            java.lang.String Destination = sc.nextLine();
            java.lang.String Departure = sc.nextLine();
            int seats = sc.nextInt();
            Flight NewFlight = new Flight(ID, Destination, Departure, seats);
            flightList.add(NewFlight);

        }

    }


}
