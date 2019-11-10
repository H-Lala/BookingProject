package Booking;

import Enums.Gender;

import java.io.Serializable;

public abstract class Person implements Serializable {
    private String name;
    private String surname;
    private int date0fBirth;
    private Gender gender;

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setDate0fBirth(int date0fBirth) {
        this.date0fBirth = date0fBirth;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public Gender getGender() {
        return gender;
    }

    public Person(String name, String surname, int date0fBirth, Gender gender) {
        this.name = name;
        this.surname = surname;
        this.date0fBirth = date0fBirth;
        this.gender = gender;
    }

    @Override
    public String toString() {
        return
                String.format("Person{Name: %sSurname: %sBirth Date: %dGender: %s", name, surname, date0fBirth, gender);
    }
}
