package ru.job4j.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.07.2018
 */
public class ConvertList2ArrayTest {

    @Test
    public void when7ElementsThen9() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4, 5, 6, 7),
                3
        );
        int[][] expect = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 0, 0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when4ElementsThen4() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2, 3, 4),
                2
        );
        int[][] expect = {
                {1, 2},
                {3, 4}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2ElementsThen4() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2),
                4
        );
        int[][] expect = {
                {1},
                {2},
                {0},
                {0}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when2ElementsThen0() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2),
                0
        );
        int[][] expect = {};
        assertThat(result, is(expect));
    }

    @Test
    public void when2ElementsThen2() {
        ConvertList2Array list = new ConvertList2Array();
        int[][] result = list.toArray(
                Arrays.asList(1, 2),
                1
        );
        int[][] expect = {
                {1, 2}
        };
        assertThat(result, is(expect));
    }

    @Test
    public void when1With2And1With4Then6() {
        List<int[]> newList = new ArrayList<>();
        newList.add(new int[]{1, 2});
        newList.add(new int[]{3, 4, 5, 6});
        ConvertList2Array list = new ConvertList2Array();
        List<Integer> result = list.convert(newList);
        List<Integer> expect = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6});
        assertThat(result, is(expect));
    }

    @Test
    public void when3With3Then9() {
        List<int[]> newList = new ArrayList<>();
        newList.add(new int[]{1, 2, 3});
        newList.add(new int[]{4, 5, 6});
        newList.add(new int[]{7, 0, 0});
        ConvertList2Array list = new ConvertList2Array();
        List<Integer> result = list.convert(newList);
        List<Integer> expect = Arrays.asList(new Integer[]{1, 2, 3, 4, 5, 6, 7, 0, 0});
        assertThat(result, is(expect));
    }

    @Test
    public void when1With2Then2() {
        List<int[]> newList = new ArrayList<>();
        newList.add(new int[]{1, 2});
        ConvertList2Array list = new ConvertList2Array();
        List<Integer> result = list.convert(newList);
        List<Integer> expect = Arrays.asList(new Integer[]{1, 2});
        assertThat(result, is(expect));
    }
}
