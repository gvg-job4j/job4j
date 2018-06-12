package ru.job4j.condition;

/**
 * @author Valeriy Gyrievskikh
 * @since 12.06.2018.
 */
public class Point {

    private int x;
    private int y;

    /**
     * Конструктор.
     * @param x
     * @param y
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @param that точка, до которой вычисляется расстояние.
     * @return расстояние между точками
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }
}
