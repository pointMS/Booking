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

}
