package Users;

import Enums.Gender;

public class Users  {
    private int UserId;
    private String UserName;
    private String password;
    private String name;
    private String surname;
    private int date0fBirth;
    private Gender gender;

    public Users(String userName, String password) {
        this.password=password;
        this.UserName=userName;
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


    public void setDate0fBirth(int date0fBirth) {
        this.date0fBirth = date0fBirth;
    }

      public int getDate0fBirth() {
        return date0fBirth;
    }

      public void setGender(Gender gender) {
        this.gender = gender;
    }


    public Gender getGender() {
        return gender;
    }

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


   public Users(int UserID, String UserName, String password){
       this.UserId=UserID;
       this.UserName=UserName;
       this.password=password;
   }

    @Override
    public String toString() {
        return new StringBuilder().append("User{").append(" User ID: ").append(UserId).append(" User Name: ").
                append(UserName).append(" Password:").
                append(password).append(" Name: ").append("}").
                toString();
    }
}
