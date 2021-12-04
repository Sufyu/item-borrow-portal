import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.BufferedWriter;

public class app {
    public static void main(String args[]) throws IOException {
        String page = "Home";
        String activeUserName = "";
        DBManager db = new DBManager();
        LoginController lc = new LoginController(db);
        ItemListingController ic = new ItemListingController(db, "active.txt");
        UserAcct test = new UserAcct("user", "pass", "test@mail.com", 1111111111);
        UserAcct test2 = new UserAcct("user2", "pass", "test2@mail.com", 1111111112);
        lc.addUser(test);
        lc.addUser(test2);
        Scanner s = new Scanner(System.in);

        File active = new File("active.txt");
        active.createNewFile();
        FileReader reader = new FileReader(active);
        BufferedReader bReader = new BufferedReader(reader);
        FileWriter fw = new FileWriter(active);
        BufferedWriter out = new BufferedWriter(fw);
        out.close();
        fw.close();

        HomeGUI homeGUI = new HomeGUI(s, db);
        LoginGUI loginGUI = new LoginGUI(s, lc);
        UserListingsGUI userListGUI = new UserListingsGUI(s, ic, db);
        ItemListingGUI itemListingGUI = new ItemListingGUI(s, ic, db);
        AvailableItemsGUI availableItemsGUI = new AvailableItemsGUI(s, db);
        AccountCreationGUI accountCreationGUI = new AccountCreationGUI(s, lc, db);
        while(true){
            reader = new FileReader(active);
            bReader.close();
            bReader = new BufferedReader(reader);
            activeUserName = bReader.readLine();
            ic.setActive(activeUserName);
            if (page.equals("Home")){
                page = homeGUI.run();
            }
            if(page.equals("Login")){
                page = loginGUI.run();
            }
            if(page.equals("ListItem")){
                page = itemListingGUI.run();
            }
            if(page.equals("UserListings")){
                page = userListGUI.run();
            }
            if(page.equals("AvailableItems")){
                page = availableItemsGUI.run();
            }
            if(page.equals("CreateAcc")){
                page = accountCreationGUI.run();
            }
        }
    }
}
