package ru.job4j.function;

import java.util.List;

/**
 * @author Valeriy Gyrievskikh
 * @since 26.07.2018
 */
public class CalcFunction {

    /**
     * Метод возвращает список рассчитанных значений в указанном диапазоне, полученных в результате работы функции.
     *
     * @param start Первое значение.
     * @param end   Последнее значение.
     * @param func  Функция, используемая для расчета.
     * @return Список рассчитанных значений.
     */
    public List<Double> diapason(int start, int end, Function<Double> func) {
        return func.calculate(start, end);
    }
}
