package booking;

import org.junit.Assert;
import org.junit.Test;

/**
 * Booking 10.08.2020
 */
public class DateIntervalTest {
    @Test
    public void dateFinishShouldBeAfterStart1() {
        //если даты введены в обратном порядке
        Date d1 = new Date(30, 8, 2020);
        Date d2 = new Date(10, 8, 2020);

        DateInterval dateInterval = new DateInterval(d1, d2);
        boolean res = dateInterval.getStart().equals(d2) &&
                dateInterval.getFinish().equals(d1);

        Assert.assertTrue(res); // сравнение ожидания, что res = true, с тем, что получилось
    }

    @Test
    public void dateFinishShouldBeAfterStart2() {
        //если даты введены правильно
        Date d2 = new Date(30, 8, 2020);
        Date d1 = new Date(10, 8, 2020);

        DateInterval dateInterval = new DateInterval(d1, d2);
        boolean res = dateInterval.getStart().equals(d1) &&
                dateInterval.getFinish().equals(d2);

        Assert.assertTrue(res); // сравнение ожидания, что res = true, с тем, что получилось
    }

    @Test
    public void isIntersectTrueTest1() {
        //проверка пересечения интервалов, прямой порядок
        Date start1 = new Date(10, 8, 2020);
        Date finish1 = new Date(30, 8, 2020);
        DateInterval dateInterval1 = new DateInterval(start1, finish1);

        Date start2 = new Date(15, 8, 2020);
        Date finish2 = new Date(15, 9, 2020);
        DateInterval dateInterval2 = new DateInterval(start2, finish2);

        //при вызове этого метода с этими параметрами ожидаем результат true
        Assert.assertTrue(DateInterval.isIntersect(dateInterval1, dateInterval2));
    }

    @Test
    public void isIntersectTrueTest2() {
        //проверка - есть пересечение интервалов, интервалы записаны в обратном порядке
        Date start1 = new Date(10, 8, 2020);
        Date finish1 = new Date(30, 8, 2020);
        DateInterval dateInterval1 = new DateInterval(start1, finish1);

        Date start2 = new Date(15, 8, 2020);
        Date finish2 = new Date(15, 9, 2020);
        DateInterval dateInterval2 = new DateInterval(start2, finish2);

        //при вызове этого метода с этими параметрами ожидаем результат true
        Assert.assertTrue(DateInterval.isIntersect(dateInterval2, dateInterval1));
    }

    @Test
    public void isIntersectFalseTest1() {
        //проверка  - нет пересечения интервалов, прямая последовательность записи
        Date start1 = new Date(10, 8, 2020);
        Date finish1 = new Date(20, 8, 2020);
        DateInterval dateInterval1 = new DateInterval(start1, finish1);

        Date start2 = new Date(15, 9, 2020);
        Date finish2 = new Date(20, 9, 2020);
        DateInterval dateInterval2 = new DateInterval(start2, finish2);

        //при вызове этого метода с этими параметрами ожидаем результат false
        Assert.assertFalse(DateInterval.isIntersect(dateInterval1, dateInterval2));
    }

    @Test
    public void isIntersectFalseTest2() {
        //проверка - нет пересечения интервалов, обратная последовательность записи
        Date start1 = new Date(10, 8, 2020);
        Date finish1 = new Date(20, 8, 2020);
        DateInterval dateInterval1 = new DateInterval(start1, finish1);

        Date start2 = new Date(15, 9, 2020);
        Date finish2 = new Date(20, 9, 2020);
        DateInterval dateInterval2 = new DateInterval(start2, finish2);

        //при вызове этого метода с этими параметрами ожидаем результат false
        Assert.assertFalse(DateInterval.isIntersect(dateInterval2, dateInterval1));
    }
}
