package ConsoleApp;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class FileIO {
    FileOutputStream fileOutputStream;

    {
        try {
            fileOutputStream = new FileOutputStream("C:\\Users\\User\\IdeaProjects\\BookingProject");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


}
