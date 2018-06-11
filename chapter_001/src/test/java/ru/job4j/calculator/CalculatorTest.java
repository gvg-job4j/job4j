package ru.job4j.calculator;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by GVG on 11.06.2018.
 */
public class CalculatorTest {

    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculator calc = new Calculator();
        calc.add(1d, 1d);
        double result = calc.getResult();
        double expected = 2d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenSubOneFromTwoThenOne() {
        Calculator calc = new Calculator();
        calc.subtract(2d, 1d);
        double result = calc.getResult();
        double expected = 1d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenMyltiplyTwoOnTwoThenFour() {
        Calculator calc = new Calculator();
        calc.multiply(2d, 2d);
        double result = calc.getResult();
        double expected = 4d;
        assertThat(result, is(expected));
    }

    @Test
    public void whenDivFourOnTwoThenTwo() {
        Calculator calc = new Calculator();
        calc.div(4d, 2d);
        double result = calc.getResult();
        double expected = 2d;
        assertThat(result, is(expected));
    }
}
