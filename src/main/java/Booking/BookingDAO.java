package Booking;

import DAO.DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BookingDAO implements DAO<Booking> {
    private List<Booking> booking0fList = new ArrayList<>();

    public BookingDAO(List<Booking> booking0fList) {
        this.booking0fList = booking0fList;
    }

    public BookingDAO() {
        booking0fList = new ArrayList<>();
    }

    @Override
    public void SaveData(String file) {
        try {
            if (new File(file).getParentFile().mkdirs()) {
                FileOutputStream fileOutput = new FileOutputStream(file);
                ObjectOutputStream OutputStream = new ObjectOutputStream(fileOutput);
                OutputStream.writeObject(booking0fList);
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
    public void generate(Scanner sc) {

    }

    @Override
    public void ReadData(String file) {
        List<Booking> LoadedList = null;
        try {
            FileInputStream FileInput = new FileInputStream(file);
            ObjectInputStream InputStream = new ObjectInputStream(FileInput);
            LoadedList = (List<Booking>) InputStream.readObject();
            InputStream.close();
            FileInput.close();
            LoadData(LoadedList);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<Booking> getAll() {
        return (booking0fList);
    }

    @Override
    public boolean delete(int ID) {
        for(Booking booking: booking0fList){
            if(booking.ID==ID){
                booking0fList.remove(booking);
                return true;
            }
        }
        return false;
    }


    @Override
    public void save(Booking item) {
        if (booking0fList != null) {
            if (booking0fList.contains(item)) {
                booking0fList.set(booking0fList.indexOf(item), item);
            } else {
                booking0fList.add(item);
                System.out.println("Booking already saved");
            }
        }

    }

    @Override
    public Booking get(int ID) {
        return booking0fList.get((booking0fList.indexOf(ID)));
    }

    @Override
    public void LoadData(List<Booking> list) {
        if (booking0fList != null) {
            booking0fList.forEach(this::save);
        }

    }
}
