package ru.job4j.function;

import java.util.List;

/**
 * @author Valeriy Gyrievskikh
 * @since 26.07.2018
 */
public interface Function<T> {
    /**
     * Метод возвращает список рассчитанных значений в указанном диапазоне.
     *
     * @param start Начальное значение.
     * @param end   Последнее значение.
     * @return Список рассчитанных значений.
     */
    List<T> calculate(int start, int end);
}