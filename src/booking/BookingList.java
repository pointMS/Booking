package booking;

import java.util.Comparator;

public interface BookingList {
    void add(Booking booking);
    int size();
    void print();

    Booking[] getSortedArray(Comparator<Booking> comparator);

//    Booking getBookingByIndex(int index);
//    Booking findBooking (Booking booking);
}
