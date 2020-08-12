package booking;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

/**
 * Booking 11.08.2020
 */
public class ArrayBookingListTest {
    @Test
    public void getSortedByNameArrayTest() {
        Booking b1 = new Booking(
                new StandardRoom("1", 2),
                new Person("Nick3"),
                new DateInterval(new myDate(30, 7, 2020), new myDate(10, 8, 2020)));

        Booking b2 = new Booking(
                new SuiteRoom("1", 2),
                new Person("Nick1"),
                new DateInterval(new myDate(11, 8, 2020), new myDate(13, 8, 2020)));

        Booking b3 = new Booking(
                new DeLuxeRoom("4", 2),
                new Person("Nick2"),
                new DateInterval(new myDate(30, 12, 2020), new myDate(4, 1, 2021)));

        BookingList bookingList = new ArrayBookingList(3);
        bookingList.add(b1);
        bookingList.add(b2);
        bookingList.add(b3);

        Comparator<Booking> comparator = new BookingComparatorByName();
        Booking[] resArray = bookingList.getSortedArray(comparator);
        Booking[] shouldArray = {b2, b3, b1}; //ожидаемая сортировка массива

        Assert.assertArrayEquals(resArray, shouldArray);
    }

    @Test
    public void getSortedByStartDateArrayTest() {
        Booking b1 = new Booking(
                new StandardRoom("1", 2),
                new Person("Nick3"),
                new DateInterval(new myDate(12, 9, 2020), new myDate(10, 10, 2020)));

        Booking b2 = new Booking(
                new SuiteRoom("1", 2),
                new Person("Nick1"),
                new DateInterval(new myDate(11, 8, 2020), new myDate(13, 8, 2020)));

        Booking b3 = new Booking(
                new DeLuxeRoom("4", 2),
                new Person("Nick2"),
                new DateInterval(new myDate(1, 8, 2020), new myDate(4, 1, 2021)));

        BookingList bookingList = new ArrayBookingList(3);
        bookingList.add(b1);
        bookingList.add(b2);
        bookingList.add(b3);

        Comparator<Booking> comparator = new BookingComparatorByStartDate();
        Booking[] resArray = bookingList.getSortedArray(comparator);
        Booking[] shouldBeArray = {b3, b2, b1}; //expected sorting

        Assert.assertArrayEquals(resArray, shouldBeArray);

    }


}
