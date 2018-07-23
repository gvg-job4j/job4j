package ru.job4j.departmentsort;

import java.util.*;

/**
 * @author Valeriy Gyrievskikh.
 * @since 21.07.2018.
 */
public class DepartmentSort {

    /**
     * Метод выполняет сортировку по убыванию.
     *
     * @param array Массив для сортировки.
     * @return Отсортированный массив.
     */
    public String[] sortDesc(String[] array) {
        return makeSort(array, true);
    }

    /**
     * Метод выполняет сортировку по возрастанию.
     *
     * @param array Массив для сортировки.
     * @return Отсортированный массив.
     */
    public String[] sortAcs(String[] array) {
        return makeSort(array, false);
    }

    /**
     * Метод выполняет сортировку массива.
     *
     * @param array Массив для сортировки.
     * @param desc  Истина - Сортировать по убыванию, ложь - по возрастанию.
     * @return Отсортированный массив.
     */
    private String[] makeSort(String[] array, boolean desc) {
        List<String> sortDepartments = new ArrayList<>();
        List<String> topDepartments = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            if (!array[i].contains("\\")) {
                topDepartments.add(array[i]);
            }
        }
        if (desc) {
            topDepartments.sort(Collections.reverseOrder());
        } else {
            Collections.sort(topDepartments);
        }
        for (int i = 0; i < topDepartments.size(); i++) {
            List<String> departments = new ArrayList<>();
            departments.add(topDepartments.get(i));
            String find = topDepartments.get(i) + "\\";
            for (int j = 0; j < array.length; j++) {
                if (array[j].indexOf(find) == 0) {
                    departments.add(array[j]);
                }
            }
            if (desc) {
                departments.sort(new DescComparator());
            } else {
                departments.sort(new AscComparator());
            }
            sortDepartments.addAll(departments);
        }
        return sortDepartments.toArray(new String[sortDepartments.size()]);
    }

    /**
     * Метод выполняет сравнение двух строк.
     *
     * @param left  Первая строка.
     * @param right Вторая строка.
     * @param desc  Истина - сортировка по убыванию, ложь - по возрастанию.
     * @return Результат сравнения.
     */
    private int compareStrings(String left, String right, boolean desc) {
        int result = 0;
        if (left.length() == right.length()) {
            String[] leftArray = left.split("\\\\");
            String[] rightArray = right.split("\\\\");
            for (int i = 0; i < leftArray.length; i++) {
                if (!leftArray[i].equals(rightArray[i])) {
                    if (desc) {
                        result = -(leftArray[i].compareToIgnoreCase(rightArray[i]));
                    } else {
                        result = (leftArray[i].compareToIgnoreCase(rightArray[i]));
                    }
                    break;
                }
            }
        } else {
            boolean contain = left.length() > right.length() ? left.contains(right) : right.contains(left);
            if (contain) {
                result = 1;
            } else {
                if (desc) {
                    result = 1;
                } else {
                    result = -1;
                }
            }
        }
        return result;
    }

    /**
     * Класс реализует сортировку по убыванию.
     */
    private class DescComparator implements Comparator<String> {

        /**
         * Метод сравнивает две строки по убыванию.
         *
         * @param left  Первая строка.
         * @param right Вторая строка.
         * @return Результат сравнения.
         */
        @Override
        public int compare(String left, String right) {
            return compareStrings(left, right, true);
        }
    }

    /**
     * Класс реализует сортировку по возрастанию.
     */
    private class AscComparator implements Comparator<String> {

        /**
         * Метод сравнивает две строки по возврастанию.
         *
         * @param left  Первая строка.
         * @param right Вторая строка.
         * @return Результат сравнения.
         */
        @Override
        public int compare(String left, String right) {
            return compareStrings(left, right, false);
        }
    }
}
