public class LoginController {
    DBManager db;
    UserAcct active = null;
    public LoginController(DBManager dbm){
        db = dbm;
    }

    void addUser(UserAcct u){
        db.addUser(u);
    }

    boolean validateUser(String u, String p){
        UserAcct hold = db.getUserName(u);
        if(hold == null)
            return false;
        if(hold.validPassword(p))
            return true;
        else
            return false;
    }

    void setActiveUser(String user){
        active = db.getUserName(user);
    }

    UserAcct getActive(){
        return active;
    }
}
