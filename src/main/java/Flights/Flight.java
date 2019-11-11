package Flights;

import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    public int ID;
    private  String Destination;
    private Date departureTime;
    private int seats;


    public Flight(int ID, String destination, String departureTime, int seats) {
        this.ID = ID;
        Destination = destination;
        SimpleDateFormat formatter =new SimpleDateFormat("dd.mm.yyyy hh:mm");
        try{
            this.departureTime = formatter.parse(departureTime);
        }
        catch(ParseException e){
            e.printStackTrace();
        }
        this.seats = seats;
    }

    public Flight() {//????????(FLIGHT DAO)

    }

    public int getID() {
        return ID;
    }

    public int getSeats() {
        return seats;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public String getDestination() {
        return Destination;
    }

    @Override
    public String toString() {
        return "Flight Id: "+ID+"\t"
                +"Destination: "+Destination+"\t"
                +"Departure Time: "+new SimpleDateFormat("dd.mm.yyyy hh:mm").format(departureTime)+"\t"
                +"Free Seats: "+seats;
    }
}
