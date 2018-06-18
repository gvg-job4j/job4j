package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 18.06.2018.
 */
public class MergeTwoSortedArraysTest {
    @Test
    public void whenMergedTwoArraysTwoThenArrayFour() {
        MergeTwoSortedArrays merge = new MergeTwoSortedArrays();
        int[] result = merge.merge(new int[]{1, 2, 4}, new int[]{1, 5, 8});
        int[] exist = {1, 1, 2, 4, 5, 8};
        Assert.assertThat(result, is(exist));
    }

    @Test
    public void whenMergedArrayTwoAndArrayFiveThenArraySeven() {
        MergeTwoSortedArrays merge = new MergeTwoSortedArrays();
        int[] result = merge.merge(new int[]{1, 8}, new int[]{0, 1, 5, 8, 9});
        int[] exist = {0, 1, 1, 5, 8, 8, 9};
        Assert.assertThat(result, is(exist));
    }
}
