package ConsoleApp;

import Booking.BookingController;
import Enums.Gender;
import Users.Users;
import Users.UserController;
import Users.UserDAO;

import java.util.Scanner;

public class MainMenu {


    private static UserController userController = new UserController();
    private static BookingController bookingController = new BookingController();

    //FlightController flightController = new FlightController();
    public static void MainMenu() {
        System.out.printf(
                "1.Online Board\n"
                        + "2.Show the Flight Info\n"
                        + "3.Search and Book a flight\n"
                        + "4.Booking \n"
                        + "6.Cancel booking"
                        + "7.My Flights\n"
                        + "8.Exit\n"

        );

    }

    public static void main(String[] args) {
        login();
        register();
        userByReg();

        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.printf("Welcome, Please choose your operation from menu\n");
        MainMenu();
        System.out.println("Enter your choice");
        choice = sc.nextLine();
        CommandList command = CommandParser.Parse(choice);
        do {
            switch (command) {
                case OnlineBoard:
                    //
                    break;
                case ShowTheFlightInfo:
                    //
                    break;
                case SearchFlight:

                    break;
                case BookFlight:
                    break;
                case CancelBooking:
                    break;
                case MyFlights:
                    break;
                case Help:
                    break;
                case Exits:
                    System.exit(0);
                    break;
            }
            break;

        } while (true);
    }

    private static void login() {
        System.out.println("Welcome! Do You have an acoount or not?");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        switch (s.toLowerCase()){
            case "yes":
                userByReg();break;
            case "no":
                register(); break;
            default:
                throw new IllegalArgumentException("Wrong answer");

        }
    }

    private static void userByReg() {
        Scanner sc = new Scanner(System.in);
        System.out.println( "Please enter your information");
        String UserName, password;
        System.out.println("User Name");
        UserName = sc.nextLine();
        System.out.println("Enter your password");
        password = sc.nextLine();
        try {
            userController.userByReg(UserName, password);

        } catch (Exception e) {
            System.out.println("Wrong name or password");
            userByReg();
        }
    }

    private static void register() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please, enter your information");
        String name, surname, password;
        Gender gender = Gender.Female;
        System.out.println("Enter your name");
        name = sc.nextLine();
       // System.out.println("Enter your surname");
        //surname = sc.nextLine();
        System.out.println("Enter your password");
        password = sc.nextLine();
        Users NewUser = new Users(name, password);
        userController.save(NewUser);
    }
}
