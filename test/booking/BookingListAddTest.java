package booking;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookingListAddTest {
    BookingList bookingList;
    Booking b1;
    Booking b2;
    Booking b3;

    @Before
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
    public void bookingListAddTest() {
        //no idea :(


    }

}
