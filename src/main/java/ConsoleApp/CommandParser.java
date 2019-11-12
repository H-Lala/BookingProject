package ConsoleApp;

public class CommandParser {
  public static   CommandList[] commands = CommandList.values();

   public  static CommandList Parse(String x) {
       switch (x){
           case "1":
               return commands[0]; //Online Board
           case "2":
               return commands[1]; //Show the Flight info
           case "3":
               return commands[2]; //Search flight
           case "4":
               return commands[3];//Book Flight
           case "5":
               return commands[4];//Cancel Booking
           case "6":
               return commands[5]; //My Flights
           case "7":
               return commands[6]; //Help
           case "8":
               return commands[7]; //Exit
           default:
               throw new IllegalArgumentException("This operation doesn't exist");
       }
   }

}
