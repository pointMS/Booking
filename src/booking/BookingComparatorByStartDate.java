package booking;

import java.util.Comparator;

/**
 * Booking 12.08.2020
 */
public class BookingComparatorByStartDate implements Comparator<Booking> {
    @Override
    public int compare(Booking o1, Booking o2) {
        return (o1.getDateInterval().getStart().compareTo(o2.getDateInterval().getStart()));
    }
}
