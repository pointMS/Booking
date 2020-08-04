package booking;

/**
 * JavaAdvanced 31.07.2020
 */
public class StandardRoom extends Room {
    private final double priceFactor = 1.0;

    public StandardRoom(String number, int capacity) {
        super(number, capacity);
    }

    @Override
    public double getPrice() {
        return getBasePrice() * priceFactor;
    }

    @Override
    public String toString() {
        return "Standard Room Nr" + getNumber() + " (" + getPrice() + ")";
    }
}
