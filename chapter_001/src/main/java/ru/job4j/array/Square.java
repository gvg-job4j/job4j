package ru.job4j.array;

/**
 * @author Valeriy Gyrievskikh
 * @since 13.06.2018.
 */
public class Square {

    /**
     * Заполнение массива числами, возведенными в квадрат.
     *
     * @param bound Размер массива.
     * @return Массив.
     */
    public int[] calculate(int bound) {
        int[] result = new int[bound];
        for (int i = 1; i <= bound; i++) {
            result[i - 1] = (int) Math.pow(i, 2);
        }
        return result;
    }
}
