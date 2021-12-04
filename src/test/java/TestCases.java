import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;

import static org.junit.jupiter.api.Assertions.*;

class TestCases {
    @Test
    void testUC1(){
        DBManager db = new DBManager();
        LoginController lc = new LoginController(db);
        UserAcct testUser = new UserAcct("User", "P4ssword", "x@mail.com", 1234567890);
        lc.addUser(testUser);
        assertTrue(lc.validateUser("User", "P4ssword"));
        assertFalse(lc.validateUser("invalid user", "P4ssword"));
        assertFalse(lc.validateUser("User", "invalid pass"));
    }
/*
    @Test
    void testUC2(){
        DBManager db = new DBManager();
        UserAcctController uc = new UserAcctController(db);
        UserAcct testUser = new UserAcct("User", "P4ssword", "x@mail.com", 1234567890);
        UserAcct otherUser = new UserAcct("Used", "P4ssword", "x@mail.com", 1234567890);
        //uc.setActive(testUser);    something like this?
        db.addUser(testUser);
        assertTrue(uc.editAcct("User1", "p4ssw0RD", "y@mail.com", 1111111111));
        assertFalse(uc.editAcct("", "p4ssw0RD", "y@mail.com", 1111111111));
        assertFalse(uc.editAcct("User1", "p4ssw0RD", "y@mail.com", 123));
        assertFalse(uc.editAcct("User1", "p4ssw0RD", "y", 1111111111));
        assertFalse(uc.editAcct("User1", "p", "y@mail.com", 1111111111));
        //assertFalse(uc.editAcct("Used", "p4ssw0RD", "y@mail.com", 1111111111));  Once we finalize the 'active user' thing

    }
*/
    @Test
    void testUC3() throws IOException {
        DBManager db = new DBManager();
        UserAcct testUser = new UserAcct("user", "P4ssword", "x@mail.com", 1234567890);
        ItemListingController cc = new ItemListingController(db, "user");
        db.addUser(testUser);
        cc.setActive("user");
        assertTrue(cc.listItem("Vacuum", "something", 10, "222 Main Street"));
        assertFalse(cc.listItem("Leafblower", "something", 11, ""));
        assertTrue(cc.listItem("Edge trimmer", "something", 0, "333 East Avenue"));
        assertFalse(cc.listItem("Wagon", "something", 0, ""));
        assertTrue(cc.listItem("Lawnmower", "", 15, "444 Coastal Boulevard"));
        assertFalse(cc.listItem("", "something", 100, "555 Culverton Street"));
    }

    @Test
    void testUC4() throws IOException {
        DBManager db = new DBManager();
        UserAcct testUser = new UserAcct("User", "P4ssword", "x@mail.com", 1234567890);
        db.addUser(testUser);
        ItemListingController ic = new ItemListingController(db, "User");
        //cc.setActive(testUser);
        ic.listItem("Vacuum", "something", 10, "222 Main Street");
        ic.listItem("Edge trimmer", "something", 0, "333 East Avenue");
        Item testItem = new Item("Lawnmower", "", 15, "444 Coastal Boulevard");
        ArrayList<Item> hold = new ArrayList<Item>();
        hold.add(ic.getItemList().get(0));
        hold.add(ic.getItemList().get(1)); //hold is now equal to the Database Stored items for the User
        assertNotNull(hold);
        ic.unlistItem(testItem); //not an item in the user's listings, so no removal should occur
        assertEquals(hold, ic.getItemList());
        ic.unlistItem(hold.get(0)); //A listed item should be removed, so the users listings should now be different from hold
        assertNotEquals(hold, ic.getItemList());
    }

    @Test
    void testUC5(){

    }
/*
    @Test
    void testUC6(){
        DBManager db = new DBManager();
        UserAcct sellerUser = new UserAcct("User", "P4ssword", "x@mail.com", 1234567890);
        UserAcct revUser = new UserAcct("User2", "P4ssword", "x@mail.com", 1234567890);
        db.addUser(sellerUser);
        ReviewController rc = new ReviewController(db, sellerUser);
        //rc.setActive(revUser);

        assertNotNull(rc.reviewUser("not good", 3));
        assertNotNull(rc.reviewUser("", 5));
        assertNull(rc.reviewUser("pretty bad", null));
    }

    @Test
    void testUC7(){
        DBManager db = new DBManager();
        UserAcct sellerUser = new UserAcct("User", "P4ssword", "x@mail.com", 1234567890);
        UserAcct revUser = new UserAcct("User2", "P4ssword", "x@mail.com", 1234567890);
        db.addUser(sellerUser);
        ReviewController rc = new ReviewController(db, sellerUser);
        //rc.setActive(revUser);
        rc.reviewUser("not good", 3);

        //rc.setActive(sellerUser);   //Now essentially we are on the same page but the seller is logged in

        assertNotNull(rc.comment(rc.getReviewsList.get(0), "you didn't even show up to get the product"));
        assertNull(rc.comment(rc.getReviewsList.get(0), ""));
    }

    @Test
    void testUC8(){
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, 2024);
        cal.set(Calendar.MONTH, 8);
        Date d = cal.getTime();

        Payment p = new Payment();
        CreditCard c = new CreditCard(1111222233334444, d, 75252);

        AssertTrue(p.validatePayment(c));

        c = new CreditCard(1, d, 75252);
        assertFalse(p.validatePayment(c));

        c = new CreditCard(1111222233334444, d, null);
        assertFalse(p.validatePayment(c));

        c = new CreditCard(1111222233334444, null 75252);
        assertFalse(p.validatePayment(c));
    }*/

}