package booking;

/**
 * JavaAdvanced 30.07.2020
 */
public class Main {
    public static void main(String[] args) {
        Booking b1 = new Booking(
                new StandardRoom("1", 2),
                new Person("Jack"),
                new DateInterval(new Date(30, 7, 2020), new Date(10, 8, 2020)));

        Booking b2 = new Booking(
                new SuiteRoom("2", 2),
                new Person("Nick"),
                new DateInterval(new Date(11, 8, 2020), new Date(13, 8, 2020)));

        Booking b3 = new Booking(
                new DeLuxeRoom("4", 2),
                new Person("Pier"),
                new DateInterval(new Date(30, 12, 2020), new Date(4, 1, 2021)));

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b3);

    }
}
