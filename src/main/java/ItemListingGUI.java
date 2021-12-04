import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

public class ItemListingGUI {
    Scanner input;
    ItemListingController ic;
    public ItemListingGUI(Scanner s, ItemListingController iController, DBManager dbm) throws IOException {
        ic = iController;
        input = s;
    }

    public String run() throws IOException {
        String name;
        String desc;
        float price;
        String location = null;

        System.out.println("To list an item, please enter the following information. Press 1 at any time to leave this page.");

        String userIn;
        while(true){
            System.out.print("Item Name: ");
            userIn = input.nextLine();
            if (userIn.equals("1")) {
                return "Home";
            }
            else if(userIn.equals("")){
                System.out.println("please enter a name");
            }
            else {
                name = userIn;
                break;
            }
        }

        while(true){
            System.out.print("Item Description: ");
            userIn = input.nextLine();
            if (userIn.equals("1")) {
                return "Home";
            }
            else if(userIn.equals("")){
                System.out.println("please enter a description");
            }
            else {
                desc = userIn;
                break;
            }
        }

        float priceIn = 0;
        while(true){
            System.out.print("Item Price: (enter 0 to auction it) ");
            try {
                priceIn = input.nextFloat();
                userIn = input.nextLine();
            }
            catch(Exception e){
                System.out.println("please enter a number");
            }

            price = priceIn;
            break;
        }

        while(true){
            System.out.print("Your Location: ");
            userIn = input.nextLine();
            if (userIn.equals("1")) {
                return "Home";
            }
            else if(userIn.equals("")){
                System.out.println("please enter a location");
            }
            else {
                location = userIn;
                break;
            }
        }

        ic.listItem(name, desc, price, location);
        return "Home";
    }
}