package ru.job4j.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Valeriy Gyrievskikh.
 * @since 14.07.2018.
 */
public class ConvertMatrix2List {
    /**
     * Метод формирует лист и заполняет его данными из двумерного массива.
     *
     * @param array Двумерный массив.
     * @return Лист с данными.
     */
    public List<Integer> toList(int[][] array) {
        IntStream stream = Arrays.stream(array).flatMapToInt(Arrays::stream);
        return stream.boxed().collect(Collectors.toList());
    }
}
