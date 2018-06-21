package ru.job4j.pseudo;

/**
 * @author Valeriy Gyrievskikh
 * @since 21.06.2018
 */
public class Triangle implements Shape {
    /**
     * Метод рисует треугольник.
     *
     * @return Полученное зображение.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("  +");
        pic.append(System.lineSeparator());
        pic.append(" + +");
        pic.append(System.lineSeparator());
        pic.append("+++++");
        return pic.toString();
    }
}
