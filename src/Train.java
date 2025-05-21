import java.util.*;

public class Train {
    public static final int MAX_SEATS_PER_SECTION = 50;
    private String id;
    private String source;
    private String destination;
    private HashMap<Character, HashSet<Integer>> availableSeatsPerSection;
    private Integer ticketPrice;

    public Train(Integer price, String source, String destination) {
        this.id = UUID.randomUUID().toString();
        this.ticketPrice = price;
        this.source = source;
        this.destination = destination;
        this.availableSeatsPerSection = new HashMap<>(){{put('A', new HashSet<>()); put('B', new HashSet<>());}};
        for (HashSet<Integer> seats : availableSeatsPerSection.values()) {
            for (int i=0; i < MAX_SEATS_PER_SECTION; i++) {
                seats.add(i);
            }
        }
    }

    public String getId() {
        return this.id;
    }

    public  String getSource() {
        return this.source;
    }

    public  String getDestination() {
        return this.destination;
    }

    public HashMap<Character, HashSet<Integer>> getAvailableSeatsPerSection() {
        return this.availableSeatsPerSection;
    }

    public Integer getTicketPrice() {
        return this.ticketPrice;
    }

}
