package ConsoleApp;

import Booking.Booking;
import Booking.BookingController;
import Enums.Gender;
import Flights.FlightController;
import Users.Users;
import Users.ByUs;
import Users.UserController;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class MainMenu {


    private static UserController userController = new UserController();
    private static BookingController bookingController = new BookingController();
    private static FlightController flightController = new FlightController();

    public static void MainMenu() {
        System.out.printf(
                "1.Online Board\n"
                        + "2.Show the Flight Info\n"
                        + "3.Search flight\n"
                        + "4.Booking \n"
                        + "5.Cancel booking\n"
                        + "6.My Flights\n"
                        + "7.Help\n"
                        + "8.Exit\n"

        );

    }

    public static void main(String[] args) throws FileNotFoundException {
        RandomIDGenerator rand=new RandomIDGenerator();
        ByUs.Message();
        FlightsfromFile();
        login();
        Scanner sc = new Scanner(System.in);
        String choice;
        System.out.printf("Welcome, Please choose your operation from menu\n");
        MainMenu();
        do {
            System.out.println("Enter your choice");
            choice = sc.nextLine();
            CommandList command = CommandParser.Parse(choice);
            switch (command) {
                case OnlineBoard:
                    flightController.showAllFlights();
                    break;
                case ShowTheFlightInfo:
                    System.out.println("Enter the ID of the flight:");
                    int Id = sc.nextInt();
                    System.out.println(flightController.getFlightByID(Id));
                    break;
                case SearchFlight:
                    System.out.println("Enter the destination, Departure time( in the format 'dd/mm/yyyy hh:mm')"
                            + "and number of passengers");
                    String Destination = sc.nextLine();
                    String DepartureTime = sc.nextLine();
                    int numOfPassengers = sc.nextInt();
                    flightController.showRequestedFlights(Destination, DepartureTime, numOfPassengers);
                    break;
                case BookFlight:
                    System.out.println("Please enter destinations");
                    String destination = sc.nextLine();
                    System.out.println("Please, enter counts of tickets");
                    int tickets = sc.nextInt();
                    Booking NewBooking = new Booking(rand.generate_random(),destination, tickets);
                    bookingController.save(NewBooking);
                    break;
                case CancelBooking:
                    System.out.println("Please enter ID of booking");
                    int ID = sc.nextInt();
                    bookingController.delete(ID);
                    System.out.println("Deleted successfully!");
                    break;
                case MyFlights:
                    System.out.println(bookingController.getAllBookings());
                    break;
                case Help:
                    System.out.println("How can I help you?");
                    break;
                case Exits:
                    System.exit(0);
                    break;
            }
            MainMenu();
            choice = sc.nextLine();

        } while (true);
    }

    private static void login() {
        System.out.println("Welcome! Do You have an acoount or not?");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        switch (s.toLowerCase()) {
            case "yes":
                userByReg();
                break;
            case "no":
                register();
                break;
            default:
                throw new IllegalArgumentException("Wrong answer");

        }
    }

    private static void userByReg() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter your information");
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
        System.out.println("Enter your password");
        password = sc.nextLine();
        Users NewUser = new Users(name, password);
        userController.save(NewUser);

    }

    public static void FlightsfromFile() throws FileNotFoundException {
        Scanner sc = new Scanner(new FileReader("C:/Users/User/IdeaProjects/BookingProject/src/main/java/Flights/FlightDatabase.txt"));
        flightController.generate(sc);
    }


}
