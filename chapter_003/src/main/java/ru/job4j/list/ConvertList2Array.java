package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.07.2018
 */
public class ConvertList2Array {

    /**
     * Метод формирует из ArrayList двумерный массив с заданным количеством строк,
     * ячейки без данных заполняются нулями.
     *
     * @param list Исходные данные.
     * @param rows Количество строк.
     * @return Массив.
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array = new int[][]{};
        if (rows != 0) {
            int column = (int) Math.ceil((double) list.size() / rows);
            array = new int[rows][column];
            int count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < column; j++) {
                    if (count < list.size()) {
                        array[i][j] = list.get(count);
                    } else {
                        array[i][j] = 0;
                    }
                    count++;
                }
            }
        }
        return array;
    }

    /**
     * Метод собирает данные из массивов в один список.
     *
     * @param list Список массивов.
     * @return Список данных из массивов.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> outputList = new ArrayList<>();
        for (int[] array : list
                ) {
            for (int i = 0; i < array.length; i++) {
                outputList.add(array[i]);
            }
        }
        return outputList;
    }
}
