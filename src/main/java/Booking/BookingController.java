package Booking;

import java.util.List;
import java.util.Scanner;

public class BookingController {
    private BookingServise bookingServise;

    public BookingController() {
        bookingServise = new BookingServise();
    }

    public BookingServise getBookingServise() {
        return bookingServise;
    }

    public List<Booking> getAllBookings() {
        return bookingServise.getAllBookings();
    }

    public void save(Booking booking) {
        System.out.println("Saving new booking");
        bookingServise.save(booking);
    }

    public void showBookings() {
        bookingServise.getAllBookings().forEach(System.out::println);
    }

    public void delete(int ID) {
        bookingServise.delete(ID);
    }

    public void SaveData(String file) {
        bookingServise.SaveData(file);
    }

    public void ReadData(String file) {
        bookingServise.ReadData(file);
    }

    public int counts() {
        return bookingServise.getAllBookings().size();
    }


}
