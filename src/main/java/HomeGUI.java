import java.io.*;
import java.util.Scanner;

public class HomeGUI {
    Scanner input;
    FileReader active;
    DBManager dbm;
    public HomeGUI(Scanner s, DBManager db) throws FileNotFoundException {
        input = s;
        active = new FileReader("active.txt");
        dbm = db;
    }

    public String run() throws IOException {
        active = new FileReader("active.txt");
        BufferedReader read = new BufferedReader(active);
        String activeU = read.readLine();

        while(activeU == null) {
            System.out.println("This is the home page. Press 1 to login     (The available user is username: user, password: pass\n");
            String userIn = input.nextLine();
            if (userIn.equals("1")) {
                return "Login";
            }
        }

        while(true){
            System.out.println("This is the home page. You are logged in as " + activeU + ". Press 1 to list an item, Press 2 to show your listed items. Press 3 to show items available for purchase. Press 4 to logout.\n");
            String userIn = input.nextLine();
            if (userIn.equals("1")) {
                return "ListItem";
            }
            if (userIn.equals("2")) {
                //System.out.println(dbm.getUserName(activeU).getListed().toString());
                return "UserListings";
            }
            if (userIn.equals("3")) {
                return "AvailableItems";
            }
            if (userIn.equals("4")) {
                File active = new File("active.txt");
                active.createNewFile();
                FileWriter fw = new FileWriter(active);
                BufferedWriter out = new BufferedWriter(fw);
                out.close();
                fw.close();
                return "Home";
            }
        }
    }
}
