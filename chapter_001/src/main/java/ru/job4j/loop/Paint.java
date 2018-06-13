package ru.job4j.loop;

import java.util.function.BiPredicate;

/**
 * @author Valeriy Gyrievskikh
 * @since 13.06.2018.
 */
public class Paint {
    /**
     * Рисование пирамиды заданной высоты.
     *
     * @param height Высота пирамиды.
     * @return Символьнок представление пирамиды.
     */
    public String pyramid(int height) {
        return this.loopBy(height, 2 * height - 1, (row, column) -> row >= height - column - 1 && row + height - 1 >= column);
    }

    /**
     * Рисование левой части пирамиды заданной высоты.
     *
     * @param height Высота пирамиды.
     * @return Символьнок представление пирамиды.
     */
    public String leftTrl(int height) {
        return this.loopBy(height, height, (row, column) -> row >= height - column - 1);
    }

    /**
     * Рисование правой части пирамиды заданной высоты.
     *
     * @param height Высота пирамиды.
     * @return Символьнок представление пирамиды.
     */
    public String rightTrl(int height) {
        return this.loopBy(height, height, (row, column) -> row >= column);
    }

    /**
     * Выполнение отрисовки пирамиды.
     *
     * @param height  Высота пирамиды.
     * @param weight  Ширина пирамиды.
     * @param predict Класс, сравнивающий текущие значения строки и ячейки.
     * @return Символьнок представление пирамиды.
     */
    private String loopBy(int height, int weight, BiPredicate<Integer, Integer> predict) {
        StringBuilder screen = new StringBuilder();
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (predict.test(row, column)) {
                    screen.append("^");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(System.lineSeparator());
        }
        return screen.toString();
    }
}
