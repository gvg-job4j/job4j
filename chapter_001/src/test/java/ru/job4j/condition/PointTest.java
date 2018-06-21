package ru.job4j.condition;

import org.junit.Test;

import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.Assert.assertThat;

/**
 * Created by GVG on 12.06.2018.
 */
public class PointTest {

    @Test
    public void distanceBetweenTwoPoints() {
        Point point = new Point(1, 1);
        Point point2 = new Point(2, 2);
        double result = point.distanceTo(point2);
        assertThat(result, closeTo(1.4, 0.1));
    }
}
