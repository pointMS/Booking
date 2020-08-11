package booking;

/**
 * Booking 04.08.2020
 */
public interface BookingList {
    void add(Booking booking);
    int size();
    void print();
    Booking getBookingByIndex(int index);
    Booking findBooking (Booking booking);

}
