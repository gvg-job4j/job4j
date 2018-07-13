package ru.job4j.list;

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
        if (rows != 0){
            int column = 0;
            int size = list.size();
            while (rows < size) {
                column++;
                size -= rows;
            }
            column++;
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
}
