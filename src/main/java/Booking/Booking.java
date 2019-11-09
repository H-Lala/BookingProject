package Booking;

import java.time.LocalDateTime;
import java.util.List;

public class Booking {
    private String destination;
    private int tickets;
    private final LocalDateTime bookingDate;


    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getDestination() {
        return destination;

    }

    public void setTickets(int tickets) {
        this.tickets = tickets;
    }

    public int getTickets() {
        return tickets;
    }

    Booking(String destination, int tickets, LocalDateTime bookingDate) {
        this.destination = destination;
        this.tickets = tickets;
        this.bookingDate = bookingDate;
    }

    Booking(LocalDateTime bookingDate) {
        super();
        this.bookingDate = bookingDate;
    }




}
