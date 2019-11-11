package Users;


import java.util.List;

public class UserController {
    private UserService userService;

    public UserController() {
        userService = new UserService();
    }

    public UserService getUserService() {
        return userService;

    }

    public List<Users> getAllUsers() {
        return userService.getAllUsers();
    }

    public void showUsers() {
        userService.getAllUsers().forEach(System.out::println);
    }

    public void save(Users item) {
        userService.Save(item);
    }

    public void SaveData(String file) {
        userService.SaveData(file);
    }

    public void ReadData(String file) {
        userService.ReadData(file);
    }

    public void delete(int ID) {
        userService.delete(ID);
    }

    public int counts() {
        return userService.getAllUsers().size();
    }

    public Users userById(int ID) {
        if (ID < 0 || ID > this.userService.getAllUsers().size()) {
            throw new IllegalArgumentException("Invalid ID");
        } else {
            return userService.getAllUsers().get(ID);
        }
    }

    public Users userByReg(String UserName, String password) {
        return userService.getAllUsers().stream().filter(
                users -> (users.getUserName().equalsIgnoreCase(UserName) && users.getPassword().equals(password))
        ).findAny().orElse(null);
    }


}
