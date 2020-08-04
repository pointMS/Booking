package booking;

/**
 * JavaAdvanced 31.07.2020
 */
public class DeLuxeRoom extends Room {
    private final double priceFactor = 1.7;
    private final double deLuxeTax = 50.0;

    public DeLuxeRoom(String number, int capacity) {
        super(number, capacity);
    }

    @Override
    public double getPrice() {
        return getBasePrice() * priceFactor + deLuxeTax;
    }

    @Override
    public String toString() {
        return "DeLux Room Nr" + getNumber() + " (" + getPrice() + ")";
    }
}
