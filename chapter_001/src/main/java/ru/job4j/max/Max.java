package ru.job4j.max;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.06.2018.
 */
public class Max {

    /**
     * Возвращает максимальное из двух целых чисел
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @return Максимальное значение.
     */
    public int max(int first, int second) {
        return (first > second ? first : second);
    }

    /**
     * Возвращает максимальное из трех целых чисел
     *
     * @param first  Первое число.
     * @param second Второе число.
     * @param third  Третье число.
     * @return Максимальное значение.
     */
    public int max(int first, int second, int third) {
        return this.max(this.max(first, second), third);
    }
}
