package ConsoleApp;

public class User {
    private UserController user = new UserController();

    public void setUser(UserController user) {
        this.user = user;
    }

    public UserController getUser() {
        return user;
    }
}
