package booking;

import java.util.Comparator;

/**
 * Booking 11.08.2020
 */
public class BookingComparatorByName implements Comparator<Booking> {

    @Override
    public int compare(Booking o1, Booking o2) {
        return o1.getPerson().getName().compareTo(o2.getPerson().getName());
    }
}
