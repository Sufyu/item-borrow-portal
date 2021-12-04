import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class ItemListingController {
    DBManager db;
    UserAcct active;
    public ItemListingController(DBManager dbm, String username) throws IOException {
        db = dbm;
        active = db.getUserName(username);
    }

    public void setActive(String username){
        active = db.getUserName(username);
    }

    public boolean listItem(String name, String desc, float price, String location){
        if(name == "")
            return false;
        if(price < 0)
            return false;
        if(location == "")
            return false;
        Item add = new Item(name, desc, price, location);
        active.addItem(add);
        return true;
    }

    public void unlistItem(Item unlist){
        active.removeItem(unlist);
    }

    public ArrayList<Item> getItemList(){
        return(active.getListed());
    }
}
