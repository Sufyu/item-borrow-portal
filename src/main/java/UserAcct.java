import java.util.ArrayList;

public class UserAcct {
    private String username;
    private String password;
    private String email;
    private long phone;
    private ArrayList<Item> listed = new ArrayList();

    public UserAcct(String un, String pw, String em, long ph) {
        username = un;
        password = pw;
        email = em;
        phone = ph;
    }

    public String getUsername(){
        return username;
    }

    public boolean validPassword(String p){
        return (password.equals(p));
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    public void addItem(Item i) { listed.add(i); }

    public void removeItem(Item i) { listed.remove(i); }

    public ArrayList<Item> getListed() {
        return listed;
    }
}
