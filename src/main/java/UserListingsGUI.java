import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;

public class UserListingsGUI {
    Scanner input;
    FileReader active;
    ItemListingController ilc;
    DBManager dbm;
    public UserListingsGUI(Scanner s, ItemListingController itemControl, DBManager db) throws FileNotFoundException {
        input = s;
        active = new FileReader("active.txt");
        dbm = db;
        ilc = itemControl;
    }

    public String run() throws IOException {
        active = new FileReader("active.txt");
        BufferedReader read = new BufferedReader(active);
        String activeU = read.readLine();
        ilc.setActive(activeU);
        ArrayList<Item> userListings = ilc.getItemList();
        for(int i = 0; i < userListings.size(); i++){
            System.out.println((i + 1) + ":   " + userListings.get(i).getName());
            System.out.println(userListings.get(i).getDescription());
            System.out.println(userListings.get(i).getPrice());
            System.out.println(userListings.get(i).getLocation());
            System.out.println("");
        }
        while(true) {
            System.out.println("Would you like to update any of your listings?\nIf so, type the number of the listing you would like to edit.\nType the negative number to remove a listing. Press 0 to return home.");
            String userIn = input.nextLine();
            if (userIn.equals("0")) {
                return ("Home");
            }
            int userInt = 0;
            try {
                userInt = Integer.parseInt(userIn);
            }
            catch(Exception E){
                System.out.println("invalid input");
            }
            if (userInt <= userListings.size() && userInt > 0) {
                int itemNum = userInt - 1;
                System.out.println("Enter the new values for your listing. Leave blank if you wish to keep the value the same. Press 1 at any time to return to item listing page.");
                String name = userListings.get(itemNum).getName();
                String desc = userListings.get(itemNum).getDescription();
                float price = userListings.get(itemNum).getPrice();
                String location = userListings.get(itemNum).getLocation();
                while (true) {
                    System.out.print("Item Name: ");
                    userIn = input.nextLine();
                    if (userIn.equals("1")) {
                        return "UserListings";
                    } else if (userIn.equals("")) {
                        break;
                    } else {
                        name = userIn;
                        break;
                    }
                }

                while (true) {
                    System.out.print("Item Description: ");
                    userIn = input.nextLine();
                    if (userIn.equals("1")) {
                        return "UserListings";
                    } else if (userIn.equals("")) {
                        break;
                    } else {
                        desc = userIn;
                        break;
                    }
                }

                while (true) {
                    System.out.print("Item Price: (enter 0 to auction it) ");
                    userIn = input.nextLine();
                    try {
                        price = Float.valueOf(userIn);
                        break;
                    } catch (Exception e) {
                        if (userIn.equals("")) {
                            break;
                        }
                        System.out.println("please enter a number");
                    }
                }

                while (true) {
                    System.out.print("Your Location: ");
                    userIn = input.nextLine();
                    if (userIn.equals("1")) {
                        return "UserListings";
                    } else if (userIn.equals("")) {
                        break;
                    } else {
                        location = userIn;
                        break;
                    }
                }
                userListings.get(itemNum).setName(name);
                userListings.get(itemNum).setDescription(desc);
                userListings.get(itemNum).setPrice(price);
                userListings.get(itemNum).setLocation(location);
                return "UserListings";
            }
            else if(userInt >= (-1 * userListings.size()) && userInt < 0){
                ilc.unlistItem(userListings.get((userInt + 1) * -1));
            }
        }
    }
}
