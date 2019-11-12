package ConsoleApp;

import java.io.*;

public class FileIO {
    File FiLe = new File("/.data","FlightDatabase.txt");
    BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(FiLe));


    public FileIO() throws IOException {
    }
}
