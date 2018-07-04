package ru.job4j.coffee;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh.
 * @since 04.07.2018.
 */
public class CoffeeMachineTest {

    @Test
    public void whenMoneyNotEqualCostOn15() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(50, 35);
        int[] expect = new int[]{10, 5};
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void whenMoneyNotEqualCostOn65() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(100, 35);
        int[] expect = new int[]{10, 10, 10, 10, 10, 10, 5};
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void whenMoneyNotEqualCostOn5() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(10000, 9995);
        int[] expect = new int[]{5};
        Assert.assertThat(result, is(expect));
    }

    @Test
    public void whenMoneyEqualCost() {
        CoffeeMachine machine = new CoffeeMachine();
        int[] result = machine.changes(50, 50);
        int[] expect = new int[]{0};
        Assert.assertThat(result, is(expect));
    }
}
