package ru.job4j.array;

/**
 * @author Valeriy Gyrievskikh
 * @since 14.06.2018.
 */
public class BubbleSort {
    /**
     * Сортировка пузырьком.
     *
     * @param array Массив.
     * @return Отсортированный массив.
     */
    public int[] sort(int[] array) {
        int value = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length; j++) {
                if (array[j] < array[j - 1]) {
                    value = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = value;
                }
            }
        }
        return array;
    }
}
