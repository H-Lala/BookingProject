package ConsoleApp;

public class RandomIDGenerator {
    int generate_random(){
        int ID=(int)(Math.random()*10000+100);
        return ID;
    }
}
