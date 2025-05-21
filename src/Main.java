import java.util.Optional;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.

        Train train = TrainBookingService.addTrain(20, "london", "france");
        User user1 = TrainBookingService.registerUser("Sheetal", "Jantikar", "sheetaljantikar@gmail.com");
        User user2 = TrainBookingService.registerUser("Shruthi", "Jantikar", "shruthijantikar@gmail.com");

        Optional<Booking> booking1 = TrainBookingService.submitBooking(train, user1, 20);
        Optional<Booking> booking2 = TrainBookingService.submitBooking(train, user2, 20);

        if(booking1.isPresent()) {
            booking1.get().getTicket().printDetails();
        }
        if (booking2.isPresent()) {
            booking2.get().getTicket().printDetails();
        }

        TrainBookingService.removeUser(booking2.get());
        Booking booking3 = TrainBookingService.modifyBooking(booking1.get(), 'B', 45);

        TrainBookingService.viewBookingsPerSection(train, 'A');
        TrainBookingService.viewBookingsPerSection(train, 'B');


    }
}