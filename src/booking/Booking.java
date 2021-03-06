package booking;

import booking.rooms.Room;

import java.util.Objects;

public class Booking {
    static private int nextId = 0; //static - общее поле на все объекты класса, одинаковое значение
    private int id; //поле для каждого объекта класса
    private Room room;
    private Person person;
    private DateInterval dateInterval;


    public Booking(Room room, Person person, DateInterval dateInterval) {
        this.room = room;
        this.person = person;
        this.dateInterval = dateInterval;

        this.id = ++nextId; //счетчик - каждый раз, когда вызывается объект Booking, увеличивается значение этого поля
    }

    public Room getRoom() {
        return room;
    }

    public Person getPerson() {
        return person;
    }

    public DateInterval getDateInterval() {
        return dateInterval;
    }

    public double getPrice() {
        return this.room.getPrice() * this.dateInterval.getDays();
    }

    @Override
    public String toString() {
        return "\n" + id + " - Booking: " + room + ", person: " + person + "," + dateInterval +
                ", price for " + this.dateInterval.getDays() + " days is " + getPrice() + " EUR";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return person.equals(booking.person) && dateInterval.equals(booking.dateInterval);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person, dateInterval);
    }
}
