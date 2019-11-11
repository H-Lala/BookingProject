package ConsoleApp;

import Booking.Person;
import Enums.Gender;

public class Users extends Person {
    private int UserId;
    private String UserName;
    private String password;


    public void setUserId(int userId) {
        UserId = userId;
    }

    public int getUserId() {
        return UserId;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserName() {
        return UserName;
    }

    public void setPassword(    String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

   public Users(int UserID, String UserName, String password, String name , String surname, int date0fbirth, Gender gender){
       super(name,surname,date0fbirth,gender);
       this.UserId=UserID;
       this.UserName=UserName;
       this.password=password;
   }

    @Override
    public String toString() {
        return new StringBuilder().append("User{").append(" User ID: ").append(UserId).append(" User Name: ").
                append(UserName).append(" Password:").
                append(password).append(" Name: ").
                append(getName()).append("Surname:").append(getSurname()).
                append("Birth Date:").append(getDate0fBirth()).append("Gender:").append(getGender()).append("}").
                toString();
    }
}
