package Users;


import DAO.DAO;

import java.io.*;
import java.util.List;
import java.util.logging.Logger;

public class UserDAO implements DAO<Users> {
    private static Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    private List<Users> users;

    public UserDAO(List<Users> users) {
        this.users = users;
    }



    public UserDAO() {

    }


    @Override
    public void SaveData(String file) {
        logger.info("Saving information to file");
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
        logger.info("Loading info");
        if(users!=null){
            users.forEach(this::save);
        }

    }

    @Override
    public void ReadData(String file) {
        logger.info("Data from file");
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
        if (item == null) {
            logger.info("You are trying save null user");
            throw new NullPointerException();
        }
        if (this.users.contains(item)) {
            logger.info("Editing of user information");
            this.users.set(users.indexOf(item), item);
        } else {
            logger.info("Saving new user");
            this.users.add(item);
        }

    }

    @Override
    public Users get(int ID) {
        logger.info("User info by ID");
        if (this.users == null || ID < 0 || ID > this.users.size()) {
            logger.info("Invalid ID ");
            throw new IllegalArgumentException("Something went wrong");

        } else {
            return this.users.get(ID);
        }
    }

    @Override
    public List<Users> getAll() {
        logger.info("All users");
        return this.users;
    }

    @Override
    public boolean delete(int ID) {
        if (this.users == null || ID < 0 || ID > this.users.size()) {
            logger.info("Invalid ID");
            throw new IllegalArgumentException("Something went wrong");

        } else {
            this.users.remove(ID);
            return true;
        }
    }

}
