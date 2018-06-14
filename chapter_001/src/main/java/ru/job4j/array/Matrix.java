package ru.job4j.array;

/**
 * @author Valeriy Gyrievskikh
 * @since 14.06.2018.
 */
public class Matrix {
    /**
     * Создает матрицу заданного размера, заполняет перемноженными индексами.
     *
     * @param size Размер матрицы.
     * @return Заполненная матрица.
     */
    int[][] multiple(int size) {
        int[][] array = new int[size][size];
        for (int i = 1; i <= size; i++) {
            for (int j = 1; j <= size; j++) {
                array[i - 1][j - 1] = i * j;
            }
        }
        return array;
    }
}
