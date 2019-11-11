package Users;

import Enums.Gender;

public class Users {
    private String UserName;
    private String password;
    private String name;
    private String surname;
    private Gender gender;

    public Users(String name, String password) {
        this.password = password;
        this.name = name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSurname() {
        return surname;
    }


    public void setGender(Gender gender) {
        this.gender = gender;
    }


    public Gender getGender() {
        return gender;
    }


    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }


    public Users(String name, String surname, String password,Gender gender) {
        this.name=name;
        this.surname = surname;
        this.password = password;
        this.gender=gender;
    }

    @Override
    public String toString() {
        return new StringBuilder().append("User{").append(" Name: ").append(name).append(" Surname: ").
                append(surname).append(" Password:").
                append(password).append(" Name: ").append("}").
                toString();
    }
}
