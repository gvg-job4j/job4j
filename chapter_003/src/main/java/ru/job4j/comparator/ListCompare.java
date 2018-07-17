package ru.job4j.comparator;

import java.util.Comparator;

/**
 * @author Valeriy Gyrievskikh.
 * @since 17.07.2018.
 */
public class ListCompare implements Comparator<String> {
    /**
     * Метод выполняет сравнение строк в лексикографическом порядке.
     *
     * @param left  Первая сравниваемая строка.
     * @param right Вторая сравниваемая строка.
     * @return Результат сравнения.
     */
    @Override
    public int compare(String left, String right) {
        int result = 0;
        int lengthLeft = left.toCharArray().length;
        int lengthRigth = right.toCharArray().length;

        int length = lengthLeft > lengthRigth ? lengthRigth : lengthLeft;
        for (int i = 0; i < length; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                break;
            }
        }
        if (lengthLeft != lengthRigth && result == 0) {
            result = lengthLeft - lengthRigth;
        }
        return result;
    }
}
