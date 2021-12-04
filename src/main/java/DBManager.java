import java.util.ArrayList;

public class DBManager {
    ArrayList<UserAcct> users = new ArrayList();
    void addUser(UserAcct u){
        users.add(u);
    }

    UserAcct getUserName(String n){
        for(int i = 0; i < users.size(); i++){
            if(users.get(i).getUsername().equals(n)){
                return users.get(i);
            }
        }
        return null;
    }

    ArrayList<UserAcct> getUsers() { return users; }
}
