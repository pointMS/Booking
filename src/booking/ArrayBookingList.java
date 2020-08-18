package booking;

import java.util.Arrays;
import java.util.Comparator;

public class ArrayBookingList implements BookingList { //класс хранит и управляет множеством букингов
    private Booking[] bookings;
    private int size = 0; //количество элементов, которое есть сейчас в массиве
    private int capacity = 3; //размер массива на данный момент

    public ArrayBookingList(int capacity) {
        this.capacity = capacity;
        bookings = new Booking[this.capacity];
    }

    @Override
    public void add(Booking booking) {
        if (size < capacity) {
            bookings[size++] = booking;
        } else {
            capacity *= 2; //увеличение размера массива, если в нем уже накопилось минимальное количество
            Booking[] temp = new Booking[capacity]; //создание нового массива размера *2
            for (int i = 0; i < bookings.length; i++) { //переброска в него элементов из старого массива
                temp[i] = bookings[i];
            }
            bookings = temp;
            bookings[size++] = booking;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(bookings[i]);
        }
    }

    @Override
    public Booking[] getSortedArray(Comparator<Booking> comparator) {
        Booking[] res = Arrays.copyOf(bookings, bookings.length); //создана копия массива
        Arrays.sort(bookings, comparator);
        return res;
    }

    @Override
    public Booking getByIndex(int i) { //для метода add - получить запись по индексу
        if (i < 0 || i > size - 1) {
            return null;
        } else {
            return bookings[i];
        }
    }

    @Override
    public int findIndex(Booking booking) {
        for (int i = 0; i < bookings.length; i++) {
            if (booking.equals(bookings[i])) {
                return i;
            }
        }
        return -1;
    }

    @Override //переделать на void
    public void remove(Booking booking) {
        Booking[] bookingRes = new Booking[bookings.length - 1];
        int index = findIndex(booking);
        if (index >= 0 && index < bookings.length) {
            for (int i = 0, j = 0; i < bookings.length; i++) {
                if (i != index) {
                    bookingRes[j++] = bookings[i];
                }
            }
            bookings = bookingRes;
        }
    }
}
