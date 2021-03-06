package Users;


import DAO.DAO;

import java.util.List;

public class UserService {
    private User_DAO<Users> userDAO = new UserDAO();

    public User_DAO getUserDAO() {
        return userDAO;
    }

    public List<Users> getAllUsers() {
        return userDAO.getAll();
    }

    public void showUsers() {
        userDAO.getAll().forEach(System.out::println);
    }

    public void save(Users users) {

        if (users.getName() != "" && users.getPassword() != "") {
            userDAO.save(users);
        } else {
            new IllegalArgumentException();
        }

    }

    public void delete(int ID) {
        userDAO.delete(ID);
    }

    public void SaveData(String file) {
        userDAO.SaveData(file);
    }

    public void ReadData(String file) {
        userDAO.ReadData(file);
    }

    public int counts() {
        return userDAO.getAll().size();
    }

    public Users usersById(int ID) {
        if (ID < 0 || ID > this.userDAO.getAll().size()) {
            throw new IllegalArgumentException("Invalid ID");
        } else {
            return userDAO.get(ID);
        }
    }

    public Users usersByReg(String UserName, String password) {
        return userDAO.getAll().stream().filter(user -> (user.getUserName().equalsIgnoreCase(UserName) &&
                user.getPassword().equals(password))).findAny()
                .orElse(null);
    }
}
