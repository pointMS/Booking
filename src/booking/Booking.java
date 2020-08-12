package booking;

public class Booking {
    static private int nextId = 0; //общее поле на все объекты класса, счетчик
    private int id;
    private Room room;
    private Person person;
    private DateInterval dateInterval;


    public Booking(Room room, Person person, DateInterval dateInterval) {
        this.room = room;
        this.person = person;
        this.dateInterval = dateInterval;

        this.id = ++nextId; //каждый раз, когда вызывается объект Booking, увеличивается значение этого поля
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
        return id + " | Booking: " + room + " person: " + person + " " + dateInterval +
                " \n\tprice for " + this.dateInterval.getDays() + " days is " + getPrice() + " EUR";
    }
}
