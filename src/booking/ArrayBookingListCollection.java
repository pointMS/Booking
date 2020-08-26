package booking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ArrayBookingListCollection implements BookingList {
    ArrayList<Booking> bookings = new ArrayList<>();

    @Override
    public void add(Booking booking) {
        bookings.add(booking);
    }

    @Override
    public int size() {
        return bookings.size();
    }

    @Override
    public void print() {
        System.out.println(Arrays.toString(bookings.toArray()));
    }

    @Override
    public Booking[] getSortedArray(Comparator<Booking> comparator) {
        Booking[] res = bookings.toArray(new Booking[bookings.size()]);
        bookings.sort(comparator);
        return res;
    }


    @Override
    public Booking getByIndex(int i) {
        return bookings.get(i);
    }

    @Override
    public int findIndex(Booking booking) {
        return bookings.indexOf(booking);
    }

    @Override
    public void remove(Booking booking) {
        bookings.remove(booking);
    }
}
