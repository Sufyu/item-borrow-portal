import java.io.BufferedReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.FileReader;

public class AccountCreationGUI {
    Scanner input;
    LoginController lc;
    DBManager db;
    public AccountCreationGUI(Scanner s, LoginController lController, DBManager dbm) throws IOException {
        lc = lController;
        input = s;
        db = dbm;
    }

    public String run() throws IOException {
        String name;
        String pass;
        long phone = 0;
        String email = null;

        System.out.println("To create an account, please enter the following information. Press 1 at any time to leave this page.");

        String userIn;
        while(true){
            System.out.print("Username: ");
            userIn = input.nextLine();
            if (userIn.equals("1")) {
                return "Home";
            }
            else if(userIn.equals("")){
                System.out.println("please enter a username");
            }
            else {
                name = userIn;
                break;
            }
        }

        while(true){
            System.out.print("Password: ");
            userIn = input.nextLine();
            if (userIn.equals("1")) {
                return "Home";
            }
            else if(userIn.equals("")){
                System.out.println("please enter a password");
            }
            else {
                pass = userIn;
                break;
            }
        }

        while(true){
            System.out.print("Email: ");
            userIn = input.nextLine();
            if (userIn.equals("1")) {
                return "Home";
            }
            else if(userIn.equals("")){
                System.out.println("please enter an email");
            }
            else {
                if(userIn.contains("@")) {
                    email = userIn;
                    break;
                }
                else{
                    System.out.println("a valid email must contain an @");
                }
            }
        }

        float priceIn = 0;
        while(true){
            System.out.print("Phone number: ");
            userIn = input.nextLine();
            try {
                phone = Long.valueOf(userIn);
                break;
            } catch (Exception e) {
                if (userIn.equals("")) {
                    break;
                }
                System.out.println("please enter a valid number");
            }
        }
        UserAcct newUser = new UserAcct(name, pass, email, phone);
        lc.addUser(newUser);
        return "Home";
    }
}