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
            /*При каждом проходе элементы в конце массива будут упорядочиваться, и их количество будет равно (i + 1),
             поэтому можно уменьшать максимальное количество проверяемых элементов на это число
             */
            for (int j = 0; j < array.length - (i + 1); j++) {
                if (array[j] > array[j + 1]) {
                    value = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = value;
                }

            }
        }
        return array;
    }
}
