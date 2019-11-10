package Booking;

import java.util.List;

public class BookingServise {
    private BookingDAO bookingDAO = new BookingDAO();

    public BookingDAO getBookings() {
        return bookingDAO;
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAll();
    }

    public void showBookings() {
        bookingDAO.getAll().forEach(System.out::println);
    }

    public void save(Booking booking) {
        bookingDAO.save(booking);
    }

    public int counts(){
        return bookingDAO.getAll().size();
    }
    public void SaveData(String file) {
        bookingDAO.SaveData(file);
    }

    public void ReadData(String file) {
        bookingDAO.ReadData(file);
    }
    public void delete(int ID){
        bookingDAO.delete(ID);
    }

}
