package ru.job4j.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 26.07.2018
 */
public class CalcFunctionTest {

    @Test
    public void whenLinearFunction() {
        CalcFunction calc = new CalcFunction();
        List<Double> result = calc.diapason(1, 3, (start, end) -> {
            List<Double> calcres = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                calcres.add(4d * i + 20.0d);
            }
            return calcres;
        });
        List<Double> expect = Arrays.asList(24d, 28d, 32d);
        assertThat(result, is(expect));
    }

    @Test
    public void whenQuadraticFunction() {
        CalcFunction calc = new CalcFunction();
        List<Double> result = calc.diapason(1, 3, (start, end) -> {
            List<Double> calcres = new ArrayList<>();
            for (int i = start; i <= end; i++) {
                calcres.add((2d * Math.pow(i, 2)) + (4 * i) + 10);
            }
            return calcres;
        });
        List<Double> expect = Arrays.asList(16d, 26d, 40d);
        assertThat(result, is(expect));
    }

    @Test
    public void whenLogarifmicFunction() {
        CalcFunction calc = new CalcFunction();
        List<Double> result = calc.diapason(1, 10, (start, end) -> {
            List<Double> calcres = new ArrayList<>();
            for (int i = start; i <= end; i += 9) {
                calcres.add(Math.log10(i));
            }
            return calcres;
        });
        List<Double> expect = Arrays.asList(0d, 1d);
        assertThat(result, is(expect));
    }
}
