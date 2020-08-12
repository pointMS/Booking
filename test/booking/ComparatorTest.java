package booking;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;

/**
 * Booking 11.08.2020
 */
public class ComparatorTest {
    @Test
    public void bookingComparatorByNameTest() {
        Booking b1 = new Booking(
                new StandardRoom("1", 2),
                new Person("Nick3"),
                new DateInterval(new myDate(30, 7, 2020), new myDate(10, 8, 2020)));

        Booking b2 = new Booking(
                new SuiteRoom("2", 2),
                new Person("Nick1"),
                new DateInterval(new myDate(11, 8, 2020), new myDate(13, 8, 2020)));

        Booking b3 = new Booking(
                new SuiteRoom("2", 2),
                new Person("Nick1"),
                new DateInterval(new myDate(11, 8, 2020), new myDate(13, 8, 2020)));

        Comparator<Booking> comp1 = new BookingComparatorByName();
        int res = comp1.compare(b1, b2); // вернется "+" число - Nick3>Nick1
        int res1 = comp1.compare(b2, b1); //вернется "-" число
        int res2 = comp1.compare(b2, b3); // return 0
        Assert.assertTrue((res > 0) && (res1 < 0) && (res2 == 0));
    }

    @Test
    public void bookingComparatorByStartDateTest() {
        Booking b1 = new Booking(
                new StandardRoom("1", 2),
                new Person("Nick3"),
                new DateInterval(new myDate(30, 7, 2020), new myDate(10, 8, 2020)));

        Booking b2 = new Booking(
                new SuiteRoom("2", 2),
                new Person("Nick1"),
                new DateInterval(new myDate(11, 8, 2020), new myDate(13, 8, 2020)));

        Booking b3 = new Booking(
                new SuiteRoom("2", 2),
                new Person("Nick1"),
                new DateInterval(new myDate(11, 8, 2020), new myDate(13, 8, 2020)));

        Comparator<Booking> comp2 = new BookingComparatorByStartDate();

        int res1 = comp2.compare(b1, b2); //return -
        int res2 = comp2.compare(b2, b1); //return +
        int res3 = comp2.compare(b2, b3); //return 0
        Assert.assertTrue((res1 < 0) && (res2 > 0) && (res3 == 0));
    }
}
