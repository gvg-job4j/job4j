package ru.job4j.array;

import java.util.Arrays;

/**
 * @author Valeriy Gyrievskikh
 * @since 14.06.2018.
 */
public class ArrayDuplicate {
    /**
     * Удалаяет дубликаты в массиве.
     *
     * @param array Исходный массив.
     * @return Массив без дубликатов.
     */
    public String[] remove(String[] array) {
        int count = 0;
        String value = "";
        for (int i = 0; i < array.length - count; i++) {
            value = array[i];
            for (int j = i + 1; j < array.length; j++) {
                if (array[j].equals(value)) {
                    array[j] = array[array.length - 1 - count];
                    array[array.length - 1 - count] = value;
                    count++;
                    break;
                }
            }
        }
        return Arrays.copyOf(array, array.length - count);
    }
}
