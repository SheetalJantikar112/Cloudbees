import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.UUID;

public class User {

    public String firstName;
    public String lastName;
    private String emailAddress;
    public String id;
    private HashMap<Train, Pair<Character, Integer>> bookings;

    public User(String fname, String lname, String emailId) {
        this.id = UUID.randomUUID().toString();
        this.firstName = fname;
        this.lastName = lname;
        this.emailAddress = emailId;
        this.bookings = new HashMap<>();
    }
}
