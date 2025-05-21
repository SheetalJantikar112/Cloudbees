public class Ticket {

    private User user;
    private String source;
    private String destination;
    private Integer seatNumber;
    private Integer price;
    private Character section;

    public Ticket(User user, Train train, Character section, Integer seatNumber) {
        this.user = user;
        this.source = train.getSource();
        this.destination = train.getDestination();
        this.seatNumber = seatNumber;
        this.price = train.getTicketPrice();
        this.section = section;
    }

    public  void printDetails() {
        System.out.println("Source: " + source);
        System.out.println("Destination: " + destination);
        System.out.println("User: " + user.firstName +" " + user.lastName);
        System.out.println("Price paid: " + this.price);

    }
}
