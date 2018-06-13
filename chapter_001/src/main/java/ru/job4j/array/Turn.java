package ru.job4j.array;

/**
 * @author Valeriy Gyrievskikh
 * @since 13.06.2018.
 */
public class Turn {
    /**
     * Переворачивание массива задом наперёд.
     *
     * @param array Массив.
     * @return Перевернутый массив.
     */
    public int[] turn(int[] array) {
        for (int index = 0; index < array.length; index++) {
            if (index >= array.length / 2) break;
            int value = array[index];
            array[index] = array[array.length - 1 - index];
            array[array.length - 1 - index] = value;
        }
        return array;
    }
}
