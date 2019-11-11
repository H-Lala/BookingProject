package ConsoleApp;

import java.util.Scanner;

public class Console {
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
                    break;
                case ShowTheFlightInfo:
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
}
