package ru.job4j.loop;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.06.2018.
 */
public class Board {

    /**
     * Рисование шахматной доски.
     *
     * @param width  Ширина доски.
     * @param height Высота доски.
     * @return Строки символов.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}
