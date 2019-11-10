package Booking;

import Flights.Flights;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Booking implements Serializable {

    private int tickets;
    private LocalDateTime bookingDate = LocalDateTime.now();
    private List<Person> passengers = new ArrayList<>();
    private List<Flights> flights = new ArrayList<>();


    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getTickets() {
        return tickets;
    }

    public void setFlights(List<Flights> flights) {
        this.flights = flights;

    }

    public List<Flights> getFlights() {
        return flights;
    }

    public void setPassenger(List<Person> passengers) {
        this.passengers = passengers;
    }

    public List<Person> getPassengers() {
        return passengers;
    }


    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public Booking(List<Flights> flights, List<Person> passenger, int tickets) {
        this.flights = flights;
        this.passengers = passenger;
        this.tickets = tickets;

    }

    public boolean addPerson(Person passenger) {
        if (!passengers.contains(passenger) &&
                passenger != null) {
            passengers.add(passenger);
            return true;
        } else return false;
    }

    public boolean deletePassenger(Person passenger) {
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
                String.format("Booking{Counts of Tickets:%dData Time: %s", tickets,
                        bookingDate.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
    }
}
