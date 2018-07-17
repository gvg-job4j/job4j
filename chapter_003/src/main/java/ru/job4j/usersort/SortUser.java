package ru.job4j.usersort;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * @author Valeriy Gyrievskikh
 * @since 16.07.2018
 */
public class SortUser {
    /**
     * Метод формирует упорядоченное по возрасту множество пользователей.
     *
     * @param list Список пользователей.
     * @return Множество пользователей.
     */
    public Set<User> sort(List<User> list) {
        return new TreeSet<>(list);
    }
}
