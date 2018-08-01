package ru.job4j.usersort;

import java.util.*;
import java.util.stream.Collectors;

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

    /**
     * Метод сортирует список пользователей по длине имени.
     *
     * @param list Список пользователей.
     * @return Отсортированный список пользователей.
     */
    public List<User> sortNameLength(List<User> list) {
        return list.stream().sorted(new NameComparator()).collect(Collectors.toList());
    }

    /**
     * Метод сортирует список пользователей по имени и возрасту.
     *
     * @param list Список пользователей.
     * @return Отсортированный список пользователей.
     */
    public List<User> sortByAllFields(List<User> list) {
        return list.stream().sorted(new AgeNameComparator()).collect(Collectors.toList());
    }

    /**
     * Метод выполняет сортировку по длине имени.
     */
    private class NameComparator implements Comparator<User> {
        @Override
        public int compare(User userFirst, User userSecond) {
            int lengthFirst = userFirst.getName().toCharArray().length;
            int lengthSecond = userSecond.getName().toCharArray().length;
            return lengthFirst - lengthSecond;
        }
    }

    /**
     * Метод выполняет сортировку по имени и возрасту.
     */
    private class AgeNameComparator implements Comparator<User> {
        @Override
        public int compare(User userFirst, User userSecond) {
            int result = userFirst.getName().compareToIgnoreCase(userSecond.getName());
            if (result == 0) {
                result = Integer.compare(userFirst.getAge(), userSecond.getAge());
            }
            return result;
        }
    }
}
