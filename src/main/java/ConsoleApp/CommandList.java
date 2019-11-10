package ConsoleApp;

public enum CommandList {
    OnlineBoard,
    ShowTheFlightInfo,
    SearchFlight,
    BookFlight,
    CancelBooking,
    MyFlights,
    Help,
    Exits;

    public static CommandList valueOf(int i) {
        return CommandList.valueOf(i);
    }


}
