import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;

public class AvailableItemsGUI {
    Scanner input;
    FileReader active;
    DBManager dbm;

    public AvailableItemsGUI(Scanner s, DBManager db) throws FileNotFoundException {
        input = s;
        active = new FileReader("active.txt");
        dbm = db;
    }

    public String run() throws IOException {
        active = new FileReader("active.txt");
        BufferedReader read = new BufferedReader(active);
        String activeU = read.readLine();
        ArrayList<UserAcct> users = dbm.getUsers();
        int hold = 0;
        UserAcct holdUsr;
        for(int i = 0; i < users.size(); i++){
            holdUsr = users.get(i);
            if(!(holdUsr.getUsername().equals(activeU))){
                ArrayList<Item> userListings = holdUsr.getListed();
                for(int j = 0; j < userListings.size(); j++) {
                    hold++;
                    System.out.println((hold) + ":   " + userListings.get(j).getName());
                    System.out.println(userListings.get(j).getDescription());
                    System.out.println(userListings.get(j).getPrice());
                    System.out.println(userListings.get(j).getLocation());
                    System.out.println("");
                }
            }
        }
        return "Home";
    }
}