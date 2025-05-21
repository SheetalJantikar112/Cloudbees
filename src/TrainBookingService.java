import java.util.*;

public class TrainBookingService {

    private static Map<String, User> users = new HashMap<>();
    private static  Map<String, Train> trains = new HashMap<>();
    private static  Map<Train, List<Booking>> bookingsPerTrain = new HashMap<>();

    private TrainBookingService () {}


    public static User registerUser(String fname, String lname, String email) {
        User user = new User(fname, lname, email);
        users.put(user.id, user);
        return user;
    }

    public static  Train addTrain(Integer ticketPrice, String source, String destination) {
        Train train = new Train(ticketPrice, source, destination);
        trains.put(train.getId(), train);
        return train;
    }

    public static  Optional<Booking> submitBooking(Train train, User user, Integer pricePaid) {
        if(pricePaid >= train.getTicketPrice()) {
            for (Map.Entry<Character, HashSet<Integer>> section : train.getAvailableSeatsPerSection().entrySet()) {
                Iterator<Integer> seatIterator = section.getValue().iterator();
                if (seatIterator.hasNext()) {
                    int allotedSeat = seatIterator.next();
                    Booking booking = new Booking(user, train, pricePaid, section.getKey(), allotedSeat);
                    section.getValue().remove(allotedSeat);
                    if (bookingsPerTrain.containsKey(train)){
                        bookingsPerTrain.get(train).add(booking);
                    } else {
                        bookingsPerTrain.put(train, new ArrayList<>() {{add(booking);}});
                    }
                    return Optional.of(booking);
                }
            }
        }
        System.out.println("Booking unsuccessfull");
        return Optional.empty();
    }

    public static void removeUser(Booking booking) {
        Train train = booking.getTrain();
        bookingsPerTrain.get(train).remove(booking);
        // free up the seat in the train
        train.getAvailableSeatsPerSection().get(booking.getSection()).add(booking.getAllotedSeat());
        System.out.println("successfully removed User: " + booking.getUserDetails());
    }

    public static Booking modifyBooking(Booking booking, Character newSection, Integer newSeat) {
        Train train = booking.getTrain();
        if (newSeat > 0 && newSeat < train.MAX_SEATS_PER_SECTION && train.getAvailableSeatsPerSection().containsKey(newSection) &&
        train.getAvailableSeatsPerSection().get(newSection).contains(newSeat)) {
            Character allotedSection = booking.getSection();
            Integer allotedSeat = booking.getAllotedSeat();

            booking.setAllotedSection(newSection);
            booking.setAllotedSeat(newSeat);

            // free up old seat and reserve new seat in the seat map
            train.getAvailableSeatsPerSection().get(allotedSection).add(allotedSeat);
            train.getAvailableSeatsPerSection().get(newSection).remove(newSeat);

            System.out.println("Successfully modified booking");
        } else {
            System.out.println("Unable to modify booking");
        }
        return booking;
    }

    public static void viewBookingsPerSection(Train train, Character section) {
        if (train.getAvailableSeatsPerSection().containsKey(section)) {
            List<Booking> bookings = bookingsPerTrain.get(train);
            for (Booking booking : bookings) {
                if (booking.getSection().equals(section)) {
                    System.out.println("SeatNumber:" +" " + booking.getAllotedSeat());
                    System.out.println("User Details: " + booking.getUserDetails());
                    System.out.println(" ---------------------------");
                }
            }
        }
        System.out.println("Section not available");
    }

}
