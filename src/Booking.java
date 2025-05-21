import java.util.UUID;

public class Booking {

    private User bookedBy;
    private Train train;
    private String bookingId;
    private int pricePaid;
    private char allotedSection;
    private int allotedSeat;

    public Booking(User user, Train train, int price, char allotedSection, int allotedSeat) {
        this.bookingId = (UUID.randomUUID()).toString();
        this.train = train;
        this.pricePaid = price;
        this.allotedSection = allotedSection;
       this.allotedSeat = allotedSeat;
       this.bookedBy = user;
    }

    public Train getTrain() {
        return this.train;
    }

    public Ticket getTicket() {
        return new Ticket(this.bookedBy, this.train, this.allotedSection, this.allotedSeat);
    }

    public Character getSection() {
        return this.allotedSection;
    }

    public Integer getAllotedSeat() {
        return this.allotedSeat;
    }

    public void setAllotedSeat(Integer allotedSeat) {
        this.allotedSeat = allotedSeat;
    }

    public  void setAllotedSection(Character section) {
        this.allotedSection = section;
    }

    public String getUserDetails() {
        return this.bookedBy.firstName + " " + this.bookedBy.lastName;
    }

}
