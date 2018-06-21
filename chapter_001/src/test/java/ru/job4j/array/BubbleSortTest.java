package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 14.06.2018.
 */
public class BubbleSortTest {
    @Test
    public void whenSortArrayWithTenElementsThenSortedArray() {
        BubbleSort sort = new BubbleSort();
        int[] result = sort.sort(new int[]{1, 5, 4, 2, 3, 1, 7, 8, 0, 5});
        int[] test = new int[]{0, 1, 1, 2, 3, 4, 5, 5, 7, 8};
        Assert.assertThat(result, is(test));
    }

    @Test
    public void whenSortArrayWithFiveElementsThenSortedArray() {
        BubbleSort sort = new BubbleSort();
        int[] result = sort.sort(new int[]{5, 1, 2, 7, 3});
        int[] test = new int[]{1, 2, 3, 5, 7};
        Assert.assertThat(result, is(test));
    }
}
