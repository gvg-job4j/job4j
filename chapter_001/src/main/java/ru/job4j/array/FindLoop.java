package ru.job4j.array;

/**
 * @author Valeriy Gyrievskikh
 * @since 13.06.2018.
 */
public class FindLoop {
    /**
     * Поиск элемента в массиве перебором.
     *
     * @param data Массив для поиска.
     * @param el   Разыскиваемое значение.
     * @return Индекс найденного значения (-1, если значение не найдено).
     */
    public int indexOf(int[] data, int el) {
        int result = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                result = index;
                break;
            }
        }
        return result;
    }
}
