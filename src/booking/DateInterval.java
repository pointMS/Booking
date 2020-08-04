package booking;

public class DateInterval {
    private Date start;
    private Date finish;
    //private static  Random rnd = new Random(System.currentTimeMillis());
    private int days=0;

    public DateInterval(Date start, Date finish) {
        this.start = start;
        this.finish = finish;
    }

    public Date getStart() {
        return start;
    }

    public Date getFinish() {
        return finish;
    }

    public int getDays(){
     /*
        int min = 1;
        int max = 100;
        if (days == 0) {
            days =min+rnd.nextInt(max-min+1);
        }
        10.10.2016 ....... 03.08.2020
*/
        if (days == 0){
            for(int i = start.getYear();i<finish.getYear();i++){
                days+=Date.getDaysPerYear(i);
            }
            days-=start.daysFromNewYear();
            days+=finish.daysFromNewYear();
        }
        return days;
    }

    @Override
    public String toString() {
        return " [check in: " + start + "; check out: " + finish + "]";
    }
}
