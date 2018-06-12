package ru.job4j.loop;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.06.2018.
 */
public class Counter {

    /**
     * Вычисление суммы четных чисел в диапазоне указанных значений
     *
     * @param start  Начальное значение.
     * @param finish Конечное значение.
     * @return Сумма четных чисел.
     */
    public int add(int start, int finish) {
        int summ = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                summ += i;
            }
        }
        return summ;
    }
}
