package Booking;

import Enums.Gender;

import java.io.Serializable;

public class Passenger extends Person implements Serializable {

    private int ID;

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getID() {
        return ID;

    }


    public Passenger(String name, String surname, int date0fBirth, Gender gender, int ID) {
        super(name, surname, date0fBirth, gender);
        this.ID=ID;
    }

    @Override
    public String toString() {
        return
                String.format("Passenger{Name: %sSurname: %sGender: %sID: %d}", super.getName(),
                        super.getSurname(), super.getGender(), ID);
    }
}
