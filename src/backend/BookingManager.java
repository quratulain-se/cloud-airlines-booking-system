package backend;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    // Keeps a record of every booking made during this run of the program.
    // (No database yet, so this resets each time the app is restarted.)
    private static final List<Booking> bookings = new ArrayList<>();

    // The most recent booking - this is what SuccessPage's "Cancel Booking" acts on.
    private static Booking currentBooking;

    public static void bookFlight(Booking booking) {
        bookings.add(booking);
        currentBooking = booking;
    }

    public static void cancelBooking() {
        if (currentBooking != null) {
            bookings.remove(currentBooking);
            currentBooking = null;
        }
    }

    public static Booking getCurrentBooking() {
        return currentBooking;
    }

    public static List<Booking> getAllBookings() {
        return bookings;
    }
}