package Users;


import DAO.DAO;
import Users.Users;
import Users.User_DAO;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class UserDAO implements User_DAO<Users> {

    private List<Users> users = new ArrayList<>();

    public UserDAO(List<Users> users) {
        this.users = users;
    }


    public UserDAO() {

    }


    @Override
    public void SaveData(String file) {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(users);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void LoadData(List<Users> list) {

        if (users != null) {
            users.forEach(this::save);
        }

    }

    @Override
    public void ReadData(String file) {

        List<Users> ListLoaded = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            ListLoaded = (List<Users>) objectInputStream.readObject();
            LoadData(ListLoaded);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void save(Users item) {
        if (item.equals(null)) {

            throw new NullPointerException();
        } else if (this.users.contains(item)) {

            users.set(users.indexOf(item), item);
        } else {

            Users user = new Users(item.getName(), item.getPassword());

            users.add(item);
        }

    }

    @Override
    public Users get(int ID) {

        if (this.users == null || ID < 0 || ID > this.users.size()) {

            throw new IllegalArgumentException("Something went wrong");

        } else {
            return this.users.get(ID);
        }
    }

    @Override
    public List<Users> getAll() {

        return this.users;
    }


    @Override
    public boolean delete(int ID) {
        if (this.users == null || ID < 0 || ID > this.users.size()) {

            throw new IllegalArgumentException("Something went wrong");

        } else {
            this.users.remove(ID);
            return true;
        }
    }

}
