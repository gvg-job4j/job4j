package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 14.06.2018.
 */
public class CheckTest {
    @Test
    public void whenEvenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean result = check.mono(new boolean[]{true, true, true, true});
        Assert.assertThat(result, is(true));
    }

    @Test
    public void whenNotEvenDataMonoByTrueThenTrue() {
        Check check = new Check();
        boolean result = check.mono(new boolean[]{true, true, true});
        Assert.assertThat(result, is(true));
    }

    @Test
    public void whenDataNotMonoByTrueThenFalse() {
        Check check = new Check();
        boolean result = check.mono(new boolean[]{true, true, false});
        Assert.assertThat(result, is(false));
    }
}
