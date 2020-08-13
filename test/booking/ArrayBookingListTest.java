package booking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

/**
 * Booking 11.08.2020
 */
public class ArrayBookingListTest {
    BookingList bookingList;
    Booking b1;
    Booking b2;
    Booking b3;

    @Before //аннотация означает, что метод будет выполняться перед каждым тестом
    public void initBookingList() {
        b1 = new Booking(new StandardRoom("1", 2), new Person("Nick3"),
                new DateInterval(new myDate(5, 8, 2020), new myDate(10, 8, 2020)));

        b2 = new Booking(new SuiteRoom("1", 2), new Person("Nick1"),
                new DateInterval(new myDate(22, 7, 2020), new myDate(13, 8, 2020)));

        b3 = new Booking(new DeLuxeRoom("4", 2), new Person("Nick2"),
                new DateInterval(new myDate(16, 8, 2020), new myDate(4, 1, 2021)));

        bookingList = new ArrayBookingList(3);

        bookingList.add(b1);
        bookingList.add(b2);
        bookingList.add(b3);
    }

    @Test
    public void getSortedByNameArrayTest() {
        Comparator<Booking> comparator = new BookingComparatorByName();
        Booking[] resArray = bookingList.getSortedArray(comparator);
        Booking[] shouldArray = {b2, b3, b1}; //ожидаемая сортировка массива

        Assert.assertArrayEquals(shouldArray, resArray); //первый параметр - ожидаемый результат, второй - реальный
    }

    @Test
    public void getSortedByStartDateArrayTest() {
        Comparator<Booking> comparator = new BookingComparatorByStartDate();
        Booking[] resArray = bookingList.getSortedArray(comparator);
        Booking[] shouldBeArray = {b2, b1, b3}; //expected sorting

        Assert.assertArrayEquals(shouldBeArray,resArray);
    }
}
