package booking;

import booking.rooms.DeLuxeRoom;
import booking.rooms.StandardRoom;
import booking.rooms.SuiteRoom;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * JavaAdvanced 30.07.2020
 */
public class Main {
    public static void main(String[] args) {
        Booking b1 = new Booking(
                new StandardRoom("1", 2),
                new Person("Jack"),
                new DateInterval(new myDate(30, 7, 2020), new myDate(10, 8, 2020)));

        Booking b2 = new Booking(
                new SuiteRoom("2", 2),
                new Person("Nick"),
                new DateInterval(new myDate(11, 8, 2020), new myDate(13, 8, 2020)));

        Booking b3 = new Booking(
                new DeLuxeRoom("4", 2),
                new Person("Pier"),
                new DateInterval(new myDate(30, 12, 2020), new myDate(4, 1, 2021)));

        Booking b4 = new Booking(
                new DeLuxeRoom("12", 2),
                new Person("Alex"),
                new DateInterval(new myDate(30, 12, 2020), new myDate(4, 1, 2021)));

//        BookingList bookingList = new ArrayBookingList(2);
//        bookingList.add(b1);
//        bookingList.add(b2);
//        bookingList.add(b3);
//        bookingList.add(b4);
//
//        bookingList.print();
//
//        System.out.println("- - - 1 - - - - ");
//
//        Booking[] bookings = bookingList.getSortedArray(new BookingComparatorByName());
//        bookingList.print();
//
//        System.out.println("- - - 2 - comparator by name - - - ");
//
//        bookingList.print();
//        System.out.println("- - - 3 - booking list array - - - ");
//        System.out.println(Arrays.toString(bookings));

        BookingList bookings = new ArrayBookingListCollection();
        bookings.add(b1);
        bookings.add(b2);
        bookings.add(b3);
        bookings.add(b4);

        System.out.println("-- Original --");
        bookings.print();

        System.out.println("Index of b3: " + bookings.findIndex(b3));

        System.out.println("-- Index 1 removed --");
        bookings.remove(b1);
        bookings.print();

        System.out.println("-- Sorted by name --");
        bookings.add(b1);
        bookings.getSortedArray(new BookingComparatorByName());
        bookings.print();

        System.out.println("--Sorted by start date --");
        bookings.getSortedArray(new BookingComparatorByStartDate());
        bookings.print();

        System.out.println("Original size is: " + bookings.size());

    }
}
