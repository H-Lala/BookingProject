package ConsoleApp;

import Booking.BookingController;
import Users.Users;
import Users.UserController;

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
                        + "4.Cancel the booking\n"
                        + "5.My Flights\n"
                        + "6.Exit\n"

        );

    }

    public static void main(String[] args) {

        register();
        login();

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

            }
            break;

        } while (true);
    }

    private static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Creating new user, please enter your information");
        String UserName, password;
        System.out.println("User Name");
        UserName = sc.nextLine();
        System.out.println("Enter your password");
        password = sc.nextLine();
        Users user = new Users(UserName, password);

        try {
            userController.login(user,password);

        }catch (Exception e){

        }
    }

    private static void register() {

    }
}
