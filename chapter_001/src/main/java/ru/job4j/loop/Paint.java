package ru.job4j.loop;

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
    public String piramid(int height) {
        StringBuilder screen = new StringBuilder();
        int weight = 2 * height - 1;
        for (int row = 0; row != height; row++) {
            for (int column = 0; column != weight; column++) {
                if (row >= height - column - 1 && row + height - 1 >= column) {
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
