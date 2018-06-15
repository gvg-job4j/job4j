package ru.job4j.array;

/**
 * @author Valeriy Gyrievskikh
 * @since 14.06.2018.
 */
public class MatrixCheck {
    /**
     * Проверяет, одинаковы ли элементы в диагоналях массива.
     *
     * @param data Проверяемый массив.
     * @return Результат проверки.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        boolean value = data[0][0];
        for (int i = 0; i < data.length; i++) {
            if (data[i][i] != value || data[i][data.length - 1 - i] != value) {
                result = false;
                break;
            }
        }
        return result;
    }
}
