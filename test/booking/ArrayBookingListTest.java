package booking;

import booking.rooms.DeLuxeRoom;
import booking.rooms.StandardRoom;
import booking.rooms.SuiteRoom;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

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
    public void remove_DecrementBookingList() {
        //Booking[] expectedList = new Booking[2];
        bookingList = new ArrayBookingList(3);
        bookingList.add(b1);
        bookingList.add(b2);
        bookingList.add(b3);
        bookingList.remove(b1);

        Assert.assertEquals(2, bookingList.size());
        Assert.assertTrue(bookingList.findIndex(b1) == -1); //находится ли удаленный индекс в новом массиве


    }

    @Test
    public void getByIndex_Correct_ReturnBooking() {
        Assert.assertEquals("the first element fail", b1, bookingList.getByIndex(0));
        Assert.assertEquals("get element fail", b2, bookingList.getByIndex(1));
        Assert.assertEquals("the last element fail", b3, bookingList.getByIndex(2));
    }

    @Test
    public void getByIndex_NotCorrectIndex_ReturnNull() {
        Assert.assertTrue("negative index not ok", bookingList.getByIndex(-1) == null);
        Assert.assertTrue("bigger index not ok", bookingList.getByIndex(3) == null);
    }

    @Test
    public void add_CorrectSize_IncrementAndBookingAdd() {
        Booking booking = new Booking(new DeLuxeRoom("4", 2), new Person("Nick222"),
                new DateInterval(new myDate(15, 8, 2020), new myDate(4, 1, 2021)));
        //создаем новый букинг, добавляем и проверяем изменился ли размер массива, было 3, ожидаем 4
        bookingList.add(booking);
        Assert.assertEquals(4, bookingList.size());//проверяем размер массива
        Assert.assertEquals(booking, bookingList.getByIndex(3)); //проверяем, есть ли элемент с нужным индексом
    }

    @Test
    //название метода_начальное условие_что ожидаем
    public void add_emptyBookingList_correctAdded() { //проверяем, увеличивается ли List
        BookingList bookingList = new ArrayBookingList(1); // создаем массив размером 1

        bookingList.add(b1); //добавляем в него один элемент
        Assert.assertEquals(1, bookingList.size()); //проверяем размер массива
        bookingList.add(b2); //добавляем еще один элемент и повторяем проверку
        Assert.assertEquals(2, bookingList.size());

        //проверяем, есть ли элемент с нужным индексом после роста массива
        Assert.assertEquals(b1, bookingList.getByIndex(0));
        Assert.assertEquals(b2, bookingList.getByIndex(1));
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

        Assert.assertArrayEquals(shouldBeArray, resArray);
    }
}
