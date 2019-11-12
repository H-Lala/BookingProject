package Flights;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    public int ID;
    private  String Destination;
    private String departureTime;
    private int seats;


    public Flight(int ID, String destination, String departureTime, int seats) {
        this.ID = ID;
        Destination = destination;
        /*SimpleDateFormat formatter =new SimpleDateFormat("dd.mm.yyyy hh:mm");
        try{
            this.departureTime = formatter.parse(departureTime);
        }
        catch(ParseException e){
            e.printStackTrace();
        }*/
        this.departureTime=departureTime;
        this.seats = seats;
    }

    public Flight(String id, String destination, String departure) {
        this.ID=Integer.parseInt(id);
        this.Destination=destination;
        this.departureTime=departure;
    }

    /*public Flight() {//????????(FLIGHT DAO)

    }*/

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getSeats() {
        return seats;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public String getDestination() {
        return Destination;
    }

    @Override
    public String toString() {
        return "Flight Id: "+ID+"\t"
                +"Destination: "+Destination+"\t"
                +"Departure Time: "+departureTime+"\t"
                +"Free Seats: "+seats;
    }
}
