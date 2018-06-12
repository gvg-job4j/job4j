package ru.job4j.loop;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


/**
 * @author Valeriy Gyrievskikh
 * @since 12.06.2018.
 */
public class CounterTest {

    @Test
    public void SummOneToTen(){
        Counter counter = new Counter();
        int result = counter.add(1, 10);
        assertThat(result, is(30));
    }
}
