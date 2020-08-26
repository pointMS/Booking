package booking;

import java.util.Objects;

public class DateInterval {
    private myDate start;
    private myDate finish;
    //private static  Random rnd = new Random(System.currentTimeMillis());
    private int days = 0;

    public DateInterval(myDate start, myDate finish) {
        if (start.compareTo(finish) > 0) {
            this.start = finish;
            this.finish = start;
        } else {
            this.start = start;
            this.finish = finish;
        }
    }

    public static boolean isIntersect(DateInterval interval1, DateInterval interval2) {
        // при выполнении этого условия интервалы НЕ пересекаются - !
        return !((interval1.getStart().compareTo(interval2.getFinish()) > 0) ||
                (interval2.getStart().compareTo(interval1.getFinish()) > 0));
    }

    public myDate getStart() {
        return start;
    }

    public myDate getFinish() {
        return finish;
    }

    public int getDays() {
     /*
        int min = 1;
        int max = 100;
        if (days == 0) {
            days =min+rnd.nextInt(max-min+1);
        }
        10.10.2016 ....... 03.08.2020
*/
        if (days == 0) {
            for (int i = start.getYear(); i < finish.getYear(); i++) {
                days += myDate.getDaysPerYear(i);
            }
            days -= start.daysFromNewYear();
            days += finish.daysFromNewYear();
        }
        return days;
    }

    @Override
    public String toString() {
        return " [check-in: " + start + "; check-out: " + finish + "]";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DateInterval that = (DateInterval) o;
        return days == that.days && start.equals(that.start) && finish.equals(that.finish);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, finish, days);
    }
}
