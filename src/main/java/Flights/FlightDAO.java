package Flights;

import DAO.DAO;

import java.util.ArrayList;
import java.util.List;

public class FlightDAO implements DAO<Flight> {
    List <Flight> flightList=new ArrayList<>();

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
        Flight flight=new Flight();//??????????
        flightList.add(flight);
    }

    @Override
    public Flight get(int ID) {
        for(Flight flight:flightList){
            if(flight.ID==ID){
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
        for(Flight flight: flightList){
            if(flight.ID==ID){
                flightList.remove(flight);
                return true;
            }
        }
        return false;
    }
}
