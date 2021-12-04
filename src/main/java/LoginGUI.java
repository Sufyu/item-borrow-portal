import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LoginGUI {
    private Scanner input;
    private LoginController cont;
    private BufferedWriter writer;
    public LoginGUI(Scanner s, LoginController lc) throws IOException {
        input = s;
        cont = lc;
    }

    public String run() throws IOException {
        while(true) {
            FileWriter hold = new FileWriter(new File("active.txt"));
            writer = new BufferedWriter(hold);
            System.out.println("Enter your username and password. \n");
            String u = input.nextLine();
            String p = input.nextLine();
            if (cont.validateUser(u, p)) {
                cont.setActiveUser(u);
                writer.write(u);
                writer.close();
                return "Home";
            }
            else{
                System.out.println("Invalid credentials");
            }
        }
    }
}
