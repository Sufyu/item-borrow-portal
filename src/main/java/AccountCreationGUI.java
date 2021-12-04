import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AccountCreationGUI {
    private Scanner input;
    private LoginController cont;
    private BufferedWriter writer;
    public AccountCreationGUI(Scanner s, LoginController lc) throws IOException {
        input = s;
        cont = lc;
    }

    public String run() throws IOException {
        while (true) {
            FileWriter hold = new FileWriter(new File("active.txt"));
            writer = new BufferedWriter(hold);
            ;
        }
    }
}
