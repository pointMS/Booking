package booking;

import org.junit.Assert;
import org.junit.Test;

public class BookingListSizeTest {
    @Test
    public void bookingListSizeTest() {
        int result = 0; //размер не м.б. меньше или равен 0
        BookingList bookingList = new ArrayBookingList(1); //массив минимального размера
        bookingList.size(); //вызов метода

        Assert.assertTrue(result < bookingList.size());
    }
}

