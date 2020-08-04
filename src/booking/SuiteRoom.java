package booking;

/**
 * JavaAdvanced 31.07.2020
 */
public class SuiteRoom extends Room{
    private final double priceFactor = 1.5;

    public SuiteRoom(String number, int capacity) {
        super(number, capacity);
    }

    @Override
    public double getPrice() {
        return getBasePrice()*priceFactor;
    }
    @Override
    public String toString() {
        return "Suite Room Nr" + getNumber() + " (" + getPrice() + ")";
    }
}
