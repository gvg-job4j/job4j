package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

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
        List<Integer> list = new ArrayList<>();
        for (int[] row : array
                ) {
            for (int column : row
                    ) {
                list.add(column);
            }
        }
        return list;
    }
}
