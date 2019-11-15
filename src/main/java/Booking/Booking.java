package Booking;

import Flights.Flight;
import Users.Users;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Booking implements Serializable {
    public int ID;
    private int tickets;
    private LocalDateTime bookingDate = LocalDateTime.now();
    private List<Users> passengers = new ArrayList<>();
    private List<Flight> flights = new ArrayList<>();
    private String destination;


    public Booking() {

    }

    public void setID(int ID){ this.ID=ID; }
    public int getID(){ return ID; }
    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getTickets() {
        return tickets;
    }

    public void setFlights(List<Flight> flights) {
        this.flights = flights;

    }

    public List<Flight> getFlights() {
        return flights;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;
    }

    public void setPassenger(List<Users> passengers) {
        this.passengers = passengers;
    }

    public List<Users> getPassengers() {
        return passengers;
    }


    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public Booking(int ID, List<Flight> flights, List<Users> passenger, int tickets) {
        this.ID=ID;
        this.flights = flights;
        this.passengers = passenger;
        this.tickets = tickets;

    }
    public Booking(int ID,String destination,int tickets){
        this.ID=ID;
        this.destination=destination;
        this.tickets=tickets;
    }
    public boolean deletePassenger(Users passenger) {
        if (!passengers.contains(passenger)) return false;
        passengers.remove(passenger);
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if(this.hashCode()==obj.hashCode()) return true;
        if(obj==null || getClass()!=obj.getClass()) return  false;
        Booking booking= (Booking) obj;
        return true; // have to correct && hashcode
    }

    @Override
    public String toString() {
        return
                String.format("Booking{ID: %d   Destination: %s   Counts of Tickets:  %d " +
                                "Data Time: %s",ID, destination,tickets,
                        bookingDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")));
    }
}
