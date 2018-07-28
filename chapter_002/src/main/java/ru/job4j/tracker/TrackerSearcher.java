package ru.job4j.tracker;

import java.util.List;

/**
 * @author Valeriy Gyrievskikh.
 * @since 28.07.2018.
 */
public interface TrackerSearcher<T> {
    /**
     * Метод выполняет поиск в заданном списке по указанному значению.
     *
     * @param string Значение, по которому выполняется поиск.
     * @param list   Список, в котором выполняется поиск.
     * @return Список найденных значений.
     */
    List<T> findBy(String string, List<T> list);
}
