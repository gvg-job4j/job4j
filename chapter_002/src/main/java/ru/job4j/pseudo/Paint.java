package ru.job4j.pseudo;

/**
 * @author Valeriy Gyrievskikh
 * @since 21.06.2018
 */
public class Paint {

    /**
     * Основной метод
     *
     * @param args Входные параметры.
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        Square square = new Square();
        paint.draw(square);
        Triangle triangle = new Triangle();
        paint.draw(triangle);
    }

    /**
     * Метод рисует переданную фигуру.
     *
     * @param shape Фигура, которую нужно нарисовать.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

}
